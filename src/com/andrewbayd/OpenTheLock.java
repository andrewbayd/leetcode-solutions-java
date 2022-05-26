package com.andrewbayd;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {
    public static Map<Character, Character> nextDigit = Map.of(
            '0', '1',
            '1', '2',
            '2', '3',
            '3', '4',
            '4', '5',
            '5', '6',
            '6', '7',
            '7', '8',
            '8', '9',
            '9', '0'
    );

    public static Map<Character, Character> prevDigit = nextDigit.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static int openLock(String combo, List<String> trappedCombos) {
        if (combo.equals("0000")) {
            return 0;
        }
        HashSet<String> trappedComboSet = new HashSet<>(trappedCombos);
        HashMap<String, Integer> bfsMap = new HashMap<>();
        bfsMap.put("0000", 0);
        ArrayDeque<String> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer("0000");
        while (!bfsQueue.isEmpty()) {
            String top = bfsQueue.poll();
            for (int i = 0; i < 4; i++) {
                String newCombo = top.substring(0, i).concat(String.valueOf(nextDigit.get(top.charAt(i)))).concat(top.substring(i + 1));
                if (!trappedComboSet.contains(newCombo) && !bfsMap.containsKey(newCombo)) {
                    bfsQueue.offer(newCombo);
                    bfsMap.put(newCombo, bfsMap.get(top) + 1);
                    if (newCombo.equals(combo)) {
                        return bfsMap.get(newCombo);
                    }
                }
                newCombo = top.substring(0, i).concat(String.valueOf(prevDigit.get(top.charAt(i)))).concat(top.substring(i + 1));
                if (!trappedComboSet.contains(newCombo) && !bfsMap.containsKey(newCombo)) {
                    bfsQueue.offer(newCombo);
                    bfsMap.put(newCombo, bfsMap.get(top) + 1);
                    if (newCombo.equals(combo)) {
                        return bfsMap.get(newCombo);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        openLock("0202", List.of("0201","0101","0102","1212","2002"));
    }
}
