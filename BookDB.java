package exFinal;

import java.sql.*; //SQLに関連したクラスライブラリをインポート
import java.awt.*;
import java.awt.event.*;

public class BookDB {

    /*フィールドの定義*/
    protected int[] bookid = new int[10000];//書籍ID
    protected String[] title = new String[10000];//タイトル
    protected String[] author = new String[10000];//著者
    protected String[] heading = new String[10000];//著者標目
    protected String[] publisher = new String[10000];//出版社
    protected String[] year = new String[10000];//出版年  
    protected Date[] day = new Date[10000];//登録日 
    protected String[] rental = new String[10000];//貸出状況
    protected int num;//データ取得件数

    /*メソッド*/
 /*データベースからのデータ取得メソッド*/
    public void dataload() throws Exception { //エラー処理が必要にする
/*データベースに接続 */
        num = 0; //取得件数の初期化
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
        //Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /*SELECT文の実行 */
        String sql = "SELECT * FROM book"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
        stmt.setMaxRows(10000); //最大の数を制限

        ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

        /* 2.1.3 結果の取り出しと表示 */
        while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
            this.bookid[num] = rs.getInt("BookID");
            this.title[num] = rs.getString("Title");
            this.author[num] = rs.getString("Author");
            this.heading[num] = rs.getString("Heading");
            this.publisher[num] = rs.getString("Publisher");
             this.year[num] = rs.getString("Year");
            this.day[num] = rs.getDate("Day");
            this.rental[num] = rs.getString("Rental");

            num++;
        }

        /*データベースからの切断 */
        rs.close(); //開いた順に閉じる
        stmt.close();
        conn.close();
    }

    public void dataload2(String title, String author) throws Exception { //エラー処理が必要にする
/*データベースに接続 */
        num = 0; //取得件数の初期化
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
        //Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /*SELECT文の実行 */
        String sql = "SELECT * FROM book WHERE Title LIKE ? AND Author LIKE ? ORDER BY BookID"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成

        stmt.setString(1,"%"+ title + "%"); //1つ目の？に引数をセットする
        stmt.setString(2, "%"+author + "%"); //2つ目の？に引数をセットする

        ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

        /* 2.1.3 結果の取り出しと表示 */
        while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
            this.bookid[num] = rs.getInt("BookID");
            this.title[num] = rs.getString("Title");
            this.author[num] = rs.getString("Author");
            this.heading[num] = rs.getString("Heading");
            this.publisher[num] = rs.getString("Publisher");
            this.day[num] = rs.getDate("Day");
            this.year[num] = rs.getString("Year");
            
            this.rental[num] = rs.getString("Rental");
            num++;
        }

        /*データベースからの切断 */
        rs.close(); //開いた順に閉じる
        stmt.close();
        conn.close();
    }

    public void dataload3(int bookid) throws Exception { //エラー処理が必要にする
/*データベースに接続 */
        num = 0; //取得件数の初期化
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
        //Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /*SELECT文の実行 */
        String sql = "SELECT * FROM book WHERE BookID = ?"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成

        stmt.setInt(1, bookid); //1つ目の？に引数をセットする

        ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

        /* 2.1.3 結果の取り出しと表示 */
        while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
          this.bookid[num] = rs.getInt("BookID");
            this.title[num] = rs.getString("Title");
            this.author[num] = rs.getString("Author");
            this.heading[num] = rs.getString("Heading");
            this.publisher[num] = rs.getString("Publisher");
            this.day[num] = rs.getDate("Day");
            this.year[num] = rs.getString("Year");
            
            this.rental[num] = rs.getString("Rental");
            num++;
        }

        /*データベースからの切断 */
        rs.close(); //開いた順に閉じる
        stmt.close();
        conn.close();
    }

   

   

    /* データベースへのアップデートメソッド */
    

    public void update1(int bookid, String t) throws Exception {
        /* データベースに接続 */
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8";
        //Connection conn = DriverManager.getConnection(url, "softd", "softd");

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /* Update文の実行 */
        String sql = "UPDATE book SET Rental=? WHERE BookID = ?";

        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
        stmt.setString(1, t); //1つ目の？に引数をセットする
        stmt.setInt(2, bookid); //1つ目の？に引数をセットする

        /* 実行（InsertやDeleteも同じメソッドを使う） */
        stmt.executeUpdate();

        /*データベースからの切断 */
        stmt.close();
        conn.close();
    }

    public void update2(int bookid, String t) throws Exception {
        /* データベースに接続 */
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8";
        //Connection conn = DriverManager.getConnection(url, "softd", "softd");

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /* Update文の実行 */
        String sql = "UPDATE book SET Rental= ? WHERE BookID = ?";

        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
        stmt.setString(1, t); //1つ目の？に引数をセットする
        stmt.setInt(2, bookid); //1つ目の？に引数をセットする

        /* 実行（InsertやDeleteも同じメソッドを使う） */
        stmt.executeUpdate();

        /*データベースからの切断 */
        stmt.close();
        conn.close();
    }
    
  
    

    /* 3. アクセッサ */
 /* 3.1 Getアクセッサ */
    public int getBookid(int i) {
        if (i >= 0 && num > i) {
            return bookid[i];
        } else {
            return 0;
        }
    }

    public String getTitle(int i) {
        if (i >= 0 && num > i) {
            return title[i];
        } else {
            return "";
        }
    }

    public String getAuthor(int i) {
        if (i >= 0 && num > i) {
            return author[i];
        } else {
            return null;
        }
    }

    public String getHeading(int i) {
        if (i >= 0 && num > i) {
            return heading[i];
        } else {
            return null;
        }
    }

    public String getPublisher(int i) {
        if (i >= 0 && num > i) {
            return publisher[i];
        } else {
            return null;
        }
    }

    public String getYear(int i) {
        if (i >= 0 && num > i) {
            return year[i];
        } else {
            return null;
        }
    }

    public Date getDay(int i) {
        if (i >= 0 && num > i) {
            return day[i];
        } else {
            return null;
        }
    }

   

    public String getLental(int i) {
        if (i >= 0 && num > i) {
            return rental[i];
        } else {
            return null;
        }
    }

    public int getNum() {
        return num; // データ件数
    }
}
