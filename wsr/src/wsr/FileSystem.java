package wsr;
/*
 *   FileSystem.java --- Interactive packet manipulation tool
 *
 *   Author: Juan Carlos Torres
 *
 *
 *   $Log:  FileSystem.java
 *
 *   Revision 1.0.0  04/30/2014.
 *   - Creates Folders for new clients, returns the path of the file to enable access to any files
 *     that are saved on this directory
 *
 */

import java.io.File;

public class FileSystem {

 
  public FileSystem() {
//Empty
  }


  public void makefile(String ID){

    String userDir = System.getProperty("user.dir"); 
    File dir = new File(new File(userDir, "Users"), ID);
    if (!dir.exists()){
      dir.mkdirs();
    }

  }

  public String getFileSystemPath(String ID){
    String userDir = System.getProperty("user.dir");
    return userDir +"/Users/" +ID;
  }
 
}
