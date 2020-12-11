/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class AccountConnection {

    Connection con;
    Statement stmt;
    String url = "jdbc:postgresql://localHost:5432/Lin";
    String users = "postgres";
    String pas = "postgres";
    /**
     * データベースに連結する
     *
     * @return
     */
    public Connection getConnection() {
        
        try {
            con = DriverManager.getConnection(url, users, pas);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     /**
     * データベースに同じデータがあるか
     *
     * @param query
     * @return
     */
    public int getSameData(String query) {
        int i = 0;
        con = getConnection();
        try {
            stmt = con.createStatement();
            // sqlqueryで検索する
            ResultSet rs = stmt.executeQuery(query);
            // データが存在する場合
            
            if (rs != null && rs.next()) {
                i = 1;
            } else {
                // データがなければiは0のまま戻る
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i);
        return i;
    }
    /**
     * queryでデータを増やし、削除、更新する
     *
     * @param query
     * @return i
     */
    public int excuteSQLQuery(String query) {
       int i = 0;
        con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            // 入れたsqlを実行する
            System.out.println(query);
             i = st.executeUpdate(query);
            con.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
