import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            long n = fs.nextLong();
            long ans = 0;

            long pow3 = 1; // 3^i
            int i = 0;

            while (n > 0) {
                long digit = n % 3;

                if (digit > 0) {
                    long cost;
                    if (i == 0) {
                        cost = 3; // special case: 3^(-1) doesn't exist
                    } else {
                        cost = pow3 * 3 + i * (pow3 / 3);
                    }
                    ans += digit * cost;
                }

                n /= 3;
                pow3 *= 3;
                i++;
            }

            out.append(ans).append('\n');
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
