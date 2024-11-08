package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// https://leetcode.com/problems/maximum-xor-for-each-query/description/?envType=daily-question&envId=2024-11-08
public class MaximumXor {
    public static void main(String[] args) throws IOException {
        //System.out.println(Arrays.toString(getMaximumXor(new int[]{0,1,2,2,5,7}, 3)));
        // take Input using BufferedReader class
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of Element of the Nums:");
        int n=Integer.parseInt(bf.readLine());
        // array declaration
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the "+i+"th element::");
            nums[i]=Integer.parseInt(bf.readLine());
        }
        System.out.print("Enter the Maximum bits::");
        int maximumBit=Integer.parseInt(bf.readLine());

        int[]ans=getMaximumXor(nums, maximumBit);
        System.out.println(Arrays.toString(ans));


    }
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int[] prefixZorSum=new int[n];
        int[] ans=new int[n];
        prefixZorSum[0]=nums[0];
        int temp=nums[0];
        for(int i=1;i<n;i++){
            temp=temp^nums[i];
            prefixZorSum[i]=temp;
        }
        int k=(int)Math.pow(2, maximumBit);
        int maximumXor=k-1;
        int i=n-1;
        while(i>=0){
            int currentSum=prefixZorSum[i];
            if((maximumXor-currentSum)<k){
                ans[n-i-1]=maximumXor-currentSum;
            }
            i--;
        }
        return ans;
    }
}
