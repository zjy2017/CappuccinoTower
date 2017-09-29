<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新页面~~~~~~~</title>
    <link rel="stylesheet" href="resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#ss").hide();
            $(".icon-search").click(function(){
                $("#ss").slideToggle();
            })
            $("#通知框").hide()
            $(".icon-ok").tooltip()
            $(".icon-more").tooltip()
            $(".icon-tip").click(function(){
                $("#通知框").slideToggle()
                $("#manmenu").hide()
            })
            $("#manmenu").hide()
            $(".icon-man").click(function(){

                $("#manmenu").fadeToggle()
                $("#通知框").hide()
            })
            $(".icon-filter").tooltip()
            // 第一次进来遍历所有团队
            $.ajax({
                type:"POST",
                url:"/user/queryTeam",
                dataType:"json",
                success : function (result) {
                    $.each(result.data,function (n,v) {
                        var op="<option value="+v.tId+">"+v.tName+"</option>"
                        $("#select1_1").append(op);
                    })

                },
                error:function () {
                    alert("错错错")
                }
            })
            // 切换团队
            $("#select1_1").change(function () {
                alert($("#select1_1").val());
                $.ajax({
                    type:"POST",
                    url:"/user/changeTeam",
                    dataType:"json",
                    data:{
                        tId:$("#select1_1").val(),
                    },
                    success:function (result) {
                        alert("切换团队成功");
                    }
                })
            })
        })

        function godynamic() {
            alert($("#select1_1").val());
            $.ajax({
                type:"Post",
                url:"/dynamic/DynamicList",
                dataType:"json",
                data:{
                    tId:$("#select1_1").val(),
                },
                success:function (result) {
                    if(result.errcode==1){
                        location.href="dynamic/dynamic.jsp?tId="+$('#select1_1').val();
                    }
                    if(result.errcode==0){
                        alert("生成动态列表失败");
                    }
                },
                error:function () {
                    alert("生成动态列表失败11111");
                }
            })
        }

        function goweekly() {
                        location.href="/weekly/weekly.jsp";
        }

        function gopersonalsetting() {
            location.href="/personal/personal-setting.jsp";
        }

    </script>

    <style>
        iframe{
            position: absolute;height: 1000px;width: 1100px;
            margin-top: 70px;margin-left: 120px;

        }
    </style>
</head>

<body style="background-color: white;">

<iframe  id="if" src="http://localhost:8080/mainindex.jsp"
         frameborder="0" scrolling="no"></iframe>


<div style="margin-left: 100px;margin-top: 30px;">
    <div id="下拉菜单">
        <select id="select1_1">
        </select>

        <div id="mm" style="width:150px;">
            <div class="menu-sep"></div>

        </div>

        <span style="margin-left: 40px;">
    		<a href="#" style="color: coral;margin-left: 40px;">项目</a>
            <button onclick=godynamic() style="color: coral;margin-left: 40px;">动态</button>
    		<button onclick=goweekly() style="color: coral;margin-left: 40px;">周报</button>
    		<a href="#" style="color: coral;margin-left: 40px;">团队</a>
    		<a href="#" style="color: coral;margin-left: 40px;">我自己</a>
    		<a href="#" style="color: coral;margin-left: 40px;">知人</a>
    		<a href="#" style="color: coral;margin-left: 40px;">升级到Pro</a>


    	<span style="color: white;margin-left: 40px;">
    	<button class="icon-tip" style="height: 20px;width: 20px;border: none;" title="通知"></button>
    	</span>
  		<button class="icon-man" style="height: 20px;width: 20px;background-color: white;margin-left: 23px;" title="个人"></button>
    	<span style="margin-left: 40px;">
		<button class="icon-search" style="height: 20px;width: 20px;border: none;" title="搜索"></button>


            <!--搜索框-->
		<span id = "ss">
		<input style="background-color: white;" />
		<button style="font-family: '微软雅黑';"><b>搜索</b></button>
		</span>
		</span>
    	</span>

        <!-- 通知框 -->
        <div id="通知框" style=" position:absolute;color: white;width: 400px;margin-left: 700px;
			margin-top: 10px;border-color: white;border-style:solid ;
			border-width: 1px;background-color:black;" >
            <div id="通知框第一行">
                <span style="float: left;font-family: '微软雅黑';"><b>通知</b></span>
                <span style="float: right;">
					<button style="height: 20px;width: 20px;background-color: white;" class="icon-ok" title="全部标记为已读"></button>
					<button style="height: 20px;width: 20px;background-color: white;" class="icon-more" title="设置通知发送方式"></button>
				</span>
                </br>
                <div class="menu-sep" style="width: 400px;margin-left: -1px;"></div>

            </div>
            <div id="通知框核心内容" >
                <p style="color: white;text-align: center;">- 没有新通知 -</p>
                <div class="menu-sep" style="width: 400px;margin-left: -1px;"></div>
                <p style="text-align: center;"><a href="#" style="color: white;">查看全部</a></p>
            </div>

        </div>


        <!--头像下拉菜单-->
        <div id="manmenu" style="margin-left: 830px; position:absolute;
				background-color: black;border: solid;border-color: white;border-width: 0.3px;">
            <button style="color: white;" onclick="gopersonalsetting()">个人设置</button>><br>
            <a href="#" style="color: white;">通知设置</a><br>
            <a href="#" style="color: white;">我的关注</a><br>
            <div class="menu-sep" style="width: 70px;margin-left: 00px;"></div>
            <a href="#" style="color: white;">最新功能</a><br>
            <a href="#" style="color: white;margin-left: 15px;">退出</a>
        </div>

        <!-- cappuccino -->
        <div>
            <p style="margin-top: 305px;text-align: center;font-family:tahoma;font-size: 15px;margin-top: 650px;">
                <span style="color: lightskyblue;">C</span>
                <span style="color: plum;">a</span>
                <span style="color: lightskyblue;">p</span>
                <span style="color: plum;">p</span>
                <span style="color: lightskyblue;">u</span>
                <span style="color: plum;">c</span>
                <span style="color: lightskyblue;">c</span>
                <span style="color: plum;">i</span>
                <span style="color: lightskyblue;">n</span>
                <span style="color: plum;">o</span>
                <span style="color: orangered;">®</span>

            </p>
        </div>
    </div>
</body>
</html>
