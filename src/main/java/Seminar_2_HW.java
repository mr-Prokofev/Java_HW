//Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder или String.
//Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Seminar_2_HW {
    public static void main(String[] args) throws Exception{
       //Создаем новый файл с параметрами для фильтрации
        File file = new File("data_request.txt");
        file.createNewFile();

        //Записываем параметры для SQL запроса
        FileWriter writer = new FileWriter(file);
        writer.write("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        writer.close();

        //Считываем параметры

        FileReader reader = new FileReader("data_request.txt");
        Scanner scanner = new Scanner(reader);
        String string_data = scanner.nextLine();
        System.out.println(string_data);
        reader.close();

        // Парсинг строки для массива
        string_data = string_data.replaceAll("[,{}]", "").replaceAll(":", " ").
                replaceAll("\"", "");
        String[] arr_data = string_data.split(" ");
        System.out.println(Arrays.toString(arr_data));


        // Финальная строка для вывода результата
        String and = "";
        StringBuilder stringBuilder = new StringBuilder("select * from students where ");
        for (int i = 1; i < arr_data.length; i+=2) {
            if (arr_data[i].equals("null") == false){
                stringBuilder.append(and);
                stringBuilder.append(String.format("'%s' = %s", arr_data[i-1], arr_data[i]));}
                and = " and ";
        }

        System.out.println(stringBuilder);








    }


}