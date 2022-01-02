<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="book" scope="session" class="exFinal.BookDB" />
<%try {%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <title>書籍情報</title>
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
                <font size="7"><h2>書籍情報</h2></font>
                <div id="input">
                    <font size="7"><font color="#FF3300"><%= book.getNum()%></font>冊の書籍を保管！<br>
                    お気に入りの本を見つけよう！</font><br>
                    <div id="author">
                        該当著者<br>
                        山田悠介・宮部みゆき・恩田陸・池井戸潤・伊坂幸太郎・村上春樹・朝井リョウ・あさのあつこ・東野圭吾・綾辻行人
                        ・有川浩・住野よる・太宰治・司馬遼太郎・重松清・アガサ・クリスティ・吉本ばなな・湊かなえ・森博嗣・知念実希人
                        ・夏目漱石・遠藤周作・さくらももこ・星新一・芥川龍之介・辻村深月・山田詠美・サマセット・モーム・吉村昭・貴志祐介
                        ・北杜夫・永井路子・ぺんたぶ
                    </div>
                    <br>

                    <font size="5">
                    <form action="Bookinfo.jsp" method="post">

                        タイトル：<input type="text" name="Title" value="" size="30" /><br />
　　著者：<input type="text" name="Author" value="" size="30" /><br />
                        <div id="button1">
                            <input type="submit" value="検索" style="font-size: 20px;">
                                     
                            <input type="reset" value="リセット"style="font-size: 20px;">
                        </div>
                    </form>
                    
                    <div id="button3"> 
                        <form action="BookTop1.jsp" method="post">
                            <input type="submit" value="書籍一覧" style="font-size: 20px;">
                        </form>
                     
                        <input type="button" onclick="location.href = 'http://localhost:8080/maven/ex13-15_1/Bookrentalinfo.jsp'"value="貸出状況" style="font-size: 20px;">
                    </div>
                    
                    <div id="button5"> 
                        <form action="Login.jsp" method="post">
                            <input type="submit" value="ログイン画面に戻る" style="font-size: 20px;">
                        </form>
                    </div>
                    
                    <br>
                    </font>
                </div>

                <div id="booktop1">
                    <div id="booktop2">  
                        書籍冊数：<font size="7" color="fff200"><%= book.getNum()%></font>冊
                    </div>
                    <table border="1">

                        <tr><th>タイトル</th><th>著者</th><th>著者標目</th><th>出版社</th><th>出版年</th><th>登録日</th><th>貸出状況</th></tr>

                        <% for (int i = 0; i < book.getNum(); i++) {
                                // 貸出状況に応じて表示を切り替える
                                String BookinforentalLink = (Integer.parseInt(book.getLental(i)) == 0) ? "<a href=\"Bookinforental.jsp?target=" + book.getBookid(i) + "\">" + book.getTitle(i) + "</a>": "<a href=\"Bookinforental_4.jsp?target=" + book.getBookid(i) + "\">" + book.getTitle(i) + "</a>";
                                String BookinfoStr = (Integer.parseInt(book.getLental(i)) == 0) ? "貸出可" : "貸出中";
                        %>
                        <tr><td><%= BookinforentalLink%></a></td><td><%= book.getAuthor(i)%></td>
                            <td><%= book.getHeading(i)%></td><td><%= book.getPublisher(i)%></td><td><%= book.getYear(i)%></td><td><%= book.getDay(i)%></td>
                            <td><%= BookinfoStr%></td><td><%="<a href=\"Bookinforental.jsp?target=" + book.getLental(i) + "\">"%></td></tr>
                            <% }%>

                    </table>


            </article>
        </div>
    </center>
</body>
</html>
<%} catch (Exception e) {%>
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
                <center> <font size="10"><i><h1>BOOKHOUSE</h1></i></font>
                </center>
            </div>
            <div id="error">
                <header>
                    <font size="10"><br><br><br><br></font>

                    <font size="7" color="#f9e900"><B>エラーが発生しました<br>
                        もう一度やり直してください!!<br><br></B></font>
                </header>
                <article>
                    <%=e%>
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