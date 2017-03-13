package geekbrains.java.j2l3;

import java.util.*;

/**
 * Created by myname on 12.03.17.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся)
        ArrayList<String> wordList = new  ArrayList<>();
        for (int i = 0; i < 30; i++) {
            wordList.add(i, generateString(new Random(i) ,"hello word world",3));

        }
        System.out.println("massive wordList: " + wordList+"\nsize:"+wordList.size());

        // Найти список слов, из которых состоит текст (дубликаты не считать);
        HashSet<String> wordHashSet = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            wordHashSet.add(wordList.get(i).toString());
        }
        System.out.println("hash list: " +wordHashSet+ "\nsize: "+wordHashSet.size());

        //Посчитать сколько раз встречается каждое слово(использовать HashMap);
        HashMap<Integer,String> wordHashMap = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            wordHashMap.put(i,wordList.get(i));
        }
        System.out.println("hash list: " +wordHashMap+ "\nsize: "+wordHashMap.size());

        for (int i = 0; i < wordHashMap.size(); i++) {

        }


    }



    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
