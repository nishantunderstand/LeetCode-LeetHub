// Leetcode : 210
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //return anyOrder(numCourses,prerequisites);
        return lexiographicallyOrder(numCourses,prerequisites);        
    }


    public int[] lexiographicallyOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegArr = new int[numCourses];
        // Build InDegArr + Build Graph + Source -> Destination 
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            inDegArr[u]++; //<--
            adj.get(v).add(u);  //<-- 
        }
        // Any Order
        PriorityQueue<Integer> que = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        // Inserting with Course is 0
        for(int i=0;i<numCourses;i++){
            if(inDegArr[i]==0) que.offer(i);
        }
        while(!que.isEmpty()){
            Integer current = que.poll();
            res.add(current);
            for(Integer nei : adj.get(current)){
                inDegArr[nei]--;
                if(inDegArr[nei]==0) que.offer(nei);
            }
        }
        if(res.size()!=numCourses) return new int[0];
        // ArrayList to Array
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i]=res.get(i);
        }
        return resArr;
    }

    public int[] anyOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegArr = new int[numCourses];
        // Build InDegArr + Build Graph + Source -> Destination 
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            inDegArr[u]++; //<--
            adj.get(v).add(u);  //<-- 
        }
        // Any Order
        Queue<Integer> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        // Inserting with Course is 0
        for(int i=0;i<numCourses;i++){
            if(inDegArr[i]==0) que.offer(i);
        }
        while(!que.isEmpty()){
            Integer current = que.poll();
            res.add(current);
            for(Integer nei : adj.get(current)){
                inDegArr[nei]--;
                if(inDegArr[nei]==0) que.offer(nei);
            }
        }
        if(res.size()!=numCourses) return new int[0];
        // ArrayList to Array
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i]=res.get(i);
        }
        return resArr;
    }
}