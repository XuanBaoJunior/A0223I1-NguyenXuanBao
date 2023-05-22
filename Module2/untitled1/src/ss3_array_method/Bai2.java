package ss3_array_method;
import java.util.*;

    public class Bai2 {
        public static void main(String args[]) {
            String[] arr = {"1", "2" , "3", "4", "5"};

            System.out.println("Mảng ban đầu:\n"
                    + Arrays.toString(arr));

            int N = arr.length;

            arr = Arrays.copyOf(arr, N + 1);

            arr[N] = "6";
            arr[N] = "7";
            System.out.println("Mảng mới sau khi thêm phần tử:\n"
                    + Arrays.toString(arr));
        }
    }

