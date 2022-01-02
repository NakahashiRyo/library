<%-- 
    新規ユーザ登録作業
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="NewUser" scope="session" class="exFinal.UserDB" />

<% /* エンコード */

    request.setCharacterEncoding("UTF-8");

    /* 変数の宣言　*/
    String getvalue1 = "";
    int useid = 0;
    String usepass = "";
    try {
        /* パラメータの取得 */
        if (session.getAttribute("useid") != null) {
            getvalue1 = session.getAttribute("useid").toString();
            useid = Integer.parseInt(getvalue1);
        }
        if (session.getAttribute("usepass") != null) {
            usepass = session.getAttribute("usepass").toString();
        }

        /* データの追加メソッド */
        int joinn = NewUser.dataload1(useid, usepass);
        /* データ一覧の取得メソッド */
        if (joinn == 0) {
            NewUser.insert(useid, usepass);

    
%>

<jsp:forward page="News.jsp" />
<%} else {%>
<html>
    <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <center>
        <div id="book2">
            <br><br>
            <center>
                <div id ="book4">
                    <p><font size="7"color="#3aacad"> すでに使われています。</font></center></p>
                </div>
                <form action="Login.jsp" method="post">
                    <input type="submit" value="ログインページへ戻る"style="font-size: 20px;">            
                </form>
                <br>
                <form action="NewUser.jsp" method="post">
                    <input type="submit" value="新規情報登録ページに戻る"style="font-size: 20px;">            
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
                                <form action="NewUser.jsp" method="post">
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

