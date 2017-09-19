<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>团队-Power</title>
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
        })


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
        <a href="javascript:void(0)" id="mb" class="easyui-menubutton"
           data-options="menu:'#mm'" style="color:red;">卡布其诺 ▼</a>

        <div id="mm" style="width:150px;">
            <div class="menu-sep"></div>
            <div>团队账户</div>
            <div>应用中心</div>
            <div>邀请成员</div>
            <div>团队统计（PRO）</div>
            <div>升级为Pro版</div>
            <div class="menu-sep"></div>
            <div>切换团队：EDG</div>
            <div class="menu-sep"></div>
            <div>创建管理团队</div>
        </div>

        <span style="margin-left: 40px;">
    		<a href="#" style="color: coral;margin-left: 40px;">项目</a>
    		<a href="#" style="color: coral;margin-left: 40px;">动态</a>
    		<a href="#" style="color: coral;margin-left: 40px;">周报</a>
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
            <a href="#" style="color: white;">个人设置</a><br>
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
