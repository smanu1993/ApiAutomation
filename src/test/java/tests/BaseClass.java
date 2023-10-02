package tests;

import java.util.Random;

public class BaseClass {
    public static String baseUri = "https://reqres.in/api/";

    public static int getRandomNumber() {
        Random random = new Random(1000);
        return random.nextInt();
    }
}
