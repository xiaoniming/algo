package NowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class RoadLights {

	public RoadLights() {
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			int n = s.nextInt();
			long l = s.nextInt();
			long a[] = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			Arrays.sort(a);
			// 注意输出格式
			System.out.println(String.format("%.2f", minD(a, l)));
		}
		s.close();
	}

	public static double minD(long[] data, long l) {
		double maxd = 0;
		for (int i = 1; i < data.length; i++) {
			if ((data[i] - data[i - 1]) > maxd)
				maxd = data[i] - data[i - 1];
		}
		maxd = maxd / 2.0;
		// 考虑两个边界不用除以2
		maxd = Math.max(maxd, data[0]);
		maxd = Math.max(maxd, l - data[data.length - 1]);
		return maxd;
	}

}
