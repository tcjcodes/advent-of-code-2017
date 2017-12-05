package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day2Checksum {

    @Test
    public void test() {
        int[][] matrix = TestUtil.readFileToIntMatrix("day2_input0.txt");
        assertEquals(18, checksum(matrix));

        System.out.println(checksum(TestUtil.readFileToIntMatrix("day2_input1.txt")));
    }

    static int checksum(int[][] matrix) {
        int checksum = 0;
        for (int[] row : matrix) {
            int rowMin = Integer.MAX_VALUE;
            int rowMax = Integer.MIN_VALUE;

            for (int val : row) {
                rowMin = Math.min(rowMin, val);
                rowMax = Math.max(rowMax, val);
            }
            checksum += rowMax - rowMin;
        }
        return checksum;
    }

}
