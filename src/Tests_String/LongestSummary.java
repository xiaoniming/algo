package Tests_String;

import java.util.ArrayList;
import java.util.List;

import Utils.U;

//最大子序列、最长递增子序列、最长公共子串、最长公共子序列、字符串编辑距离

public class LongestSummary {

	public static void main(String args[]) {
		LongestSummary sm = new LongestSummary();
		// int[] nums = new int[] { -1, 2, 3, -10, 2 };
		// maxSumSub(nums);
		// maxSumSub2(nums);
		// maxSumSub3(nums, 0, nums.length);
		// U.p(LCSequence("1234567", "1246578"));
		// U.print(sm.EditDistance("a", "bca"));
		sm.LCSequence("ttrmeoqrheqojqaxiobgmvmievtbbi", "cxgzqczkjxjfyyzuhtgxrgfqojoogcxgluqzveuznczntawtbfov");
	}

	/***
	 * 最大子序列和
	 * 
	 * http://www.cnblogs.com/CCBB/archive/2009/04/25/1443455.html
	 ***/
	// 动态规划， O（N），快成狗~
	// 只遍历一次，遇到和变成负数就存档跳过重新开始计数
	public int maxSumSub(int[] nums) {
		if (nums.length == 0)
			return 0;
		int maxSum = nums[0];// 初值赋第一个数保险
		int curStart = 0, curSum = 0, savedEnd = 0, savedStart = 0;
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			if (curSum > maxSum) {
				maxSum = curSum;
				savedStart = curStart;
				savedEnd = i;
			}
			if (curSum < 0) {
				curStart = i + 1;
				curSum = 0;
			}
		}
		// 按题目要求去处理一个正数没有的情况
		if (maxSum <= 0) {

		}
		int[] subSequence = new int[savedEnd - savedStart + 1];
		for (int i = 0; i < savedEnd - savedStart + 1; i++) {
			subSequence[i] = nums[savedStart + i];
		}
		U.print("maxSum:" + maxSum);
		U.print("ans:");
		U.print(subSequence);
		return maxSum;
	}

	// 递推解法，O（N*N）慢
	// 利用 s[i] = s[i-1]+a[i]; a[j] + a[j+1] + ... + a[i] = s[i] - s[j-1];
	// maxSum = Max{maxSum,s[i] - s[j-1]};

	public int maxSumSub2(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] s = new int[nums.length + 1];
		s[0] = 0;// 置空
		int maxSum = nums[0], begin = 0, end = 0;
		for (int i = 1; i <= nums.length; i++) {
			s[i] = s[i - 1] + nums[i - 1];
			for (int j = 1; j <= i; j++) {
				if (maxSum < s[i] - s[j - 1]) {
					maxSum = s[i] - s[j - 1];
					begin = j;
					end = i;
				}
			}
		}
		// 按题目要求去处理一个正数没有的情况
		if (maxSum <= 0) {

		}
		U.print("maxSum:" + maxSum);
		U.print("ans:");
		U.print(begin, end);
		return maxSum;
	}

	// “分治策略”（divide-and-conquer）：O(NlogN) 还是挺快的~
	// 最大子序列可能在三个地方，或者在左半部，或者在右半部，或者跨越输入数据的中部而占据左右两部分。
	// 前两种情况递归求解，第三种情况的最大和可以通过求出前半部分最大和（包含前半部分最后一个元素）以及后半部分最大和（包含后半部分的第一个元素）相加而得到。
	// 划分问题，递归求解，合并问题

	// 划分数组 [x,y) = [x,m)+[m,y) 左闭右开

	public int maxSumSub3(int[] nums, int x, int y) {
		if (nums.length == 0) {
			return 0;
		}
		if (y - x <= 1) {
			return nums[x];
		}
		int m = x + (y - x) / 2;

		// maxs是单独在左或者单独在右的最大和
		int maxs = Math.max(maxSumSub3(nums, x, m), maxSumSub3(nums, m, y));

		int L, R, v;
		// 求出以左边对后一个数字结尾的序列最大值
		L = nums[m - 1];
		v = 0;
		for (int i = m - 1; i >= x; i--)
			L = Math.max(L, v += nums[i]);

		// 求出以右边对后一个数字结尾的序列最大值
		R = nums[m];
		v = 0;
		for (int i = m; i < y; i++)
			R = Math.max(R, v += nums[i]);

		// 合并问题
		U.print("maxSum:" + Math.max(maxs, L + R));
		return Math.max(maxs, L + R);
	}

	/***
	 * 最长递增子序列长度(DP)
	 * 
	 * http://www.hawstein.com/posts/dp-novice-to-advanced.html
	 * 
	 * 状态转移方程 d(i) = max{1, d(j)+1},其中j<i,A[j]<=A[i]
	 * 
	 * 用一个previous数组记录
	 ***/

	public int LIS(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;

		int d[] = new int[len]; // mark every node's longest
		int previous[] = new int[len];
		for (int i = 0; i < len; i++) {
			previous[i] = i; // every one comes from itself except when changed
								// afterwards
		}

		int longestLen = 0, t = 0;
		for (int i = 0; i < len; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && ((d[j] + 1) > d[i])) {
					d[i] = d[j] + 1;
					previous[i] = j;
				}
			}
			if (d[i] > longestLen) {
				longestLen = d[i];
				t = i; // mark largest position t
			}

		}
		U.print("longestLength: " + longestLen);
		U.print(d);
		U.print(previous);
		while (previous[t] != t) { //
			U.print(nums[t]);
			t = previous[t];
		}
		U.print(nums[t]);

		return longestLen;
	}

	/***
	 * Longest Common SubString
	 * 
	 * 最长公共子串：给定两个字符串，求出它们之间最长的相同子字符串（连续）的长度。
	 *
	 ***/
	//// h e b l t l o
	// a 0 0 0 0 0 0 0
	// h 1 0 0 0 0 0 0 更新 max = 1
	// e 0 2 0 0 0 0 0 更新 max = 2
	// b 0 0 3 0 0 0 0 更新 max = 3
	// l 0 0 0 4 0 1 0 更新 max = 4
	// o 0 0 0 0 0 0 2
	// t 0 0 0 0 1 0 0
	public void LCS(String s1, String s2) {
		int b[] = new int[s1.length()];
		int i, j, maxLen = 0, maxPosition = 0;
		for (j = 0; j < s2.length(); j++) {
			for (i = s1.length() - 1; i > 0; i--) { // 倒序处理
				if (s1.charAt(i) == s2.charAt(j)) {
					b[i] = b[i - 1] + 1;
					if (b[i] > maxLen) {
						maxLen = b[i];
						maxPosition = i;
					}
				} else {
					b[i] = 0;
				}
			}
			b[0] = (s1.charAt(0) == s2.charAt(j)) ? 1 : 0;
			U.print(b);
		}
		U.print(b);
		U.print("longest common substring length is : ", maxLen);
		U.print("longest common substring  coloum : ", maxPosition);

	}

	/***
	 * Longest Common SubSequence
	 * 
	 * 最长公共子序列：给定两个字符串，求出它们之间最长的相同子字符序列（不连续）的长度。
	 *
	 * DP动态规划做，LCS(S1,S2)等于下列3项的最大者：
	 * 
	 * （1）LCS（S1，S2’）
	 * 
	 * （2）LCS（S1’，S2）
	 * 
	 * （3） LCS（S1'，S2'）+C1 --如果C1等于C2；
	 ***/
	public int LCSequence(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 == 0 || len2 == 0)
			return 0;
		int i = 0, j = 0;
		int b[][] = new int[len2 + 1][];
		for (i = 0; i < len2 + 1; i++) {
			b[i] = new int[len1 + 1];
		}
		for (j = 1; j <= len2; j++) {
			for (i = 1; i <= len1; i++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					b[j][i] = b[j - 1][i - 1] + 1;
				} else {
					b[j][i] = Math.max(b[j][i - 1], b[j - 1][i]);
				}
			}
		}
		for (int ii = 0; ii < b.length; ii++) {
			U.print(b[ii]);
		}
		// 输出最长的子序列
		i = len1;
		j = len2;
		StringBuilder sb = new StringBuilder();
		int count = b[len2][len1];
		while (count > 0) {
			if (i > 0 && j > 0) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					sb.append(s1.charAt(i - 1));
					i--;
					j--;
					count--;
				} else if (b[j - 1][i] > b[j][i - 1]) {
					j--;
				} else {
					i--;
				}
			}
		}
		sb.reverse();
		U.print(sb.toString());
		return b[len2][len1];
	}

	/**
	 * 字符串编辑距离
	 * 
	 * 要想把字符串S1变成S2，可以经过若干次下列原子操作： 1.删除一个字符 2.增加一个字符 3.更改一个字符
	 * 
	 * 字符串S1和S2的编辑距离定义为从S1变成S2所需要原子操作的最少次数。
	 * 
	 * 解法跟上面的最长公共子序列十分相似，都是动态规划，把一个问题转换为若干个规模更小的子问题，并且都借助于一个二维矩阵来实现计算。
	 * 
	 * 约定：字符串S去掉最后一个字符T后为S'，T1和T2分别是S1和S2的最后一个字符。
	 * 
	 * 则dist(S1,S2)是下列4个值的最小者：
	 * 
	 * 1.dist(S1',S2')--当T1==T2
	 * 
	 * 2.1+dist(S1',S2)--当T1!=T2，并且删除S1的最后一个字符T1
	 * 
	 * 3.1+dist(S1,S2')--当T1!=T2，并且在S1后面增加一个字符T2
	 * 
	 * 4.1+dist(S1',S2')--当T1!=T2，并且把S1的最的一个字符T1改成T2
	 **/
	public int EditDistance(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		int i = 0, j = 0;
		int[][] d = new int[len1 + 1][];
		for (i = 0; i < len1 + 1; i++) {
			d[i] = new int[len2 + 1];
			for (j = 0; j < len2 + 1; j++) {
				if (i == 0) {
					d[i][j] = j;// 边界情况
				}
				if (j == 0) {
					d[i][j] = i;
				}
			}
		}
		d[0][0] = 0;
		for (i = 1; i <= len1; i++) {
			for (j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					d[i][j] = 1 + Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]);
				}
			}
		}
		for (j = 0; j <= len1; j++) {
			U.print(d[j]);
		}

		return d[len1][len2];
	}

	// 暴力求解最长子序列
	public static int longestCommonSubSequence(String arr1, String arr2) {
		if (arr1 == null || arr2 == null)
			return Integer.MIN_VALUE;
		String newString1 = null;// duan
		String newString2 = null;// chang
		List<String> list = new ArrayList<>();
		int result = Integer.MIN_VALUE;
		if (arr1.length() < arr2.length()) {
			newString1 = arr1;
			newString2 = arr2;
		} else {
			newString1 = arr2;
			newString2 = arr1;
		}
		list = GetAllSubSequence.getAllSubSequence(newString1);
		for (String tmpList : list) {
			if (xifContainTheString(newString2, tmpList)) {
				int tmpListLength = tmpList.length();
				if (tmpListLength > result)
					result = tmpListLength;
				// System.out.println("tmpListLength=" + tmpListLength);
			}
		}
		return result;
	}

	// s1子序列是否包含s2
	public static boolean xifContainTheString(String s1, String s2) {
		// U.p("s1: " + s1 + " s2: " + s2);
		int location = 0;
		int count = 0;
		int length = s2.length();
		for (int i = 0; i < s2.length(); i++) {
			while (location < s1.length() && s1.charAt(location) != s2.charAt(i))
				location++;
			if (location < s1.length() && s1.charAt(location) == s2.charAt(i)) {
				location++;
				count++;
			}
		}
		if (count == length)
			return true;
		else
			return false;
	}
}
