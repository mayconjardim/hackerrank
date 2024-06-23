import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] split = input.split(";");
            char operation = split[0].charAt(0);
            char type = split[1].charAt(0);
            String words = split[2];
            String output = processInput(operation, type, words);
            System.out.println(output.trim());
        }

        scanner.close();
    }

    private static String processInput(char operation, char type, String words) {
        StringBuilder output = new StringBuilder();
        char[] wordsArr = words.toCharArray();

        if (operation == 'S') {
            splitWords(output, wordsArr);
        } else if (operation == 'C') {
            combineWords(output, wordsArr, type);
        }

        return output.toString();
    }

    private static void splitWords(StringBuilder output, char[] wordsArr) {
        for (char ch : wordsArr) {
            if (Character.isUpperCase(ch)) {
                output.append(" ").append(Character.toLowerCase(ch));
            } else if (ch != '(' && ch != ')') {
                output.append(ch);
            }
        }
    }

    private static void combineWords(StringBuilder output, char[] wordsArr, char type) {
        boolean capitalizeNext = false;

        for (char ch : wordsArr) {
            if (ch == ' ') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    output.append(Character.toUpperCase(ch));
                    capitalizeNext = false;
                } else {
                    output.append(ch);
                }
            }
        }

        if (type == 'M') {
            output.append("()");
        } else if (type == 'C') {
            output.setCharAt(0, Character.toUpperCase(output.charAt(0)));
        }
    }
}
