import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static void miniMaxSum(List<Integer> arr) {
     
        int sum = arr.stream().mapToInt(Integer::intValue).sum();
        int minSum = sum - arr.stream().max(Integer::compareTo).orElse(0);
        int maxSum = sum - arr.stream().min(Integer::compareTo).orElse(0);
        System.out.println(minSum + " " + maxSum);
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
