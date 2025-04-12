package trees;

import java.util.*;

public class treeBuild {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    int preIndex = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }
        return treebuild(preorder , 0 , preorder.length-1);
    }

    private TreeNode treebuild(int[] preorder, int start , int end){
        if(start>end) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = map.get(root.val);

        root.left = treebuild(preorder,start,index-1);
        root.right = treebuild(preorder,index+1,end);

        return root;
    }
}

// This is the solution for leetcode problem on making tree using just preorder and inorder .