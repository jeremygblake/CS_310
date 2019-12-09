package com.jeremygblake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

@SuppressWarnings("All")
public class JUnit<T extends MapInterface> {
    private T testClass;

    public JUnit(T x)
    {
        this.testClass = x;

    }

    public void run() throws IOException {
        int table_size = 50;

        //ProbingHashTable pht = new ProbingHashTable(table_size);

        BufferedReader br = new BufferedReader(new FileReader("src/Records.txt"));

        System.out.println("Currently Running " + this.testClass.getClass().getSimpleName());
        br.readLine(); //Remove the DATA Labels
        String dataPair;

        while((dataPair = br.readLine()) != null)
        {
            String[] str = dataPair.split("\\s+");  //regex for one or mare spaces
            this.testClass.put(str[0], str[1]);
        }

        System.out.println("THE VALUE FOR B9S6Y  " + this.testClass.get("B9S6Y"));

        System.out.println("Removed VALUE FOR B9S6Y  " + this.testClass.remove("B9S6Y"));

        System.out.println("THE VALUE FOR B9S6Y  " + this.testClass.get("B9S6Y") + " But it does not exist as we can see");

        System.out.println("Printing all values using iterator");


        Iterator itrValues = this.testClass.values();
        for (Iterator itrKeys = this.testClass.keys(); itrKeys.hasNext(); ) {
            Object x = itrKeys.next();
            Object y = itrValues.next();
            System.out.println("Key: " + x.toString() + " Value: " + y.toString());
        }


        this.testClass.remove("B9S6Y");
    }


}
