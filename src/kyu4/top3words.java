package kyu4;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class top3words {

    public static void main(String[] args) {
        System.out.println( top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e") );
    }


    public static List<String> top3(String s) {

        s = s.toLowerCase();
        Map<String, Integer> words = new HashMap<>();

        Pattern pattern = Pattern.compile("[a-z']*[a-z][a-z']*");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()) {
            words.merge(matcher.group(), 1, Integer::sum);
        }

        List<String> sortedWords = words.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return sortedWords;
    }

}
