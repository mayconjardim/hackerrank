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
     
    int min = arr.get(0);
    int max = arr.get(0);
    long totalSum = 0;
    
    for (int n : arr){
        totalSum += n;
        if (n < min) min = n;
        if (n > max) max = n;
    }
    
    System.out.print((totalSum - max) + " " + (totalSum - min));
        

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
