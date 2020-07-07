package fileIO.a_directory_file;

import java.io.File;
// mkdir() kann nur einen Ordner erstellen, alles was im Pfad davor steht, muss schon vorhanden sein
public class create_directory {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\valen\\Documents\\newSingle");
        if(!file.exists()) {
            if(file.mkdir()){
                System.out.println("Created directory!");
            } else {
                System.out.println("Failed to create directory");
            }
        } else {
            System.out.println("Directory already exists!");
        }
        File moreFiles = new File("C:\\Users\\valen\\Documents\\new\\sub1\\sub2");
        if(!moreFiles.exists()) {
            if(moreFiles.mkdirs()){
                System.out.println("Created multiple directories!");
            } else {
            System.out.println("Failed to create directory");
            }
        } else {
            System.out.println("Directories already exist!");
        }
    }
}
