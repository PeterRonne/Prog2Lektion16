package opgave01;

import opgave01.models.EaaaLinkedList;

import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        LinkedList<String> linkedStringList = new LinkedList<>();

        EaaaLinkedList<String> strings = new EaaaLinkedList<>();

        strings.add("Hello");
        strings.add("World");

        for (String string : strings) {
            System.out.println(string);
        }




    }
}
