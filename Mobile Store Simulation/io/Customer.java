package io;

import static java.lang.Thread.sleep;

public class Customer {

    String name;
    int cash;

    public Customer(String name, int cash)
    {
        this.name = name;
        this.cash = cash;
    }

    public void buy(Smartphone sm1)
    {
        System.out.println(name + " is trying to buy: " + sm1);


        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName()
    {
        return name;
    }

    public int getCash()
    {
        return cash;
    }

    public void deductCash(int amount)
    {
        this.cash -= amount;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
