import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ans = new int[n + 1]; // 1-based indexing

        for (int i = 1; i <= n; i++) {
            int p = sc.nextInt();
            ans[p] = i;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
