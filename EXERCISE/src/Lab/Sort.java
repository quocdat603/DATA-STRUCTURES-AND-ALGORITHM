package Lab;

import java.util.Scanner;

public class Sort {
    //Sắp xếp mảng dữ liệu
    public void display(int arr[]) {
        for (int i = 0; i< arr.length; i++) {
            System.out.print("[" + arr[i] + "] " );
        }
    }

    public static int welcome(Scanner sc) {
        System.out.println("Lựa chọn thao tác (1 or 2 or 3 or 4): ");
        System.out.println("1. Data list");
        System.out.println("2. Select Sort");
        System.out.println("3. Insert Sort");
        System.out.println("4. Search value");
        System.out.println("5. Thoát");
        int choice = 0;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            sc.next();
        }
        while (choice < 1 || choice > 4) {
            System.out.println("There was no option, please try again!");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();
            }
        }
        return choice;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Sắp xếp chọn lựa
    public void SelectSort(int[] arr) {
        int i,j, minIndex;
        for (i = 0; i<arr.length-1; i++) {
            minIndex = i;
            System.out.println("vong lap thu " + (i+1));
            for (j = i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                System.out.println("=> trao phan tu " + arr[i] + " va " + arr[minIndex]);
                swap(arr,minIndex,i);
            }
            display(arr);
            System.out.println();
        }
    }
    //Sắp xếp chèn
    public void InsertSort(int[] arr) {
        int i, valueToInsert, position;
        for (i = 1; i<arr.length; i++) {
            System.out.println("vong lap thu " + i);
            valueToInsert = arr[i];
            position = i;
            while (position>0 && arr[position -1] > valueToInsert) {
                arr[position] = arr[position-1];
                position--;
                System.out.println("di chuyen phan tu " + arr[position]);
            }
            if (position != i) {
                System.out.println("chen phan tu " + valueToInsert + " tai vi tri " + position);
                arr[position] = valueToInsert;
            }
            display(arr);
            System.out.println();
        }
    }

    //tìm kiếm giá trị cần tìm
    public void Search(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số cần tìm: ");
        int number = sc.nextInt();
        boolean find = true;
        for (int i = 0; i<arr.length; i++) {
            if(arr[i] == number) {
                //find = true;
                System.out.println("Nhập số cần tìm tại vị trí thứ : " + i);
            } else  {
                find = false;
            }
            if(find)
                System.out.println("Không tìm thấy số cần tìm kiếm ");
        }
    }

    public static void main(String[] args) {
        //tạo mảng arr
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Số thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        Sort sapXep = new Sort();
        int option;
        do {
            option = welcome(sc);
            while (option == 1) {
                System.out.println("Mang du lieu đầu vào");
                sapXep.display(arr);
                System.out.println();
                System.out.println("------------------------------------------------------------------");
                option = -1;
            }
            while (option == 2) {
                System.out.println("Mang du lieu đầu vào");
                sapXep.display(arr);
                System.out.println();
                sapXep.SelectSort(arr);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Mang du lieu đầu ra");
                sapXep.display(arr);
                System.out.println();
                option = -1;
            }
            while (option == 3) {
                System.out.println("Mang du lieu đầu vào");
                sapXep.display(arr);
                System.out.println();
                sapXep.InsertSort(arr);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Mang du lieu đầu ra");
                sapXep.display(arr);
                System.out.println();
                option = -1;

            }
            while (option == 4) {
                System.out.println("Mang du lieu đầu vào");
                sapXep.display(arr);
                System.out.println();
                sapXep.Search(arr);
                option = -1;
            }
        } while (option != 5);
    }
}


/*int i,j, minIndex;
        //Lặp qua các số
        for(i = 0; i<arr.length-1; i++) {
            //gán phần tử hiện tại là Min
            minIndex = i;
            System.out.println("Vòng lặp thứ " + (i+1));
            for(j = i+1; j<arr.length; j++) {
                //Ktr xem phần tử hiện tại có phải là Min
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex !=i) {
                System.out.println("=> tráo đổi phần tử [ " + arr[i] + " và " + arr[minIndex] + " ]");
                //đổi vị trí phần tử
                swap(arr, minIndex, i);
            }
            display(arr);
            System.out.println();
        }*/


/*int i, valueToInsert, position;
        //Lặp qua tất cả
        for (i = 1; i< arr.length; i++) {
            System.out.println("Vòng lặp thứ " + i);
            //chọn giá trị để chèn
            valueToInsert = arr[i];
            //chọn vi trí để chèn
            position = i;
            //Ktr số liền trước có lớn hơn số được chèn hay ko?
            while (position > 0 && arr[position -1]> valueToInsert) {
                arr[position] = arr[position-1];
                position--;
                System.out.println("Di chuyển phần tử " + arr[position]);
            }
            if(position != i) {
                System.out.println("Chèn phần tử " + valueToInsert + " tại vị trí thứ: " + position);
                //chèn phần tữ tại vị trí chèn
                arr[position] = valueToInsert;
            }
            display(arr);
            System.out.println();
        }*/