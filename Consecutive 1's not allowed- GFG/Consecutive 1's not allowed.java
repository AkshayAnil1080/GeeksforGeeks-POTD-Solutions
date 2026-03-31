Video Link -  https://youtu.be/TpF-7LZgipM
https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1


class Solution {
    int countStrings(int n) {
        // code here
       int  a=2; int b=3;
       if(n==1) return a; 
       if(n==2) return b;
       int c=0;
       for(int i=0; i<n-2; i++){
           c=a+b;
           a=b;
           b=c;
       }
       return c;
      
    }
}
