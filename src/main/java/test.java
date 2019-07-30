import java.awt.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

import org.json.simple.*;

public class test {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", new Integer(38));
        obj.put("age", new Integer(900000000));
        obj.put("salary", new Integer(600000));
        System.out.print(obj);

        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        SortMapByValue obj1= new SortMapByValue();
//        System.out.println(obj.size());

        System.out.println(obj.keySet());

        LinkedList<Integer> al = new LinkedList<Integer>();

        for (Object key : obj.keySet()) {
//            System.out.println(key);
            Object keyvalue = obj.get(key);
//            System.out.println(keyvalue);
//            al.add((Integer) keyvalue);
//            System.out.println(keyvalue.getClass().getSimpleName());
            obj1.insertKeyValue(key.toString(),(Integer) keyvalue);
        }
        Collections.sort(al, Collections.<Integer>reverseOrder());
//        System.out.println("link list :" + al.getFirst());

        HashMapTest hM = new HashMapTest();

//        hM.testHashmap();

//        System.out.println(hM.testHashmap().);
//        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(hM.testHashmap());
//        Set<Map.Entry<String, Integer>> mappings = sorted.entrySet();
//        System.out.println(mappings);



        obj1.insertKeyValue("hello d",3);
        obj1.insertKeyValue("hello s",12);
        obj1.insertKeyValue("hello c",3);

        obj1.getMeModeKey();

        System.out.println( obj1.getMeModeKey());

    }
}
