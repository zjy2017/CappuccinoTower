<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/19
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>周报</title>
    <link rel="stylesheet" href="../resources/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nifty Modal Window Effects</title>
    <meta name="description" content="Nifty Modal Window Effects with CSS Transitions and Animations"/>
    <meta name="keywords"
          content="modal, window, overlay, modern, box, css transition, css animation, effect, 3d, perspective"/>
    <meta name="author" content="Codrops"/>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        /**
         * 获取url中指定变量的值
         * @param paramName [String]变量名
         **/
        function getParam(paramName) {
            // 第二个是可选参数：i表示匹配时大小写不敏感、g表示匹配到一次就停止、m表示多次匹配
            var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)", "i");
            // substr(1)表示从下标1开始截取字符串，相当于删除第一个字符
            var result = window.location.search.substr(1).match(reg);
            if (result != null) {
                // 中文解码
                return decodeURI(result[2]);
            } else {
                return null;
            }
        }


        /**
         * 把毫秒级时间转换成字符串,保留时分秒
         * 格式：yyyy年MM月dd日 hh点mm分ss秒
         * @param date
         * @returns {string}
         */
        function dateFormatDetail(date) {
            var dateStr = new Date(v.date);
            // 重写toString方法
            Date.prototype.toLocaleString = function () {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日 " + this.getHours() + "点" + this.getMinutes() + "分" + this.getSeconds() + "秒";
            };
            return dateStr.toLocaleString();
        }

        /**
         * 把毫秒级时间转换成字符串
         * 格式：yyyy年MM月dd日
         * @param date
         * @returns {string}
         */
        function dateFormat(date) {
            var dateStr = new Date(date);
            // 重写toString方法
            Date.prototype.toLocaleString = function () {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日";
            };
            return dateStr.toLocaleString();
        }
        $(document).ready(function () {
            //在动态中点击周报，跳至本页面加载所选周报
            $.ajax({
                type: "Post",
                url: "/weekly/weeklyByweekId",
                dataType: "json",
                data: {
                    operateId:${param.operateId},
                },
                success: function (result) {
                    if (result.errcode == 1) {
                            $("#aa1").append(result.data.wSummary),
                            $("#aa2").append(result.data.wChallenge),
                            $("#aa3").append(result.data.wTarget),
                            $("#aa4").append(result.data.wMethod)
                            $("#who1_1").append(result.page.uName),
                            $("#when1_1").append(dateFormat(result.data.wTime));
                    } else {
                        alert("错误");
                    }
                }, error: function () {
                    alert("操作错误！");
                }
            })
        })

            $("#weekly1_1_empty").hide();
            $('#report_setting').hide()
            $("#report_index").show()

            $("#inreport_setting").click(function () {
                $("#report_setting").fadeIn("fast")
                $("#report_index").fadeOut("fast")
            })

            $("#inreport_index").click(function () {
                $("#report_setting").fadeOut("fast")
                $("#report_index").fadeIn("fast")
            })

            $("#team_add_span").hide()

            $("#team_add").click(function () {
                $("#team_add_span").show()
                $("#team_add").hide()
            })

            $("#team_add_sure").click(function () {
                $("#team_add_span").hide()
                $("#team_add").show()
            })

            $("#team_add_cancel").click(function () {
                $("#team_add_span").hide()
                $("#team_add").show()
            })

            $("#member_add_span").hide()

            $("#member_add").click(function () {
                $("#member_add_span").show()
                $("#member_add").hide()
            })

            $("#member_add_sure").click(function () {
                $("#member_add_span").hide()
                $("#member_add").show()
            })

            $("#member_add_cancel").click(function () {
                $("#member_add_span").hide()
                $("#member_add").show()
            })

            $("#report_setting_span1").hide()
            $("#report_setting_span2").hide()
            $("#report_setting_span3").hide()

            $("#report_setting_p1").hover(function () {
                $("#report_setting_span1").toggle()
            })

            $("#report_setting_p2").hover(function () {
                $("#report_setting_span2").toggle()
            })

            $("#report_setting_p3").hover(function () {
                $("#report_setting_span3").toggle()
            })


        //选择日期，显示该日期所在周的周报
        function aaa() {
            var a = $("#time1").val();
            $.ajax({
                type: "POST",
                url: "/weekly/selectWeekly",
                dataType: "json",
                data: {
                    wTime: a,
                },
                success: function (result) {
                    if (result.errcode == 1) {
                        $("#weekly1_1_empty").hide();
                        $("#weekly1_1_content").show();
                        //每次点击日期后清空
                        $("#aa1").empty();
                        $("#aa2").empty();
                        $("#aa3").empty();
                        $("#aa4").empty();
                        $("#who1_1").empty();
                        $("#when1_1").empty();
                        {
                            //在指定问题后输出周报内容
                            $("#aa1").append(result.data.wSummary),
                                $("#aa2").append(result.data.wChallenge),
                                $("#aa3").append(result.data.wTarget),
                                $("#aa4").append(result.data.wMethod),
                                $("#who1_1").append(result.page.uName),
                                $("#when1_1").append(dateFormat(result.data.wTime));
                        }
                    } else {
                        $("#weekly1_1_content").hide()
                        $("#weekly1_1_empty").show()
                    }
                },
                error: function (result) {
                    alert("周报不存在");
                }
            })


            //根据所选日期查询该日期所在周
            $.ajax({
                type: "Post",
                url: "/weekly/weekByday",
                dataType: "json",
                data: {
                    wTime: $("#time1").val(),
                },
                success: function (result) {
                    if (result.errcode == 1) {
                        $("#bb1").empty();
                        $("#bb2").empty();
                        $("#bb1").append(dateFormat(result.data) + "-");
                        $("#bb2").append(dateFormat(result.page));
                    }
                },
                error: function (result) {
                    alert("查询失败！！！！");
                }
            })
        }


        //跳转至添加周报页面
        function goaddweekly() {
            var a = $("#time1").val();
            location.href = "../personal/personal.jsp?wTime=" + a;
        }

    </script>






</head>

<body style="background-color: #212121;">
<%
    //   datebox中默认日期为当前时间,以下java代码块用于获取正确格式的当前时间
    SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
    Date beginDate = new Date();
    Calendar date = Calendar.getInstance();
    date.setTime(beginDate);
    date.set(Calendar.DATE, date.get(Calendar.DATE));
    String today = dft.format(date.getTime());  // today即为当前时间
%>
<div style="margin: 30px;">
    <div  href='#' style="text-align: center;font-size: 30px;color: #0ABD6A">
        周报总览
    </div>
    <p style="text-align: center;font-size: 30px;color: #0abd6a;font-weight: bold;">
        <a href="#" class="report_btn" style="font-weight: bold;font-size: 30px;">
        </a>
        <span id="report_indate"><input id="time1" name="createdatetimeStart" value="<%=today%>"
                                        style="width: 120px;border: none;background-color: #212121;color: #0abd6a;cursor: pointer;font-size: 20px"
                                        onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" onclick="aaa()"/></span>
        <a class="report_btn" href="#" style="font-weight: bold;font-size: 30px;"></a>

    </p>
    <p style="text-align: center;font-size: 20px; color: gray;">
        <span id="bb1"></span>
        <span id="bb2"></span>
    </p>

</div>

<div class="menu-sep" style="margin-top: 130px;"></div>

<!--主页面-->
<div id="report_index">
    <%--<img src="images/fzl2.jpg" height="50px" style=" margin-left: 50px;margin-top: 30px;" />--%>
    <br><br>
    <%--<a href="#" class="report_btn" style="margin-left: 60px;font-weight: bold;">邓超</a>--%>
    <div style="margin-left: 250px;margin-top: -110px;margin-bottom: 10px;">
        <div>
            <h3 style="color:white;font-style:30px;">本周周报</h3></div>
        <br>
        <div id="weekly1_1_content">
            <div id="p1" style="font-weight: bold;color: #0ABD6A;"><span>"本周工作成果总结，说说你对自己点赞或失望的地方。"</span><br>
                <span style="color: grey;" id="aa1"></span>
            </div>

            <div id="p2" style="font-weight: bold;color: #0ABD6A;"><span>"有遇到挑战或者困难么？希望团队怎么帮助你？"</span><br>
                <span style="color: grey;" id="aa2"></span>
            </div>

            <div id="p3" style="font-weight: bold;color: #0ABD6A;"><span>"下周的工作目标是什么？只许说一个。"</span><br>
                <span style="color: grey;" id="aa3"></span>
            </div>

            <div id="p4" style="font-weight: bold;color: #0ABD6A"><span>"你觉得采取哪些措施，会对你提升工作效率有帮助？"</span><br>
                <span style="color: grey;" id="aa4"></span>
            </div>

            <br>
            <span id="who1_1" style="color: grey;"></span>
            <span style="color: grey;">，创建于</span>
            <span id="when1_1" style="color: grey;"></span>
        </div>

    </div>
    <br>
    <div class="menu-sep" style="margin-left:0px ;"></div>
</div>
</div>
</body>
</html>