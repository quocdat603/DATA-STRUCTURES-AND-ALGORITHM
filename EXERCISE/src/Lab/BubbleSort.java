package Lab;

import java.util.Scanner;

public class BubbleSort {
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort(int arr[]) {
       int i,j;
       for (i = 0; i<arr.length-1; i++) {
           System.out.println("vong lap thu " + (i+1));
           boolean change  =true;
           for (j=0; j<arr.length-1-i; j++) {
               System.out.println("so sanh " + arr[j] + " " + arr[j+1]);
               if (arr[j] > arr[j+1]) {
                   swap(arr, j, j+1) ;
                   System.out.println("hoan doi " + arr[j] + " thanh " + arr[j+1] );
                   change = false;
                   display(arr);
                   System.out.println();
               } else {
                   System.out.println(" ko doi ");
               }
           }
           if (change) {
               break;
           }
       }
        display(arr);
        System.out.println();
    }

    //Sắp xếp mảng dữ liệu
    public void display(int arr[]) {
        for (int i = 0; i< arr.length; i++) {
            System.out.print("[" + arr[i] + "] " );
        }
    }

    public static void main(String[] args) {
        //tạo mảng arr
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< n; i++) {
            System.out.print("Số thứ " + (i+ 1) + ": ");
            arr[i] = sc.nextInt();
        }

        BubbleSort sapXepNoiBot = new BubbleSort();
        System.out.println("Mang du lieu đầu vào");
        sapXepNoiBot.display(arr);
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        sapXepNoiBot.bubbleSort(arr);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Mang du lieu đầu ra");
        sapXepNoiBot.display(arr);
    }
}






/*for (i = 0; i<arr.length - 1; i++) {
            boolean change = true;
            System.out.println("Vòng lặp thứ " + (i+1));
            for (j = 0; j< arr.length - 1 - i; j++) {
                System.out.print("So sánh phần tử  [ " + arr[j] + " và " + arr[j+1] + " ]");
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    change = false;
                    System.out.println("=> Hóa đổi thành [ " + arr[j] + " và " + arr[j+1] + " ]" );
                    display(arr);
                    System.out.println();
                } else {
                    System.out.println("=> Không cần hoán đổi");
                }
            }
            if(change) {
             break;
             }
            display(arr);
            System.out.println();
        }*/