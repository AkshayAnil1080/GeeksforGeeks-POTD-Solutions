https://youtu.be/8DmXgxug-gA


rec

class Solution {
    public int minimumCost(int[] cost, int w) {
        // code here
        int n =cost.length;
        
        int ans = helper(cost, n-1, w);
        
        return ans==Integer.MAX_VALUE ? -1 :ans;
        
    }
    int helper(int[] cost, int n,int w){
        
        //base cases
        if(w==0){
            return 0;
        }
        if(n<0) //w!=0
        return Integer.MAX_VALUE;
        ///rec cal
        
        // if(curr_wt <= capacity)
        if((n+1)<=w && cost[n]!=-1){
            // take 
        int take  = Integer.MAX_VALUE;
            
        int temp = helper(cost, n, w-(n+1));
        if(temp!=Integer.MAX_VALUE){
            take = cost[n] + temp;
        }
        // not take
        int notTake = helper(cost, n-1, w);
        
        return Math.min(take,notTake);
        }
        
        else{
             return helper(cost, n-1, w);
        }
}
}

  memo
  class Solution {
    int dp[][];
    public int minimumCost(int[] cost, int w) {
        // code here
       
        int n =cost.length;
         dp = new int[n][w+1];
         for(int x [] : dp){
             Arrays.fill(x,-1);
         }
        int ans = helper(cost, n-1, w);
        
        return ans==Integer.MAX_VALUE ? -1 :ans;
        
    }
    int helper(int[] cost, int n,int w){
        
        //base cases
        if(w==0){
            return 0;
        }
        if(n<0) //w!=0
        return Integer.MAX_VALUE;
        ///rec cal
        
        if(dp[n][w]!=-1)
        return dp[n][w];
        // if(curr_wt <= capacity)
        if((n+1)<=w && cost[n]!=-1){
            // take 
        int take  = Integer.MAX_VALUE;
            
        int temp = helper(cost, n, w-(n+1));
        if(temp!=Integer.MAX_VALUE){
            take = cost[n] + temp;
        }
        // not take
        int notTake = helper(cost, n-1, w);
        
        return dp[n][w] = Math.min(take,notTake);
        }
        
        else{
             return dp[n][w] = helper(cost, n-1, w);
        }
}
}
