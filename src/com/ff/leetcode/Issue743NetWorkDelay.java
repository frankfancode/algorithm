package com.ff.leetcode;

import com.ff.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class Issue743NetWorkDelay {
    public static void main(String[] args) {
//        System.out.println(new Issue743NetWorkDelay().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
//        System.out.println(new Issue743NetWorkDelay().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
//        System.out.println(new Issue743NetWorkDelay().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
////        System.out.println(new Issue743NetWorkDelay().networkDelayTime(new int[][]{{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}}, 5, 5));
//        System.out.println(new Issue743NetWorkDelay().networkDelayTime(new int[][]{{1,2,1},{2,3,2},{1,3,1}}, 3, 2));
        System.out.println(new Issue743NetWorkDelay().networkDelayTime(new int[][]{{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}}, 5, 3));


    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] resultTimes = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    resultTimes[i][j] = Integer.MIN_VALUE;
                } else {
                    resultTimes[i][j] = 0;
                }

            }
        }

        int[] processedNodeSet = new int[n + 1];
        for (int i = 0; i < times.length; i++) {
            resultTimes[times[i][0]][times[i][1]] = times[i][2];
        }
        System.out.println(Utils.toString(resultTimes));


        int node = k;
        Queue<Integer> queue = new LinkedList<>();
        while (node > 0) {
            for (int i = 1; node < n + 1 && i < n + 1; i++) {
                if (node == i || resultTimes[node][i] == Integer.MIN_VALUE) {
                    continue;
                }

                int length = resultTimes[k][node] + resultTimes[node][i];
                if (resultTimes[k][i] == Integer.MIN_VALUE) {
                    resultTimes[k][i] = length;
                } else if (resultTimes[k][i] > length) {
                    resultTimes[k][i] = length;
                }

                if (processedNodeSet[i] != 1) {
                    queue.add(i);
                }
            }

            System.out.println("node "+node);
            System.out.println(Utils.toString(resultTimes));

            processedNodeSet[node] = 1;
            node = findNextNode(processedNodeSet, queue);
        }
        System.out.println(Utils.toString(resultTimes));

        int max = -1;
        for (int i = 1; i < resultTimes[k].length; i++) {
            if (i == k) {
                continue;
            }
            if (resultTimes[k][i] == Integer.MIN_VALUE) {
                return -1;
            } else if (resultTimes[k][i] > max) {
                max = resultTimes[k][i];
            }
        }

        return max;
    }


    private int findNextNode(int[] processedNodeSet, Queue<Integer> queue) {
        Integer node = queue.poll();
        int next = 0;
        while (node != null) {
            next = node;
            if (processedNodeSet[node] != 1) {
                next = node;
                break;
            } else {
                node = queue.poll();
            }
        }
        return next;
    }
}
