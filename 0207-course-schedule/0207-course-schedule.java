/** 
DFS 
BFS 
Topological Sort
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return dfsApproach(numCourses,prerequisites);    
    }
    private boolean dfsApproach(int n,int[][] mat){

        List<List<Integer>> adj = buildGraph(n,mat);
        boolean[] vis = new boolean[n]; // <--
        boolean[] path = new boolean[n];

        // Iterate Over Adjaceny List , Only if it not visited
        // Check for Cycle , If Cycle Found , Return False
        for(int i=0;i<n;i++){
            if(!vis[i] && dfsHasCycle(adj,i,vis,path)){
                return false; // <--
            }
        }
        return true;
    }

    private boolean dfsHasCycle(List<List<Integer>> graphs,int src,boolean[] vis,boolean[] path){
        vis[src]=true;
        path[src]=true;

        for(Integer nbr : graphs.get(src)){
            if(path[nbr]) return true;
            if(!vis[nbr] && dfsHasCycle(graphs,nbr,vis,path)) return true;
        }
        path[src]=false;
        return false;
    }


    private List<List<Integer>> buildGraph(int n, int[][] mat){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        // Directed 
        for(int i=0;i<mat.length;i++){
            int x = mat[i][0]; // Course to Take <--
            int y = mat[i][1]; // Prerequisite Course <--
            adj.get(y).add(x);
        }
        return adj;
    } 
}