package assigment2;

import java.io.*;
import java.util.Scanner;

public class OperationToProduct {

    public int index(Product p, MyList<Product> list) {
        if (list.isEmpty()) {
            return -1;
        }
        Node<Product> currentNode = list.headNode;
        for (int i = 0; i< list.length(); i++) {
            if (p.equals(list.info)) {
                return i;
            } else {
                currentNode = currentNode.nextNode;
            }
        }
        return -1;
    }

    public static Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID of Product (in letter): ");
        String idProduct = sc.next();
        System.out.print("Name of Product (in letter): ");
        String nameProduct = sc.next();
        System.out.print("Price (in number): ");
        double priceProduct = sc.nextDouble();
        System.out.print("Quantity (in number): ");
        int quantityProduct = sc.nextInt();
        return new Product(idProduct, nameProduct, priceProduct, quantityProduct);
    }

    public static void getAllItemsFromFile(String fileName, MyList<Product> list) {
        String thisLine;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1], Float.parseFloat(productInfo[2]), (int) Float.parseFloat(productInfo[3]));
                list.insertToTail(newProduct);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAllItemsFromFile(String fileName, MyStack<Product> myStack) {
        String thisLine;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1], Float.parseFloat(productInfo[2]), (int) Float.parseFloat(productInfo[3]));
                myStack.push(newProduct);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAllItemsFromFile(String fileName, MyQueue<Product> myQueue) {
        String thisLine;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1], Float.parseFloat(productInfo[2]), (int) Float.parseFloat(productInfo[3]));
                myQueue.push(newProduct);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            FileWriter writer = new FileWriter(fileName, false);
            BufferedWriter buffer = new BufferedWriter(writer);
            Node<Product> newProduct = list.headNode;
            Product tempProduct;
            while (newProduct != null) {
                tempProduct = newProduct.info;
                String productInfo = tempProduct.idProduct + " , " + tempProduct.nameProduct + " , " + tempProduct.priceProduct + " , " + tempProduct.quantityProduct;
                buffer.write(productInfo);
                buffer.newLine();
                newProduct = newProduct.nextNode;
            }
            buffer.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addLast(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        String isNext;
        do {
            list.insertToTail(createProduct());
            System.out.print("Continue (Y/N)?");
            isNext = sc.next();
        } while (isNext.equalsIgnoreCase("Y") || isNext.equalsIgnoreCase("yes") ||isNext.equalsIgnoreCase("y"));
    }

    public static void displayAll(MyList<Product> list) { list.showProductInfo();}
    public static void displayAll(MyStack<Product> myStack) { myStack.showProductInfo();}
    public static void displayAll(MyQueue<Product> myQueue) { myQueue.showProductInfo(); }

    public static void searchByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        Node<Product> newProduct = list.headNode;
        System.out.println("Searching by ID (by string): ");
        String searchingID = sc.next();
        boolean isSearch = false;
        while (newProduct != null) {
            if (searchingID.equalsIgnoreCase(newProduct.info.idProduct)) {
                System.out.println("Product was found: ");
                System.out.println(newProduct.info);
                isSearch = true;
                break;
            } else {
                newProduct = newProduct.nextNode;
            }
        } if (!isSearch) {
            System.out.println(" - 1 Not found");
        }
    }

    public static void deleteByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        Node<Product> newProduct = list.headNode;
        System.out.println("Delete ID (by string): ");
        String searchingID = sc.next();
        boolean isSearch = false;
        while (newProduct != null) {
            if (searchingID.equalsIgnoreCase(newProduct.info.idProduct)) {
                list.deleteElement(newProduct.info);
                System.out.println("Completed!!!!!!!!!!!!");
                isSearch = true;
                break;
            } else {
                newProduct = newProduct.nextNode;
            }
        }
            if (!isSearch) {
                System.out.println("Not found");
            }
    }

    //convert by recursion
    public static int convertToBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return (i%2 + 10*convertToBinary(i/2));
        }
    }
    public static void deleteAtPosition(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        Node<Product> newProduct = list.headNode;
        System.out.println("Delete position (by number): ");
        int pos = sc.nextInt();
        while (newProduct != null) {
            if (pos > list.length() -1) {
                System.out.println("No position!!!!!!!!!!!!!");
                break;
            }
            for (int i = 0; i<pos; i++) {
                newProduct = newProduct.nextNode;
                list.deleteElement(newProduct.info);
            }
        }
    }
    public static void sortByCode(MyList<Product> list, Node<Product> start) {
        if (list.isEmpty()) {
            System.out.println("Empty!!!!!!!!!!!!!!!");
        }
        if (start.nextNode == null) {
            return;
        }
        Node<Product> min = start.nextNode;
        while (min != null) {
            if (start.info.idProduct.compareToIgnoreCase(min.info.idProduct) > 0) {
                list.swap(start, min);
            }
            min = min.nextNode;
        }
        sortByCode(list, start.nextNode);
    }



}
