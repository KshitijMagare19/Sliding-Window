import java.util.ArrayList;

public class First_Negative_Number_in_every_Window_of_Size_K {
    static ArrayList<Integer> solve(int[] arr, int k){
        
        // * Bruth Force O(n*2)
        // ArrayList<Integer> arrl = new ArrayList<>();
        // for(int i = 0; i <= arr.length-k; i++){
        //     int temp = 0;
        //     for(int j = i; j < i+k; j++){
        //         if(arr[j] < 0){
        //             arrl.add(arr[j]);
        //             break;
        //         }
        //         else{
        //             temp++;
        //         }
        //     }
        //     if(temp == k) arrl.add(0);
            
        // }

        // *Optimized Sliding Window O(n)
        
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int i = 0 , j = 0;
        int n = arr.length;
        while(j<n) {
            if(arr[j] < 0) neg.add(arr[j]);

            if(j-i+1<k) {
              j++;
            }
            else if(j-i+1==k){
                if(neg.size() < 1) ans.add(0);
                else{
                    ans.add(neg.get(0));
                    if(arr[i] == neg.get(0))
                        neg.remove(0);
                }
                j++;    
                i++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(solve(arr,k));
    }
}
