public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 64, 25, 12, 22, 11 };
        for (int num : SelectionSortAlgo(nums)) {
            System.out.print(num + " ");
        }
    }

    public static int[] SelectionSortAlgo(int[] nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}