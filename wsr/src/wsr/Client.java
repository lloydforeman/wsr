package wsr;
/*
*

* Linking Code.
*
*/

import java.io.File;

public class Client {

public String FirstName;
public String LastName;
public String Address;
public String DOB;
public String Age;
public String City;
public String State;
public String Zip;
public String County;
public String Phone;
private String Gender;
private String FilePath;
private int ID;
private int Rank;

public Client() {
    FirstName ="";
    LastName ="";
    Gender = "";
    ID = 0;
    Rank = 0;
}

public Client(String First, String Last) {
    FirstName = First;
    LastName = Last;
    Address = "";
    DOB = "";
    Age = "";
    City = "";
    State = "";
    Zip = "";
    County = "";
    Phone = "";
    Gender = "";
    ID = 0;
    Rank = 0;
}

public Client(String First, String Last, String address, String dob, String age,
	   String city, String state, String zip, String county, String phone, String gender, int id) {
    
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
}


public String getPhone() {
	return Phone;
}

public void setPhone(String phone) {
	Phone = phone;
}

public String getCounty() {
	return County;
}

public void setCounty(String county) {
	County = county;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getDOB() {
	return DOB;
}

public void setDOB(String dOB) {
	DOB = dOB;
}

public String getAge() {
	return Age;
}

public void setAge(String age) {
	Age = age;
}

public String getCity() {
	return City;
}

public void setCity(String city) {
	City = city;
}

public String getState() {
	return State;
}

public void setState(String state) {
	State = state;
}

public String getZip() {
	return Zip;
}

public void setZip(String zip) {
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

public void SetID(int id) {
    ID = id;
}

public int GetID() {
    return ID;
}

public void SetRank(String rank) {
  if (rank.equals("USER")){
    Rank = 0;
  }
    else if (rank.equals("ADMIN")) {
        Rank = 1;
    }
}

public int GetRank() {
    return Rank;
}



public static void makefile(int ID){

  String userDir = System.getProperty("user.dir");
  File rootDir = File.listRoots()[0];
  File dir = new File(new File(userDir, "Users"), Integer.toString(ID));
  if (!dir.exists()){
        dir.mkdirs();
  }
}

public  static String getClientPath(int ID){
  String userDir = System.getProperty("user.dir");
     return userDir + "Users/" + ID;
}

public static void main(String[] args) {
    System.out.println("Hello World!");
    makefile(001);
 String dir = getClientPath(001);
    System.out.println(dir);

}
}
