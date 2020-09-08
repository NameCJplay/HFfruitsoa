package com.hf.domain.Common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static SimpleDateFormat YYMMdd =  new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat YYMMddHHmmss =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat YYYY =new SimpleDateFormat("yyyy");

    //获得多少天后的日期，今天就是0
    public static Date getDate(Date date,int day){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        c.add(Calendar.DATE, day);//天后的日期
        Date mydate= new Date(c.getTimeInMillis()); //将c转换成Date
        return mydate;
    }
    //相减得天数-Data2-Data1
    public static int SubDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //不同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //同一年
        {
            return day2-day1;
        }
    }

    /**
     * 获取现在
     * @return String
     * */
    public static String getToday(){
        return YYMMddHHmmss.format(new Date());
    }

    /**
     * 获取今天开始
     * @return String
     * */
    public static String getTodayStart(){
        return YYMMdd.format(new Date())+" 00:00:00";
    }

    /**
     * 获取今天结束
     * @return String
     * */
    public static String getTodayEnd(){
        return YYMMdd.format(new Date())+" 23:59:59";
    }


    /**
     * 获取今天是周几
     * @return String
     * */
    public static Integer getTodayforWeek(){
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        return weekday-1;
    }
    /**
     * 获取昨天
     * @return String
     * */
    public static String getYestoday(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date time=cal.getTime();
        return YYMMdd.format(time);
    }
    /**
     * 获取本月开始日期
     * @return String
     * **/
    public static String getMonthStart(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time=cal.getTime();
        return YYMMdd.format(time)+" 00：00：00";
    }
    /**
     * 获取本月最后一天
     * @return String
     * **/
    public static String getMonthEnd(){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time=cal.getTime();
        return YYMMdd.format(time)+" 23:59:59";
    }
    /**
     * 获取本周的第一天
     * @return String
     * **/
    public static String getWeekStart(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //set the first day of the week is Monday
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        return YYMMdd.format(cal.getTime())+ " 00:00:00";

    }
    /**
     * 获取本周的最后一天
     * @return String
     * **/
    public static String getWeekEnd(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //set the first day of the week is Monday
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        return YYMMdd.format(cal.getTime())+ " 23:59:59";
    }

    /**
     * 获取本年的第一天
     * @return String
     * **/
    public static String getYearStart(){
        return YYYY.format(new Date())+"-01-01";
    }

    /**
     * 获取本年的最后一天
     * @return String
     * **/
    public static String getYearEnd(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYearLast = calendar.getTime();
        return YYMMdd.format(currYearLast)+" 23:59:59";
    }
}
