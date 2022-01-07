package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3 {
    public static class Node {
        private int data;
        private Node nextNode;
        public Node(int data, Node nextNode) {this.data = data; this.nextNode = nextNode; }
        public Node(int data) {this(data, null);}
        @Override
        public String toString() {return (data + " ");}
    }

    public static class MyList {
        Node headNode, tailNode;

        public MyList() {
            this.headNode = this.tailNode = null;
        }

        public boolean isEmpty() {
            return (this.headNode == null);
        }

        public void showInfo() {
            Node number = this.headNode;
            while (number != null) {
                System.out.print(number.data + " ");
                number = number.nextNode;
            }
            System.out.println();
        }

        public void addHead(int x) {
           Node newNode = new Node(x);
           if (isEmpty()) {
               this.headNode = this.tailNode = newNode;
           } else  {
               newNode.nextNode = this.headNode;
               this.headNode = newNode;
           }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyList myList = new MyList();
        int option;
        do {
            option = showMenu(sc);
            while (option == 1) {
                System.out.println("--------------------------------------------------------------------------------------");
                addFirst(myList);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 2) {
                System.out.println("--------------------------------------------------------------------------------------");
                myList.showInfo();
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 3) {
                System.out.println("--------------------------------------------------------------------------------------");
                myList.addHead(createInfo());
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 4) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Comparing number?");
                int num = sc.nextInt();
                search(myList.headNode, num);
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }

        } while (option != 0);
    }

    public static int showMenu(Scanner sc) {
        System.out.println("Choose one of this options:");
        System.out.println("1. Input data.");
        System.out.println("2. Display data");
        System.out.println("3. Add data (At Head)");
        System.out.println("4. Search");
        System.out.println("0. Exit");
        System.out.println("Your choice is (0-4): ");
        int choice = 0;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            sc.next();
        }
        while (choice < 1 || choice > 10) {
            System.out.println("No option, please try again (0-4)!");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();
            }
        }
        return choice;
    }

    public static int createInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number: ");
        int num = sc.nextInt();
        return num;
    }

    public static void addFirst(MyList myList) {
        Scanner sc = new Scanner(System.in);
        String isNext;
        do {
            myList.addHead(createInfo());
            System.out.print("Continue (Y/N)?");
            isNext = sc.next();
        } while (isNext.equalsIgnoreCase("Y") || isNext.equalsIgnoreCase("yes") ||isNext.equalsIgnoreCase("y"));
    }

    public static void search(Node headNode, int num) {
        Node tempNode = headNode;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while (tempNode != null) {
            tempList.add(tempNode.data);
            tempNode = tempNode.nextNode;
        }
        for (int i = 0; i<tempList.size();  i++) {
            if (tempList.get(i) > num) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}


/*Node newNode = new Node(x);
            if (isEmpty()) {
                this.headNode = this.tailNode = newNode;
            } else {
                newNode.nextNode = this.headNode;
                this.headNode = newNode;
            }
        }*/