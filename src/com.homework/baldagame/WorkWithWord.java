package com.homework.baldagame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkWithWord {

    private static Map<Character, Integer> charPoint = new HashMap<Character, Integer>(Map.of(
            'а', 2, 'б', 4, 'в', 4, 'г', 2, 'д', 3,
            'е', 3, 'ж', 2, 'з', 4, 'и', 5, 'к', 3));

    static {
        charPoint.put('л', 3);
        charPoint.put('м', 4);
        charPoint.put('н', 2);
        charPoint.put('о', 4);
        charPoint.put('п', 2);
        charPoint.put('р', 2);
        charPoint.put('с', 4);
        charPoint.put('т', 5);
        charPoint.put('у', 3);
        charPoint.put('ф', 2);
        charPoint.put('х', 4);
        charPoint.put('я', 4);
    }

    public static Set<Character> getChars(String word) {
        var letters = new HashSet<Character>();
        for (int i = 0; i < word.length(); i++) {
            letters.add(word.charAt(i));
        }
        return letters;
    }

    public static boolean isContainsAll(Set<Character> first, Set<Character> second) {
        for (var elem : second) {
            if (!first.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    public static int countPoints(String word) {
        Integer point = 0;
        for (int i = 0; i < word.length(); i++) {
            if (charPoint.containsKey(word.charAt(i))) {
                point += charPoint.get(word.charAt(i));
            } else {
                point += 1;
            }
        }
        return point;
    }

}
