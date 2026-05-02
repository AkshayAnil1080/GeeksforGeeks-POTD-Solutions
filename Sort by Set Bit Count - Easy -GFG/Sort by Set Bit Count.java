nlogn, 1

  best video explanation - https://youtu.be/Q6oN2mbT-QI

    try yourself first - https://www.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1


class Solution {
    void sortBySetBitCount(int[] arr) {
        // code here
        int n = arr.length;
        
        //initailize 1-d array of size 31
        ArrayList<Integer>[] ans = new ArrayList[32];

        for (int i = 0; i < 32; i++) {
            ans[i] = new ArrayList<>();
        }
        
        //step 2 fill the buckets
        for(int i=0; i<n; i++){
            ans[setBitCount(arr[i])].add(arr[i]);
        }
    
        //step 4 rebuild arr
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i =31; i>=0; i--){
            for(int x : ans[i])
            res.add(x);
        }
        return res;
    }
    
    //step 3 setBitCount
    int setBitCount( int n){
        int cnt=0;
        while(n>0){
            if((n&1)==1)
            cnt++;
            n=n/2;
        }
        return cnt;
    }
}
