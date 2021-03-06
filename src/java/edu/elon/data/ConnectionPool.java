package edu.elon.data;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * Establishes connection pool for database connection and web application.
 * @author davidhan
 */
public class ConnectionPool {

  private static ConnectionPool pool = null;
  private static DataSource dataSource = null;

  private ConnectionPool() {
    try {
      InitialContext ic = new InitialContext();
      dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/MySQLDS");
      //dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/mvc2");
    } catch (NamingException e) {
      System.out.println(e);
    }
  }
/**
 * Creates instance of a connection pool.
 * @return 
 */
  public static synchronized ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }

  public Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    }
  }
/**
 * Frees connection when user is finished with SQL commands.
 * @param c 
 */
  public void freeConnection(Connection c) {
    try {
      c.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
