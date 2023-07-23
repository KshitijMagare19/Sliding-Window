class max_Sum_SubArray{

    static int solve(int[] arr){
        
        // * Bruth Force O(n*3)
        //int ans = Integer.MIN_VALUE;
        // for(int i = 0; i < arr.length-3; i++){
        //     int temp = 0;
        //     for(int j = i; j < i+3; j++){
        //         temp+=arr[j];
        //     }
        //     ans = Math.max(ans,temp);
        // }

        //Optimized Sliding Window O(n)
        int temp = arr[0] + arr[1]+ arr[2];
        int ans = temp;
        for(int i = 1; i < arr.length-1; i++){
            temp = temp - arr[i-1] + arr[i+1];
            ans = Math.max(ans,temp);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10,2,5, 5, 6, 8, 1, 2};
        System.out.println(solve(arr));
    }
}
