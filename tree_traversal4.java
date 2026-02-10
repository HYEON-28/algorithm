// 145. Binary Tree Postorder Traversal
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
class Solution {
    Deque<TreeNode> stack = new ArrayDeque<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();


        if(root == null) return result;
        addToStack(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
        }

        return result;
    }

    public void addToStack(TreeNode node) {
        stack.push(node);
        if(node.right != null) addToStack(node.right);
        if(node.left != null) addToStack(node.left);
    }

}


// 재귀없이 스택2개 쓰는버전 추천.
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;

//         Deque<TreeNode> s1 = new ArrayDeque<>();
//         Deque<TreeNode> s2 = new ArrayDeque<>();

//         s1.push(root);

//         while (!s1.isEmpty()) {
//             TreeNode node = s1.pop();
//             s2.push(node);

//             if (node.left != null) s1.push(node.left);
//             if (node.right != null) s1.push(node.right);
//         }

//         while (!s2.isEmpty()) {
//             result.add(s2.pop().val);
//         }

//         return result;
//     }
// }
