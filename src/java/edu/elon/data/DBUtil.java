package edu.elon.data;

import java.sql.*;
/**
 * Utility class that includes different methods for closing SQL statements.
 * @author davidhan
 */
public class DBUtil {
/**
 * Closes SQL Statement.
 * @param s 
 */
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
/**
 * Closes Prepared SQL Statement.
 * @param ps 
 */
    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
/**
 * Closes Result Set for SQL.
 * @param rs 
 */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}