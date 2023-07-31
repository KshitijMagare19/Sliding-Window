import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;


public class Maximum_of_all_subarrays_of_size_k {
    static int[] solve2(int[] a, int k) {		
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}

    static ArrayList<Integer> solve(int[] arr, int k) {

        // * Optimized Sliding Window O(n^k)
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
       int i=0;
       int j=0;
       while (j<arr.length){
           temp.add(arr[j]);
           if(j-i+1<k){
               j++;
           }else if(j-i+1==k){
              list.add(Collections.max(temp));
              temp.remove(0);
               i++;
               j++;
           }

       }
       return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, -1,-5,-10,3, 6 };
        int k = 3;
        //System.out.println(solve(arr, k));
        System.out.println(Arrays.toString(solve2(arr, k)));
    }
}
