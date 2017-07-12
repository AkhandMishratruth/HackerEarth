import java.io.*;
import java.util.*;

public class Topological_Sort{
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt(), e = in.nextInt(),s,d;
        Graph Gra = new Graph(v);
        for(int i=0;i<e;i++) {
            s= in.nextInt(); d = in.nextInt();
            Gra.setEdge(s,d);
        }
        Gra.sorter();
        Gra.DFS_loop();
        for(int i=1;i<Gra.order.length;i++)
            System.out.print(Gra.order[i]+" ");
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
    int current;
    Map<Integer, LinkedList<Integer>> gra;
    boolean[] visit;
    int[] order;

    Graph(int vertex) {
        current=vertex;
        visit = new boolean[vertex + 1];
        order = new int[vertex+1];
        gra = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 1; i <= vertex; i++)
            gra.put(i, new LinkedList<Integer>());
    }

    void setEdge(int s, int d) {
        List<Integer> th = gra.get(s);
        th.add(d);
    }

    void sorter(){
        Iterator it = gra.keySet().iterator();
        while(it.hasNext()){
            gra.get((int)it.next()).sort(com);
        }
    }

    void DFS_loop() {

        for(int j =gra.size();j>0;j--){
            if (!visit[j]) {
                DFS(j);
            }
        }
    }

    void DFS(int i) {
        int temp;
        visit[i] = true;
        Iterator it = gra.get(i).iterator();
        while (it.hasNext()) {
            temp = (int) it.next();
            if (!visit[temp])
                DFS(temp);
        }
        order[current--]=i;
    }
    Comparator<Integer> com = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };
}