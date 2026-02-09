import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

// 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         Deque<TreeNode> stack = new ArrayDeque<>();
//         List<Integer> result = new ArrayList<>();

//         if(root == null) return result;
//         stack.push(root);

//         while(!stack.isEmpty()) {
//             TreeNode node = stack.peek();

//             if(node.left == null) {
//                 result.add(node.val);
//                 stack.pop();
//                 if(node.right != null) stack.push(node.right);
//             } else {
//                 stack.push(node.left);
//                 node.left = null;
//             }
//         }

//         return result;
//     }
// }

// 개선점: 원본트리를 수정하지 않고 푸는게 좋음 

public class tree_traversal3 {

    // LeetCode와 동일한 TreeNode 정의
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // inorder traversal (반복)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        /*
         입력 트리 구조:
                 1
               /   \
              2     3
             / \     \
            4   5     8
               / \   /
              6   7 9
         */

        TreeNode root =
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(7)
                    )
                ),
                new TreeNode(3,
                    null,
                    new TreeNode(8,
                        new TreeNode(9),
                        null
                    )
                )
            );

        List<Integer> result = inorderTraversal(root);
        System.out.println(result); // [4, 2, 6, 5, 7, 1, 3, 9, 8]
    }
}