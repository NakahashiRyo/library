<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="screen" href="style1.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン</title>
    </head>
    <body>
    <center>
        <div id="book2">
            <div id ="book4">
                <font size="10" color="#3aacad"><i><h1>BOOKHOUSE</h1></i></font>
            </div>
            <font size="7"><h2>ログインしてください</h2></font><br><br>
            <div id="input">
                <br>
                <form action="Login1_1.jsp" method="post">
                    <font size="5">
                    <B>ユーザーID</B>
                    <input type="text" name="useid" value1="ユーザ名" size="50" required/><br><br>
                    <B>パスワード</B>
                    <input type="password" name="usepass" value2="パスワード" size="50" required/><br>
                    <input type="submit" value="決定"style="font-size: 20px;">
                    <input type="reset" value="リセット"style="font-size: 20px;">
                </form><br>
                <br><br>
                <B>新規登録の方は下のボタンをクリックしてください。</B>
                <form action="NewUser.jsp" method="post">
                    <input type="submit" value="新規登録"style="font-size: 20px;"> 
                </form>
                <br>
                </font>
            </div>
            <br><br><br>
        </div>
    </center>
</body>

</html>
