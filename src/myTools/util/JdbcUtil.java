package myTools.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static final String USER = "root";
    private static final String PWD = "root";
    //创建驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement pst, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst != null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //增删改
    public static int executeUpdate(String sql,Object... obj){
        Connection conn = null;
        PreparedStatement pst = null;
        conn = getConnection();
        int row = 0;
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            if(obj != null){
                for (int i = 0;i < obj.length;i++){
                    pst.setObject(i + 1,obj[i]);
                }
            }
            row = pst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            close(null,pst,conn);
        }
        return row;
    }

    //查（多条件）
    public static <T> List<T> executeQuery(String sql, RowMap<T> rm, Object... obj){
        ArrayList<T> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = getConnection();
        try {
            pst = conn.prepareStatement(sql);
            if (obj != null){
                for(int i = 0;i < obj.length;i++){
                    pst.setObject(i + 1,obj[i]);
                }
            }
            rs = pst.executeQuery();
            while (rs.next()){
                T t = rm.RowMapping(rs);
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,pst,conn);
        }
        return list;
    }


    public static <T> T getOne(String sql, RowMap<T> rm, Object... obj){
        T t = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = getConnection();
        try {
            pst = conn.prepareStatement(sql);
            if (obj != null){
                for(int i = 0;i < obj.length;i++){
                    pst.setObject(i + 1,obj[i]);
                }
            }
            rs = pst.executeQuery();
            while (rs.next()){
                t = rm.RowMapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,pst,conn);
        }
        return t;
    }
}
