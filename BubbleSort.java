class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 64, 25, 12, 22, 11 };
        for (int num : BubbleSortAlgo(nums)) {
            System.out.print(num + " ");
        }

    }

    public static int[] BubbleSortAlgo(int[] nums) {
        boolean swapped;
        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return nums;
    }
}