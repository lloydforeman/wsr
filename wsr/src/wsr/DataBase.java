package wsr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase //extends Client
{

  public Connection connection;
  public Statement statement;
  public ResultSet rs;


  /*
   * Open, Create Table
   *
   */
  public DataBase(String table) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");
    Connection connection = null;

    try {
      connection = DriverManager.getConnection("jdbc:sqlite:client_data_base.db");
      statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      //  statement.executeUpdate("drop table if exists person"); // DELETES THE TABLE IF IT EXISTS
      //Create database file
     // statement.executeUpdate("create table person (ID string, LastName string, FirstName string, Gender string)");
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
  }

  /*
   *
   * Close table once we are done
   */
  public void De_DataBase() throws ClassNotFoundException
  {
    try
    {
      if(connection != null)
        connection.close();
    }
    catch(SQLException e)
    {
      System.err.println(e);
    }

  }

  public void insertToTable(String table, String ID, String LastName, String FirstName, String Gender){

    String cmd2 = "insert into " + table + " values('" + ID +"', '" + LastName + "', '" + FirstName + "', '" + Gender + "')";
    try
    {
      statement.executeUpdate(cmd2);
      //statement.executeUpdate("insert into person values(001, 'Torres', 'Juan-Carlos', 'Male')"); //insert
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
  }

  public void updateTable(String table, String ID, String command, String field) {

    String cmd2 = "update " + table + " set "+ command + " = '" + field + "' where ID = " + ID;
    try
    {
      statement.executeUpdate(cmd2);
      // UPDATE COMPANY SET ADDRESS = 'Texas' WHERE ID = 6;
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
  }


  public void searchTableByID(String table, String ID) throws ClassNotFoundException {
    //   SELECT * FROM COMPANY WHERE SALARY = 10000;
    String cmd2 = "select * from '" + table + "' where ID = " + ID;
    try
    {
      statement.executeUpdate(cmd2);
      rs = statement.executeQuery(cmd2); //print all
      while(rs.next())
      {
        // read the result set
        System.out.println("Client " + rs.getInt("ID") + ": " + rs.getString("FirstName") + " " + rs.getString("LastName") );
      }
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
  }


  public void printTable(String table) throws ClassNotFoundException {
    String cmd = "select * from '" + table +"'"; //print all
    try
    {
      rs = statement.executeQuery(cmd); //print all
      while(rs.next())
      {
        // read the result set
        System.out.println("Client " + rs.getInt("ID") + ": " + rs.getString("FirstName") + " " + rs.getString("LastName") );
      }
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
  }


public void deleteById(String table, String id) throws ClassNotFoundException {
  String cmd = "delete from '" + table + "'where ID =" + id;

  try {
    rs = statement.executeQuery(cmd);
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
}



  /*
     public static void main(String[] args)throws ClassNotFoundException
     {

     Client client = new Client();
     DataBase DB = new DataBase("person");


  // load the sqlite-JDBC driver using the current class loader
  System.out.println("Client " );

  // DB.insertToTable("person", "0004","Torres", "Juan-Carlos", "Male");
  // DB.insertToTable("person", "1000","stark", "Tony", "Male");
  DB.updateTable("person", "1000","FirstName", "Pat");


  DB.printTable("person");
  //Set Functions
  //client.SetID(rs.getInt("ID"));
  //client.SetFirstName(rs.getString("FirstName"));
  //client.SetLastName(rs.getString("LastName"));
  //client.SetGender(rs.getString("Gender"));


  DB.De_DataBase();
     }
     */
}

