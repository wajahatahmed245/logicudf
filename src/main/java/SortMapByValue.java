
import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue {

    public static boolean ASC = true;
    public static boolean DESC = false;
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

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }


}
