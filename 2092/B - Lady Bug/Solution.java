import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String a = br.readLine().trim();
            String b = br.readLine().trim();

            int ones1 = 0, ones2 = 0;
            int bSlots1 = 0, bSlots2 = 0;

            for (int i = 0; i < n; i++) {
                int idx = i + 1; // 1-based index

                if (idx % 2 == 1) { // odd index
                    if (a.charAt(i) == '1') ones1++;
                    if (b.charAt(i) == '1') ones2++;
                    bSlots2++; // b[odd] belongs to component 2
                } else { // even index
                    if (a.charAt(i) == '1') ones2++;
                    if (b.charAt(i) == '1') ones1++;
                    bSlots1++; // b[even] belongs to component 1
                }
            }

            if (ones1 <= bSlots1 && ones2 <= bSlots2) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out.toString());
    }
}
