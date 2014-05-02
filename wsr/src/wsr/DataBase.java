package wsr;
/*
 *   DataBase.java --- Interactive packet manipulation tool
 *
 *   Author: Juan Carlos Torres
 *
 *
 *   $Log:  DataBase.java
 *
 *   Revision 1.0.0  04/30/2014.
 *   - Created a database file with the required fields as suggested by the client,
 *     created insert, delete, search, update and print functions coded on sqlite
 *     to enable the direct interaction with the database.
 *
 */


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
      connection = DriverManager.getConnection("jdbc:sqlite:DataBase/client_data_base.db");
      statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      // Used to Create the database when needed
      //       statement.executeUpdate("drop table if exists db_clients"); // DELETES THE TABLE IF IT EXISTS
      //      Create database file
      //     statement.executeUpdate("create table db_clients (ID string, FirstName string, LastName string, " +
      //                             "Address string, DOB string, Age string, City string, State string, Zip string, " +
      //                             "County string, Phone string, Gender string, FilePath string, Rank string)");


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

  public void insertToTable(String table, String ID, String FirstName, String LastName, String Address,
      String DOB, String Age, String City, String State, String Zip, String County, String Phone,
      String Gender, String FilePath, String Rank) {

    String cmd2 = "insert into " + table + " values('" + ID +"', '" + LastName + "', '" + FirstName + "', '" + Address + "', '" +
      DOB  + "', '" + Age  + "', '" + City  + "', '" + State  + "', '" + Zip  + "', '" + County  + "', '" + Phone  + "', '" +
      Gender  + "', '" + FilePath + "', '" + Rank + "')";

    try
    {
      statement.executeUpdate(cmd2);
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
  }

  public void updateTable(String table, String ID, String table_Field, String updated_field) {

    String cmd2 = "update " + table + " set "+ table_Field + " = '" + updated_field + "' where ID = " + ID;
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


  public Client searchTableByID(String table, String ID) throws ClassNotFoundException {
    //   SELECT * FROM COMPANY WHERE SALARY = 10000;
    String cmd2 = "select * from '" + table + "' where ID = " + ID;
    Client client_test = new Client();
    FileSystem FS = new FileSystem();
    try
    {
      statement.executeUpdate(cmd2);
      rs = statement.executeQuery(cmd2); //print all
      while(rs.next())
      {
        // read the result set
 
        client_test.SetFirstName(rs.getString("FirstName"));
        client_test.SetLastName(rs.getString("LastName"));
        client_test.SetGender(rs.getString("Gender"));
        client_test.SetID(rs.getString("ID"));
        client_test.SetAddress(rs.getString("Address"));
        client_test.SetDOB(rs.getString("DOB"));
        client_test.SetAge(rs.getString("Age"));
        client_test.SetCity(rs.getString("City"));
        client_test.SetState(rs.getString("State"));
        client_test.SetZip(rs.getString("Zip"));
        client_test.SetCounty(rs.getString("County"));
        client_test.SetPhone(rs.getString("Phone"));
        client_test.SetFilePath(FS.getFileSystemPath("ID"));
        client_test.SetRank("ACTIVE");

      }
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }

    return client_test;
  }


  public void printTable(String table) throws ClassNotFoundException {
    String cmd = "select * from '" + table +"'"; //print all
    try
    {
      rs = statement.executeQuery(cmd); //print all
      while(rs.next())
      {
        String out = rs.getString("ID") + ", "  + rs.getString("LastName") + ", "  + rs.getString("FirstName") + ", "  + rs.getString("Address") +
          rs.getString("DOB") + ", "  + rs.getString("Age") + ", "  + rs.getString("City") + ", "  + rs.getString("State") + ", "  + rs.getString("Zip") +
          rs.getString("County") + ", "  + rs.getString("Phone") + ", "  + rs.getString("Gender")  + ", "  + rs.getString("FilePath");

        System.out.println("Client " + out );
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

}
