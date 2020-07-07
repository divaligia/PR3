package fileIO.a_directory_file;

import java.io.File;
// mkdirs() kann mehrere Ordner erstellen
public class create_directories {
    public static void main(String[] args) {

        File f = new File("C:\\Users\\kursinstall\\Documents\\Pr3\\neu");
        createDirs(f);
    }

    public static void createDirs(File f){
        // check ob fileObjekt schon existiert und ob es ein Verzeichnis ist
        if(!f.exists() && !f.isDirectory()){
            System.out.println("Directory " + f.getAbsolutePath() + " created?: " + f.mkdirs());
        } else {
        // gibt true aus wenn der/die ordner erstellt wurden
            System.out.println("Directory " + f.getAbsolutePath() + " created?: " + f.mkdirs());
        }
    }
}
