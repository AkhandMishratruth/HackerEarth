import java.io.*;
import java.util.*;

public class Strongly_Connected_Component {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt(), e = in.nextInt(),s,d;
        Graph RevGra = new Graph(v);
        for(int i=0;i<e;i++) {
            s= in.nextInt(); d = in.nextInt();
            RevGra.setEdge(s,d);
        }
        RevGra.DFS_loop();
        Graph Gra = Graph.reversed(RevGra);
        Gra.DFS_loop();
        int[] reveL = new int[v+1];
        for(int i=1;i<reveL.length;i++){
            reveL[RevGra.reversefinish[i]]=RevGra.reversefinish[Gra.leader[i]];
        }
        HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();
        int i, temp,ans =0;
        for(int j = 1;j<reveL.length;j++) {
            i=reveL[j];
            if(!count.containsKey(i))
                count.put(i,1);
            else {
                temp = count.get(i)+1;
                count.put(i, temp);
            }
        }
        Iterator it = count.keySet().iterator();
        while(it.hasNext()){
            temp =count.get((int)it.next());
            if(temp%2==0)
                ans-=temp;
            else
                ans+=temp;
        }
        System.out.println(ans);
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
    int t = 0, so;
    Map<Integer, List<Integer>> gra;
    boolean[] visit;
    int[] leader;int[] reversefinish;
    int[] finish;

    Graph(int vertex) {
        reversefinish = new int[vertex+1];
        visit = new boolean[vertex + 1];
        leader = new int[vertex + 1];
        finish = new int[vertex + 1];
        gra = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= vertex; i++)
            gra.put(i, new LinkedList<Integer>());
    }

    void setEdge(int s, int d) {
        List<Integer> th = gra.get(s);
        th.add(d);
    }

    static Graph reversed(Graph ini) {
        Graph toret = new Graph(ini.gra.size());
        Iterator it;
        for (int i = 1; i <= ini.gra.size(); i++) {
            it = ini.gra.get(i).iterator();
            while (it.hasNext())
                toret.setEdge(ini.finish[(int) it.next()], ini.finish[i]);
        }
        return toret;
    }

    void DFS_loop() {

        for(int j =gra.size();j>0;j--){
            if (!visit[j]) {
                //System.out.println(j+" ");
                so=j;
                DFS(j);
            }
        }
    }

    void DFS(int i) {
        int temp;
        visit[i] = true;
        leader[i] = so;
        Iterator it = gra.get(i).iterator();
        while (it.hasNext()) {
            temp = (int) it.next();
            if (!visit[temp])
                DFS(temp);
        }
        t++;
        finish[i] = t;
        reversefinish[t] = i;
    }
}