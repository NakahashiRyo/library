<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="book" scope="session" class="exFinal.BookDB" />

<% /* エンコード */


    request.setCharacterEncoding("UTF-8");

    String target = "";

    if (request.getParameter("target") != null) {
        target = request.getParameter("target");
    }

    /* Insertメソッドの実行 */
    session.setAttribute("bookid", target);
%>



<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>貸出ORコメント</title>
    </head>
    <body>
    <center>
        <div id="book1">
            
            <div id="book4">
                <header>
                    <font size="10"color="#3aacad"><h1><i>BOOKHOUSE</i></h1></font>
                </header>
            </div>
            <br><br>
            <article>
                <div id="input">
                    <br>
                    <br />
                    <%=target%>
                    <font size="6"> 本を借りますか？</font><br>
                    <form action="Bookinforental_1.jsp" method="post">
                        <input type="submit" value="借りる"style="font-size: 20px;">
                    </form>
                    <br>
                    <font size="6"> コメントを記入、閲覧しますか？</font><br>
                    <form action="BookComment2.jsp" method="post">
                        <input type="submit" value="コメント"style="font-size: 20px;">
                    </form
                    <br><br>
                    <form action="BookTop.jsp" method="post">
                        <input type="submit" value="入力画面へ戻る"style="font-size: 20px;">
                    </form>
                    <br>
                    <br>
                </div>
            </article>
            <br><br>
        </div>
    </center>

</body>
</html>