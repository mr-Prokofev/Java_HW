//Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder,
//создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Seminars_2_2_HW {
    public static void main(String[] args) throws Exception{

        // Считываем файл
        FileReader fileReader = new FileReader("journal.txt");
        Scanner iscanner = new Scanner(fileReader);
        String data_student = iscanner.nextLine();
        data_student = data_student.replaceAll("[;,{}]", "").replaceAll(":", " ")
                .replaceAll("\"", " ");
        data_student = data_student.replaceAll("фамилия", "").replaceAll("оценка", "")
                .replaceAll("предмет", "");
        data_student = data_student.replaceAll("[\\s]{2,}", " ").replace("[ ", "")
                .replace(" ]", "");
        String[] arr_data_student = data_student.split(" ");
        System.out.println(data_student);
        System.out.println(Arrays.toString(arr_data_student));

        for (int i = 2; i < arr_data_student.length; i+=3) {
            System.out.printf("Студент %s получил %s по предмету %s.\n", arr_data_student[i-2],
                    arr_data_student[i-1], arr_data_student[i]);
        }


    }
}
