package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortHashmapByValues {
    private static HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("abc", 2);
        map.put("bcd", 1);
        map.put("cda",3);
    }
    public static void main(String rags[]) {
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted((e1, e2)-> e1.getValue().compareTo(e2.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap.toString() + "abc".replace("a", "b"));
    }
}
