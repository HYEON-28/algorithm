// 102. Binary Tree Level Order Traversal
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
// 94. Binary Tree Inorder Traversal
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return result;
        queue.offer(root);
        
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();  // queue.size로 레벨 판단!!

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(result.size() < level) {
                    List<Integer> levelList = new ArrayList<>();
                    levelList.add(node.val);
                    result.add(levelList);
                } else {
                    result.get(level-1).add(node.val);
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            level++;
        }

        return result;
        
    }
}


// 개선 코드
// 1. level 처리 불필요함
// 2. levelList만드는 조건분기 불필요함
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) return result;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> levelList = new ArrayList<>();

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 levelList.add(node.val);

//                 if (node.left != null) queue.offer(node.left);
//                 if (node.right != null) queue.offer(node.right);
//             }

//             result.add(levelList);
//         }

//         return result;
//     }
// }