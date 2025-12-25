import java.io.*;
import java.util.*;

public class Main {

    static boolean isPrime(long x) {
        if (x < 2) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] parts = br.readLine().split(" ");
            long x = Long.parseLong(parts[0]);
            int k = Integer.parseInt(parts[1]);

            if (k == 1) {
                out.append(isPrime(x) ? "YES\n" : "NO\n");
            } else {
                if (x == 1 && k == 2)
                    out.append("YES\n");
                else
                    out.append("NO\n");
            }
        }

        System.out.print(out.toString());
    }
}
