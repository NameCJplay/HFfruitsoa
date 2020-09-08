package com.hf.dao.Controller;

import com.hf.dao.Service.*;
import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.DateUtil;
import com.hf.domain.Domain.Fruits.FruitsDO;
import com.hf.domain.Domain.Notify.NotifyDO;
import com.hf.domain.Domain.Orders.OrdersDataDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dao")
public class IndexApiController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private NotifyService notifyService;
    @Autowired
    private FruitsService fruitsService;
    @Autowired
    private UserService userService;

    @PostMapping("/loadIndex")
    @MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
    public Map loadIndex() throws IllegalAccessException {
        Map dataMap = new HashMap();
        List<FruitsDO> fruitsList = fruitsService.toMaturity(new Date(),7);
        List<NotifyDO> notifyList = notifyService.toDayList();
        Integer uid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long did = userService.get(uid.longValue()).getUserDeptId();
        OrdersDataDo toweek = new OrdersDataDo(did,null,null,null,null,3,2, DateUtil.getWeekStart(), DateUtil.getWeekEnd());
        OrdersDataDo today= new OrdersDataDo(did,null,null,null,null,4,2, DateUtil.getTodayStart(), DateUtil.getTodayEnd());

        List<OrdersDataDo> Toweek = ordersService.getDataOrders(toweek);
        List<OrdersDataDo> Today = ordersService.getDataOrders(today);

        String[] totalList = new String[7];
        String[] grossList = new String[7];
        String[] profitList = new String[7];
        if(Toweek.size()<=0){
            int Todayforweek = DateUtil.getTodayforWeek();
            totalList[Todayforweek-1] = "0";
            grossList[Todayforweek-1] = "0";
            profitList[Todayforweek-1] = "0";
        }
        for (OrdersDataDo data:Toweek) {
            Integer day = new Integer(data.getTime());
            if(day == 0)day=7;
            totalList[day-1] = data.getTotal().toString();
            grossList[day-1] = data.getGross().toString();
            profitList[day-1] = data.getProfit().toString();
        }
        dataMap.put("totalList",totalList);
        dataMap.put("grossList",grossList);
        dataMap.put("profitList",profitList);
        try{dataMap.put("Today",Today.get(0));}catch (Exception e){dataMap.put("Today",new OrdersDataDo());}
        dataMap.put("notifyList",notifyList);
        dataMap.put("fruitsList",fruitsList);
        return dataMap;
    }


}
