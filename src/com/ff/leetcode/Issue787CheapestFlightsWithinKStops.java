package com.ff.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.cn/problems/cheapest-flights-within-k-stops/
 * 20230303 在看完 Bellman fold 算法后 AC 用了 40 分钟
 */
public class Issue787CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        System.out.println(new Issue787CheapestFlightsWithinKStops().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(new Issue787CheapestFlightsWithinKStops().findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));
        System.out.println(new Issue787CheapestFlightsWithinKStops().findCheapestPrice(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        int INF = Integer.MAX_VALUE / 2 - 1;
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dist[flight[1]] = flight[2];
            }
        }

        for (int i = 0; i < k; i++) {
            int[] distCopy = Arrays.copyOf(dist, dist.length);
            for (int[] flight : flights) {
                if (dist[flight[1]] > distCopy[flight[0]] + flight[2]) {
                    dist[flight[1]] = distCopy[flight[0]] + flight[2];
                }
            }
        }

        if (dist[dst] < INF) {
            return dist[dst];
        }

        return -1;
    }




}


/**
 *
 作者：paddi-yan
 链接：https://leetcode.cn/problems/cheapest-flights-within-k-stops/solution/78-by-paddi-yan-qsdu/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int start, int end, int k) {
        LinkedList<int[]>[] graph = buildGraph(n, flights);
        int[] costTo = new int[n];
        int[] stopTo = new int[n];
        Arrays.fill(costTo, Integer.MAX_VALUE);
        costTo[start] = 0;
        stopTo[start] = 0;
        PriorityQueue<Station> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.costFromStart - o2.costFromStart;
        });
        queue.offer(new Station(start, 0, 0));
        while(!queue.isEmpty()) {
            Station curInfo = queue.poll();
            int curId = curInfo.id;
            int curCostFromStart = curInfo.costFromStart;
            int curStopFromStart = curInfo.stopFromStart;
            if(curId == end) return curCostFromStart;
            //花费更多就立马跳过这条航线是错误的局限的
            //因为还有K的限制
            //有可能花费更少的路线但是中转次数不符合要求
            //最后就会输出-1
            //if(curCostFromStart > costTo[curId]) continue;
            if(curStopFromStart > k) continue;
            for(int[] next : graph[curId]) {
                int nextId = next[0];
                int nextCostFromStart = curCostFromStart + next[1];
                int nextStopFromStart = curStopFromStart + 1;
                if(nextCostFromStart < costTo[nextId]) {
                    costTo[nextId] = nextCostFromStart;
                    stopTo[nextId] = nextStopFromStart;
                    /**
                     错误示例
                     5
                     [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
                     0
                     2
                     2
                     Dijkstra算法会优先选择0->3->1->4->2的路线 花费为6 但是中转次数不符合要求
                     costTo[1]已经更新记录为4了
                     而正确的路线是0->1->4->1 花费为7 但是Dijkstra算法已经不会再选择这条路线了
                     因为costTo[1]为4 而单走0->5的航线花费已经是5了,无法加入队列
                     那么接下来Dijkstra算法就会选择0->3->1->2这条路线 最后的花费也就是输出的错误答案9
                     显然这是错误的,分析这个错误,就可以得出我们正确的剪枝条件了
                     */
                    //通过花费更少才将下一个航班加入队列是错误的一种剪枝
                    //因为当前这条路线花费最少但是后面中转次数会超过k
                    //就会使得costTo将局部最优的航线更新进入后,后面不管是否这条路线中转次数符合条件
                    //其他路线都无法再加入队列
                    //queue.offer(new Station(nextId, nextCostFromStart, nextStopFromStart));
                }
                //剪枝条件需要改变
                //当花费更多并且中转次数更多
                if(nextCostFromStart > costTo[nextId] && nextStopFromStart > stopTo[nextId]) {
                    continue;
                }
                queue.offer(new Station(nextId, nextCostFromStart, nextStopFromStart));
            }
        }
        return -1;
    }

    private LinkedList<int[]>[] buildGraph(int n, int[][] flights) {
        LinkedList<int[]>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            graph[from].add(new int[]{to, cost});
        }
        return graph;
    }
}
class Station {
    int id;
    int costFromStart;
    int stopFromStart;

    public Station(int id, int costFromStart, int stopFromStart) {
        this.id = id;
        this.costFromStart = costFromStart;
        this.stopFromStart = stopFromStart;
    }
}
