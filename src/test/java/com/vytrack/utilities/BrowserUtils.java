package com.vytrack.utilities;

public class BrowserUtils {

 /*

   Method that will accept int
   Wait for given second duration

   1 sec = 1000 milli seconds

   1 * 1000 = 1000

   BrowserUtils.sleep(1);  --> 1 second

    */

    public static void sleep(int second) {

        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
