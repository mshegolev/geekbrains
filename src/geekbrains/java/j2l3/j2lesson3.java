package geekbrains.java.j2l3;

import java.util.*;

/**
 * Created by myname on 09.03.17.
 */
public class j2lesson3 {

 private static Box box1 = new Box(1,2);
 private static Box box2 = new Box(2,2);
 private static Box box3 = new Box(3,3);


    public static void main(String[] args) {
    myArrya();

        //demoLinkHashSet();
        //demoThreeSet();
        demoHashMap();
        demoLinkHashMap();
        treeMap();
    }
    public static void myArrya(){
        System.out.println("Linked list");
        LinkedList<Box> list = new LinkedList<>();

        list.add(box1);

        System.out.println(list.get(0));

        String[] arr = {"one", "two","three"};
        List<String> list2 = Arrays.asList(arr);
        System.out.println(list2);
    }

    public static void demoHashSet(){
        System.out.println("Hashlet: " );
        HashSet<String> set = new HashSet<>();
        set.add("gg");
        set.add("bb");
        set.add("брава");
        set.remove("gg");
        for (String s : set ) System.out.println(s);
    }

    public static void demoLinkHashSet(){
        System.out.println("LinkedHashSet: " );
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("gg");
        set.add("bb");
        set.add("брава");
        set.remove("gg");
        for (String s : set ) System.out.println(s);
    }

    public static void demoThreeSet() {
        System.out.println("Three set: ");
        TreeSet<Box> set = new TreeSet<>();
        set.add(box3);
        set.add(box2);
        set.add(box1);
        System.out.println(set);
    }

    public static void demoHashMap() {
        System.out.println("HASH MAP: ");
        HashMap<String,Integer> map = new HashMap<>();
        map.put("январь",1);
        map.put("февраль",2);
        map.put("март",3);

        System.out.println(map);
        System.out.println(map.get("февраль"));
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = set.iterator();
        while (iterator.hasNext())
        {Map.Entry<String, Integer> entry =iterator.next();
            System.out.println("key "+ entry.getKey()+ "value " + entry.getValue());
        }
    }
    public static void demoLinkHashMap() {
        System.out.println("HASH MAP: ");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("январь", 1);
        map.put("февраль", 2);
        map.put("март", 3);

        System.out.println(map);
        System.out.println(map.get("февраль"));
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("key " + entry.getKey() + "value " + entry.getValue());
        }
    }
    public static void treeMap() {
        System.out.println("HASH MAP: ");
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("январь",1);
        map.put("февраль",2);
        map.put("март",3);
        System.out.println(map);

    }
}
