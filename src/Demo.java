
//  	
// Assignment 1
// © OSmary Ostos
// Written by: (Osmary Ostos 2394108)
// 
// This program shows to user a menu to select different options to do on an Array of Objects what is an inventory of computers
 	

import java.util.Date;
import java.util.Scanner;

public class Demo {
    private static final String PASSWORD = "12345";



    public static void main(String[] args) throws Exception {
        Date date = new Date();
        System.out.println(date);
        System.out.println("                          WELCOME! \n              SOFTWARE AND HARWARE COMPUTER STORE \n");
        int maxNumComputers = 0;
      
        // B.1.a) User Enter size of inventory
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
        // B.1.b) Array inventory is created
        Computer[] inventory = new Computer[maxNumComputers];

        //B.1.c Print User Menu
        printMenu(inventory);

      //  Computer c1 = new Computer();
       // Computer c2 = new Computer();
       // Computer.findNumberOfCreatedComputers();

//Print the name of the class
      //  System.out.println(c1.getClass().toString());
      //  c1.equals(c2);
    }



    public static void printMenu(Computer[] inventory){
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
            System.out.print("Please enter your choice >");
            try{
                Scanner kb = new Scanner(System.in); // hacer una excepcion aqui
                optionSelected = kb.nextInt();
            }
            catch(Exception e){
                System.out.println("Please try again");   
             }
            
        }
        act(optionSelected, inventory);
    }
    

    private static void act(int option, Computer[] inventory) {  
        switch(option){
            case 1:
                if(login()){
                    System.out.println("Successful Login");
                    newComputers(inventory);
                }else{
                    printMenu(inventory);
                }

                break;
            default:
                
                
        }
        
    }


private static boolean validateComputer(Computer[] inventory, int numComputers ){
    int spaceInventory = 0;
    int j = 0 ;
         if(numComputers > inventory.length){
          System.out.println("The number of computer is greater than inventory");
          return false;
        }
        //count avalaibable space
        for(int i=0; i< inventory.length; i++){ 
            if(inventory[i] == null) spaceInventory++;
        }
        // System.out.println("We have only " + spaceInventory + " slots avalaibles"); 
        
         if(spaceInventory == 0) {
          System.out.println("There is any space");
          return false;
        }
        if(numComputers > spaceInventory) {
          System.out.println("The remain space of inventory is not enought, try with " + spaceInventory + " or less number of computers");
          return false;
        }
        
       
         return true;

}
    private static void newComputers(Computer[] inventory) {
        // Check space in Array then insert computer
        System.out.println("How many computers do you want to enter");
        Scanner kb = new Scanner(System.in);
        int numComputers = kb.nextInt();
        boolean validComputer = validateComputer(inventory, numComputers);
        if(validComputer){
            String data = "";
            double prix = 0; 
            int iplus;
            for(int i = 0; i < numComputers; i++) {
                iplus = i + 1;
                Computer c = new Computer();
                System.out.println("Enter BRAND of computer " + iplus);
                data = kb.next();
                c.setBrand(data);
               
                System.out.println("Enter MODEL of computer " + iplus);
                data = kb.next();
                c.setModel(data);
                System.out.println("Enter PRICE of computer " + iplus);
                prix = kb.nextInt();
                c.setPrice(prix);
                
                //validar el espacio vacio o posicion vacia
                inventory[i] = c;
            }
            
        }
        //Check space on inventory
        boolean validNumber = false;
       
    }



    private static boolean login() {
        int countErrors = 0;
        Scanner kb = new Scanner(System.in);

        while (countErrors <3) {
         
            System.out.println("Enter Password");
            String userPassw = kb.next();

            if(PASSWORD.equals(userPassw) ){
                 return true;
            }else{
                countErrors++;
                 if (countErrors <3){
                    System.out.println("Try Again(" + countErrors + ")");
                 }else{
                    break;
                 }
                
            }

        }
        System.out.println("Do not match");
        return false;
        
    }

}

