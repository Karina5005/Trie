package ru.hse.java.trie;


import java.util.Map;

public class StringTrie implements Trie {
    private int sizeNode = 0;
    private int sizeWord = 0;
    private final Node root = new Node();


    private Node findString(String element) {
        Node currentNode = root;
        for (Character c : element.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return null;
            }
            currentNode = currentNode.children.get(c);
        }
        return currentNode;
    }

    @Override
    public boolean add(String element) {
        Node currentNode = root;
        for (int i = 0; i < element.length(); i++) {
            if (!currentNode.children.containsKey(element.charAt(i))) {
                currentNode.children.put(element.charAt(i), new Node(element.charAt(i), currentNode));
                sizeNode++;
            }
            currentNode = currentNode.children.get(element.charAt(i));
            currentNode.plusTerm();
        }
        if (currentNode.isTerm) {
            return false;
        }
        currentNode.isTerm = true;
        sizeWord++;
        return true;
    }

    @Override
    public boolean contains(String element) {
        Node result = findString(element);
        if (result != null) {
            return result.isTerm;
        }
        return false;
    }

    @Override
    public boolean remove(String element) {
        Node currentNode = findString(element);
        if (currentNode == null) {
            return false;
        } else if (currentNode.isTerm && !currentNode.children.isEmpty()) {
            currentNode.isTerm = false;
            while (currentNode.getParent() != null) {
                currentNode = currentNode.getParent();
                currentNode.minusTerm();
            }
            sizeWord--;
            return true;
        } else if (currentNode.isTerm) {
            do {
                Node parent = currentNode.getParent();
                parent.children.remove(currentNode.getVal());
                currentNode = parent;
                currentNode.minusTerm();
                sizeNode--;
            } while (currentNode.children.size() == 0 && !currentNode.isTerm);

            while (currentNode.getParent() != null) {
                currentNode = currentNode.getParent();
                currentNode.minusTerm();
            }
            sizeWord--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return sizeNode;
    }

    public int amountWords() {
        return sizeWord;
    }

    @Override
    public int howManyStartsWithPrefix(String prefix) {
        Node currentNode = findString(prefix);
        if (currentNode != null) {
            return currentNode.getTermCount();
        }
        return 0;
    }
}
