import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;



public class Seminars_4_HW {
    static Scanner iscanner;
    static public void sort_by_age(ArrayList<String> family, ArrayList<String> name, ArrayList<String> middle_name,
                                                 ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id) {

        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                 return age.get(o1) - age.get(o2);
            }
        });

        for (int i = 0; i < id.size(); i++) {
            System.out.printf("%s %s.%s. %s %s\n", family.get(id.get(i)), name.get(id.get(i)).charAt(0),
                    middle_name.get(id.get(i)).charAt(0), age.get(id.get(i)), (gender.get(id.get(i)))? "М" : "Ж");
        }
    }


    static public void sort_by_age_and_gender(ArrayList<String> family, ArrayList<String> name, ArrayList<String> middle_name,
                             ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id) {

        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1)) return 1;
                else return -1;
            }
        });

        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1) == gender.get(o2)) return age.get(o1) - age.get(o2);
                return 0;
            }
        });
        for (int i = 0; i < id.size(); i++) {
            System.out.printf("%s %s.%s. %s %s\n", family.get(id.get(i)), name.get(id.get(i)).charAt(0),
                    middle_name.get(id.get(i)).charAt(0), age.get(id.get(i)), (gender.get(id.get(i)))? "М" : "Ж");
        }

    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> family = new ArrayList<String>();
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> middle_name = new ArrayList<String>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<Boolean>();
        ArrayList<Integer> id = new ArrayList<Integer>();

        iscanner = new Scanner(System.in);


        String temp;
        while (true) {
            family.add(iscanner.nextLine());
            name.add(iscanner.nextLine());
            middle_name.add(iscanner.nextLine());
            age.add(Integer.valueOf(iscanner.nextLine()));
            gender.add(iscanner.nextLine().contains("М"));
            id.add(family.size() - 1);
            temp = iscanner.nextLine();
            if (temp.contains("q")) break;
        }


        for (int i = 0; i < family.size(); i++) {
            System.out.printf("%s %s.%s. %s %s\n", family.get(i), name.get(i).charAt(0), middle_name.get(i).charAt(0),
                    age.get(i), (gender.get(i))? "М" : "Ж");
        }

        System.out.println("Выходим или сортируем по возрасту?");
        temp = iscanner.nextLine();
        if (temp.contains("y")){
            sort_by_age(family, name, middle_name, age, gender, id);

        }


        temp = iscanner.nextLine();
        System.out.println("Сортировать по возрасту и полу?");
        if (temp.contains("y")){
            sort_by_age_and_gender(family, name, middle_name, age, gender, id);
        }

        }


    }

