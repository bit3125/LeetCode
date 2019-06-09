package others.codingtest.alibaba;

import java.util.Arrays;

public class Main {

    private static int totalPrice(int categoryCount, int totalVolume, int totalWeight,
                                  int[] volume, int[] weight, int[] stock, int[] price, int[] itemType) {

        int[] volumes = new int[volume.length+1], weights = new int[weight.length+1],
                stocks = new int[stock.length+1], prices = new int[price.length+1];
        System.arraycopy(volume, 0, volumes, 1, volume.length);
        System.arraycopy(weight, 0, weights, 1, weight.length);
        System.arraycopy(stock, 0, stocks, 1, stock.length);
        System.arraycopy(price, 0, prices, 1, price.length);

        int[][][] dp = new int[categoryCount+1][totalVolume+1][totalWeight+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], 0);
            }
        }

//        /*
        int i, j, k, l;
        for (i = 1; i <= categoryCount; ++i) {
            for (j = volume[i - 1]; j <= totalVolume; ++j) {
                for (k = weight[i - 1]; k <= totalWeight; ++k) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    for (l = 1; l <= stock[i - 1]; ++l) {
                        if (l * volume[i - 1] <= j && l * weight[i - 1] <= k) {
                            dp[i][j][k] =
                                    dp[i][j][k]
                                            > (dp[i - 1][j - l * volume[i - 1]][k
                                            - l * weight[i - 1]] + l * price[i - 1]) ?
                                            dp[i][j][k] :
                                            (dp[i - 1][j - l * volume[i - 1]][k
                                                    - l * weight[i - 1]] + l * price[i - 1]);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
//        */

        return dp[dp.length - 1][dp[0].length - 1][dp[0][0].length - 1];
    }
}
