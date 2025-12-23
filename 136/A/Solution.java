import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] giver = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int p = sc.nextInt();
            giver[p] = i;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(giver[i] + " ");
        }
    }
}
