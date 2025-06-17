public class Merging_Two_Sorted_Arrays{
    public static void main(String[] args) {
        int[] a = {2, 7, 12, 18, 23, 55};
        int[] b = {6, 11, 18, 21, 25, 70};
        int[] c= new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b [j]) {
                c[k] = b[j];
                j++;
                k++;
            } 
            else {
                c[k] = a[i];
                i++;
                k++;
            }
        }
        while  (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }
        while  (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        for (int l = 0; l < k; l++) {
            System.out.print(c[l]+ " ");
        }
    }
}