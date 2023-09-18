package exceptions;

public class InputException extends Exception {
    public InputException() {
        super("The input type is not correct");
    }

 

    public String getMessage() {
        return super.getMessage();
    }
}
