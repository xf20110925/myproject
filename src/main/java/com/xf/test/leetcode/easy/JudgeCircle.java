package com.xf.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/judge-route-circle/description/
 * <p>
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class JudgeCircle {
    public static boolean judgeCircle(String moves) {
        final Map<Character, Integer> moveMap = new HashMap<>();
        for (final char c : moves.toCharArray()) {
            Integer counter = moveMap.get(c);
            if (counter == null) {
                moveMap.put(c, 1);
            } else {
                counter++;
                moveMap.put(c, counter);
            }
        }
        if (moveMap.get('U') == moveMap.get('D') && moveMap.get('L') == moveMap.get('R'))
            return true;
        return false;
    }

    public boolean judgeCircle1(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("UDUD"));
        System.out.println(judgeCircle("UDDUL"));
    }
}
