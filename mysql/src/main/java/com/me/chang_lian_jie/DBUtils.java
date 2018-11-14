package com.me.chang_lian_jie;

/**
 * @author: shimingming
 * @create: 2018-11-05
 * @description:
 **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;
public class DBUtils {
    /**
     * 初始化的时候就会创建一个数据库连接。等处理完了之后再关闭
     * 情况：长连接
     * */
    private Connection conn = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public DBUtils() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456789");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        conn = null;
    }
    public ResultSet myResultSet(String sqls) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sqls);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            while((e = e.getNextException()) != null) {
                System.out.println(e.getMessage());
            }

        } finally {
            statement = null;
        }
        return rs;
    }
    public int executeSQL(String sqls) {
        Statement statement = null;
        int count = 0;
        try {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            statement = conn.createStatement();
            count = statement.executeUpdate(sqls);
            statement.executeUpdate("insert into innodb(name) values('e')");
            statement.executeUpdate("insert into innodb(names) values('e')");
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println(e.getMessage());
            while((e = e.getNextException()) != null) {
                System.out.println(e.getMessage());
            }

        } finally {
            statement = null;
        }
        return count;
    }
    public boolean executeMethod(String sqls) {
        Statement statement = null;
        boolean results = false;
        try {
            statement = conn.createStatement();
            results = statement.execute(sqls);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            while((e = e.getNextException()) != null) {
                System.out.println(e.getMessage());
            }

        } finally {
            statement = null;
        }
        return results;
    }
    private void init() throws SQLException {
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("insert into innodb(name) value(?)");
        pstmt.clearParameters();
        pstmt.setString(1, "hko");
        pstmt.executeUpdate();
    }
    public static void main(String[] args) throws SQLException, InterruptedException {
        DBUtils tool = new DBUtils();
        long i=0;
        while(true) {
            System.out.println("**");
            tool.init();
            i++;
            if (i>100000) break;
        }
        tool.closeConnection();
    }
}
