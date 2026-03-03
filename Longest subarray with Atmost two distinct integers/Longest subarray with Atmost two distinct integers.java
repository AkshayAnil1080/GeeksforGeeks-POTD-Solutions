class Solution {
    public int totalElements(int[] arr) {
        // code here
        
        //m1
    //     int n = arr.length;
    //     int size = 0; 
        
    //     // Generate all subarrays
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
                
    //             // Create a set to store distinct elements
    //             Set<Integer> distinct = new HashSet<>();
                
    //             // Check if the subarray has 
    //             // at most two distinct elements
    //             for (int k = i; k <= j; k++) {
    //                 distinct.add(arr[k]);
    //                 if (distinct.size() > 2) {
    //                     break;
    //                 }
    //             }
                
    //             // Update the size of the largest subarray
    //             if (distinct.size() <= 2) {
    //                 size = Math.max(size, j-i+1);
    //             }
    //         }
    //     }
        
    //     return size;
    // }
    
    
    //2 SW
    Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = arr.length;
        int size = 0;

        while (j < n) {
            
            // Add the current element 
            // to the map (or update its count)
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);

            // If we have more than 2 distinct elements
            // shrink the window from the left
            while (mp.size() > 2) {
                mp.put(arr[i], mp.get(arr[i]) - 1);

                // Remove the number completely 
                // if its count becomes 0
                if (mp.get(arr[i]) == 0)
                    mp.remove(arr[i]);
                
                // move the left boundary
                i++; 
            }

            size = Math.max(size, j - i + 1);
            
            // expand the window to the right
            j++; 
        }

        return size;
    }
}
