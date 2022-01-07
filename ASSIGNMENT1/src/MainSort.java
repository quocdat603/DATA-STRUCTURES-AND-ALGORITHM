import java.io.*;
import java.util.Scanner;
public class MainSort {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        float[] arr = new float[0];
        double start, end;
        int option;
        do {
            option = welcome(sc);
            while (option == 1) {
                arr = Algorithm.input();
                Algorithm.writeFile(arr, "input.txt", false);
                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }

            while (option == 2) {
                try {
                    System.out.println("Read from file");
                    arr = Algorithm.readFile();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }

            while (option == 3) {
                float[] bubbleSortArr = new float[arr.length];
                System.out.println("Bubble Sort: ");
                System.arraycopy(arr, 0, bubbleSortArr, 0, arr.length);
                start = System.currentTimeMillis();
                Algorithm.bubbleSort(bubbleSortArr);
                end = System.currentTimeMillis();
                int time1 = (int) (end - start);
                System.out.println("Bubble Sort time: " + time1 + " ms");

                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }

            while (option == 4) {
                float[] sectionSortArr = new float[arr.length];
                System.out.println("Section Sort: ");
                System.arraycopy(arr, 0, sectionSortArr, 0, arr.length);
                start = System.currentTimeMillis();
                Algorithm.sectionSort(sectionSortArr);
                end = System.currentTimeMillis();
                int time2 = (int) (end - start);
                System.out.println("Bubble Sort time: " + time2 + " ms");
                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }

            while (option == 5) {
                float[] insertionSortArr = new float[arr.length];
                System.out.println("Section Sort: ");
                System.arraycopy(arr, 0, insertionSortArr, 0, arr.length);
                start = System.currentTimeMillis();
                Algorithm.insertionSort(insertionSortArr);
                end = System.currentTimeMillis();
                int time3 = (int) (end - start);
                System.out.println("Bubble Sort time: " + time3 + " ms");
                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }

            while (option == 6) {
                System.out.println("Linear Search ");
                System.out.println("Value number : ");
                float valueNumber = sc.nextFloat();
                System.out.println("Vị trí : ");
                try {
                    Algorithm.linearSearch(arr, valueNumber);
                } finally {
                    System.out.println("Hoàn thành");
                }
                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }
            while (option == 7) {
                System.out.println("Binary Search ");
                System.out.println("Value number : ");
                float valueNumber = sc.nextFloat();
                System.out.println("Vị trí : ");
                try {
                    Algorithm.binarySearch(arr, valueNumber);
                } finally {
                    System.out.println("Hoàn thành");
                }
                do {
                    System.out.println("Chọn lại: Y/N");
                } while (!sc.next().equalsIgnoreCase("Y"));
                option = -1;
            }
        } while (option != 8);

    }
    //Hàm welcome
    public static int welcome(Scanner sc) {
        System.out.println("Welcome");
        System.out.println("1. Input");
        System.out.println("2. Output");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Section Sort");
        System.out.println("5. Insertion Sort");
        System.out.println("6. Linear Search");
        System.out.println("7. Binary Search");
        System.out.println("8. Quit");
        System.out.print("What is your choice? ");
        int choice = 0;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            sc.next();
        }
        while (choice < 1 || choice > 8) {
            System.out.println("There was no option, please try again!");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();
            }
        }
        return choice;
    }
}
