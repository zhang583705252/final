<%@ page language="java"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例

    var myChart= echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        title : {
            text: '持名法寺用户图',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',

        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name: '',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                ]
            },

        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    $.ajax({
        url:'${pageContext.request.contextPath}/user/allUser',
        type:'get',
        dataType:'JSON',
        success:function (result) {


            //result.data
            myChart.setOption({
                series : [
                    {
                        name: '用户',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                       data:result
                    },

                ]
            });
        }
    })

</script>
