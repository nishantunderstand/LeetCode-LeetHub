class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        // Bi-directional Graph
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n+1];
        return hasPath(adjList,visited,source,destination);
    }
    public boolean hasPath(List<List<Integer>> graphs,boolean[] visited, int src, int dest) {
        if(src==dest) return true;
        if(visited[src]) return false;
        visited[src]=true;
        for(int nei : graphs.get(src)){
            if(!visited[nei] && hasPath(graphs,visited,nei,dest)) return true;
        }
        return false;
    }
}