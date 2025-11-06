package kyu4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class getPINs {


    public static void main (String[] args) {
        System.out.println( getPINs("369") );
    }

    private static final Map<Character, Button> buttons = new HashMap<>();

    static {
        buttons.put('1', new Button('1', List.of('2', '4')));
        buttons.put('2', new Button('2', List.of('1', '3', '5')));
        buttons.put('3', new Button('3', List.of('2', '6')));
        buttons.put('4', new Button('4', List.of('1', '5', '7')));
        buttons.put('5', new Button('5', List.of('2', '4', '6', '8')));
        buttons.put('6', new Button('6', List.of('3', '5', '9')));
        buttons.put('7', new Button('7', List.of('4', '8')));
        buttons.put('8', new Button('8', List.of('5', '7', '9', '0')));
        buttons.put('9', new Button('9', List.of('6', '8')));
        buttons.put('0', new Button('0', List.of('8')));
    }



    public static List<String> getPINs(String s) {
        if (s.length() == 1)
            return buttons.get(s.charAt(0)).getPossibleDigits();

        List<String> results = new ArrayList<>();

        char c = s.charAt(0);

        List<String> P = buttons.get(c).getPossibleDigits();

        List<String> tailResults = getPINs(s.substring(1));

        for(String p : P)
            for(String t : tailResults)
                results.add(p + t);

        return results;

    }



    public static class Button {
        private final Character number;
        private final List<Character> neighbours;

        public Button(Character number, List<Character> neighbours) {
            this.number = number;
            this.neighbours = neighbours;
        }

        public List<Character> getNeighbours() {
            return neighbours;
        }

        public List<String> getPossibleDigits() {
            List<Character> result = new ArrayList<>(neighbours);
            result.add(number);
            return result
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
        }
    }



}
