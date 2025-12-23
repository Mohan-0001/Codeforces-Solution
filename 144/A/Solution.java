import java.util.Scanner;

public class ArrivalOfTheGeneral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = a[0], min = a[0];
        int maxIndex = 0, minIndex = 0;

        // Find first maximum and last minimum
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
            if (a[i] <= min) {
                min = a[i];
                minIndex = i;
            }
        }

        int swaps = maxIndex + (n - 1 - minIndex);

        // Adjustment if max crosses min
        if (maxIndex > minIndex) {
            swaps--;
        }

        System.out.println(swaps);
    }
}
