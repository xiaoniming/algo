package Tests_Tree;

import java.util.Random;
import java.util.Scanner;

import Utils.U;

/** 最大异或值**/
/**
 * 给一个长度为n的整数序列，现在要你截取这个序列的一个前缀和一个后缀(前缀和后缀不能相交)，使得前缀和后缀的异或值最大。
 * 
 * 前缀和后缀的异或值为前缀序列中的数和后缀序列中的数，异或的结果，比如，某个序列的前缀为1、 2、 4 ，后缀为8、 16，那么它们的异或值为31.
 * 
 * 前缀和后缀可以为空，为空时他们的值为0。 Input 有多组测试数据，请处理到文件结束。
 * 
 * 对于每组测试数据，第一行包含一个整数n(1<=n<=100 000)。
 * 
 * 接下来一行有n个用空格隔开的整数a1, a2, a3, ..., an (0 <= ai <= 1000 000 000 000)。
 **/
// not： 此题数据较大， 需要使用 long 型数据
public class MaxXor {
	public static TrieNode root;
	public static int N;
	public static long[] data;
	public static Scanner s;

	public static void main(String[] args) {

		MaxXor mx = new MaxXor();
		U.print("Please Enter");

		s = new Scanner(System.in);
		while (s.hasNext()) {
			mx.readData();

			mx.calculateMax();
		}
		s.close();
	}

	public void calculateMax() {
		long time_start = System.currentTimeMillis();
		root = new TrieNode();
		long headXOR = 0, tailXOR = 0, maxXOR;
		for (long num : data) {
			tailXOR ^= num;
		}
		maxXOR = headXOR ^ tailXOR;
		insertNode(headXOR);
		for (int i = 0; i < N; i++) {
			headXOR ^= data[i];
			tailXOR ^= data[i];
			insertNode(headXOR);
			maxXOR = Math.max(maxXOR, getMaxXOR(tailXOR));
		}
		System.out.print("maxXOR is : ");
		System.out.println(maxXOR);
		System.out.print("using time:" + (System.currentTimeMillis() - time_start));
	}

	public void readData() {

		N = s.nextInt();
		data = new long[N];
		for (int i = 0; i < N; i++) {
			data[i] = s.nextLong();
		}
	}

	public void insertNode(long _word) {
		if (searchTrieNode(_word))
			return;
		byte[] num = longToByte(_word);
		TrieNode cur = root;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				if (cur.zero == null) {
					cur.zero = new TrieNode();
				}
				cur = cur.zero;
			}
			if (num[i] == 1) {
				if (cur.one == null) {
					cur.one = new TrieNode();
				}
				cur = cur.one;
			}
		}
	}

	public boolean searchTrieNode(long _word) {
		byte[] num = longToByte(_word);
		TrieNode cur = root;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				if (cur.zero == null) {
					return false;
				} else
					cur = cur.zero;
			}
			if (num[i] == 1) {
				if (cur.one == null) {
					return false;
				} else
					cur = cur.one;
			}
		}
		return true;
	}

	// search the trie tree and find max xor for input num
	public long getMaxXOR(long _word) {
		byte[] num = longToByte(_word);
		TrieNode cur = root;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				if (cur.one != null) {
					cur = cur.one;
					num[i] = 1;
				} else {
					cur = cur.zero;
					num[i] = 0;
				} // note that you changed num[i] before, so must use else here!
			} else if (num[i] == 1) {
				if (cur.zero != null) {
					cur = cur.zero;
					num[i] = 1;
				} else {
					cur = cur.one;
					num[i] = 0;
				}
			}
		}
		return byteToLong(num);
	}

	// long to byte[]
	// note every num should end with L, or it will be converted into int!!!
	public static byte[] longToByte(long lnum) {
		long temp = lnum;
		byte[] b = new byte[41];
		for (int i = b.length - 1; i >= 0; i--) {
			b[i] = new Long(temp & 0x01L).byteValue();// 将最低位保存在最低位
			temp = temp >> 1; // 向右移1位
		}
		return b;
	}

	// byte数组转成long
	public static long byteToLong(byte[] b) {
		long s = 0L;
		for (int i = b.length - 1; i >= 0; i--) {
			s |= (((b[i] & 0x01L) << (b.length - 1 - i)));
		}
		return s;
	}

	// create test case ,use it like this: createNum(100, 1000000000000L);
	public static void createNum(int n, long range) {
		// N = n;
		// data = new long[N];
		Random r = new Random();
		U.print(n);
		for (int i = 0; i < n; i++) {
			System.out.println("" + Math.abs(r.nextLong() % range));
			// data[i] = Math.abs(r.nextLong() % range);
		}
		// U.p(data);
	}

}

class TrieNode {
	TrieNode zero;
	TrieNode one;
}
