package Pertemuan15;

import java.util.ArrayList;

public class DemoArrayList23 {
    public static void main(String[] args) {
        ArrayList<Customer23> customers = new ArrayList<>(2);

        Customer23 customer1 = new Customer23(1, "Zakia");
        Customer23 customer2 = new Customer23(5, "Budi");

        customers.add(customer1);
        customers.add(customer2);

        System.out.println("=== Data awal customers ===");
        for (Customer23 cust : customers) {
            System.out.println(cust.toString());
        }

        customers.add(new Customer23(4, "Cica"));
        System.out.println("\n=== Setelah tambah Cica melebihi kapasitas awal ===");
        for (Customer23 cust : customers) {
            System.out.println(cust.toString());
        }

        customers.add(2, new Customer23(100, "Rosa"));
        System.out.println("\n=== Setelah insert Rosa di index 2 ===");
        for (Customer23 cust : customers) {
            System.out.println(cust.toString());
        }

        System.out.println("\nIndex customer2: " + customers.indexOf(customer2));

        Customer23 customer = customers.get(1);
        System.out.println("Customer pada index 1: " + customer.name);
        customer.name = "Budi Utomo";

        System.out.println("\n=== Setelah data index 1 diubah ===");
        for (Customer23 cust : customers) {
            System.out.println(cust.toString());
        }

        ArrayList<Customer23> customersTanpaSize = new ArrayList<>();
        customersTanpaSize.add(new Customer23(10, "TanpaSize"));
        System.out.println("\nArrayList tanpa size awal tetap bisa dipakai:");
        System.out.println(customersTanpaSize);

        ArrayList<Customer23> newCustomers = new ArrayList<>();
        newCustomers.add(new Customer23(201, "Della"));
        newCustomers.add(new Customer23(202, "Victor"));
        newCustomers.add(new Customer23(203, "Sarah"));

        customers.addAll(newCustomers);
        System.out.println("\n=== Setelah addAll(newCustomers) ===");
        for (Customer23 cust : customers) {
            System.out.println(cust.toString());
        }

        System.out.println("\n=== Debug print customers ===");
        System.out.println(customers);
    }
}
