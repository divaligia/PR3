package fileIO.a_directory_file;

import java.io.File;

public class list_directories {
    // Write a method which lists all filenames of a given directory.
    // Tip: Check if Directory exists, if given File is a directory,
    // to prevent failures. Write a message to console if this is the case

    public static void main(String[] args) {
        File path = new File("C:\\Users\\kursinstall\\Documents\\Pr3\\neu");
        File absolute = new File("/");
        // wenn man hier die datei hinten weglässt, wird sie unten in der konsole ausgegeben, so gilt kommentar zeile 21
        File file = new File("C:\\Users\\kursinstall\\Documents\\Pr3\\neu\\test.txt");
        System.out.print("Pfad zu Pr3: ");
        listDirectories(path);
        System.out.println("------------------");
        System.out.print("Absoluter Pfad: ");
        listDirectories(absolute);
        System.out.println("------------------");
        System.out.print("Pfad zu Textdatei: ");   // Darf nicht funktionieren weil mit der Methode die Inhalte
        listDirectories(file);                     // eines Verzeichnisses ausgegeben werden, nicht von Datei

    }

    public static void listDirectories(File f){
        if(f.exists() && f.isDirectory()){
            String[] files = f.list();           // Diese Methode gibt alle Namen der Dateien in String Array aus
            for(String file : files){
                System.out.println(file);
            }
        } else {
            System.out.println("Doesn't exist or not a directory!");
        }
    }
}
