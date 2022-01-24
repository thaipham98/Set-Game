package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Solver solver = Solver.getSolver();

    public static void main(String[] args) {

        System.out.println("Welcome to the Set Game Solver!");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();

        List<String> cards = new ArrayList<>();

        while (N-- > 0) {
            String cardInfo = sc.nextLine();
            cards.add(cardInfo);
        }

        solver.solve(cards);
    }
}
