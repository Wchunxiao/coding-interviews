package Chap4;

import java.util.ArrayList;
//二叉树中和为某一路径的值
//输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
//路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
public class FindPathInBST {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * @param root 二叉树根结点
     * @param target 目标值
     * @return 所有和目标值相同的路径上结点的集合
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root, target, path, res);
        return res;
    }

    private void preOrder(TreeNode root, int curVal,ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        // 模拟结点进栈
        path.add(root.val);
        curVal -= root.val;
        // 只有在叶子结点处才判断是否和目标值相同，若相同加入列表中
        if (root.left == null && root.right == null) {
            if (curVal == 0) res.add(new ArrayList<>(path));
        }
        preOrder(root.left, curVal, path, res);
        preOrder(root.right, curVal, path, res);
        // 模拟结点出栈
        path.remove(path.size() - 1);
        curVal += root.val;
    }
}
