all approcahes explained by me here --https://youtu.be/lLSsjFFrGIo

// m1 - rec
2^n, n

  class Solution {
    public int maxProduct(int n) {
        // code here
        
        return fun(n);
        
    }
    
    int fun(int n){
        
        if(n==0 || n==1)
        return 0;
        
        int ans=0;
        for(int i=1; i<n; i++){
            //cut at i
            int curr_prod = i*(n-i);
            int rem_prod = i*fun(n-i);
            ans = Math.max(ans, Math.max(curr_prod,rem_prod ));
        }
       return ans;
        
    }
}

//m2 - DP - mem O(n^2), O(n)


class Solution {
    int dp[];
    public int maxProduct(int n) {
        // code here
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fun(n);
        
    }
    
    int fun(int n){
        
        if(n==0 || n==1)
        return 0;
        
        if(dp[n]!=-1)
        return dp[n];
        
        int ans=0;
        for(int i=1; i<n; i++){
            //cut at i
            int curr_prod = i*(n-i);
            int rem_prod = i*fun(n-i);
            ans = Math.max(ans, Math.max(curr_prod,rem_prod ));
        }
       return dp[n]=ans;
        
    }
}




// m3 - Greedy O(n), 1
class Solution {
    public int maxProduct(int n) {
        // code here
     
     //cut into as may parts of 3/
         if(n==2) return 1;  //1,1
         if(n==3) return 2;  //1,2
         
         int ans=1;
         while(n>4){
             ans *=3;
             n-=3;
         }
         
         return ans*n;
    }
}


// m3 = Binary exponentiation - O(logn), O(1)

class Solution {
    public int maxProduct(int n) {
        // code here
     
        if(n==2) return 1;  //1,1
         if(n==3) return 2;  //1,2
     
        // number of 3
        int cnt3 = n/3;
        int rem = n%3;
        
        if(rem==1){ // we can take 2+2 , instead 3+1 as 4>3
            //decrease cnt of 1
            
            cnt3-=1;
            rem=4;
        }
        int ans = power(3, cnt3);
        
        if (rem !=0) // if rem ==0
         ans*=rem;
         
         return ans;

    }
    int power(int a, int b) {
        int res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) ;

            a = (a * a) ;
            b >>= 1;
        }

        return res;
    }
}
