package de.bschandera.ngrams;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);
        if (n < 1 || n > 2) {
            System.out.println("Bad luck... only numbers between 1 - 2 pls.");
            return;
        }

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String line = inputReader.readLine();

        switch (n) {
            case 1:
                doForOne(line, inputReader);
            case 2:
                doForTwo(line, inputReader);
        }


    }

    private static void doForOne(CharSequence line, BufferedReader inputReader) throws IOException {
        Map<Character, Integer> nGrams = new HashMap();
        do {
            for (Character c : Lists.charactersOf(line)) {
                // gibt nie new line
                if (Objects.equals(c, '\n')) {
                    break;
                }

                if (nGrams.containsKey(c)) {
                    int old = nGrams.get(c);
                    nGrams.put(c, old + 1);
                } else {
                    nGrams.put(c, 1);
                }
            }
            line = inputReader.readLine();
        } while (line != null);

        System.out.println(nGrams);
    }

    private static void doForTwo(CharSequence line, BufferedReader inputReader) throws IOException {
        Map<String, Integer> nGrams = new HashMap();

        do {
            Character lastOne = null;
            for (Character c : Lists.charactersOf(line)) {
                if (lastOne == null) {
                    lastOne = c;
                    continue;
                }
                if (Objects.equals(c, '\n')) {
                    break;
                }

                String nGram = String.valueOf(lastOne) + c;
                if (nGrams.containsKey(nGram)) {
                    int old = nGrams.get(nGram);
                    nGrams.put(nGram, old + 1);
                } else {
                    nGrams.put(nGram, 1);
                }

                lastOne = c;
            }
            line = inputReader.readLine();
        } while (line != null);

        System.out.println(nGrams);
    }

}
