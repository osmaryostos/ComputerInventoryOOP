import java.util.Date;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        System.out.println(date);
        System.out.println("                          WELCOME! \n              SOFTWARE AND HARWARE COMPUTER STORE \n");
        int maxNumComputers = 0;

        // B.1.a)
        while ( maxNumComputers < 1) {
            try {
                System.out.println(" How many computers we can save today?...");
                Scanner kb = new Scanner(System.in); // hacer una excepcion aqui
                maxNumComputers = kb.nextInt();
            }
            catch (Exception e){
              //  throw new Exception("There is an error try again");
                System.out.println("There is an error, try again");
            }
        }
        // B.1.b)
        Computer[] inventory = new Computer[maxNumComputers];

        //B.1.c
        int option = printMenu();

        act(option);
      //  Computer c1 = new Computer();
       // Computer c2 = new Computer();
       // Computer.findNumberOfCreatedComputers();

//Print the name of the class
      //  System.out.println(c1.getClass().toString());
      //  c1.equals(c2);
    }



    public static int printMenu(){
        System.out.println();
        System.out.println("      ***What do you want to do?***");
        int optionSelected = 0;
        while ( optionSelected <=0 || optionSelected >5) {
            System.out.println();
            System.out.println("1.\tEnter new computers (password required)");
            System.out.println("2.\tChange information of a computer (password required)");
            System.out.println("3.\tDisplay all computers7 by a specific brand");
            System.out.println("4.\tDisplay all computers under a certain a price.");
            System.out.println("5.\tQuit");
            Scanner kb = new Scanner(System.in); // hacer una excepcion aqui
            optionSelected = kb.nextInt();
        }
        return optionSelected;
    }
    private static void act(int option) {
        
        System.out.println("4sdsd");
    }
}

