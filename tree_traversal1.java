// Deque<Integer> stack = new ArrayDeque<>();

// stack.push(1);   // 삽입
// stack.push(2);

// int top = stack.pop();   // 2
// int peek = stack.peek(); // 1

// boolean empty = stack.isEmpty();

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
/* 144. Binary Tree Preorder Traversal */
class Solution {
    public static List<Integer> result;
    public static Deque<TreeNode> stack = new ArrayDeque();

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();

        if(root != null) traversal(root);
        return result;
    }

    public void traversal(TreeNode node) {
        if(node.right != null) stack.push(node.right);
        if(node.left != null) stack.push(node.left);
        
        result.add(node.val);
        if(!stack.isEmpty()) {
            traversal(stack.pop());
        }
    } 
}

// 조금 더 깔끔한 풀이.
// 재귀, stack 중 하나만 사용
// static 사용 X
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;

//         Deque<TreeNode> stack = new ArrayDeque<>();
//         stack.push(root);

//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             result.add(node.val);

//             // 오른쪽 먼저 push
//             if (node.right != null) stack.push(node.right);
//             if (node.left != null) stack.push(node.left);
//         }

//         return result;
//     }
// }