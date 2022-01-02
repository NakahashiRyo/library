<%-- 
    Document   : Login
    Created on : 2021/01/13, 1:18:25
    Author     : towak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% /* リクエストの取得 */
    request.setCharacterEncoding("UTF-8");
    String getvalue1 = request.getParameter("useid");
    int value1 = 0;
    if (request.getParameter("useid") != null) {
        getvalue1 = request.getParameter("useid");
        value1 = Integer.parseInt(getvalue1);
    }

    String value2 = request.getParameter("usepass");
    if (request.getParameter("usepass") != null) {
        value2 = request.getParameter("usepass");
    }
// 演習9-2追加　セッションオブジェクトの格納
    session.setAttribute("useid", value1);
    session.setAttribute("usepass", value2);

%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認</title>
    </head>
    <body>
    <center>
        <div id="book2">
            <br><br>
            <div id ="book4">
                <font size="10" color="#3aacad"><i><h1>新規ユーザー登録確認</h1></i></font>

            </div>

            <font size="7"><h2>よろしければOKを押してください。</h2></font><br><br>
            <div id="input">
                <br>

                <font size="5">
                <b>ユーザーID</b>：<font size="7"font color="#3aacad"><%= value1%></font><br><br>
                <b>ユーザーパスワード</b>：<font size="7"font color="#3aacad"><%= value2%></font><br><br>
                </font>
                <form action="NewUserR.jsp" method="post">
                    <input type="submit" value="OK"style="font-size: 20px;"> 
                </form>
                <form action="Login.jsp" method="post">
                    <input type="submit" value="戻る"style="font-size: 20px;"> 
                </form>
            </div>
    </center>
    <br><br>
</body>
</html>
