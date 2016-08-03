package Tests_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Utils.U;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// return ans like this :[[1, 2, 6], [1, 3, 5]]

public class L113Path_Sum_II {
	List<List<Integer>> ansList;
	int finalSUM;
	Stack<Integer> curList;

	public L113Path_Sum_II() {
		U.print(pathSum(TreeNode.getTree(), 9));
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// initialize
		ansList = new ArrayList<List<Integer>>();
		curList = new Stack<>();
		finalSUM = sum;

		sumTree(root, 0);

		return ansList;
	}

	public void sumTree(TreeNode root, int curSum) {

		// curSum does not include this root node

		if (root == null) {
			return;
		}

		// reach leaf node and sum is right
		if (curSum + root.val == finalSUM && root.left == null && root.right == null) {

			// here create a new stack for saving to list
			// if you use curList,it will be changed afterwards
			Stack<Integer> save = new Stack<>(); // Important!!!!!
			save.addAll(curList);
			save.add(root.val);
			ansList.add(save);
			return;
		}
		curList.push(root.val); // important!
		sumTree(root.left, curSum + root.val);
		sumTree(root.right, curSum + root.val);
		curList.pop(); // important!
	}
}
