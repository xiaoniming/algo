package Tests_Math;

/**
 * There are n bulbs that are initially off. You first turn on all the
 * bulbs(灯泡). Then, you turn off every second bulb. On the third round, you
 * toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on
 * after n rounds.
 * 
 * Example: Given n = 3.
 * 
 * At first, the three bulbs are [off, off, off].
 * 
 * After first round, the three bulbs are [on, on, on].
 * 
 * After second round, the three bulbs are [on, off, on].
 * 
 * After third round, the three bulbs are [on, off, off].
 * 
 * So you should return 1, because there is only one bulb is on.
 **/
public class L319_BulbSwitcher {

	public L319_BulbSwitcher() {
		bulbSwitch(999999);
	}

	public int bulbSwitch(int n) {
		// for every num must have factors in pairs
		// 3: 3;
		// 4: 2,4(for 2*2)
		// 8: 2,4,8
		// Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and
		// 3 and 4. Except when i is a square, like 36 has divisors 1 and 36, 2
		// and 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on
		// if and only if i is a square.
		return (int) Math.sqrt(n);
	}

	// Stupid Method
	public int bulbSwitch2(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int count, ans = 0;
		for (int i = 1; i <= n; i++) {
			count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0)
					count++;
			}
			if (count % 2 != 0)
				ans++;
		}
		return ans;
	}

}
