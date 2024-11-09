package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class DeclareGraph {
    public static void main(String[] args) throws IOException {
        Graph g1=new Graph();
        g1.createGraph();
    }

    
}


class Graph{
    public void createGraph() throws IOException{
        // adjacency List
        List<List<Integer>>list=new ArrayList<>();
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the no of Nodes::");
        int n= Integer.parseInt(bf.readLine());
        // Initialize n+1 list
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        // list updatation -- for undirect graph
        System.out.print("Enter the no of edges::");
        int edges=Integer.parseInt(bf.readLine());
        for(int i=0;i<edges;i++){
            System.out.print("Enter the edges::");
            String str=bf.readLine();
            String edgeString[]=str.split(" ");
            int v=Integer.parseInt(edgeString[0]);
            int u=Integer.parseInt(edgeString[1]);
            list.get(v).add(u);
            list.get(u).add(v);
        }


        // Let's print the list
        System.out.println("************************* ADJACENCY LIST **************************");
        for(int i=0;i<list.size();i++){
            System.out.print(i+" -> {");
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j));
                if(j!=list.get(i).size()-1){
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
    }
}