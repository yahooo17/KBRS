package by.bsu.kbrs;

import by.bsu.kbrs.vigenere.VigenereCipher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {


    public static void main(String[] args) {
        int i = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        System.out.println(Constants.TEXTS[0].length());
        for (String s : Constants.KEYS) {
            executorService.execute(new VigenereCipher(i, s, Constants.TEXTS[0]));
            i++;
        }
        executorService.shutdown();

        i = 0;
        ExecutorService exService = Executors.newFixedThreadPool(8);
        System.out.println(Constants.KEYS[4].length());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : Constants.TEXTS) {
            stringBuilder.append(s);
            System.out.println(stringBuilder.length());
            exService.execute(new VigenereCipher(i, Constants.KEYS[4], stringBuilder.toString()));
            i++;
        }
        exService.shutdown();
    }
}
