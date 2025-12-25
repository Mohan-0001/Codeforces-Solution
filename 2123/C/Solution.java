import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            // prefix minimums
            int[] prefMin = new int[n];
            prefMin[0] = a[0];
            for (int i = 1; i < n; i++) {
                prefMin[i] = Math.min(prefMin[i - 1], a[i]);
            }

            // suffix maximums
            int[] suffMax = new int[n];
            suffMax[n - 1] = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffMax[i] = Math.max(suffMax[i + 1], a[i]);
            }

            // build answer
            for (int i = 0; i < n; i++) {
                if (a[i] == prefMin[i] || a[i] == suffMax[i]) {
                    out.append('1');
                } else {
                    out.append('0');
                }
            }
            out.append('\n');
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
    }
}
