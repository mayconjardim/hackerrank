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


    public static void plusMinus(List<Integer> arr) {
     float positives = 0;
     float negatives = 0;
     float zeros = 0;
     
     for (int i =0; i<arr.size(); i++){
         if (arr.get(i) > 0){
             positives++;
         } else if (arr.get(i) == 0){
             zeros++;
         } else {
             negatives++;
         }
     }
    
    positives /= arr.size();
    negatives /= arr.size();
    zeros /= arr.size();
    
    System.out.println(positives);
    System.out.println(negatives);
    System.out.println(zeros);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
