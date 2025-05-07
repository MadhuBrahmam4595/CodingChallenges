
// 🔹 Problem: Shuffle the Array
// Given an array nums consisting of 2n elements in the form:
// [x1, x2, ..., xn, y1, y2, ..., yn]
// Return: [x1, y1, x2, y2, ..., xn, yn]

/* -----------------------------
   ✅ Method 1: Using simple loop
---------------------------------- */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Arrays_ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7}; // Example input
        int n = 3;

        int[] result1 = shuffle(nums, n);
        System.out.println("Method 1 (Basic loop): " + Arrays.toString(result1));

        List<Integer> result2 = shuffleList(nums, n);
        System.out.println("Method 2 (ArrayList): " + result2);

        int[] result3 = shuffleStream(nums, n);
        System.out.println("Method 3 (Streams): " + Arrays.toString(result3));
    }

    // Method 1: Simple loop
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];         // x1, x2, ...
            ans[2 * i + 1] = nums[i + n]; // y1, y2, ...
        }
        return ans;
    }

    // Method 2: Using ArrayList
    public static List<Integer> shuffleList(int[] nums, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(nums[i]);
            result.add(nums[i + n]);
        }
        return result;
    }

    // Method 3: Using Java 8 Streams
    public static int[] shuffleStream(int[] nums, int n) {
        return IntStream.range(0, n * 2)
                .map(i -> (i % 2 == 0) ? nums[i / 2] : nums[n + i / 2])
                .toArray();
    }
}
