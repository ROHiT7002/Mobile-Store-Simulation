package io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Store {

    private Scanner sc = new Scanner(System.in);
    private List<Smartphone> phones = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Employee employee = new Employee("Mohit", 1);

    public void run() {
        boolean exit = false;


        while (!exit) {
            System.out.println("\n----- Mobile Store Menu -----");
            System.out.println("1. View Smartphones");
            System.out.println("2. Add New Smartphone");
            System.out.println("3. Add Customer");
            System.out.println("4. Buy Phone");
            System.out.println("5. View Customer Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {

            /*
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();  // leaves '\n' in input
            System.out.print("Enter name: ");
            String name = sc.nextLine();  // reads empty line
             */

                // that's why we using sc.nextLine()

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> viewPhones();
                    case 2 -> addPhone();
                    case 3 -> addCustomer();
                    case 4 -> buyPhone();
                    case 5 -> viewCustomerBalance();
                    case 6 -> exit = true;
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void viewPhones()
    {
        if(phones.isEmpty())
        {
            System.out.println("No smartphones available");
        }
        else
        {
            int i = 1;
            for(Smartphone s : phones)
            {
                System.out.println(i++ + ". "+ s);
            }
        }

        try{sleep(5000);} catch (Exception e) {e.getMessage();}
    }

    private void addPhone()
    {
        try
        {
            System.out.print("Enter model name: ");
            String name = sc.nextLine();
            System.out.print("Enter price: ");
            int price = Integer.parseInt(sc.nextLine());
            System.out.print("Enter color: ");
            String color = sc.nextLine();

            phones.add(new Smartphone(name, price, color));
            System.out.println("Phone Added Successfully.");
        }catch(Exception e)
        {
            System.out.println("Error Adding phone. Please try again.");
        }
    }

    private void addCustomer()
    {
        try {

            System.out.print("Enter Customer name: ");
            String name = sc.nextLine();
            System.out.print("Enter cash amount: ");
            int cash = Integer.parseInt(sc.nextLine());

            customers.add(new Customer(name, cash));
            System.out.println("Customer added.");
        }catch (Exception e)
        {
            System.out.println("Invalid input. Try again.");
        }
    }

    private void viewCustomerBalance()
    {
        for(Customer c : customers)
        {
            System.out.println(c.getName() + " - Balance: ₹" + c.getCash());
        }

        try{sleep(2000);} catch (Exception e) {e.getMessage();}
    }

    private void buyPhone()
    {
        try {
            if (customers.isEmpty() || phones.isEmpty()) {
                System.out.println("Add both customer and phones first.");
                return;
            }

            System.out.println("Select Customer: ");
            for (int i = 0; i < customers.size(); i++) {
                System.out.println((i + 1) + " " + customers.get(i).getName());
            }
            int customerChoice = Integer.parseInt(sc.nextLine()) - 1;

            System.out.println("Select Phone: ");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println((i + 1) + " " + phones.get(i));
            }
            int phoneChoice = Integer.parseInt(sc.nextLine()) - 1;

            Customer selectedCustomer = customers.get(customerChoice);
            Smartphone selectedPhone = phones.get(phoneChoice);

            selectedCustomer.buy(selectedPhone);
            employee.sellPhone(selectedCustomer, selectedPhone);
            saveTransaction(selectedCustomer, selectedPhone);

        } catch (Exception e) {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private void saveTransaction(Customer c, Smartphone s)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JAVA\\PROJECTS\\Mobile Store Simulation\\io\\transactions.txt", true)))
        {
            writer.write("Customer: " + c.getName() + " bought " + s.getModelName() + " for ₹" + s.getPrice() + "\n");
        }catch (Exception e)
        {
            System.out.println("Could not save transaction.");
        }
    }
}
