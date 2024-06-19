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
   
    public static List<Integer> breakingRecords(List<Integer> scores) {
        Integer currentHigh = scores.get(0);
        Integer currentLow = scores.get(0);
        Integer High = 0; 
        Integer Low = 0;
        List<Integer> records = new ArrayList<>();
        
        for (Integer score : scores){
            if (score > currentHigh) {
                currentHigh = score;
                High++;
            } else if (score < currentLow){
                 currentLow = score;
                 Low++;        
            }
        }
        
        records.add(High);
        records.add(Low);
        
        return records;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
