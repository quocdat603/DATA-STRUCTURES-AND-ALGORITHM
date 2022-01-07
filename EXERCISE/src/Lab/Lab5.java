package Lab;


import java.util.Scanner;
import java.util.Stack;

public class Lab5 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Stack<Integer> myStack = new Stack<>();
        System.out.println("Nhap so ");
       int num = sc.nextInt();
       while (num != 0) {
           int a = num % 2;
           myStack.push(a);
           num /= 2;
       }
        System.out.println("result");
       while (!(myStack.isEmpty())) {
           System.out.print(myStack.pop());
       }
    }
}





















 /*Scanner sc = new Scanner(System.in);
        //Khai báo Stack
        Stack<Integer> myStack = new Stack<Integer>();
        System.out.println("Nhập số đầu vào: ");
        int number = sc.nextInt();
        //chia lấy dư đẩy vào stack
        while (number != 0) {
            int a = number % 2;
            myStack.push(a);
            number /= 2;
        }
        // lấy giá trị in ra kết quả
        System.out.println("Giá trị nhị phân là: ");
        while (!(myStack.isEmpty())) {
            System.out.print(myStack.pop());
        }*/