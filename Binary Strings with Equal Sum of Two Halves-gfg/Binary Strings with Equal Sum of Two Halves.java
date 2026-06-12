https://youtu.be/cAWU2FKDNZ8

Binary Strings with Equal Sum of Two Halves

  nlognMod,1
class Solution {
    long MOD = 1000000007;
    public int computeValue(int n) {
        // code here
        long ans = 1;

        // Compute C(2n, n)
        for (int i = 1; i <= n; i++) {
            ans = (ans * (2L * n - i + 1)) % MOD;

            // divide by i using modular inverse
            ans = (ans * power(i, MOD - 2)) % MOD;
        }

        return (int) ans;
    }

    long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}
