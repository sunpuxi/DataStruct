package src.Array;

public class 构成整天的下标对的数目 {
    public long countCompleteDayPairs(int[] hours) {
        long res = 0;
        int[] arr = new int[24];
        for (int t : hours) {
            res += arr[(24 - t % 24) % 24];
            arr[t % 24]++;
        }
        return res;
    }
}
