package Utils;

import java.util.Random;

public class RandomData {
    public static String generateRandomText() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder text = new StringBuilder();
        Random random = new Random();

        // Generate random text (10 characters)
        for (int i = 0; i < 100; i++) {
            text.append(characters.charAt(random.nextInt(characters.length())));
        }
        return text.toString();
    }
    public static String RandomNumber() {
        Random random = new Random();
        int RandomNo = 100000 + random.nextInt(900000);
        return String.valueOf(RandomNo);
    }




}
