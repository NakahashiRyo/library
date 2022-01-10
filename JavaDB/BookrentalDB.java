package exFinal;

import java.util.Calendar;
import java.sql.*; //SQLに関連したクラスライブラリをインポート

public class BookrentalDB {

    /*フィールドの定義*/
    protected int[] rentid = new int[10000];//貸出id
    protected int[] bookid = new int[10000];//書籍id
    protected int[] useid = new int[10000];//ユーザid
    protected String[] title = new String[10000];//タイトル
    protected Date[] rentday = new Date[10000];//貸出日
    protected int num;//データ取得件数
    
  
    
    
    /*メソッド*/
 /*データベースからのデータ取得メソッド*/
   
      public void dataload1(int useid) throws Exception { //エラー処理が必要にする
/*データベースに接続 */
        num = 0; //取得件数の初期化
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8"; //softd1がデータベース名：文字エンコードはUTF-8
        //Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /*SELECT文の実行 */
        String sql = "SELECT Title,Rentday,rental.bookID,UseId FROM rental LEFT JOIN book ON rental.bookID = book.bookID WHERE UseId = ?"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
                    stmt.setInt(1,useid );
                    
        ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

        /* 2.1.3 結果の取り出しと表示 */
        while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
            this.bookid[num] = rs.getInt("rental.bookID");
             this.useid[num] = rs.getInt("UseId");
             this.title[num] = rs.getString("Title");
            this.rentday[num] = rs.getDate("RentDay");
            num++;
        }

        /*データベースからの切断 */
        rs.close(); //開いた順に閉じる
        stmt.close();
        conn.close();
    }

    
    /* データベースへのインサートメソッド */
    public void insert(int bookid,int useid) throws Exception {
        int count = 0; //登録件数のカウント
       // try {

            /* 2.2.1 データベースに接続 */
            //Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
            //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8";
            //Connection conn = DriverManager.getConnection(url, "softd", "softd");

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
            String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection conn = DriverManager.getConnection(url, "root", "");
   
            /* 2.2.2 INSERT文の実行 */
            String sql = "INSERT INTO rental (bookID,UseId,RentDay) VALUES (?,?,now())"; //SQL文の設定 INSERTはパラメータが必要なことが多い

            PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
            
            stmt.setInt(1,bookid ); //2つ目の？に引数をセットする
            stmt.setInt(2,useid ); //3つ目の？に引数をセットする
           

            /* 2.2.3 実行（UpdateやDeleteも同じメソッドを使う） */
            count = stmt.executeUpdate();

            /* 2.2.4 データベースからの切断 */
            stmt.close();
            conn.close();
           // return count;
       // } catch (Exception e) {
           // return 0;
      //  }
    }

    /* データベースへのデリートメソッド */
    public int delete(int rentid) throws Exception {
        
        try{
        /* データベースに接続 */
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8";
        //Connection conn = DriverManager.getConnection(url, "softd", "softd");

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /* DELETE文の実行 */
        String sql = "DELETE FROM rental  WHERE  bookID = ?";//lec_nameを条件に一件データを削除
        

        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
        stmt.setInt(1, rentid); //1つ目の？に引数をセットする
/*実行（UpdateやInsertも同じメソッドを使う） */
        stmt.executeUpdate();

        /* データベースからの切断 */
        stmt.close();
        conn.close();
        return 0;
        }catch (Exception e) {
            return 1;
        }
    }

   


    /* 3. アクセッサ */
 /* 3.1 Getアクセッサ */
    public int getRentId(int i) {
        if (i >= 0 && num > i) {
            return rentid[i];
        } else {
            return 0;
        }
    }

    public int getBookid(int i) {
        if (i >= 0 && num > i) {
            return bookid[i];
        } else {
            return 0;
        }
    }

    public int getUseid(int i) {
        if (i >= 0 && num > i) {
            return useid[i];
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
    
    public Date getRentday(int i) {
        if (i >= 0 && num > i) {
            return rentday[i];
        } else {
            return null;
        }
    }
    
   
    

    public int getNum() {
        return num; // データ件数
    }
}

