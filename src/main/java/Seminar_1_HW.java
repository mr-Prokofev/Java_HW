import java.util.Random;

public class Seminar_1_HW {

    public static void main(String[] args) {
        int i = new Random().nextInt(2000); //1
        System.out.printf("%s - Случайное число \n", i);

        int n = Integer.toBinaryString(i).length(); //2
        System.out.printf("%s - Номер старшего бита", n);

        int len_m1 = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {    // Определение длинны м1
            if (j % n == 0) {
                len_m1++;
            }
        }

        int[] m1 = new int[len_m1];
        len_m1 = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j%n == 0) {
                m1[len_m1++] = j;
            }
        } // Добавление элементов

        int len_m2 = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0){
                len_m2++;
            }
        }

        int[] m2 = new int[len_m2];
        len_m2 = 0;

        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0){
                m2[len_m2++] = j;
            }
        }
    }
}
