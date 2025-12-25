import java.io.*;
import java.util.*;

public class Main {

    static boolean can(long n, long m, long k, long L) {
        long block = L + 1;
        long full = m / block;
        long rem = m % block;
        long perRow = full * L + Math.min(L, rem);
        return perRow * n >= k;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long lo = 1, hi = m, ans = m;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (can(n, m, k, mid)) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}
