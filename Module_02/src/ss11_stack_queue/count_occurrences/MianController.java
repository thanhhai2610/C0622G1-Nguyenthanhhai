package ss11_stack_queue.count_occurrences;

import java.util.*;

public class MianController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi:");
        String string = sc.nextLine();
        string = string.toUpperCase(Locale.ROOT).replaceAll("\\s", " ");
        Map<Character, Integer> stringMap = new TreeMap<>(Collections.reverseOrder());
        System.out.println(string);
//        System.out.println(stringMap.get(string.charAt(2)));
//        stringMap.containsKey(string.charAt(i))
        for (int i = 0; i < string.length(); i++) {
            if (stringMap.containsKey(string.charAt(i))) {
                Integer value = stringMap.get(string.charAt(i));// .get(key)-> giá trị value
//                System.out.println(stringMap);
                value++;
                stringMap.replace(string.charAt(i), value);
            } else {
                stringMap.put(string.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
