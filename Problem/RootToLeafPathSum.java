package Problem;
//  https://www.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1
public class RootToLeafPathSum {
    public static void main(String[] args) {

    }

    static class Tree {
        int data;
        Tree left, right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static int treePathsSum(Tree root) {
        if (root != null)
            return (int)helper(root, 0L);
        return 0;
    }

    private static int helper(Tree root,long val){
            if(root==null){
                return 0;
            }
    
            val= val*10+root.data;
    
            if(root.left==null && root.right==null){
                return (int)val;
            }
    
            return helper(root.left, val) + helper(root.right, val);
    }
}
