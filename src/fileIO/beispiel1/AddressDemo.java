package fileIO.beispiel1;

import java.io.IOException;

public class AddressDemo {
    public static void main(String[] args) throws AddressLoadException {
        String filePath = "test.csv";
        String seperator = ";";
        AddressManager am = new AddressManager();
        Address a1 = new Address("Tina", "Supperl", "0660", "tina@gmx.at");
        Address a2 = new Address("Christian", "Saurer", "0660", "saurer@gmail.com");
        Address a3 = new Address("Marlene", "Neubauer", "0660", "neubauer@outlook.com");
        Address a4 = new Address("Franz", "Bers", "0660", "fbers@outlook.com");

        am.addAddress(a1);
        am.addAddress(a2);
        am.addAddress(a3);
        am.addAddress(a4);

        try {
            am.exportToCsv(filePath, seperator);
        } catch (AddressExportException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            am.loadFromCsv(filePath, seperator);
        } catch (AddressLoadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new AddressLoadException(e);
        } catch (AddressLoadWrongFormatException e) {
            e.printStackTrace();
        }

        System.out.println(am.getAddresses().toString());

    }
}
