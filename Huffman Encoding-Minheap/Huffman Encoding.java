Video Solution of Code - https://youtu.be/u9jYKemT83k

class Solution {
    class Node{
        int data;
         int idx;
         Node left, right;
         
         Node(int data, int idx){
             this.data = data;
             this.idx = idx;
             left=right=null;
         }
    }
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        // Code here
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.data==b.data) return a.idx-b.idx;
                return a.data-b.data;
            }
        );
        
        //insert
        for(int i=0; i<f.length; i++){
            pq.add(new Node(f[i], i));
        }
        // base case
         ArrayList<String> ans = new ArrayList<>();
        if(f.length==1){
            ans.add("0");
            return ans;
        }
        
        // builf the huffman tree
        while(pq.size()>1){
            Node left=pq.poll();
             Node right=pq.poll();
             Node parent = new Node(left.data + right.data, Math.min(left.idx, right.idx));
             
             parent.left = left;
             parent.right = right;
             
             pq.add(parent);
        }
        Node root=pq.poll();
        preorder(root, "", ans);
        return ans;
    }
    void preorder(Node root, String s, ArrayList<String> ans) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            if(s.length() == 0) s = "0"; 
            ans.add(s);
            return;
        }
        
        preorder(root.left, s + "0", ans);
        preorder(root.right, s + "1", ans);
    }
}
