import java.util.Scanner;

public class LuckyTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String ticket = sc.next();

        int half = n / 2;
        int sumFirst = 0;
        int sumSecond = 0;

        for (int i = 0; i < n; i++) {
            char c = ticket.charAt(i);

            // Check if digit is lucky
            if (c != '4' && c != '7') {
                System.out.println("NO");
                return;
            }

            int digit = c - '0';

            if (i < half) {
                sumFirst += digit;
            } else {
                sumSecond += digit;
            }
        }

        if (sumFirst == sumSecond) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
