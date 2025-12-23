import java.util.Scanner;

public class AmusingJoke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String guest = sc.nextLine();
        String host = sc.nextLine();
        String pile = sc.nextLine();

        // Frequency array for letters A-Z
        int[] count = new int[26];

        // Count guest and host letters
        for (char c : guest.toCharArray()) {
            count[c - 'A']++;
        }
        for (char c : host.toCharArray()) {
            count[c - 'A']++;
        }

        // Subtract pile letters
        for (char c : pile.toCharArray()) {
            count[c - 'A']--;
        }

        // Check if all counts are zero
        for (int x : count) {
            if (x != 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
