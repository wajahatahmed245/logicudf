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

public class test {

    public static void main(String[] args) {

        SortMapByValue hashmap = new SortMapByValue();

        hashmap.insertKeyValue("hello12", Long.valueOf(12));
        hashmap.insertKeyValue("hello11", Long.valueOf(13));
        hashmap.insertKeyValue("hello112", Long.valueOf(16));
        hashmap.insertKeyValue("hello1", Long.valueOf(16));


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

hashmap.getKeysByValue(hashmap.getUnsortMap(),hashmap.getUnsortMap().get(hashmap.getMeModeKey()));
        System.out.println(hashmap.getKeysByValue(hashmap.getUnsortMap(),hashmap.getUnsortMap().get(hashmap.getMeModeKey())));

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

