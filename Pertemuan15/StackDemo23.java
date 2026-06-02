package Pertemuan15;

import java.util.Stack;

public class StackDemo23 {
    public static void main(String[] args) {
        Book23 book1 = new Book23("1234", "Dasar Pemrograman");
        Book23 book2 = new Book23("7145", "Hafalah Shalat Delisa");
        Book23 book3 = new Book23("3562", "Muhammad Al-Fatih");

        Stack<Book23> books = new Stack<>();
        books.push(book1);
        books.push(book2);
        books.push(book3);

        System.out.println("=== Peek ===");
        Book23 temp = books.peek();
        if (temp != null) {
            System.out.println(temp.toString());
        }

        System.out.println("\n=== Pop ===");
        Book23 temp2 = books.pop();
        if (temp2 != null) {
            System.out.println(temp2.toString());
        }

        System.out.println("\n=== Isi stack setelah pop ===");
        for (Book23 book : books) {
            System.out.println(book.toString());
        }

        System.out.println("\n=== Debug print stack ===");
        System.out.println(books);

        System.out.println("\n=== Search elemen pada stack ===");
        int posisi = books.search(book2);
        System.out.println("Posisi book2 dari puncak stack: " + posisi);
    }
}
