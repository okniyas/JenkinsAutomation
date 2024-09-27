package com.automation.utils;

import java.util.Random;

public class UniqueNameGenerator {
//        private static int counter = 0;
//
//        public static synchronized String getUniqueName() {
//            counter++;
//            return "JenkinsJob-" + counter;
//        }

    public static String getUniqueName() {
        Random random  = new Random();
        String username = "JenkinsJob-" + random.nextInt(1000);

            return username;
        }


}
