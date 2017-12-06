package test.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestUtil {
    public static final String TEST_DIR = "src/test/resources/";

    static List<String> readTextFileAsList(String fileName) {
        List<String> result = null;
        Path p = Paths.get(TEST_DIR + fileName);
        try {
            result = Files.readAllLines(p, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    static String[] splitRow(String line) {
        StringTokenizer st = new StringTokenizer(line);
        String[] row = new String[st.countTokens()];
        for (int i = 0; i < row.length; i++) {
            row[i] = st.nextToken();
        }
        return row;
    }

    static List<List<String>> readStringMatrixFile(String fileName) {
        int maxRowLength = 0;
        List<List<String>> inputs = new ArrayList<>();
        File file = new File(TEST_DIR + fileName);
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String[] row = splitRow(in.nextLine());
                maxRowLength = Math.max(maxRowLength, row.length);
                inputs.add(Arrays.asList(row));
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputs;
    }

    static int[][] readIntMatrixFile(String fileName) {
        int maxRowLength = 0;
        List<int[]> inputs = new ArrayList<>();
        File file = new File(TEST_DIR + fileName);
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                StringTokenizer st = new StringTokenizer(in.nextLine());
                int[] row = new int[st.countTokens()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = Integer.valueOf(st.nextToken());
                }
                maxRowLength = Math.max(maxRowLength, row.length);
                inputs.add(row);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[][] matrix = new int[inputs.size()][maxRowLength];
        return inputs.toArray(matrix);
    }

    static int[] readIntListFile(String fileName) {
        return Arrays.stream(readIntMatrixFile(fileName))
                .flatMapToInt(Arrays::stream)
                .toArray();
    }

    static int getNumber(String s, int index) {
        return Integer.valueOf(s.substring(index, index + 1));
    }

}
