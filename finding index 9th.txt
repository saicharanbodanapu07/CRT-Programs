public class FindingIndex {
    public static void main(String[] args) {
         System.out.println("Found at : " + indexSearch(new int[]{15, 23, 6, 3, 9, 10, 32}, 9));
    }
    
    public static int indexSearch(int[] nums, int target) {
        int index = -1;
         for (int i = 0; i < nums.length; i++) {
             if(nums[i] == target) index = i;
         }
         return index;
    }
}