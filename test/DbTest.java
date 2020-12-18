/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import jdbc.LogninConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class DbTest {

    public DbTest() {
    }


//    @Test
//    public  void queryが実行できない() throws Exception{
//        LogninConnection lc = new LogninConnection();
//        String query = "insert into bookData(bookId,title,author,isbn,price)values(\n"
//                + ",'','dtt'"
//                + ");";
//        int expected = 0;
//        int actual = lc.excuteSQLQuery(query);
//    }
//    @Test
//    public  void queryが実行できる() throws Exception {
//        LogninConnection lc = new LogninConnection();
//        String query ="insert into bookData(bookId,title,author,isbn,price)values(nextval('bookData_bookId_seq'),'we','dtt','fg','121');";
//
//        int expected = 1;
//        int actual = lc.excuteSQLQuery(query);
////        assertThat(actual,is(expected));
//    }
    @Test
    public  void query_1() throws Exception {
        LogninConnection lc = new LogninConnection();
        String query ="SELECT * FROM bookdata WHERE title  LIKE '%d%'or author like '%4%';";

        int expected = 1;
        int actual = lc.getSameData(query);
//        assertThat(actual,is(expected));
//           assertThat(actual, expected);
    }
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
