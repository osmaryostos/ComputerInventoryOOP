package exceptions;

public class EmptyInventory extends Exception{
    public EmptyInventory() {
        super("This inventory is empty..");
    }

    public String getMessage() {
        return super.getMessage();
    }
}
