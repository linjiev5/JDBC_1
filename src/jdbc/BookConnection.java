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
import java.util.ArrayList;
import object.Book;

/**
 *
 * @author linjie
 */
public class BookConnection {

    
    String url = "jdbc:postgresql://localHost:5432/Lin";
    String user = "postgres";
    String pas = "postgres";


    /**
     * データベースに連結する
     *
     * @return
     */
    public Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, pas);
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 本のデータを取得する
     *
     * @param query
     * @return
     */
    public ArrayList<Book> getBookList(String query) {
        // 本のデータをListで保存する
        ArrayList<Book> bookList = new ArrayList<>();
        Connection connection = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            // sqlを入れて検索する
            rs = st.executeQuery(query);
                // データをループする
                while (rs.next()) {
                    // 本のデータをｂで保存する
                    Book b = new Book();
                    b.setBookId(rs.getInt("bookId"));
                    b.setTitle(rs.getString("title"));
                    b.setAuthor(rs.getString("author"));
                    b.setIsbn(rs.getString("isbn"));
                    b.setPrice(rs.getString("price"));
                    // Listに入れる
                    bookList.add(b);
                }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookList;
    }
   

    /**
     * queryでデータを増やし、削除、更新する
     *
     * @param query
     * @return i
     */
    public int excuteSQLQuery(String query) {
       int i = 0;
        Connection con = getConnection();
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

    /**
     * データベースに同じデータがあるか
     *
     * @param query
     * @return
     */
    public int getSameData(String query) {
        int i = 0;
        Connection con = getConnection();
        Statement stmt;
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

}
