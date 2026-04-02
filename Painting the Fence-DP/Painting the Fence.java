Live Video Explanation - https://youtu.be/D0XqBBGrFns

// class Solution {
//     int countWays(int n, int k) {
//         // code here.
//       return help(n,k);
//     }
//     int help(int n, int k){
//         if(n==1) return k;
//          if(n==2) return k*k;
         
//         return help(n-1,k)*(k-1) + help(n-2,k)*(k-1);
//     }
// }

// memo - number of states changing - only n = 1 => 1 d memo array -top 
// class Solution {
//     int countWays(int n, int k) {
//         // code here.
//         int dp[] = new int[n+1];
//         Arrays.fill(dp,-1);
//       return help(n,k,dp);
//     }
//     int help(int n, int k, int dp[]){
//         if(n==1) return k;
//          if(n==2) return k*k;
//          if(dp[n]!=-1) return dp[n];
         
//         return dp[n] = help(n-1,k,dp)*(k-1) + help(n-2,k,dp)*(k-1);
        
//     }
// }
// tb - bottom up 
class Solution {
    int countWays(int n, int k) {
        // code here.
        int dp[] = new int[n+1];
        if(n==1) return k;
        if(n==2) return k*k;
        
        dp[1] =k; dp[2]=k*k;
        
        for(int i=3; i<=n;i++){
            dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1);
        }
        return dp[n];
    }
}


