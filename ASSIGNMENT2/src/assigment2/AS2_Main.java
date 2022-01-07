package assigment2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AS2_Main {
    public static void main(String[] args) {
        printOut();
        Scanner sc = new Scanner(System.in);
        int option;
        MyList<Product> myList = new MyList<Product>();
        MyStack<Product> myStack = new MyStack<Product>();
        MyQueue<Product> myQueue = new MyQueue<Product>();
        do {
            option = showMenu(sc);
            while (option == 1) {
                System.out.println("--------------------------------------------------------------------------------------");
                OperationToProduct.getAllItemsFromFile("data.txt", myList);
                System.out.println("List of product: ");
                OperationToProduct.displayAll(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 2) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Add new product: ");
                OperationToProduct.addLast(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 3) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Product details");
                OperationToProduct.displayAll(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 4) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Save product list to file.");
                OperationToProduct.writeAllItemsToFile("data.txt", myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 5) {
                System.out.println("--------------------------------------------------------------------------------------");
                OperationToProduct.searchByCode(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 6) {
                System.out.println("--------------------------------------------------------------------------------------");
                OperationToProduct.deleteByCode(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 7) {
                System.out.println("--------------------------------------------------------------------------------------");
                OperationToProduct.sortByCode(myList, myList.headNode);
                OperationToProduct.displayAll(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 8) {
                System.out.println("--------------------------------------------------------------------------------------");
                Node<Product> temp = myList.headNode;
                ArrayList<Integer> tempList = new ArrayList<>();
                while (temp != null) {
                    tempList.add(temp.info.quantityProduct);
                    temp = temp.nextNode;
                }
                for (int i = 0; i< tempList.size(); i++) {
                    System.out.println("Convert " + tempList.get(i) + " to " + OperationToProduct.convertToBinary(tempList.get(i)));
                }

                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 9) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Save product list to stack.");
                OperationToProduct.getAllItemsFromFile("data.txt", myStack);
                OperationToProduct.displayAll(myStack);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 10) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Save product list to queue.");
                OperationToProduct.getAllItemsFromFile("data.txt", myQueue);
                OperationToProduct.displayAll(myQueue);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
        } while (option != 0);
    }

    public static int showMenu(Scanner sc) {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        System.out.println("Your choice is (0-10): ");
        int choice = 0;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            sc.next();
        }
        while (choice < 1 || choice > 10) {
            System.out.println("No option, please try again (0-10)!");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();
            }
        }
        return choice;
    }

    public static void printOut() {
        try {
            //create output streams writing to file
            FileOutputStream fOut = new FileOutputStream("console_output.txt");
            FileOutputStream fErr = new FileOutputStream("streamErr.txt");

            //append all output stream to one stream
            MultiOutputStream multiOut = new MultiOutputStream(System.out, fOut);
            MultiOutputStream multiErr = new MultiOutputStream(System.err, fErr);

            //create a print stream
            PrintStream streamOut = new PrintStream(multiOut);
            PrintStream streamErr = new PrintStream(multiErr);

            //set output
            System.setOut(streamOut);
            System.setErr(streamErr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
