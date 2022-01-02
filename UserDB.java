package exFinal;

import java.sql.*;

public class UserDB {

    /* 1. フィールドの定義 */
    protected int[] useid = new int[10000]; //システム利用者ID
    protected String[] usepass = new String[10000]; //パスワード 
    protected int num;

    /* 2. メソッド */
 /* 2.1 データベースからのデータ取得メソッド */
   

    public int dataload1(int useid, String usepass) throws Exception { //エラー処理が必要にする

        /* 2.1.1 データベースに接続 */
        //Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
        //String url = "jdbc:mysql://localhost/softd3?characterEncoding=UTF-8"; //データベース名は適宜修正：文字エンコードはUTF-8
        //Connection conn = DriverManager.getConnection(url, "softd", "softd"); //上記URL設定でユーザ名とパスワードを使って接続

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // SELECTの時と同じ
        String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezero=JSTzeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection conn = DriverManager.getConnection(url, "root", "");

        /* 2.1.2 SELECT文の実行 */
        String sql = "SELECT * FROM userinfo WHERE UseId = ? AND UsePass = ? "; //SQL文の設定 ?などパラメータが必要がない場合は通常のStatementを利用
        PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成

        stmt.setInt(1, useid); //Like文で曖昧検索
        stmt.setString(2, usepass ); //Like文で曖昧検索
        
        ResultSet rs = stmt.executeQuery(); //ステートメントを実行しリザルトセットに代入

        /* 2.1.3 結果の取り出しと表示 */
        num = 0;
        int count = 0;
        while (rs.next()) { //リザルトセットを1行進める．ない場合は終了
            this.useid[count] = rs.getInt("UseID");
            this.usepass[count] = rs.getString("UsePass");
            count++;
            num++;
        }

        /* 2.1.4 データベースからの切断 */
        rs.close(); //開いた順に閉じる
        stmt.close();
        conn.close();
        return num;
    }

    /*新規ユーザ登録*/
    public int insert(int useid, String usepass) {
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
            String sql = "INSERT INTO userinfo (UseId,UsePass) VALUES (?,?)"; //SQL文の設定 INSERTはパラメータが必要なことが多い

            PreparedStatement stmt = conn.prepareStatement(sql); //JDBCのステートメント（SQL文）の作成
            stmt.setInt(1, useid); //1つ目の？に引数をセットする
            stmt.setString(2, usepass); //3つ目の？に引数をセットする

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

 

    public int getUseId(int i) {
        if (i >= 0 && num > i) {
            return useid[i];
        } else {
            return 0;
        }
    }

    public String getUsePass(int i) {
        if (i >= 0 && num > i) {
            return usepass[i];

        } else {
            return "";
        }
    }

    public int getNum() {
        return num;
    }
}
