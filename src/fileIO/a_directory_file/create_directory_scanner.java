package fileIO.a_directory_file;

import java.io.File;
import java.util.Scanner;

public class create_directory_scanner{
       public static void main(String[] args) {
           // mkdir() erstelle ein Verzeichnis  -->ist eine Methode von File - dh ohne File kein neues directory!
           // mkdirs() erstelle Verzeichnis + Subverzeichnisse (Unterverzeichnisse)

           System.out.println("Enter a path to create a directory:");

           Scanner scanner = new Scanner(System.in);
           // Für einen Input durch den User eignet sich ein Scanner,
           // diesem wird der String mit dem gewünschten Pfad für das neue Verzeichnis übergeben
           String path = scanner.next();
           System.out.println("Enter the name of the desired directory:");
           // Hier den Namen des neuen Verzeichnis eingeben (Backslash nicht vergessen!)
           // So lässt sich der Pfad um das neue Verzeichnis erweitern:
           path= path+scanner.next();

           // File Objekt erstellen, um dieses zu erstellen, muss ein Pfad als Parameter übergeben werden
           // Achtung! So entsteht ein File Objekt im Programm, aber noch keine echte Datei am PC
           File file= new File(path);

           // Überprüfen, ob Verzeichnis erstellt wurde, das funktioniert weil mkdir()/mkdirs() einen
           // boolschen Wert zurückliefern
           boolean created = file.mkdirs();
           System.out.println(path);
           if(created){
               System.out.println("created");
           } else {
               System.out.println("not created");
           }
    }
}
