import java.util.*;
public class Main {
  public static void printOddsAsc(int start, int end) {
        if (start > end) return;
        if (start % 2 == 1) {
            System.out.print(start + " ");
        }
        printOddsAsc(start + 1, end);
    }

    // Recursive method to print odd numbers in descending order
    public static void printOddsDesc(int start, int end) {
        if (start < end) return;
        if (start % 2 == 1) {
            System.out.print(start + " ");
        }
        printOddsDesc(start - 1, end);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        if (n >= 369) {
            // Case where n is greater than or equal to 369
            printOddsAsc(369, n);
        } else {
            // Case where n is less than 369
            printOddsAsc(n, 369);
        }
    }
}