package wsr;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *   DB_Link.java --- Interactive packet manipulation tool
 *
 *     Author: Juan Carlos Torres
 *
 *
 *       $Log:  DB_Link.java
 *
 *       Revision 1.0.0  04/30/2014.
 *       - Created a link functions to access the database
 *        -insert,update,search, delete and print functions were created.
 *
 */

public class DB_Link //extends Client
{
  public static String table = "db_clients";
  public static DataBase DB;
  public static FileSystem FS;

  public DB_Link() throws ClassNotFoundException
  {
    DB = new DataBase(table);
    FS = new FileSystem();
  }

  public void insert(Client client){
    DB.insertToTable(table, client.GetID(), client.GetFirstName(), client.GetLastName(), client.GetAddress(),
        client.GetDOB(), client.GetAge(), client.GetCity(), client.GetState(), client.GetZip(), client.GetCounty(),
        client.GetPhone(), client.GetGender(), client.GetFilePath(), client.GetRank());

    FS.makefile(client.GetID());
  }

  public void update(String table, String ID, String command, String field) {
    DB.updateTable(table, ID, field, command);
  }

  public Client searchById(String id) throws ClassNotFoundException {
    Client temp = DB.searchTableByID(table, id);
    return temp;
  }

  public String getPath(String id) throws ClassNotFoundException {
    String dir = FS.getFileSystemPath(id);
    return dir;
  }

  public void deleteById(String id) throws ClassNotFoundException {
    DB.deleteById(table,id);
  }

  public void printTable() throws ClassNotFoundException {
    DB.printTable(table);
  }

  public ResultSet getTable() {
    return DB.getTable(table);

  }




  public int totalEntries() throws ClassNotFoundException {

    ResultSet rs = DB.getTable(table);

    // public void DisplayDataBase(ResultSet rs) {
    int i = 0;
    try {
      while(rs.next()) {

        i++;  
      }
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }  

    return i;
  }



}

