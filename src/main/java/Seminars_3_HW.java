import java.util.*;
import java.util.stream.IntStream;

public class Seminars_3_HW {
    public static void main(String[] args) {
        ArrayList<Integer> list_int = new ArrayList<>();  // Произвольный список
        for (int i = 0; i < 15; i++) {  // Произвольный список целых чисел
            list_int.add(new Random().nextInt(50));
        }

        // Удаление из списка чётных чисел
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer integer : list_int) {
            if (integer % 2 == 0) {
                temp.add(integer);
            }
        }

        System.out.println(list_int);
        System.out.printf("%s - Четные числа в tempe\n", temp); // Вывод четных чисел
        list_int.removeAll(temp);
        System.out.printf("%s - список с нечетными числами\n",list_int);

        // Вывод максимальноги и минимального без сортировки всего списка
        System.out.println(Collections.min(list_int));
        System.out.println(Collections.max(list_int));

        //Среднее значение
        double sum = 0;
        for (int i : list_int) {
            sum += i;
        }
        double avr = sum/list_int.size();


        // Поиск минимального и максимального с сортировкой
        list_int.sort(Comparator.naturalOrder());
        System.out.printf("%s - Минимальное значение\n%s - Максимальное значение %s - Среднее значение", list_int.get(0),
                list_int.get(list_int.size()-1), avr);


        // Поиск минимального и максимального циклом
//        int min = list_int.get(0);
//        int max = list_int.get(0);
//        for (int i: list_int) {
//            if (i < min) {
//                min = i;
//            }
//            if (i > max)
//            {
//                max = i;
//            }
//        }
//        System.out.println(min);
//        System.out.println(max);

    }
}