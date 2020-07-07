package fileIO.a_directory_file;

import java.io.File;

public class properties {
    // Eigenschaften einer Datei auslesen

   public static void main(String[] args) {

       File file = new File("C:\\Users\\valen\\Documents\\Pr3\\text.txt");
       readFileInformation(file);
   }

// Create a method, which has a parameter File
// The method should print the following information of a file on the console:

    public static void readFileInformation(File file){
       // - Does this file exist?
       System.out.println("file.exists() = " + file.exists());
       // - Name of the File
       System.out.println("file.getName() = " + file.getName());
       // - Parent Directory of the File
       System.out.println("file.getParent() = " + file.getParent());
       // - Path to this File
       System.out.println("file.getPath() = " + file.getPath());
       // - Is this a directory?
       System.out.println("file.isDirectory() = " + file.isDirectory());
       // - Is this a file?
       System.out.println("file.isFile() = " + file.isFile());
       // - Is this file readable?
       System.out.println("file.canRead() = " + file.canRead());
       // - Is this File writeable
       System.out.println("file.canWrite() = " + file.canWrite());
       // - File Size
        System.out.println("file.length() = " + file.length());

    }
}
