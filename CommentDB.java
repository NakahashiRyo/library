package exFinal;

import java.sql.*; //SQLに関連したクラスライブラリをインポート

public class CommentDB {

    /*フィールドの定義*/
    protected int[] cid = new int[10000];//コメントID
    protected int[] bookid = new int[10000];//書籍id
    protected int[] useid = new int[100];//ユーザーid
    protected String[] contents = new String[18000];//コメント
    protected Date[] day = new Date[2000];//更新日時
    protected int num;//データ取得件数

    /*メソッド*/
 /*データベースからのデータ取得メソッド*/
   

     public void dataload2(int bookid) throws Exception { //エラー処理が必要にする

        /* 2.1.1 データベースに接続 */
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8"; //データベース名は適宜修正：文字エンコードはUTF-8
        //Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /* 2.1.2 SELECT文の実行 */
        String sql =  "SELECT * FROM comment WHERE BookID = ?"; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
   
          stmt.setInt(1, bookid); //検索
          
              
        
        ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

        /* 2.1.3 結果の取り出しと表示 */
        num = 0;
        while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
            this.cid[num] = rs.getInt("CId");
            this.bookid[num] = rs.getInt("BookID");
            this.contents[num] = rs.getString("Contents");
             this.day[num] = rs.getDate("Day");
             
            
            

            num++;
        }

        /* 2.1.4 データベースからの切断 */
        rs.close(); //開いた順に閉じる
        stmt.close();
        conn.close();
  

    }

    
    public int insert(int bookid, String contents ) {
        int count = 0; //登録件数のカウント
        try {

            /* 2.2.1 データベースに接続 */
            //Class.forName("com.mysql.jdbc.Driver").newInstance(); // SELECTの時と同じ
            //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8";
            //Connection conn = DriverManager.getConnection(url, "softd", "softd");

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
            String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection conn = DriverManager.getConnection(url, "root", "");

            /* 2.2.2 INSERT文の実行 */
            String sql = "INSERT INTO comment (BookID,Contents,Day) VALUES (?,?,NOW())"; //SQL文の設定 INSERTはパラメータが必要なことが多い

            PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
            stmt.setInt(1, bookid); //1つ目の？に引数をセットする
            stmt.setString(2, contents); //2つ目の？に引数をセットする
            


            /* 2.2.3 実行（UpdateやDeleteも同じメソッドを使う） */
            count = stmt.executeUpdate();

            /* 2.2.4 データベースからの切断 */
            stmt.close();
            conn.close();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    /* 3. アクセッサ */
 /* 3.1 Getアクセッサ */
    public int getCid(int i) {
        if (i >= 0 && num > i) {
            return cid[i];
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
    
    public String getContents(int i) {
        if (i >= 0 && num > i) {
            return contents[i];
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

    public int getNum() {
        return num; // データ件数
    }
}
