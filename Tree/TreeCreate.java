package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeCreate {

    // Create a treeNode
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        // Constructor
        public TreeNode(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        // method
        static int idx=-1;
        public static TreeNode buildTree(int[]nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            TreeNode newNode=new TreeNode(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

        // pre-order Traversal
        // current node ->left node -> right node
        public static void preOrderTraversal(TreeNode node){
            if(node!=null){
                System.out.print(node.value+" -> ");
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }

        // post order traversal
        // left -> right -> current
        public static void postOrderTraversal(TreeNode node){
            if(node!=null){
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                System.out.print(node.value+" -> ");
            }
        }
        // In order traversal
        // left -> current -> right 
        public static void inOrderTraversal(TreeNode node){
            if(node!=null){
                inOrderTraversal(node.left);
                System.out.print(node.value+" -> ");
                inOrderTraversal(node.right);
            }
        }

        // Level order traversal or BFS
        public static void bfs(TreeNode node){
            Queue<TreeNode>q=new LinkedList<>();
            q.add(node);
            q.add(null);
            while(!q.isEmpty()){
                TreeNode curr=q.remove();
                if(curr==null){
                    System.out.println(); // new Line print
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                System.out.print(curr.value+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if (curr.right!=null){
                    q.add(curr.right);
                }
            }
            }
        }

        // Count of nodes - O(n)

        public static int countNodes(TreeNode root){
            if(root==null){
                return 0;
            }

            int leftCount=countNodes(root.left);
            int rigthCount=countNodes(root.right);

            return leftCount+rigthCount+1;
        }

         // Sum of nodes - O(n)

         public static int sumNodes(TreeNode root){
            if(root==null){
                return 0;
            }

            int leftSum=sumNodes(root.left);
            int rightSum=sumNodes(root.right);

            return leftSum+rightSum+root.value;
        }

        // height of the Tree

        public static int height(TreeNode root){
            if(root==null){
                return 0;
            }

            int leftHeight=height(root.left);
            int rightHeight=height(root.right);

            int myHeight=Math.max(leftHeight, rightHeight)+1;

            return myHeight;
        }

        public static int diameter(TreeNode root){ // O(n^2) time 
            if(root==null){
                return 0;
            }

            int diam1=diameter(root.left);
            int diam2=diameter(root.right);
            int diam3=height(root.left)+height(root.right)+1;

            return Math.max(diam3,Math.max(diam1,diam2));
        }

        static class TreeInfo{
            int ht;
            int diam;
            public TreeInfo(int ht,int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }

        public static TreeInfo diameter2(TreeNode root){ // O(n)
            if(root==null){
                return new TreeInfo(0, 0);
            }

            TreeInfo left=diameter2(root.left);
            TreeInfo right=diameter2(root.right);

            int myHeight=Math.max(left.ht,right.ht)+1;

            int diam1=left.diam;
            int diam2=right.diam;
            int diam3=left.ht+right.ht+1;

            int myDiam=Math.max(diam1,Math.max(diam2,diam3));

            return new TreeInfo(myHeight, myDiam);
        }

    }
    public static void main(String[] args){
        int[]nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeNode root=BinaryTree.buildTree(nodes);
        // System.out.println(root.value +" and left "+root.left.value+" and right "+root.right.value);
        // System.out.print("pre order Traversal::");
        // BinaryTree.preOrderTraversal(root);
        // System.out.print("post order Traversal::");
        // BinaryTree.postOrderTraversal(root);
        // System.out.println();
        // System.out.print("In order Traversal::");
        // BinaryTree.inOrderTraversal(root);
        // System.out.println();
        // BinaryTree.bfs(root);
        System.out.println("Count of Nodes= "+BinaryTree.countNodes(root));
        System.out.println("Sum of all Nodes: "+BinaryTree.sumNodes(root));
        System.out.println("Height of the Tree :: "+BinaryTree.height(root));
        System.out.println("Diameter of the Tree::"+BinaryTree.diameter2(root).diam);
    }
}
