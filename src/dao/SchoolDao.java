package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SchoolDao {

    // データベース接続情報
    private static final String URL = "jdbc:h2:~/teambkazuyoshi";
    private static final String USER = "teambkazuyoshi";
    private static final String PASSWORD = "";

    /**
     * schoolテーブルからすべてのschool_nameを取得するメソッド
     *
     * @return List<String> すべてのschool_nameを含むリスト
     */
    public List<String> getSchoolNames() {
        // school_nameを格納するリストを初期化
        List<String> schoolNames = new ArrayList<>();

        // SQL文の定義: schoolテーブルからschool_nameカラムのみを取得する
        String sql = "SELECT school_name FROM school";

        try {
            // H2ドライバをロード
            Class.forName("org.h2.Driver");

            // リソースの自動クローズを行うtry-with-resources構文を使用
            try (
                // データベース接続を取得
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

                // SQL文を実行するためのPreparedStatementを作成
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // クエリを実行し、結果セット(ResultSet)を取得
                ResultSet rs = pstmt.executeQuery()
            ) {
                // 結果セットからschool_nameカラムのデータを1件ずつ取り出す
                while (rs.next()) {
                    // school_nameカラムのデータをリストに追加
                    schoolNames.add(rs.getString("school_name"));
                }
            }
        } catch (Exception e) {
            // 例外が発生した場合はエラーメッセージを表示
            e.printStackTrace();
        }

        // 取得したschool_nameのリストを返す
        return schoolNames;
    }
}
