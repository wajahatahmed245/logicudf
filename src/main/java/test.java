import java.awt.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.stream.Collectors;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.stream.Collectors;

import java.io.*;


public class test implements Bet {

    public static class SortMapByValue {

        public boolean ASC = true;
        public boolean DESC = false;
        private Map<String, Long> unsortMap = new HashMap<String, Long>();


        public Map<String, Long> getUnsortMap() {
            return unsortMap;
        }

        public void insertKeyValue(String key, Long value) {
            unsortMap.put(key, value);


        }

        public Map<String, Long> sortByComparator(Map<String, Long> unsortMap, final boolean order) {

            List<Map.Entry<String, Long>> list = new LinkedList<Map.Entry<String, Long>>(unsortMap.entrySet());


            Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
                public int compare(Map.Entry<String, Long> o1,
                                   Map.Entry<String, Long> o2) {
                    if (order) {
                        return o1.getValue().compareTo(o2.getValue());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());

                    }
                }
            });


            Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
            for (Map.Entry<String, Long> entry : list) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            return sortedMap;
        }

        public String getMeModeKey() {
            Map<String, Long> sortedMapDesc = sortByComparator(unsortMap, DESC);
            return printMap(sortedMapDesc);
        }

        public String printMap(Map<String, Long> map) {
            String firstKey = map.keySet().iterator().next();
            return firstKey;
        }

        public <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
            return map.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), value))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
        }


    }


    public static void main(String[] args) throws IOException {

        SortMapByValue hashmap = new SortMapByValue();

        hashmap.insertKeyValue("hello12", Long.valueOf(1));
        hashmap.insertKeyValue("hello11", Long.valueOf(1));
        hashmap.insertKeyValue("hello112", Long.valueOf(1));
        hashmap.insertKeyValue("hello1", Long.valueOf(1));


        System.out.println(hashmap.getMeModeKey());
//        System.out.println();

        System.out.println("--------------------------------------testing hashmaps--------------------------------------------");


        Map<String, Long> hashMap_non = new HashMap();
        hashMap_non.put("A", Long.valueOf(1));
        hashMap_non.put("B", Long.valueOf(2));
        hashMap_non.put("C", Long.valueOf(3));
        hashMap_non.put("w", Long.valueOf(3));
//        hashMap_non.put("e", Long.valueOf(3));


//        System.out.println(getKey(hashMap_non, 3));
//        System.out.println(getKeysByValue(hashMap_non, Long.valueOf(3)).toString());
//        System.out.println(hashmap.getUnsortMap().getClass().getSimpleName());
        System.out.println(hashMap_non.getClass().getSimpleName());
        hashmap.getUnsortMap();

        hashmap.getKeysByValue(hashmap.getUnsortMap(), hashmap.getUnsortMap().get(hashmap.getMeModeKey()));
        System.out.println("this is " + hashmap.getUnsortMap().get(hashmap.getMeModeKey()));


        if (hashmap.getUnsortMap().get(hashmap.getMeModeKey()) == Long.valueOf(1)) {

            System.out.println("no mode");
        } else {
            System.out.println("this is in if " + hashmap.getUnsortMap().get(hashmap.getMeModeKey()));
        }

//        System.out.println(hashmap.getKeysByValue(hashmap.getUnsortMap(), hashmap.getUnsortMap().get(hashmap.getMeModeKey())).toString());

        StringBuilder text = new StringBuilder("javatutorialhq.com");
        text.replace(0, text.length(), "hello12");
//        System.out.println(text.toString().getClass().getSimpleName());
        System.out.println(hashmap.getKeysByValue(hashmap.getUnsortMap(), hashmap.getUnsortMap().get(hashmap.getMeModeKey())).toString().replace("[", "").replace("]", ""));

        File file = new File("/home/wajahat/Documents/eventlistener-File/filename.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        PrintWriter pw = new PrintWriter(file);
        pw.println("this is my file");
        pw.close();

        String num = "132.42";
        StringBuilder sb = new StringBuilder(num);
        ReplaceString rs1 = new ReplaceString();
        try {
            System.out.println(Double.parseDouble(num));
//            sb.delete(0,sb.length());
//            sb.append(num.replace(".","point"));
            sb.insert(0, "Col");

            System.out.println(sb);

            System.out.println(rs1.validationsCol(sb));

        } catch (Exception e) {
            System.out.println(rs1.validationsCol(sb));
        }
    }


    public static <K, V> K getKey(Map<K, V> map, V value) {
        return map.keySet()
                .stream()
                .filter(key -> value.equals(map.get(key)))
                .findAny().get();
    }

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}

