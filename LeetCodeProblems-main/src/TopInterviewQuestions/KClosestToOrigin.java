package TopInterviewQuestions;

import java.util.*;

//973. K Closest Points to Origin
public class KClosestToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, List<int[]>> map = new HashMap<>();
        for (int[] ints : points) {
            double d = Math.sqrt(Math.pow(ints[0], 2) + Math.pow(ints[1], 2));
            List<int[]> list;
            if (map.containsKey(d)) {
                list = map.get(d);
            } else {
                list = new ArrayList<>();
            }
            list.add(ints);
            map.put(d, list);
        }
        Set<Double> keySet = map.keySet();
        Double[] keys = keySet.toArray(new Double[keySet.size()]);
        Arrays.sort(keys);
        int[][] result = new int[k][2];
        int j = 0, i = 0;
        while (i < k) {
            List<int[]> curPoints = map.get(keys[j++]);
            for (int[] point : curPoints) {
                if (i < k)
                    result[i++] = point;
            }
        }
        return result;
    }

    static int[][] pClosest(int [][]points, int k)
    {
        int n = points.length;
        int[] distance = new int[n];
        for(int i = 0; i < n; i++)
        {
            int x = points[i][0], y = points[i][1];
            distance[i] = (x * x) + (y * y);
        }

        Arrays.sort(distance);

        // Find the k-th distance
        int distk = distance[k - 1];

        // Print all distances which are
        // smaller than k-th distance
        int[][] res = new int[k][2];
        int j=0;
        for(int i = 0; i < n; i++)
        {
            int x = points[i][0], y = points[i][1];
            int dist = (x * x) + (y * y);
            if (dist <= distk)
                res[j++] = new int[]{x,y};;
        }
        return res;
    }

    public static void main(String[] args) {
        int points[][] = {{1, 3}, {-2, 2}}, k = 1;
        int res[][] = new KClosestToOrigin().pClosest(points, k);
        for (int[] r : res) {
            System.out.println(r[0] + "," + r[1]);
        }
    }
}
