package Lab;

import java.util.Scanner;

public class Lab4 {
    public static class Person {
        String name;
        int age;
        public Person() { }
        public Person(String name, int age) {this.name = name; this.age= age;}
        @Override
        public String toString() {return (name + " " + age);}
    }

    public static class Node<Person> {
        Person info;
        Node nextNode;
        public Node (Person info, Node nextNode) {this.info = info; this.nextNode = nextNode;}
        public Node(Person info) {this(info, null);}
        @Override
        public String toString() {return info + "\n"; }
    }

    public static class MyList<Person> {
        Node<Person> headNode, tailNode;

        public MyList() {
            this.headNode = this.tailNode = null;
        }

        public MyList(Node<Person> headNode, Node<Person> tailNode) {
            this.headNode = headNode;
            this.tailNode = tailNode;
        }

        public boolean isEmpty() {
            return (this.headNode == null);
        }

        public void insertToTail(Person x) {
            Node<Person> newPerson = new Node<>(x);
            if (isEmpty()) {
                this.headNode = this.tailNode = newPerson;
            } else {
                Node<Person> currentNode = headNode;
                while (currentNode.nextNode != null) {
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode = newPerson;
            }
        }

        public void swap(Node<Person> firstNode, Node<Person> secondNode) {
            Person temp;
            temp = firstNode.info;
            firstNode.info = secondNode.info;
            secondNode.info = temp;
        }

        public void showInfo() {
            Node eachPerson = this.headNode;
            while (eachPerson != null) {
                System.out.println(eachPerson.info);
                eachPerson = eachPerson.nextNode;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyList<Person> myList = new MyList<Person>();
        int option;
        do {
            option = showMenu(sc);
            while (option == 1) {
                System.out.println("--------------------------------------------------------------------------------------");
                addLast(myList);
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
                myList.insertToTail(createInfo());
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
            while (option == 4) {
                System.out.println("--------------------------------------------------------------------------------------");
                sortByName(myList, myList.headNode);
                myList.showInfo();
                System.out.println("--------------------------------------------------------------------------------------");
                option = -1;
            }
        } while (option != 0);
    }
    public static int showMenu(Scanner sc) {
        System.out.println("Choose one of this options:");
        System.out.println("1. Input information.");
        System.out.println("2. Display data");
        System.out.println("3. Add information (At Tail)");
        System.out.println("4. Sort by name.");
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

    public static Person createInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        return new Person(name, age);
    }
    public static void addLast(MyList<Person> list) {
        Scanner sc = new Scanner(System.in);
        String isNext;
        do {
            list.insertToTail(createInfo());
            System.out.print("Continue (Y/N)?");
            isNext = sc.next();
        } while (isNext.equalsIgnoreCase("Y") || isNext.equalsIgnoreCase("yes") ||isNext.equalsIgnoreCase("y"));
    }


    public static void sortByName(MyList<Person> list, Node<Person> start) {
        if (list.isEmpty()) {
            System.out.println("empty");
        }
        if (start.nextNode == null) {
            return;
        }
        Node<Person> min = start.nextNode;
        while (min != null) {
            if (start.info.name.compareToIgnoreCase(min.info.name) > 0) {
                list.swap(start, min);
            }
            min = min.nextNode;
        }
        sortByName(list, start.nextNode);
     }

}


/*Node<Person> newPerson = new Node<Person>(x);
            if (isEmpty()) {
                this.headNode = this.tailNode = newPerson;
            } else {
                Node<Person> lastNode = headNode;
                while (lastNode.nextNode != null) {
                    lastNode = lastNode.nextNode;
                }
                lastNode.nextNode = newPerson;
            }*/


/*if (list.isEmpty()) {
            System.out.println("Empty!!!!!!!!!!!!!!!");
        }
        if (start.nextNode == null) {
            return;
        }
        Node<Person> min = start.nextNode;
        while (min != null) {
            if (start.info.name.compareToIgnoreCase(min.info.name) > 0) {
                list.swap(start, min);
            }
            min = min.nextNode;
        }
        sortByName(list, start.nextNode);*/