https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1#better-approach-using-sliding-window-on-time-and-on-space

Video live explanation - https://youtu.be/5lnFWKQLWdA
  n,1
class Solution {
    public int minSwaps(int[] arr) {
        // code here
        //step 1:
        // count number of 1 - say x
        int n = arr.length;
        int cnt_of1 = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==1)
            cnt_of1++;
        }
        if(cnt_of1==0){
            return -1;
        }
        
        int x = cnt_of1;
        // step 2 : find max number of 1 in window of x - say maxOnes
        int currOnes = 0;
        int maxOnes = 0;

        // Step 2: sliding window of size x
        for (int i = 0; i < n; i++) {

            currOnes += arr[i];
            
            // maintain window size = x
            if (i >= x) {
                currOnes -= arr[i - x];
            }

            // once window is valid
            if (i >= x - 1) {
                maxOnes = Math.max(maxOnes, currOnes);
            }
        }

   //step 3 : return x-maxOnes.
        return x - maxOnes;
    
        
       
    }
}
