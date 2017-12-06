package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day5TwistyMaze {


    @Test
    public void test() {
        int[] maze = TestUtil.readIntListFile("day5_input0.txt");
        assertEquals(5, countEscapeSteps(maze));

        int[] maze1 = TestUtil.readIntListFile("day5_input1.txt");
        System.out.println(countEscapeSteps(maze1));
    }

    public static int countEscapeSteps(int[] maze) {
        int index = 0;
        int steps = 0;
        while (index < maze.length) {
            int jumps = maze[index];
            int oldIndex = index;
            index += jumps;
            maze[oldIndex] = jumps + 1;
            steps++;
        }
        return steps;
    }
}
