class max_Sum_SubArray{

    static int solve(int[] arr, int k){
        
        // * Bruth Force O(n*3)
        //int ans = Integer.MIN_VALUE;
        // for(int i = 0; i < arr.length-3; i++){
        //     int temp = 0;
        //     for(int j = i; j < i+3; j++){
        //         temp+=arr[j];
        //     }
        //     ans = Math.max(ans,temp);
        // }

        // * Optimized Sliding Window O(n)
        int sum = 0, i = 0, j =0 ;
        int ans = 0;
        while(j<arr.length) {
            sum+=arr[j];
            if(j-i+1<k) {
              j++;
            }
            else if(j-i+1==k){
                ans=Math.max(sum,ans);
                sum-=arr[i];
                j++;    
                i++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10,2,5, 5, 6, 8, 1, 2};
        int k = 3;
        System.out.println(solve(arr,k));
    }
}
