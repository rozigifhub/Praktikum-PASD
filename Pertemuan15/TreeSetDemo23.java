package Pertemuan15;

import java.util.TreeSet;

public class TreeSetDemo23 {
    public static void main(String[] args) {
        TreeSet<String> fruits = new TreeSet<>();

        fruits.add("Mangga");
        fruits.add("Apel");
        fruits.add("Jeruk");
        fruits.add("Jambu");

        System.out.println("=== Isi TreeSet ===");
        for (String temp : fruits) {
            System.out.println(temp);
        }

        System.out.println("\nFirst: " + fruits.first());
        System.out.println("Last: " + fruits.last());

        fruits.remove("Jeruk");
        System.out.println("Setelah remove " + fruits);

        fruits.pollFirst();
        System.out.println("Setelah poll first " + fruits);

        fruits.pollLast();
        System.out.println("Setelah poll last " + fruits);
    }
}
