package test.java;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Day4HighEntropyPassphrases {

    @Test
    public void test() {
        List<List<String>> stringList = TestUtil.readStringMatrixFile("day4_input0.txt");
        assertEquals(2, countValid(stringList));

        List<List<String>> stringList2 = TestUtil.readStringMatrixFile("day4_input1.txt");
        System.out.println(countValid(stringList2));
    }

    private static int countValid(List<List<String>> stringList) {
        int count = 0;
        for(List<String> passphrase : stringList) {
            if (validPassphrase(passphrase)) {
                count++;
            }
        }
        return count;
    }

    static boolean validPassphrase(List<String> passphrase) {
        Set<String> set = new HashSet<>(passphrase.size());
        for (String phrase : passphrase) {
            if (set.contains(phrase)) {
                return false;
            }
            set.add(phrase);
        }
//        System.out.println("valid = [" + passphrase.toString() + "]");
        return true;
    }

}
