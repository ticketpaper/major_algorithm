import java.util.Arrays;

public class DPCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int amount = 13;
        int[] memories = new int[amount + 1];
        memories[1]= 1;
        for (int i = 2; i <= amount; i++) {
            int min = amount;
            for (int coin : coins) {
                if (i - coin < 0) continue;
                if (min > memories[i - coin]) {
                    min = memories[i - coin];
                }
            }
            memories[i] = min + 1;
        }
        System.out.println(Arrays.toString(memories));
    }
}
