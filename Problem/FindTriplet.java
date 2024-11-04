package Problem;

import java.util.*;

public class FindTriplet {
    public static void main(String[] args){
        System.out.println(findTriplets(new int[]{0, -1, 2, -3, 1}));
    }

    public static List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>>vis=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        ArrayList<Integer>temp=new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(k);
                        vis.add(temp);
                    }
                }
            }
        }
        return vis;
    }
}
