/**
 * TelethonBook
 */

import java.util.*;

/**
 * Задание
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут
 повторяющиеся имена с разными телефонами, их необходимо считать,
 как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
 */
public class TelethonBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Boris", 991);
        phoneBook.add("Rich", 50123);
        phoneBook.add("Rich", 1234);
        phoneBook.add("Alex", 123);
        phoneBook.add("Alex", 4567);
        phoneBook.add("Artem", 1233);
        phoneBook.add("Artem", 12331);
        phoneBook.add("Artem", 12334);
        phoneBook.add("Alex", 1233);
        phoneBook.print();
    }
}
class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    private static int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() != b.size()) return -a.size() + b.size();
        return 1;
    }

    public void add(String name, Integer phoneNum) {

// Введите свое решение ниже
    if (phoneBook.containsKey(name)){
        phoneBook.get(name).add(phoneNum);
    } else {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(phoneNum);
        phoneBook.put(name,number);
    }
}
    public void print(){
        TreeMap<ArrayList<Integer>,String> treemap = new TreeMap<>(PhoneBook::compare);
        for (String key:phoneBook.keySet()) {
            treemap.putIfAbsent(phoneBook.get(key),key);
        }
        treemap.forEach((k,v) -> System.out.println(v +  " : " + k));
    }
}