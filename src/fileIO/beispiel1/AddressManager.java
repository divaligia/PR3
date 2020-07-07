package fileIO.beispiel1;

import java.io.*;
import java.util.ArrayList;


public class AddressManager {
    private ArrayList<Address> addresses;

    public AddressManager() {
        addresses = new ArrayList<>();
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address a) {
        addresses.add(a);
    }

    public void exportToCsv(String path, String separator) throws IOException, AddressExportException {
        FileWriter fw = new FileWriter(new File(path));
        PrintWriter pw = new PrintWriter(fw);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        for (Address a : addresses) {
//            bufferedWriter.write(a.getFirstname() + separator + a.getEmail()
//                    + separator + a.getMobileNumber() + separator +a.getEmail());
//            bufferedWriter.newLine();
            pw.println(a.getFirstname() + separator + a.getLastname()
                    + separator + a.getMobileNumber() + separator + a.getEmail());
        }

//        bufferedWriter.flush();
//        bufferedWriter.close();
        pw.flush();
        pw.close();
    }


    public void loadFromCsv(String path, String separator) throws IOException, AddressLoadWrongFormatException, AddressLoadException {
        // clear all addresses, to avoid duplicates
        // addresses.removeAll(addresses);
        // or create auxiliary Arraylist (HilfAarrayList)
        ArrayList<Address> readAddresses = new ArrayList<>();
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);

        // Zum Auslesen mit dem BufferedReader erzeugt man 1 temporären String, dieser übernimmt die Werte zeilenweise
        String pickedRow;
        while ((pickedRow = br.readLine()) != null) {
        // mit split(separator) werden die Einträge in je ein Feld des String[] getrennt gespeichert
        // weil der separator signalisiert, wo die Spalten der Zeile enden/beginnen
            String[] row = pickedRow.split(separator);
        // Falls eine Zeile(Adresseintragung) kürzer/länger als 4 Spalten ist, soll eine Exception geworfen werden
            if (row.length != 4)
                throw new AddressLoadWrongFormatException("4 Spalten erwartet!");
        // Dann wird die neue AL mit den im String[] übernommenen Daten befüllt
            readAddresses.add(new Address(row[0], row[1], row[2], row[3]));
        }
        br.close();
    }
}
