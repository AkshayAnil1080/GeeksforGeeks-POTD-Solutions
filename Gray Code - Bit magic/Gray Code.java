
Live video Explanaiton : https://youtu.be/6APo78KpGsw
Time o(2^n)
Space O(2^n)


class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i< (1<<n); i++){ // itr for 0 TO 2^N-1
        //GENERTEING GRAY CODE
            int val = (i^ (i>>1));
            StringBuilder s = new StringBuilder();
                for(int j=n-1;j>=0;j--){
                    if( (val & (1<<j)) !=0)
                    s.append("1");
                    else 
                     s.append("0");
                }
         ans.add(s.toString());      
        }
        return ans;
    }
}
