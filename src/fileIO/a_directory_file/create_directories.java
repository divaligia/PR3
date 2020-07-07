package fileIO.a_directory_file;

import java.io.File;
// mkdirs() kann mehrere Ordner erstellen
public class create_directories {
    public static void main(String[] args) {
        createDirs(new File("C:\\Users\\valen\\Documents\\campus02\\test\\neu\\2020"));
    }

    public static void createDirs(File f){
        // check ob fileObjekt schon existiert und ob es ein Verzeichnis ist
//        if(!f.exists() && !f.isDirectory()){
//            System.out.println("Directory " + f.getAbsolutePath() + " created?: " + f.mkdirs());
//        } else {
            System.out.println("Directory " + f.getAbsolutePath() + " created?: " + f.mkdirs());
//        }
    }
}
