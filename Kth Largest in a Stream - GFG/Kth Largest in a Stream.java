Best live video explanation: https://youtu.be/5lnFWKQLWdA

https://www.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1


class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by def it is min heap;
        
        int n = arr.length;
        for(int i=0; i<n;i++){
            pq.add(arr[i]);
            
            // update pq
            if(pq.size()>k){
                pq.poll();
            }
            
            //update res
            if(pq.size()<k)
            res.add(-1);
            else
            res.add(pq.peek());
            
        }
        return res;
    }
}
