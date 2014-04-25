package wsr;

/*
*


*Linking Code.
*
*/

import java.io.File;

public class FileSystem {

//private String ID;

public FileSystem() {
//    ID = "";
}


public void makefile(String ID){

  String userDir = System.getProperty("user.dir");
  File rootDir = File.listRoots()[0];
  File dir = new File(new File(userDir, "Users"), ID);
  if (!dir.exists()){
        dir.mkdirs();
  }
}

public  static String getFileSystemPath(String ID){
  String userDir = System.getProperty("user.dir");
     return userDir + "Users/" + ID;
}
/*
public static void main(String[] args) {
    System.out.println("Hello World!");
    makefile(001);
 String dir = getFileSystemPath(001);
    System.out.println(dir);

}
*/

}
