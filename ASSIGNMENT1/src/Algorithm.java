import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Algorithm {
    //Sắp xếp mảng dữ liệu
    public static void display(float[] arr) {
        for (int i = 0; i< arr.length; i++) {
            System.out.print("[" + arr[i] + "] " );
        }
        System.out.println();
    }
    //nhập dữ liệu
    public static float[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử mảng: ");
        int n = sc.nextInt();
        float arr[] = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Số thứ " + (i + 1) + ": ");
            arr[i] = sc.nextFloat();
        }
        return arr;
    }

    //ghi thông tin vào file dạng float
    public static void writeFile(float[] arr, String path, boolean append) {
        try {
            FileWriter writer = new FileWriter(path, append);
            BufferedWriter buffer = new BufferedWriter(writer);
            for(float numberItem : arr ) {
                buffer.write(numberItem + "\t");
            }
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ghi thông tin vào file dạng String
    public static void writeFile(String[] arr, String path, boolean append) {
        try {
            FileWriter writer = new FileWriter(path, append);
            BufferedWriter buffer = new BufferedWriter(writer);

            for(String numberItem : arr ) {
                buffer.write(numberItem + "\t");
            }
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //xuất thông tin vào file
    public static float[] readFile() throws FileNotFoundException {
        String[] data;
        float[] newArray = new float[0];
        try {
            FileReader fr = new FileReader("input.txt");
            Scanner reader = new Scanner(fr);
            while (reader.hasNextLine()) {
                data = reader.nextLine().split("\t");
                newArray = new float[data.length];
                for (int i = 0; i < data.length; i++) {
                    newArray[i] = Float.parseFloat(data[i]);
                }
            }
        } finally {
            System.out.println("Hoàn thành");
        }
        display(newArray);
        return newArray;
    }
    //Bubble Sort
    public static void bubbleSort(float[] bubbleSortArr) {
        int i, j;
        float temp;
        for(i = 0; i< bubbleSortArr.length - 1; i++) {
            System.out.println("Vòng lặp thứ " + (i+1) + ": ");
            for (j = 0; j< bubbleSortArr.length - 1 - i; j++) {
                System.out.print("So sánh phần tử [" + bubbleSortArr[j] + " và " + bubbleSortArr[j+1] + "] ");
                //gan giá trị
                if(bubbleSortArr[j] > bubbleSortArr[j+1]) {
                    temp = bubbleSortArr[j];
                    bubbleSortArr[j] = bubbleSortArr[j+1];
                    bubbleSortArr[j+1] = temp;
                    System.out.println("=> Hoán đổi thành [" + bubbleSortArr[j] + " và " + bubbleSortArr[j+1] + "] ");
                    display(bubbleSortArr);
                } else {
                    System.out.println("=> không hoán đổi");
                    display(bubbleSortArr);
                }
            }
            if(i == 0) {
                System.out.println();
                writeFile(bubbleSortArr, "output1.txt", false);
            } else {
                System.out.println();
                writeFile(bubbleSortArr, "output1.txt", true);
            }
        }
    }
    //Section Sort để in giá trị
    public static void sectionSort(float[] sectionSortArr) {
        int i,j, minIndex;
        float temp;
        //Lặp qua các số
        for (i = 0; i< sectionSortArr.length - 1; i++) {
            //gán giá trị hiện tại là min;
            minIndex = i;
            System.out.println("Vòng lặp thứ " + (i+1) + ": ");
            for (j = i+1; j< sectionSortArr.length; j++) {
                //kiểm tra giá trị min
                if(sectionSortArr[j] < sectionSortArr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                System.out.println("Hoán đổi phần tử [" + sectionSortArr[i] +" và " + sectionSortArr[minIndex] +"] ");
                //gán đổi vi trí
                temp = sectionSortArr[minIndex];
                sectionSortArr[minIndex] = sectionSortArr[i];
                sectionSortArr[i] = temp;
            }
            display(sectionSortArr);
            if(i == 0) {
                System.out.println();
                writeFile(sectionSortArr, "output2.txt", false);
            } else {
                System.out.println();
                writeFile(sectionSortArr, "output2.txt", true);
            }
        }
    }
    //Section Sort để so sánh trong Linear Search
    public static void Sort(float[] arr) {
        int i, j, minIndex;
        float temp;
        for (i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    //Insertion sort
    public static void insertionSort(float[] insertionSortArr) {
        int i, positionToInsert;
        float valueToInsert;
        //Lặp qua 1 vòng
        for (i =1; i<insertionSortArr.length; i++) {
            System.out.println("Vòng lặp thứ " + i + ": ");
            //chọn giá trị để chèn
            valueToInsert = insertionSortArr[i];
            //chọn vị trị để chèn
            positionToInsert = i;
            //Kiểm tra số bênh cạnh có lớn số được chèn ko?
            while (positionToInsert > 0 && insertionSortArr[positionToInsert -1] > valueToInsert ) {
                insertionSortArr[positionToInsert] = insertionSortArr[positionToInsert -1];
                positionToInsert--;
                System.out.println("Di chuyển phần tử [" + insertionSortArr[positionToInsert] + "] ");
            }
            if(positionToInsert != i) {
                System.out.println("Chèn phần tử " + valueToInsert + " tại vị trí thứ: " + positionToInsert);
                //chèn phần tữ tại vị trí chèn
                insertionSortArr[positionToInsert] = valueToInsert;
            }
            display(insertionSortArr);
            if(i == 1) {
                System.out.println();
                writeFile(insertionSortArr, "output3.txt", false);
            } else {
                System.out.println();
                writeFile(insertionSortArr, "output3.txt", true);
            }
        }
    }
    //tìm kiếm nhị phân
    public static void linearSearch(float[] arr, float valueNumber) {
        String result = " ";
        for (int i =0; i<arr.length; i++) {
            if(arr[i] >= valueNumber) {
                result = result.concat(i + "\t");
            }
        }
        if(result != " ") {
            System.out.println(result);
            String[] resultArr = result.split("\t");
            writeFile(resultArr, "output4.txt", false);
        } else {
            System.out.println("No result");
            String[] noResult = {"No result"};
            writeFile(noResult, "output4.txt", false);
        }
    }
    //Tìm kiếm tuyến tính
    public static void binarySearch(float[] arr, float valueNumber) {
        Sort(arr);
        int first = 0;
        int last = arr.length - 1;
        int mid = (last + first)/2;
        while (first <= last) {
            if (arr[mid] < valueNumber) {
                first = mid + 1;
            } else if (arr[mid] == valueNumber) {
                System.out.println(mid);
                String[] resultArr = {(mid + "\t")};
                writeFile(resultArr, "output5.txt", false);
                break;
            } else {
                last = mid - 1;
            }
            mid = (last + first) / 2;
        } if(first > last) {
            System.out.println("No result");
            String[] noResult = {"No result"};
            writeFile(noResult, "output5.txt", false);
        }
    }
}





