package com.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final Solver solver = Solver.getSolver();

    public static void main(String[] args) throws Exception {

        int test = 0;

        while (test < 2) {
            System.out.println("Running test case: " + test);
            final long startTime = System.currentTimeMillis();
            File file = new File(String.format("input%d.txt", test));

            BufferedReader br = new BufferedReader(new FileReader(file));

            int N = Integer.parseInt(br.readLine());

            List<String> cards = new ArrayList<>();

            while (N-- > 0) {
                String cardInfo = br.readLine();
                cards.add(cardInfo);
            }

            solver.solve(cards);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime) / 1000F + " seconds");
            System.out.println();

            br.close();
            test++;
        }
    }
}
