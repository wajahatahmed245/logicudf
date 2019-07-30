import java.util.*;

public class SortMapByValue {

    public static boolean ASC = true;
    public static boolean DESC = false;
    private Map<String, Integer> unsortMap = new HashMap<String, Integer>();


    public void insertKeyValue(String key, Integer value) {
        unsortMap.put(key, value);

//        System.out.println("Before sorting......");
//        printMap(unsortMap);

//        System.out.println("After sorting ascending order......");
//        Map<String, Integer> sortedMapAsc = sortByComparator(unsortMap, ASC);
//        printMap(sortedMapAsc);


//        System.out.println("After sorting descindeng order......");


    }

    public Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public String getMeModeKey() {
        Map<String, Integer> sortedMapDesc = sortByComparator(unsortMap, DESC);
        return printMap(sortedMapDesc);
    }


    public String printMap(Map<String, Integer> map) {
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//
//        }
        String firstKey = map.keySet().iterator().next();
//        System.out.println("firstKey :" + firstKey);
        return firstKey;
    }


}


