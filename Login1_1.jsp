<%-- 
    Document   : Login
    Created on : 2021/01/13, 1:18:25
    Author     : towak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% /* リクエストの取得 */
    request.setCharacterEncoding("UTF-8");
    String value1 = request.getParameter("useid");
    String value2 = request.getParameter("usepass");

// 演習9-2追加　セッションオブジェクトの格納
    session.setAttribute("useid", value1);
    session.setAttribute("usepass", value2);

%>
<jsp:forward page="Login2.jsp" />
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
