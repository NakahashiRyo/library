<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="com" scope="session" class="exFinal.CommentDB" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <title>コメント欄</title>
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
                <font size="7"><h2>コメント欄</h2></font>
                <div id="input">
                    <font size="5">
                    <br>
                    コメント追加
                    <form action="BookComment4.jsp" method="post">
                        コメント：<input type="text" name="contents" value="" size="50" /><br />


                        <input type="submit" value="送信" style="font-size: 20px;">
                        <input type="reset" value="リセット"style="font-size: 20px;">
                    </form>
                    <form action="BookTop.jsp" method="post">
                        <input type="submit" value="戻る" style="font-size: 20px;">
                    </form>
                    </font>
                    <br>
                </div>
                <div id="com">
                    <br><br>
                    コメント件数：<%= com.getNum()%>件
                    <table border="1">
                        <tr><th>コメント</th><th>更新日</th></tr>
                                <% for (int i = 0; i < com.getNum(); i++) {%>
                        <tr><td><%= com.getContents(i)%></td><td><%= com.getDay(i)%></td></tr>
                        <% }%>
                    </table>
                    <br>
                </div>
                </form>
            </article>
            <br>
        </div>
    </center>
</body>
</html>