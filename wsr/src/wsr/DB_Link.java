package wsr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;



public class DB_Link //extends Client
{

  public String FirstName;
  public String LastName;
  private String Gender;
  private String FilePath;
  private int ID;
  private int Rank;

  public static Scanner input = new Scanner(System.in);
  public static String table = "person";
  public static DataBase DB;
  public Client client;
  public static FileSystem FS;

  public DB_Link() throws ClassNotFoundException
  {
    DB = new DataBase(table);
    client = new Client();
    FS = new FileSystem();
    FirstName ="";
    LastName ="";
    Gender = "";
    ID = 0;
    Rank = 0;
  }

  public static void insert(String table, String ID, String LastName, String FirstName, String Gender){
    DB.insertToTable(table, ID, LastName, FirstName, Gender);
    FS.makefile(ID);

  }

  public static void update(String table, String ID, String command, String field) {
    DB.updateTable(table, ID, field, command);//"person", "1000","FirstName", "Pat");
  }


  public static void searchById(String id) throws ClassNotFoundException {
    DB.searchTableByID(table, id);
    String dir = FS.getFileSystemPath(id);
    System.out.println("\n Path to PDF files: " + dir + "\n");
  }

 public static void deleteById(String id) throws ClassNotFoundException {
  DB.deleteById(table,id);

 }

  public static void printTable() throws ClassNotFoundException {
    DB.printTable(table);
  }

  public static void main(String[] args)throws ClassNotFoundException {
    DB_Link link = new DB_Link();

    //print table
    DB.printTable("person");

    String string = "Y";
    InputStreamReader input21 = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input21);

    int val = 5;
    while (val != 0) {

      System.out.println("\n\n        MAIN MENU         \n\n");

      System.out.println("    1:  Add Client");
      System.out.println("    2:  Search for Client & Display Info");
      System.out.println("    3:  Update Client");
      System.out.println("    4:  Detele Client");
      System.out.println("    5:  Generate Report");

      System.out.println("\n\n");
      System.out.print("Please make your choice: ");
      try{
        val = input.nextInt();
        input.nextLine();
      }catch(Exception e){
        System.out.println("Bad input data");
      }



      String firstName = "";
      String lastName = "";
      String gender = "";
      String filePath = "";
      String id = "";


      switch (val){
        case 1:
          try{
            System.out.println("   Adding New Client   ");
            System.out.print("Enter New ID: ");
            id = input.nextLine();
            System.out.print("Enter Last Name: ");
            lastName = input.nextLine();
            System.out.print("Enter First Name: ");
            firstName = input.nextLine();
            System.out.print("Enter Gender: ");
            gender = input.nextLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }

          DB_Link.insert(table, id, lastName, firstName, gender);
//          System.out.print(id + " " + firstName + " " + lastName + " " +gender);

          break;
        case 2:
          System.out.println("   Seach By ID");
          try{
            System.out.print("Enter ID: ");
            id = reader.readLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }
          DB_Link.searchById(id);
          break;
        case 3:
          System.out.println("\n  Updating Client Info  ");
          try{
            System.out.print("Enter ID: ");
            id = input.nextLine();
            System.out.print("Enter First Name: ");
            firstName = input.nextLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }
          DB_Link.update(table, id, firstName, "FirstName");
          break;
        case 4:
          System.out.println("Delete by ID");
          try{
            System.out.print("Enter ID: ");
            id = reader.readLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }
          DB_Link.deleteById(id);
          break;
        case 5:
          System.out.println("\n\n   Printing Report     \n\n");
          DB_Link.printTable();

          break;

      }

    }



  }


}

