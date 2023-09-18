
//  	
// Assignment 1
// © OSmary Ostos
// Written by: (Osmary Ostos 2394108)
// 
// This program shows to user a menu to select different options to do on an Array of Objects what is an inventory of computers

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FileException;
import exceptions.InputException;

public class Demo {
    private static final String PASSWORD = "12345";

    public static void main(String[] args) throws InputMismatchException {
        Date date = new Date();
        System.out.println(date);
        System.out.println("                          WELCOME! \n              SOFTWARE AND HARWARE COMPUTER STORE \n");
        int maxNumComputers = 0;

        // B.1.a) User Enter size of inventory
        while (maxNumComputers < 1) {
            try {
                System.out.println(" How many computers we can save today?...");
                Scanner kb = new Scanner(System.in); // hacer una excepcion aqui
                maxNumComputers = kb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Not valid type input, try again...");

               
            }
        }
        // B.1.b) Array inventory is created
        Computer[] inventory = new Computer[maxNumComputers];

        // B.1.c Print User Menu
        printMenu(inventory);

        // Computer c1 = new Computer();
        // Computer c2 = new Computer();
        // Computer.findNumberOfCreatedComputers();

        // Print the name of the class
        // System.out.println(c1.getClass().toString());
        // c1.equals(c2);
    }

    public static void printMenu(Computer[] inventory) {
        System.out.println();

        int optionSelected = 0;
        while (optionSelected != 5) {
            System.out.println();
            System.out.println("      ***What do you want to do?***");
            System.out.println("1.\tEnter new computers (password required)");
            System.out.println("2.\tChange information of a computer (password required)");
            System.out.println("3.\tDisplay all computers by a specific brand");
            System.out.println("4.\tDisplay all computers under a certain a price.");
            System.out.println("5.\tQuit");
            System.out.print("Please enter your choice >");
            try {
                Scanner kb = new Scanner(System.in);
                optionSelected = kb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try again");
            }

            act(optionSelected, inventory);

        }

    }

    private static Computer[] printMenuComputer(Computer[] inventory, int position) {
        int optionSelected = 0;
        while (optionSelected != 5) {
            System.out.println("***What information would you like to change?***");
            System.out.println();
            System.out.println("1.\tBrand");
            System.out.println("2.\tModel");
            System.out.println("3.\tSN");
            System.out.println("4.\tPrice");
            System.out.println("5.\tQuit");
            System.out.println("Enter your choice>");
            Scanner kb = new Scanner(System.in);
            String brand, model;
            double prix;
            try {

                optionSelected = kb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try again");
            }

            switch (optionSelected) {
                case 1:
                    System.out.println("Enter new Brand:");
                    brand = kb.next();
                    inventory[position].setBrand(brand);
                    System.out.println("\n +++Modified Computer+++");
                    System.out.println(inventory[position].toString());
                    break;
                case 2:
                    System.out.println("Enter new Model:");
                    model = kb.next();
                    inventory[position].setModel(model);
                    System.out.println("Modified Computer:");
                    System.out.println(inventory[position].toString());
                    break;
                case 3:
                    System.out.println("Enter SN:");
                    System.out.println("I am sorry, this is a unique number \n");
                    // String serial = kb.next();
                    // inventory[position].setSN(serial); //se debe cambiar?
                    break;
                case 4:
                    System.out.println("Enter new Price:");
                    prix = kb.nextInt();
                    inventory[position].setPrice(prix);
                    System.out.println("Modified Computer:");
                    System.out.println(inventory[position].toString());
                    break;
                case 5:
                    System.out.println("....SO, HAVE A GOOD DAY =)");
                    break;
                default:
                    break;

            }
        }
        return inventory;

    }

    private static Computer[] findCheaperThan(Computer[] inventory, double prix) {
        if (emptyInventory(inventory)) {
            return inventory;
        }
        Computer[] auxinventory = new Computer[inventory.length];
        int j = 0;
        System.out.println("////List of computers founded/////");
        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i].getPrice() <= prix) {
                System.out.println(inventory[i].toString());
                // Copy constructor
                Computer cfilter = new Computer(inventory[i]);
                auxinventory[j] = cfilter;
                j++;
            }
        }

        return auxinventory;
    }

    private static Computer[] findComputersByBrand(Computer[] inventory, String brand) {
        if (emptyInventory(inventory)) {
            return inventory;
        }
        Computer[] auxinventory = new Computer[inventory.length];
        int j = 0;
        System.out.println("////List of computers founded/////");
        for (int i = 0; i < inventory.length; ++i) {
            if (inventory[i].getBrand().equals(brand)) {

                System.out.println(inventory[i].toString());
                // Copy constructor
                Computer cfilter = new Computer(inventory[i]);
                auxinventory[j] = cfilter;
                j++;
            }
        }

        return auxinventory;
    }

    private static void act(int option, Computer[] inventory) {
        Computer[] auxComp = inventory;
        Scanner kb = new Scanner(System.in);
        switch (option) {
            case 1:
                if (login()) {
                    System.out.println("Successful Login... \n");
                    auxComp = newComputers(inventory);

                    inventory = auxComp;
                    printMenu(inventory);
                } else {
                    printMenu(inventory);
                }
                break;
            case 2:
                if (login()) {
                    System.out.println("Successful Login");
                    auxComp = updateComputer(inventory);
                    inventory = auxComp;
                    printMenu(inventory);
                } else {
                    printMenu(inventory);
                }
                break;
            case 3:
                System.out.println("Enter Brand to search Serial:");
                String brand = kb.next();
                Computer[] auxinventory;
                auxinventory = findComputersByBrand(inventory, brand);
                break;
            case 4:
                System.out.println("Enter Price:");
                double prix = kb.nextInt();
                auxinventory = findCheaperThan(inventory, prix);
                break;
            case 5:
                System.out.println();
                System.out.println("++++&&&Thank you for using Computer Inventory System!.&&&++++");
                try {
                    createBackup(inventory);
                }catch (Exception e) {
                    String s = e.getMessage();
                    System.out.println(s);
                }

            default:

        }

    }

    private static void createBackup(Computer[] inventory) throws FileException {
        System.out
                .println("..For security reasons we will create a copy of this inventory, please check your directory");
        if (inventory.length == 0)
            return; // agregar una exception
            PrintWriter pw = null;
        for (Computer cop : inventory) {
            try {
                pw = new PrintWriter(new FileOutputStream("./backups/Machine" + cop.getSN() + ".txt", true));
                pw.println(cop.toString());
            } catch (Exception e) {
                throw new FileException("!An unexpected error ocurred in the files...");
            }
            pw.close();
        }

    }

    private static Computer[] updateComputer(Computer[] inventory) {
        // System.out.println("recibo" + Arrays.toString(inventory));
        Scanner kb = new Scanner(System.in);
        int lenght = inventory.length;
        System.out.println("Please Enter the position of computer you need to update, less than " + lenght + " ...");
        int optionSelected = kb.nextInt();
        if (optionSelected > lenght) {
            System.out.println("The position is not in the inventory");
        } else if (inventory[optionSelected] == null) { // saca error
            String yn = "u";

            while (!(yn.toLowerCase().equals("n") || yn.toLowerCase().equals("y"))) {
                System.out.println(
                        "The position is empty, Do you want to create a new Computer with new values? (Y) or back to main menu? (N)");
                yn = kb.next();
                if (yn.toLowerCase().equals("y")) {
                    Computer[] auxComp = newComputers(inventory);// que hacer luegooooo?
                } else if (yn.toLowerCase().equals("n")) {
                    printMenu(inventory);
                }

            }
        } else { // valid position
            System.out.println("antes de actualizar");
            int auxPosition = optionSelected + 1;
            System.out.println("Computer#: " + auxPosition);
            System.out.println(inventory[optionSelected].toString());
            printMenuComputer(inventory, optionSelected);
        }
        return inventory;

    }

    private static boolean validateComputer(Computer[] inventory, int numComputers) {
        int spaceInventory = 0;
        int j = 0;
        if (numComputers > inventory.length) {
            System.out.println("The number of computer is greater than inventory");
            return false;
        }
        // count avalaibable space
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null)
                spaceInventory++;
        }
        // System.out.println("We have only " + spaceInventory + " slots avalaibles");

        if (spaceInventory == 0) {
            System.out.println("\n There is any space \n");
            return false;
        }
        if (numComputers > spaceInventory) {
            System.out.println("The remain space of inventory is not enought, try with " + spaceInventory
                    + " or less number of computers");
            return false;
        }

        return true;

    }

    private static boolean emptyInventory(Computer[] inventory) {
        int spaceInventory = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null)
                spaceInventory++;
        }
        if (spaceInventory == inventory.length || inventory.length == 0 || inventory == null) {
            System.out.println("\n +++This inventory is empty =(, try add some computers++++");
            return true; // all spaces are empties
        }
        return false;
    }

    private static Computer[] newComputers(Computer[] inventory) {
        // Check space in Array then insert computer
        System.out.println("How many computers do you want to enter");
        Scanner kb = new Scanner(System.in);
        int numComputers = kb.nextInt();
        boolean validComputer = validateComputer(inventory, numComputers);
        if (validComputer) {
            String data = "";
            double prix = 0;
            int iplus;
            for (int i = 0; i < numComputers; i++) {
                iplus = i + 1;
                Computer c = new Computer();
                System.out.println();
                System.out.println("Enter BRAND of computer... " + iplus);
                data = kb.next();
                c.setBrand(data);

                System.out.println("Enter MODEL of computer... " + iplus);
                data = kb.next();
                c.setModel(data);
                System.out.println("Enter PRICE of computer... " + iplus);
                prix = kb.nextInt();
                c.setPrice(prix);

                // valid empty space or empty position
                if (inventory[i] == null) {
                    inventory[i] = c;
                } else {
                    continue;
                }
            }

        }
        // Check space on inventory
        System.out.println(Arrays.toString(inventory));
        return inventory;

    }

    private static boolean login() {
        int countErrors = 0;
        Scanner kb = new Scanner(System.in);

        while (countErrors < 3) {

            System.out.println("\n Enter Password");
            String userPassw = kb.next();

            if (PASSWORD.equals(userPassw)) {
                return true;
            } else {
                countErrors++;
                if (countErrors < 3) {
                    System.out.println("Try Again(" + countErrors + ")");
                } else {
                    break;
                }

            }

        }
        System.out.println("Do not match");
        return false;

    }

}
