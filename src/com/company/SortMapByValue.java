package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortMapByValue {
    static class KeyValue {
        private String key;
        private Integer value;
        private KeyValue(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "[" + key + "," + value +"]";
        }
    }
    public static void main(String str[]) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("abc", 4);
        unsortedMap.put("bcd", 3);
        unsortedMap.put("cde", 1);
        unsortedMap.put("bkg", 2);
        Map<String, Integer> sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new ));

        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


        List<KeyValue> keyValueList;

        keyValueList = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(e -> new KeyValue(e.getKey(),e.getValue())).collect(Collectors.toList());
        keyValueList.forEach(System.out::println);

        Double avg = keyValueList.stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(kv -> kv.value), v->v*3));
        System.out.println(avg);
        countCharFrequency();
    }

    static void countCharFrequency() {
        String test = "asgderfscgdtehgsfd";
        Map<Character, Long> countmap = test.chars().mapToObj(e -> (char)e).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        countmap.entrySet().forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));
    }
}
