package ru.hse.java.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hse.java.trie.StringTrie;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TrieTest {
    StringTrie testTrie;

    @BeforeEach
    public void init() {
        testTrie = new StringTrie();
    }

    @Test
    public void testEmpty() {
        testTrie.add("");
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));
    }

    @Test
    public void testAdd1() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("trie");
        Assertions.assertEquals(4, testTrie.size());
        Assertions.assertEquals(1, testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("trie"));

        testTrie.add("test");
        Assertions.assertEquals(7, testTrie.size());
        Assertions.assertEquals(2,testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("trie"));
        Assertions.assertTrue(testTrie.contains("test"));
    }

    @Test
    public void testAdd2() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("simple");
        Assertions.assertEquals(6, testTrie.size());
        Assertions.assertEquals(1, testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("simple"));

        testTrie.add("smile");
        Assertions.assertEquals(10, testTrie.size());
        Assertions.assertEquals(2, testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("simple"));
        Assertions.assertTrue(testTrie.contains("smile"));
    }

    @Test
    public void testRemove1() {
        Assertions.assertEquals(testTrie.size(), 0);
        Assertions.assertEquals(testTrie.amountWords(), 0);
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        testTrie.add("simple");
        testTrie.add("test");
        testTrie.add("trie");
        testTrie.add("sm");
        testTrie.add("t");
        testTrie.add("te");
        testTrie.add("tries");

        testTrie.remove("trie");
        Assertions.assertEquals(10, testTrie.size());
        Assertions.assertEquals(7, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains("trie"));
        Assertions.assertTrue(testTrie.contains("test"));
        Assertions.assertTrue(testTrie.contains("simple"));
        Assertions.assertTrue(testTrie.contains("t"));
        Assertions.assertTrue(testTrie.contains("tries"));
        Assertions.assertTrue(testTrie.contains("te"));
        Assertions.assertTrue(testTrie.contains("sm"));
        Assertions.assertTrue(testTrie.contains("smile"));
    }

    @Test
    public void testRemove2() {
        Assertions.assertEquals(testTrie.size(), 0);
        Assertions.assertEquals(testTrie.amountWords(), 0);
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        testTrie.add("simple");
        testTrie.add("test");
        testTrie.add("trie");
        testTrie.add("sm");
        testTrie.add("t");
        testTrie.add("te");
        testTrie.add("tries");

        testTrie.remove("t");
        Assertions.assertEquals(18, testTrie.size());
        Assertions.assertEquals(7, testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("trie"));
        Assertions.assertTrue(testTrie.contains("test"));
        Assertions.assertTrue(testTrie.contains("simple"));
        Assertions.assertFalse(testTrie.contains("t"));
        Assertions.assertTrue(testTrie.contains("tries"));
        Assertions.assertTrue(testTrie.contains("te"));
        Assertions.assertTrue(testTrie.contains("sm"));
        Assertions.assertTrue(testTrie.contains("smile"));
    }

    @Test
    public void testRemove3() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        testTrie.add("simple");
        testTrie.add("test");
        testTrie.add("trie");
        testTrie.add("sm");
        testTrie.add("t");
        testTrie.add("te");
        testTrie.add("tries");

        testTrie.remove("smile");
        Assertions.assertEquals(15, testTrie.size());
        Assertions.assertEquals(7, testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("trie"));
        Assertions.assertTrue(testTrie.contains("test"));
        Assertions.assertTrue(testTrie.contains("simple"));
        Assertions.assertTrue(testTrie.contains("t"));
        Assertions.assertTrue(testTrie.contains("tries"));
        Assertions.assertTrue(testTrie.contains("te"));
        Assertions.assertTrue(testTrie.contains("sm"));
        Assertions.assertFalse(testTrie.contains("smile"));
    }

    @Test
    public void testRemove4() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        Assertions.assertTrue(testTrie.add("aaaaaaaaaa"));
        Assertions.assertTrue(testTrie.add("aaaaaaaaab"));

        Assertions.assertEquals(11, testTrie.size());
        Assertions.assertEquals(2, testTrie.amountWords());
        Assertions.assertTrue(testTrie.contains("aaaaaaaaaa"));
        Assertions.assertTrue(testTrie.contains("aaaaaaaaab"));

        Assertions.assertTrue(testTrie.remove("aaaaaaaaaa"));

        Assertions.assertEquals(10, testTrie.size());
        Assertions.assertEquals(1, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains("aaaaaaaaaa"));
        Assertions.assertTrue(testTrie.contains("aaaaaaaaab"));

    }

    @Test
    public void testContains1() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        testTrie.add("simple");
        testTrie.add("test");
        testTrie.add("trie");
        testTrie.add("sm");
        testTrie.add("t");
        testTrie.add("te");
        testTrie.add("tries");

        Assertions.assertTrue(testTrie.contains("trie"));
        Assertions.assertTrue(testTrie.contains("test"));
        Assertions.assertTrue(testTrie.contains("simple"));
        Assertions.assertTrue(testTrie.contains("t"));
        Assertions.assertTrue(testTrie.contains("tries"));
        Assertions.assertTrue(testTrie.contains("te"));
        Assertions.assertTrue(testTrie.contains("sm"));
        Assertions.assertTrue(testTrie.contains("smile"));
    }

    @Test
    public void testContains2() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        testTrie.add("simple");
        testTrie.add("test");
        testTrie.add("trie");
        testTrie.add("sm");
        testTrie.add("t");
        testTrie.add("te");
        testTrie.add("tries");
        Assertions.assertFalse(testTrie.contains("triis"));
        Assertions.assertFalse(testTrie.contains("tes"));
        Assertions.assertFalse(testTrie.contains("simle"));
        Assertions.assertFalse(testTrie.contains("tr"));
        Assertions.assertFalse(testTrie.contains("tris"));
        Assertions.assertFalse(testTrie.contains("trm"));
        Assertions.assertFalse(testTrie.contains("smi"));
        Assertions.assertFalse(testTrie.contains("smiles"));
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        Assertions.assertEquals(5, testTrie.size());
        testTrie.add("simple");
        Assertions.assertEquals(10, testTrie.size());
        testTrie.add("test");
        Assertions.assertEquals(14, testTrie.size());
        testTrie.add("trie");
        Assertions.assertEquals(17, testTrie.size());
        testTrie.add("sm");
        Assertions.assertEquals(17, testTrie.size());
        testTrie.add("t");
        Assertions.assertEquals(17, testTrie.size());
        testTrie.add("te");
        Assertions.assertEquals(17, testTrie.size());
        testTrie.add("tries");
        Assertions.assertEquals(18, testTrie.size());
    }

    @Test
    public void testPrefix() {
        Assertions.assertEquals(0, testTrie.size());
        Assertions.assertEquals(0, testTrie.amountWords());
        Assertions.assertFalse(testTrie.contains(""));

        testTrie.add("smile");
        testTrie.add("simple");
        testTrie.add("test");
        testTrie.add("trie");
        testTrie.add("sm");
        testTrie.add("t");
        testTrie.add("te");
        testTrie.add("tries");

        Assertions.assertSame(3, testTrie.howManyStartsWithPrefix("s"));
        Assertions.assertSame(2, testTrie.howManyStartsWithPrefix("sm"));
        Assertions.assertSame(1, testTrie.howManyStartsWithPrefix("si"));
        Assertions.assertSame(0, testTrie.howManyStartsWithPrefix("st"));
        Assertions.assertSame(5, testTrie.howManyStartsWithPrefix("t"));
        Assertions.assertSame(2, testTrie.howManyStartsWithPrefix("te"));
        Assertions.assertSame(2, testTrie.howManyStartsWithPrefix("tr"));
        Assertions.assertSame(2, testTrie.howManyStartsWithPrefix("trie"));
        Assertions.assertSame(1, testTrie.howManyStartsWithPrefix("tes"));
        Assertions.assertSame(1, testTrie.howManyStartsWithPrefix("tries"));
        Assertions.assertSame(0, testTrie.howManyStartsWithPrefix("smiles"));
        Assertions.assertSame(0, testTrie.howManyStartsWithPrefix("smip"));
    }

    @Test
    void testStress() {
        Set<String> check = new HashSet<>();
        Random rand = new Random(239);
        for (int i = 0; i < 10000; i++) {
            StringBuilder buf = new StringBuilder();
            int l = rand.nextInt(50);
            for (int j = 0; j < l; j++) {
                buf.append((char) ('a' + rand.nextInt(26)));
            }
            int command = rand.nextInt(3);
            if (command == 0) {
                check.add(buf.toString());
                testTrie.add(buf.toString());
                Assertions.assertEquals(check.contains(buf.toString()), testTrie.contains(buf.toString()));
            } else if (command == 1) {
                check.remove(buf.toString());
                testTrie.remove(buf.toString());
                Assertions.assertEquals(check.contains(buf.toString()), testTrie.contains(buf.toString()));
            } else {
                Assertions.assertEquals(check.contains(buf.toString()), testTrie.contains(buf.toString()));
            }
        }
    }
}
