<%-- 
    新規ユーザ登録作業
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="user" scope="session" class="exFinal.UserDB" />

<% /* エンコード */

    request.setCharacterEncoding("UTF-8");

    /* 変数の宣言　*/
    String getuseid;
    int useid = 0;
    String usepass = "";
    try {
        /* パラメータの取得 */
        if (session.getAttribute("useid") != null) {
            getuseid = session.getAttribute("useid").toString();
            useid = Integer.parseInt(getuseid);
        }

        if (session.getAttribute("usepass") != null) {
            usepass = session.getAttribute("usepass").toString();
        }

        int joinm = user.dataload1(useid, usepass);
        /* データ一覧の取得メソッド */
        if (joinm == 1) {
%>
<jsp:forward page="BookTop1.jsp" />
<%} else {%>
<html>
    <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <center>
        <div id="book2">
            <br><br>

            <div id ="book4">
                <p> <font size="6" color="#3aacad"><i><h1> idかパスワードが間違っています。</h1></i>
            </div>
            <br><br>
            <div id="input">
                <%= useid%>
                <%= usepass%>
                </font>
                <form action="Login.jsp" method="post">
                    <input type="submit" value="ログインページへ戻る"style="font-size: 20px;">
                </form>
                <br>
            </div>
    </center>
    <br>
</p>
</html>
<%}
} catch (Exception e) {%>



<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラーの表示</title>
    </head>
    <body>
    <center>
        <div id="book1">
            <div id="book4">
                <center> <font size="10"color="#3aacad"><i><h1>BOOKHOUSE</h1></i></font>
                </center>
            </div>
            <div id="error">
                <header>
                    <font size="10"><br><br><br><br></font>

                    <font size="7" color="#f9e900"><B>エラーが発生しました<br>
                        もう一度やり直してください!!<br><br></B></font>
                </header>
                <article>
                    <form action="Login.jsp" method="post">
                        <input id="button2" type="submit" value="　戻る　" style="font-size: 20px;">
                    </form> 
                    <br>
                </article>
            </div>
            <br>
            </center>
            </body>
            </html>

            <%
                }
            %>
