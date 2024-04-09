package opgave02;

import opgave02.models.EaaaSortedLinkedList;
import opgave02.models.SortedListEaaa;

import java.util.ArrayList;

public class Opgave02 {
    public static void main(String[] args) {
        SortedListEaaa<String> stringSortedListEaaa = new EaaaSortedLinkedList<>();

        ArrayList<String> stringssss = new ArrayList<>();

        stringSortedListEaaa.add("d");
        stringSortedListEaaa.add("c");
        stringSortedListEaaa.add("b");
        stringSortedListEaaa.add("e");
        stringSortedListEaaa.add("a");
        stringSortedListEaaa.add("g");
        stringSortedListEaaa.add("f");
        stringSortedListEaaa.add("i");
        stringSortedListEaaa.add("h");
        stringSortedListEaaa.add("j");

        System.out.println(stringSortedListEaaa);

        for (String s : stringSortedListEaaa) {
            System.out.println(s);
        }



    }
}
