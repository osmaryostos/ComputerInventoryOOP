
//  	
// Assignment 1
// © OSmary Ostos
// Written by: (Osmary Ostos 2394108)
// 
// This program shows to user a menu to select different options to do on an Array of Objects what is an inventory of computers

import java.util.Arrays;
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
        while (maxNumComputers < 1) {
            try {
                System.out.println(" How many computers we can save today?...");
                Scanner kb = new Scanner(System.in); // hacer una excepcion aqui
                maxNumComputers = kb.nextInt();
            } catch (Exception e) {
                // throw new Exception("There is an error try again");
                System.out.println("There is an error, try again");
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

        System.out.println("      ***What do you want to do?***");
        int optionSelected = 0;
        while (optionSelected <= 0 || optionSelected > 5) {
            System.out.println();
            System.out.println("1.\tEnter new computers (password required)");
            System.out.println("2.\tChange information of a computer (password required)");
            System.out.println("3.\tDisplay all computers7 by a specific brand");
            System.out.println("4.\tDisplay all computers under a certain a price.");
            System.out.println("5.\tQuit");
            System.out.print("Please enter your choice >");
            try {
                Scanner kb = new Scanner(System.in);
                optionSelected = kb.nextInt();
            } catch (Exception e) {
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
            } catch (Exception e) {
                System.out.println("Please try again");
            }
            Computer[] auxinventory;
            switch (optionSelected) {
                case 1:
                    System.out.println("Enter new Brand:");
                    brand = kb.next();
                    inventory[position].setBrand(brand);
                case 2:
                    System.out.println("Enter new Model:");
                    model = kb.next();
                    inventory[position].setModel(model);
                case 3:
                    System.out.println("Enter SN:");
                    String serial = kb.next();
                    //inventory[position].setSN(serial); //se debe cambiar?
                case 4:
                    System.out.println("Enter new Model:");
                    prix = kb.nextInt();
                    inventory[position].setPrice(prix);
                case 5:
                    System.out.println("....SO, HAVE A GOOD DAY =)");
            }
        }

        return inventory;

    }

    private static Computer[] findCheaperThan(Computer[] inventory, double prix) {
        Computer[] auxinventory = new Computer[inventory.length];
        int j = 0;
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("////List of computers founded/////");
            if (inventory[0].getPrice() <= prix) {
                System.out.println(inventory[i].toString());
                // Copy constructor
                Computer cfilter = new Computer(inventory[i]);
                auxinventory[j] = cfilter;
            }
        }

        return auxinventory;
    }

    private static Computer[] findComputersByBrand(Computer[] inventory, String brand) {
        Computer[] auxinventory = new Computer[inventory.length];
        int j = 0;
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("////List of computers founded/////");
            if (inventory[0].getBrand().equals(brand)) {

                System.out.println(inventory[i].toString());
                // Copy constructor
                Computer cfilter = new Computer(inventory[i]);
                auxinventory[j] = cfilter;
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
                    System.out.println("Successful Login");
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
            case 4:
                System.out.println("Enter Price:");
                double prix = kb.nextInt();
                auxinventory = findCheaperThan(inventory, prix);    
            default:

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
        } else if (inventory[optionSelected] == null) { //saca error
            String yn = "u";

            while (!(yn.toLowerCase().equals("n") || yn.toLowerCase().equals("y"))) {
                System.out.println(
                        "The position is empty, Do you want to create a new Computer with new values? (Y) or back to main menu? (N)");
                yn = kb.next();
                if (yn.toLowerCase().equals("y")) {
                    Computer[] auxComp = newComputers(inventory);//que hacer luegooooo?
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
            System.out.println("There is any space");
            return false;
        }
        if (numComputers > spaceInventory) {
            System.out.println("The remain space of inventory is not enought, try with " + spaceInventory
                    + " or less number of computers");
            return false;
        }

        return true;

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

            System.out.println("Enter Password");
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
