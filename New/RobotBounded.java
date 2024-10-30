package New;
// Problem Link -- https://leetcode.com/problems/robot-bounded-in-circle/description/
import java.io.BufferedReader;
import java.io.*;
public class RobotBounded{
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Instruction::");
        String instructions=bf.readLine();
        Solution s1=new Solution();
        boolean ans=s1.isRobotBounded(instructions);
        System.out.println(ans);
    }

}

class Solution{
    public boolean isRobotBounded(String instructions) {
        // directions array of size 4*2
        int[][]directions={
            {0,1},
            {-1,0},
            {0,-1},
            {1,0}
        };

        //  for rotations head directions tracking
        int i=0;
        // initially position x,y
        int x=0;
        int y=0;

        // Traverse all the instructions one by one
        for(int s=0;s<instructions.length();s++){
            if(instructions.charAt(s)=='L'){
                // update the head direction
                i=(i+1)%4;
            }else if(instructions.charAt(s)=='R'){
                i=(i+3)%4; // 3 left rotation means 1 right rotation
            }else if(instructions.charAt(s)=='G'){
                // Update the position
                x=x+directions[i][0];
                y=y+directions[i][1];
            }
        }

        return x==0 && y==0 || x!=0 ;
    }
}