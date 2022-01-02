<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="rent" scope="session" class="exFinal.BookrentalDB" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <title>利用者のホームページ</title>
    </head>
    <body>
    <center>
        <div id="book1">
            <div id="book4">
                <header>
                    <font size="10"color="#3aacad"><h1><i>BOOKHOUSE</i></h1></font>
                </header>
            </div>
            <article>
                <font size="7"><h2>貸出情報</h2></font>
                <div id="rental"><br><br>
                    貸出冊数：<%= rent.getNum()%>冊
                    <font color="#f9e900">
                    <table border="1">
                        <tr><th>タイトル</th><th>貸出日</th></tr>
                                <% for (int i = 0; i < rent.getNum(); i++) {%>
                        <tr><td><%="<a href=\"BookDeleteinfo.jsp?target=" + rent.getBookid(i) + "\">"%><%= rent.getTitle(i)%></td><td><%= rent.getRentday(i)%></td></tr>
                        <% }%>
                    </table>
                    </font>
                    <br>




                    <form action="BookTop1.jsp" method="post">
                        <input type="submit" value="戻る"style="font-size: 20px;">
                    </form>
                    <br>
                </div>
                <br>
            </article>
        </div>
    </center>
</body>
</html>
