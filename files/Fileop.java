/*Write   a   Java   program   that   reads   a   file   name   from
  the   user,   displays   information   about
whether the file exists, whether the file is readab
le, or writable, the type of file and the length
of the file in bytes. */

import java.io.*;
import java.util.Scanner;
class Fileop{
public static void main(String args[]) {
long size;
String str;
File f=null;
String fname;
System.out.print("Enter file name: ");
Scanner stdin= new Scanner(System.in);
fname=stdin.next();
f = new File(fname);
if (!f.exists())
 System.out.println("File "+fname+" does not exists");
else
{ System.out.println("File "+fname+" exists at "+f.getPath());
  checkPermission(f,fname);
  System.out.println("Setting file as read-only...");
  f.setReadOnly();
  checkPermission(f,fname);
  size=f.length();
  System.out.println("The size of the file is: "+size+" bytes");
  str=getFileExtension(f);
 System.out.println("The type of the file is: "+str);
}
}

static String getFileExtension(File f)
{    String extension = "";
     try {
            if (f != null && f.exists()) {
                String name = f.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }
        return extension;
}


static void checkPermission(File f,String fname)
{
  if(f.canRead())
    System.out.println("File "+fname+" is readable");
  else
     System.out.println("File "+fname+" is not  readable");
  if(f.canWrite())
    System.out.println("File "+fname+" is writeable");
  else
     System.out.println("File "+fname+" is not  writeable");
}

}