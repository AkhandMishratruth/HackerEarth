import java.io.*;
import java.util.*;

public class Shortest_Path_Problem {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt(), e = in.nextInt();
        int[] dist = new int[v + 1];
        Graph TheGra = new Graph(v);
        for(int i =0;i<e;i++)
            TheGra.setEdge(in.nextInt(), in.nextInt(), in.nextInt());
        PriorityQueue<pair> q = new PriorityQueue<pair>(v, pair.com);
        q.add(new pair(0, 1));
        pair temp, temp2;
        boolean[] visited = new boolean[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (visited[temp.ver])
                continue;
            else
                visited[temp.ver] = true;
            Iterator it = TheGra.gra.get(temp.ver).iterator();
            while (it.hasNext()) {
                temp2 = (pair) it.next();
                if (dist[temp.ver] + temp2.dis < dist[temp2.ver]) {
                    dist[temp2.ver] = dist[temp.ver] + temp2.dis;
                    q.add(new pair(dist[temp2.ver], temp2.ver));
                }
            }
        }
        for(int i=2;i<dist.length;i++)
            System.out.print(dist[i]+" ");
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
class Graph {
    Map<Integer, List<pair>> gra;

    Graph(int vertex) {
        gra = new HashMap<Integer, List<pair>>();
        for (int i = 1; i <= vertex; i++)
            gra.put(i, new LinkedList<pair>());
    }

    void setEdge(int s, int d, int wt) {
        List<pair> th = gra.get(s);
        th.add(new pair(wt, d));
    }
}
class pair {
    int dis, ver;

    pair(int d, int v) {
        dis = d;
        ver = v;
    }

    static Comparator<pair> com = new Comparator<pair>() {
        @Override
        public int compare(pair o1, pair o2) {
            return Integer.compare(o1.dis, o2.dis);
        }
    };
}
