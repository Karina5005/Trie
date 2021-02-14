package ru.hse.java.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Node {
    boolean isTerm;
    public Map<Character, Node> children = new TreeMap<>();
    private int termCount;
    private Node parent;
    private char val;

    public Node() {}

    public Node(char init, Node p) {
        val = init;
        parent = p;
    }

    public int getTermCount() {
        return termCount;
    }

    public char getVal() {
        return val;
    }

    public Node getParent() {
        return parent;
    }

    public void plusTerm() {
        termCount++;
    }

    public void minusTerm() {
        termCount--;
    }
}
