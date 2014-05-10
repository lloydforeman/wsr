package wsr;
/*
 *   Client.java --- Interactive packet manipulation tool
 *
 *   Author: Juan Carlos Torres
 *
 *
 *   $Log:  Clien.java
 *
 *   Revision 1.0.0  04/30/2014
 *    - Added all the necessary object attributes for the database
 *
 *
 */


public class Client {

  private String FirstName;
  private String LastName;
  private String Address;
  private String DOB;
  private String Age;
  private String City;
  private String State;
  private String Zip;
  private String County;
  private String Phone;
  private String Gender;
  private String FilePath;
  private String ID;
  private String Rank;

  public Client() {
    FirstName = "";
    LastName = "";
    Address = "";
    DOB = "";
    Age = "";
    City = "";
    State = "";
    Zip = "";
    County = "";
    Phone = "";
    Gender = "";
    FilePath = "";
    ID = "";
    Rank = "";
  }

  public Client(String First, String Last, String address, String dob, String age, String filepath, String rank,
      String city, String state, String zip, String county, String phone, String gender, String id) {

    FirstName = First;
    LastName = Last;
    Address = address;
    DOB = dob;
    Age = age;
    City = city;
    State = state;
    County = county;
    Phone = phone;
    Zip = zip;
    Gender = gender;
    ID = id;
    FilePath = filepath;
    Rank = rank;
  }


  public String GetPhone() {
    return Phone;
  }

  public void SetPhone(String phone) {
    Phone = phone;
  }

  public String GetCounty() {
    return County;
  }

  public void SetCounty(String county) {
    County = county;
  }

  public String GetAddress() {
    return Address;
  }

  public void SetAddress(String address) {
    Address = address;
  }

  public String GetDOB() {
    return DOB;
  }

  public void SetDOB(String dOB) {
    DOB = dOB;
  }

  public String GetAge() {
    return Age;
  }

  public void SetAge(String age) {
    Age = age;
  }

  public String GetCity() {
    return City;
  }

  public void SetCity(String city) {
    City = city;
  }

  public String GetState() {
    return State;
  }

  public void SetState(String state) {
    State = state;
  }

  public String GetZip() {
    return Zip;
  }

  public void SetZip(String zip) {
    Zip = zip;
  }

  public void SetFirstName(String first) {
    FirstName = first;
  }

  public String GetFirstName() {
    return FirstName;
  }

  public void SetLastName(String last) {
    LastName = last;
  }

  public String GetLastName() {
    return LastName;
  }

  public void SetGender(String gender) {
    Gender = gender;
  }

  public String GetGender() {
    return Gender;
  }

  public void SetID(String id) {
    ID = id;
  }

  public String GetID() {
    return ID;
  }

  public void SetRank(String rank) {
    Rank = rank;
  }

  public String GetRank() {
    return Rank;
  }

  public void SetFilePath(String path){
    FilePath = path;

  }

  public  String GetFilePath(){
    //    String userDir = System.getProperty("user.dir");
    //    return userDir + "/Users/" + ID;
    return FilePath;
  }

  public void printAll(Client temp){
    System.out.println(temp.GetID()+ ", " + temp.GetFirstName()+ ", " + temp.GetLastName()+ ", " + temp.GetAddress() + ", " +
        temp.GetDOB()+ ", " + temp.GetAge()+ ", " + temp.GetCity()+ ", " + temp.GetState()+ ", " + temp.GetZip()+ ", " + temp.GetCounty() + ", " +
        temp.GetPhone()+ ", " + temp.GetGender()+ ", " + temp.GetFilePath()+ ", " + temp.GetRank());

  }

}
