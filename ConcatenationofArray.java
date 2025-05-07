import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ConcatenationofArray {

//Question:
    //Given an integer array nums of length n, you want to
    //create an array ans of length 2n where ans[i] == nums[i]
    //and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
    //Specifically, ans is the concatenation of two nums arrays.

    //1. By Using for Loops
    public static int[] getConcatenationUsingLoops(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }

    //2. By Using ArrayList
    public static List<Integer> getConcatenationUsingArrayList(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            result.add(num);
        }

        for (int num : nums) {
            result.add(num);
        }

        return result;
    }

    //3. By Using Streams
    public static int[] getConcatenationUsingStreams(int[] nums){
        return IntStream.concat(Arrays.stream(nums), Arrays.stream(nums)).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        int[] ans = getConcatenationUsingLoops(nums);
        System.out.println(Arrays.toString(ans));

        List<Integer> ans2 = getConcatenationUsingArrayList(nums);
        ans2.stream().forEach(System.out::print);

        int[] ans3 = getConcatenationUsingStreams(nums);
        System.out.println(Arrays.toString(ans3));
    }
}
