package com.game;

public class Card {

    private static final String A = "Aa@";
    private static final String S = "Ss$";
    private static final String H = "Hh#";

    private Color color;
    private Symbol symbol;
    private Shading shading;
    private int number;

    public Card(String cardInfo) {
        String[] splitStr = cardInfo.split("\\s+");
        this.color = Color.valueOf(splitStr[0].toUpperCase());
        this.number = splitStr[1].length();
        this.symbol = getSymbol(splitStr[1].charAt(0));
        this.shading = getShading(splitStr[1].charAt(0));
    }

    public Color getColor() {
        return color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Shading getShading() {
        return shading;
    }

    public int getNumber() {
        return number;
    }

    private Shading getShading(char symbolStr) {
        if (symbolStr == '@' || symbolStr == '#' || symbolStr == '$') {
            return Shading.SYMBOL;
        } else if (Character.isLowerCase(symbolStr)) {
            return Shading.LOWER;
        }
        return Shading.UPPER;
    }

    private Symbol getSymbol(char symbolStr) {
        if (A.indexOf(symbolStr) != -1) {
            return Symbol.A;
        } else if (S.indexOf(symbolStr) != -1) {
            return Symbol.S;
        }
        return Symbol.H;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", symbol=" + symbol +
                ", shading=" + shading +
                ", number=" + number +
                '}';
    }
}
