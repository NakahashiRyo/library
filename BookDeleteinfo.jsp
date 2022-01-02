<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="book" scope="session" class="exFinal.BookDB" />
<jsp:useBean id="rent" scope="session" class="exFinal.BookrentalDB" />
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
        <title>返却</title>
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
                    <font size="6"> 本を返却しますか？<br>
                    返却する場合は「返却」ボタンを押してください。</font><br />

                    <br />


                    <form action="BookDeleteinfo1.jsp" method="post">
                        <input type="submit" value="返却" style="font-size: 20px;">
                    </form>
                    <br>
                </div>
            </article>
            <br>
        </div>
    </center> 
</body>
</html>