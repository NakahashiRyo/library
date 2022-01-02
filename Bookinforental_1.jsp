<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="book" scope="session" class="exFinal.BookDB" />
<jsp:useBean id="rent" scope="session" class="exFinal.BookrentalDB" />
<% /* エンコード */
    String id1 = "";
    int bookid = 0;
    String id2 = "";
    int useid = 0;

    try {
        if (session.getAttribute("bookid") != null) {
            id1 = session.getAttribute("bookid").toString();
            bookid = Integer.parseInt(id1);
        }
        if (session.getAttribute("useid") != null) {
            id2 = session.getAttribute("useid").toString();
            useid = Integer.parseInt(id2);
        }

        book.dataload3(bookid);

//    String r = book.getLental(0);
//    if(r =="1"){%>
<!--<p>貸出しできません</p>--> 
<%//} else{
    rent.insert(bookid, useid);
    book.update1(bookid, "1"); %>

<jsp:forward page="Bookinforental_2.jsp" />
<%
//    }
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
            <%}%>