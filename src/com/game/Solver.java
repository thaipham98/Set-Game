package com.game;

import java.util.*;

public class Solver {

    private static HashMap<Card, String> MAPPER = new HashMap<>();

    private static Solver solver;

    private Solver() {}

    public static Solver getSolver() {
        if (solver == null) {
            solver = new Solver();
        }
        return solver;
    }

    public void solve(List<String> stringCard) {
        List<Card> cards = getListOfCards(stringCard);
        List<List<Card>> possibleSets = getPossibleSets(cards);
        System.out.println(possibleSets.size());
        List<List<Card>> largestDisjointSets = getLargestDisjointSets(possibleSets);
        printLargestDisjointSets(largestDisjointSets);
    }

    private void printLargestDisjointSets(List<List<Card>> largestDisjointSets) {
        System.out.println(largestDisjointSets.size());
        System.out.println();
        largestDisjointSets.forEach(set -> {
            set.forEach(card -> System.out.println(MAPPER.get(card)));
            System.out.println();
        });
    }

    private List<List<Card>> getLargestDisjointSets(List<List<Card>> possibleSets) {
        List<List<List<Card>>> allDisjointSets = new ArrayList<>();
        getAllDisjointSets(possibleSets, new ArrayList<>(), allDisjointSets, new ArrayList<>());

        List<List<Card>> largestDisjointSets = new ArrayList<>();

        for (var result : allDisjointSets) {
            if (result.size() > largestDisjointSets.size()) largestDisjointSets = result;
        }

        return largestDisjointSets;
    }

    private void getAllDisjointSets(List<List<Card>> possibleSets, List<List<Card>> disjointSets, List<List<List<Card>>> allDisjointSets, List<Card> cards) {
        if (!disjointSets.isEmpty()) {
            allDisjointSets.add(new ArrayList<>(disjointSets));
        }

        for (var i = 0; i < possibleSets.size(); i++) {
            List<Card> possibleSet = possibleSets.get(i);

            if (Collections.disjoint(cards, possibleSet)) {
                disjointSets.add(possibleSet);
                cards.addAll(possibleSet);
                getAllDisjointSets(possibleSets.subList(i + 1, possibleSets.size()), disjointSets, allDisjointSets, cards);
                disjointSets.remove(disjointSets.size() - 1);
                cards.removeAll(possibleSet);
            }
        }
    }

    private List<List<Card>> getPossibleSets(List<Card> cards) {
        List<List<Card>> possibleSets = new ArrayList<>();
        findCombinationsOfCards(cards, cards.size(), 3, possibleSets, new ArrayList<Card>());
        return possibleSets;
    }

    private void findCombinationsOfCards(List<Card> cards, int size, int k, List<List<Card>> possibleSets, ArrayList<Card> triplet) {
        if (k > size) return;

        if (k == 0) {
            if (isValid(triplet)) {
                possibleSets.add(new ArrayList<>(triplet));
            }
            return;
        }

        for (int i = size - 1; i >= 0; i--) {
            triplet.add(0, cards.get(i));
            findCombinationsOfCards(cards, i, k - 1, possibleSets, triplet);
            triplet.remove(0);
        }
    }

    private boolean isValid(ArrayList<Card> triplet) {
        var firstCard = triplet.get(0);
        var secondCard = triplet.get(1);
        var thirdCard = triplet.get(2);

        int total = 0;
        total += (firstCard.getNumber() + secondCard.getNumber() + thirdCard.getNumber() - 3) % 3;
        total += (firstCard.getColor().val + secondCard.getColor().val + thirdCard.getColor().val) % 3;
        total += (firstCard.getShading().val + secondCard.getShading().val + thirdCard.getShading().val) % 3;
        total += (firstCard.getSymbol().val + secondCard.getSymbol().val + thirdCard.getSymbol().val) % 3;

        return total == 0;
    }

    private List<Card> getListOfCards(List<String> stringCard) {
        List<Card> cards = new ArrayList<>();

        for (var cardInfo : stringCard) {
            Card card = new Card(cardInfo);
            cards.add(card);
            MAPPER.put(card, cardInfo);
        }

        return cards;
    }
}
