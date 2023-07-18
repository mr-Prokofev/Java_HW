import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Random;

public class Seminars_5_HW {
    public static void main(String[] args) {

        String[] surname = new String[] {"Adamson", "Smith", "Black", "White", "Boyer", "Ewans"};
        HashMap<String, List<String>> phonebook = new HashMap<>();

        for (String item:surname) {   // Заполнение книги: ключи - массив строк,
                // значение - преобразованное случайное число в массив строк
            int number = new Random().nextInt(5000) + 80000;
            phonebook = PhoneBook(phonebook, item, String.valueOf(number));
        }


        phonebook = PhoneBook(phonebook, "Adamson", "11111");
        phonebook = PhoneBook(phonebook, "Adamson", "22222");
        phonebook = PhoneBook(phonebook, "Smith", "99999");
        System.out.println(phonebook);

        phonebook.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size()- o1.size())).forEach(System.out::println);

    }

    public static HashMap<String, List<String>> PhoneBook(HashMap<String, List<String>> pb, String key, String value) {
        pb.computeIfAbsent(key, k -> new ArrayList<>()).add(value); //Если истина, добавляет значение
        return pb;
    }



    }


