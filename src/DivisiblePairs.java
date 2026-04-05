
import java.util.Scanner;

public class DivisiblePairs {

    // Task: Find pairs (i, j) where i < j and (arr[i] + arr[j]) % k == 0
    public int countDivisiblePairs(int[] arr, int n, int k) {
        // Array to store the frequency of remainders we've seen so far
        int[] remainderCount = new int[k];
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Get the current remainder
            int rem = arr[i] % k;
            
            // Handle negative numbers safely (if any exist)
            if (rem < 0) rem += k;

            // Calculate the "target" remainder we need to form a divisible pair.
            // If rem is 1 and k is 3, we need a previous element with a remainder of 2.
            int target = (k - rem) % k;

            // Add the number of times we've seen this target remainder previously
            count += remainderCount[target];

            // Record the current remainder for future elements to pair with
            remainderCount[rem]++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size of array and the divisor
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[] arr = new int[n];
            
            // Read array elements
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            DivisiblePairs solver = new DivisiblePairs();
            System.out.println(solver.countDivisiblePairs(arr, n, k));
        }
        
        sc.close();
    }
}
