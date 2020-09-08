// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('js-chartjs-lines'));
var totalList = new Array();
var grossList = new Array();
var profitList = new Array();

$.ajax({
    cache: true,
    type:'Post',
    url:'/dao/loadIndex',
    async: false,
    success: function (data) {
        totalList = data.totalList;
        grossList = data.grossList;
        profitList = data.profitList;
        var notifyList = data.notifyList;
        var fruitsList = data.fruitsList;
        if(data.Today.total == null || data.Today.total == ''){
            $('#total').html("0 笔");
            $('#gross').html("0 元");
            $('#profit').html("0 元");
        }else{
            $('#total').html(data.Today.total+" 笔");
            $('#gross').html(data.Today.gross+" 元");
            $('#profit').html(data.Today.profit+" 元");
        }
        if(notifyList.length <= 0){
            $("#notity").html("0 条");
        }else{
            $("#notity").html(notifyList.length+" 条");
        }
        for(var i =0;i<fruitsList.length;i++){
            var fruits = fruitsList[i];
            var maturity = new Date(fruits.fruitsMaturityDate);
            var now=new Date()
            $('#toMaturity').append('<tr>' +
                '<td>'+fruits.fruitsId+'</td>' +
                '<td>'+fruits.fruitsName+'</td>' +
                '<td>'+maturity.toLocaleString()+'</td>' +
                '<td>'+Math.round((maturity-now)/(24 * 60 * 60 * 1000))+'天</td>' +
                '<td>'+fruits.fruitsStock+''+fruits.fruitsUnit+'</td></tr>');
        }
    }
});
// 指定图表的配置项和数据
var option = {
    title: {
        text: '本周',
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['今日收入', '今日利润', '成交量']
    },
    toolbox: {
        show: true,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line', 'bar']},
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value} 元'
        }
    },
    series: [
        {
            name: '今日收入',
            type: 'line',
            data: grossList,
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
        {
            name: '成交量',
            type: 'line',
            data: totalList,
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
        {
            name: '今日利润',
            type: 'line',
            data: profitList,
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

//地图开始

var adCode = 430000;
var depth = 3;
var map = new AMap.Map("container", {
    zoom: 6.8,
    center: [112.607693,27.500358],
    pitch: 0,
    viewMode: '3D',
});
// 创建省份图层
var disProvince;
function initPro(code, dep) {
    dep = typeof dep == 'undefined' ? 2 : dep;
    adCode = code;
    depth = dep;

    disProvince && disProvince.setMap(null);

    disProvince = new AMap.DistrictLayer.Province({
        zIndex: 12,
        adcode: [code],
        depth: dep,
        styles: {
            'fill': function (properties) {
                // properties为可用于做样式映射的字段，包含
                // NAME_CHN:中文名称
                // adcode_pro
                // adcode_cit
                // adcode
                var adcode = properties.adcode;
                return getColorByAdcode(adcode);
            },
            'province-stroke': 'cornflowerblue',
            'city-stroke': 'white', // 中国地级市边界
            'county-stroke': 'rgba(255,255,255,0.5)' // 中国区县边界
        }
    });

    disProvince.setMap(map);
}

// 颜色辅助方法
var colors = {};
var getColorByAdcode = function (adcode) {
    if (!colors[adcode]) {
        var gb = Math.random() * 155 + 50;
        colors[adcode] = 'rgb(' + gb + ',' + gb + ',255)';
    }

    return colors[adcode];
};
// 按钮事件
function changeAdcode(code) {
    if (code != 100000) {
        initPro(code, depth);
    }
}
function changeDepth(dep) {
    initPro(adCode, dep);
}
initPro(adCode, depth);

// // 构造下拉框
// var optArr = adcodes.map(function (item) {
// 	if (item.adcode == 100000) {
// 		item.name = '选择省份';
// 	}
// 	return '<option ' + (item.adcode == adCode ? 'selected' : '') + ' value="' + item.adcode + '">' + item.name + '</option>';
// });
// document.getElementById('adcode-list').innerHTML = optArr.join('');
