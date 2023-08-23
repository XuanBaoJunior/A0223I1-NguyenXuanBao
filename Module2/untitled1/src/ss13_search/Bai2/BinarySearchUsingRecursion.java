package ss13_search.Bai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử trong mảng: ");
        for (int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);

        System.out.println("Nhập giá trị cần tìm: ");
        int value = scanner.nextInt();
        int result = binarySearch(array, 0, n - 1, value);

        if (result == -1){
            System.out.println("Không tìm thấy giá trị trong mảng");
        }else {
            System.out.println("Giá trị được tìm thấy tại vị trí: " + result);
        }
    }
    public static int binarySearch(int[] array, int left, int right, int value){
        if (left > right){
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value){
            return middle;
        }else if (value > array[middle]){
            return binarySearch(array, middle +1, right, value);
        }else {
            return binarySearch(array, left, middle -1, value);
        }
    }
}
