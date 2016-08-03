package Recursive_Iterative;

import java.util.ArrayList;
import java.util.List;

public class L22_GenerateParentheses {
	List<String> list;

	public L22_GenerateParentheses() {
		list = new ArrayList<>();
		backTrack(0, 0, 3, "");
		System.out.print(list);
	}

	public void backTrack(int left, int right, int max, String s) {
		if (left == max && right == max) {
			list.add(s);
			return;
		}
		if (left < max) {
			backTrack(left + 1, right, max, s + "(");
		}
		if (left > right) {
			backTrack(left, right + 1, max, s + ")");
		}
	}

}
// public L22GenerateParentheses() {
// list = new ArrayList<>();
// Node root = new Node(0, 0);
// createTree(root, 3, "");
// // printTree(root, "");
// System.out.print(list);
// }
//
// public void createTree(Node n, int max, String s) {
// if (n.l == max && n.r == max) {
// list.add(s);
// return;
// }
// if (n.l < max) {
// n.left = new Node(n.l + 1, n.r);
// createTree(n.left, max, s + "(");
// }
// if (n.l > n.r) {
// n.right = new Node(n.l, n.r + 1);
// createTree(n.right, max, s + ")");
// }
// }
//
// private class Node {
// int l, r;
// Node left, right;
//
// Node(int left, int right) {
// l = left;
// r = right;
// }
// }
