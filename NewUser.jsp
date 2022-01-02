<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <title>新規ユーザ登録ページ</title>
    </head>
    <body>
    <center>
        <div id="book2">
            <div id="book4">
                <font size="10" color="#3aacad"><i><h1>BOOKHOUSE</h1></i></font>
            </div>

            <font size="7"> <h1>新規ユーザ登録</h1></font>
            <div id="input">
                <br>
                <article>
                    <form action="NewUser1.jsp" method="post">
                        <font size="5">
                        <b>ユーザーID</b>
                        <input type="text" name="useid" value1="" size="30" required/><br />
                        <b>パスワード</b>
                        <input type="text" name="usepass" value2="" size="30" required/><br />
                        <input type="submit" value="送信" style="font-size: 20px;">
                    </form>
                    <input type="reset" value="リセット"style="font-size: 20px;">
                    <form action="Login.jsp" method="post">
                        <input type="submit" value="戻る" style="font-size: 20px;">
                        <br><br>
                    </form>
                    </font>
                </article>
            </div>
            <br>
        </div>
    </center>
</body>
</html>