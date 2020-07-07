package fileIO.beispiel1;
// This one gets only thrown, if the File does not exist
public class AddressLoadException extends Exception{
    public AddressLoadException(Throwable cause){
        super(cause);
    }
}
