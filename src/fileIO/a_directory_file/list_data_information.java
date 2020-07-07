package fileIO.a_directory_file;

import java.io.File;

public class list_data_information {
    // Schreiben Sie eine Anwendung, die alle Dateien eines Ordners sowie deren Größen auf der Konsole ausgibt
    // ▪ Tipp: File.length() gibt einen Long Wert einer Datei zurück
    // und die Gesamtgröße aller Dateien (dieses Ordners) berechnet sowie auf der Konsole ausgibt

    // Unterschied list() und listFiles():
    // list() method returns the names of all files in the given directory in the form of a String Array
    // listFiles() method returns the objects(File) of the files in the given directory, in the form of an
    // Array of Type File
    public static void main(String[] args) {
        File dir = new File("C:\\\\Users\\\\kursinstall\\\\Documents");
        listDirContent(dir);

    }

    public static void listDirContent(File f){
        if(f.isDirectory()){
            // Long zum aufsummieren der Größe aller Dateien
            long filesize = 0;
            // Iterate through directory; listFiles() was created to return array of Files(Objects)
            for (File file : f.listFiles()){
            // Jede Datei + Größe ausgeben
                System.out.println("Filename: " + file.getName() + ", Size: " + file.length());
                filesize += file.length();
            } System.out.println("Gesamtgröße: " + filesize);
        } else System.out.println("Not a directory");

    }
}
