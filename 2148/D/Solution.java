import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            List<Long> odd = new ArrayList<>();
            long evenSum = 0;

            for (int i = 0; i < n; i++) {
                long a = fs.nextLong();
                if ((a & 1) == 1) {
                    odd.add(a);
                } else {
                    evenSum += a;
                }
            }

            // No odd fields → mower never turns on
            if (odd.isEmpty()) {
                out.append(0).append('\n');
                continue;
            }

            // Sort odd fields descending
            odd.sort(Collections.reverseOrder());

            int canCutOdds = (odd.size() + 1) / 2;
            long oddSum = 0;

            for (int i = 0; i < canCutOdds; i++) {
                oddSum += odd.get(i);
            }

            out.append(evenSum + oddSum).append('\n');
        }

        System.out.print(out.toString());
    }

    // Fast input
    static class FastScanner {
        byte[] buffer = new byte[1 << 16];
        int ptr = 0, len = 0;
        InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
