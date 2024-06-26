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

  
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        int[] results = new int[queries.size()];
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String string : strings) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        
        for (int i = 0; i < queries.size(); i++) {
            results[i] = map.getOrDefault(queries.get(i), 0);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int result : results) {
            resultList.add(result);
        }
        
        return resultList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.matchingStrings(strings, queries);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
