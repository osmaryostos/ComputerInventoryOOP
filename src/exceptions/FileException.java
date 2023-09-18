package exceptions;

public class FileException extends Exception {
  
  
        public FileException() {
            super("We had some problems making backup");
        }
    
        public FileException(String s) {
            super(s);
        }
    
     
    
    }  

