package de.bschandera.ngrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(args[0]);

        List<String> nGrams = new ArrayList<>();
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String line = inputReader.readLine();
        while (line != null) {
            nGrams.addAll(findNGrams(line));
            line = inputReader.readLine();
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String nGram : nGrams) {
            if (counts.containsKey(nGram)) {
                int old = counts.get(nGram);
                counts.put(nGram, old + 1);
            } else {
                counts.put(nGram, 1);
            }
        }
        System.out.println(counts);
    }

    private static List<? extends String> findNGrams(String line) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= line.length() - n; i++) {
            result.add(line.substring(i, i + n));
        }
        return result;
    }

}
