package Algo_DP;

import Utils.U;

public class L121_BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		U.print(maxProfit(new int[] { 6, 5, 4, 3, 2 }));

	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;
		int lowest = prices[0], max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
				continue;
			}
			if (prices[i] - lowest > max)
				max = prices[i] - lowest;

		}
		return max;
	}

}
