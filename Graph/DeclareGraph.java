package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeclareGraph {
    public static void main(String[] args) throws IOException {
        Graph g1 = new Graph();
        List<List<Integer>> adjacency = g1.createGraph();
        // bfs traversal
        System.out.println("*********************** BFS TRAVERSAL ***************************");
        g1.bfs(adjacency, 1);

        // DFS Traversal
        System.out.println("*********************** DFS TRAVERSAL ***************************");
        g1.dfs(adjacency, 1);
    }

}

class Graph {
    public List<List<Integer>> createGraph() throws IOException {
        // adjacency List
        List<List<Integer>> list = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the no of Nodes::");
        int n = Integer.parseInt(bf.readLine());
        // Initialize n+1 list
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        // list updatation -- for undirect graph
        System.out.print("Enter the no of edges::");
        int edges = Integer.parseInt(bf.readLine());
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the edges::");
            String str = bf.readLine();
            String edgeString[] = str.split(" ");
            int v = Integer.parseInt(edgeString[0]);
            int u = Integer.parseInt(edgeString[1]);
            list.get(v).add(u);
            list.get(u).add(v);
        }

        // Let's print the list
        System.out.println("************************* ADJACENCY LIST **************************");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " -> {");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
                if (j != list.get(i).size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
        return list;
    }

    // BFS - Breadth First Search
    public void bfs(List<List<Integer>> list, int startNode) {
        // Let's take an Queue for store adjacent nodes
        Queue<Integer> queue = new LinkedList<>();
        // Take an visited array of size nodes
        boolean[] visited = new boolean[list.size()];
        // Initialize all are false
        Arrays.fill(visited, false);
        // add startNode into the queue
        queue.add(startNode);
        // mark visited
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + "-> ");
            // go through all adjecent node of this current node
            for (int i = 0; i < list.get(currentNode).size(); i++) {
                if (visited[list.get(currentNode).get(i)] == false) {
                    // marked as true / visited
                    visited[list.get(currentNode).get(i)] = true;
                    // add into queue
                    queue.add(list.get(currentNode).get(i));
                }
            }
        }
        System.out.println("NULL");
    }

    // DFS - Depth First Search
    public void dfs(List<List<Integer>>list,int startNode){
        // Take a visited array
        boolean[] visited=new boolean[list.size()];
        Arrays.fill(visited, false);
        // call the dfs Recursion function
        dfsRec(list,visited,startNode);
        System.out.println();
    }

    private void dfsRec(List<List<Integer>>list,boolean[]visited,int s){
        // mark as startnode true
        visited[s]=true;
        System.out.print(s+" ->");

        for(int adjacent:list.get(s)){
            if(visited[adjacent]==false){
                dfsRec(list, visited, adjacent);
            }
        }
    }
}