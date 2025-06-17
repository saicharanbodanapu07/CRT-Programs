public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 10, 15, 23, 32};
        int target = 10;
        System.out.println(findIndex(arr, target));
        }
    
    public static int findIndex(int[] arr, int target) {
        int left = 0;
        int index = -1;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid-1;
            } else if (arr[mid] < target) {
                left = mid+1;
            } else {
                index = mid;
                return index;
            }
        }
        return index;
    }
}