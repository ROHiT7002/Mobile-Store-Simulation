package io;

import static java.lang.Thread.sleep;

public class Employee {

    private String name;
    private int id;

    public Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public void sellPhone(Customer cm, Smartphone sm)
    {
        if(cm.getCash() >= sm.getPrice())
        {
            cm.deductCash(sm.getPrice());
            System.out.println("Sold the smartphone to the customer: "+ cm);


            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            emi(sm);
        }
    }

    public void emi(Smartphone sm)
    {
        double emi = ( sm.getPrice() ) / 12.0;
        System.out.printf("The 12-month EMI for this smartphone is ₹%.2f\n" + emi);
    }
}
