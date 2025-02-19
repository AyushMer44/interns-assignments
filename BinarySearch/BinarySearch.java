import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the target element: ");
        int target = scanner.nextInt();
        
        int index = binarySearch(sortedArray, target);
        
        if (index != -1) {
            System.out.println("Element " + target + " is found at index " + index + ".");
        } else {
            System.out.println("Element " + target + " is not in the array.");
        }
        
        scanner.close();
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}