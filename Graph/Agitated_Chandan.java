import java.io.*;
import java.util.*;

public class Agitated_Chandan {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int t=in.nextInt(), v, cost;
        Graph TheGra;
        while(t-->0) {
            v=in.nextInt();
            TheGra = new Graph(v);
            for (int i = 0; i < v-1; i++)
                TheGra.setEdge(in.nextInt(), in.nextInt(), in.nextInt());
            int max=0;
                max=TheGra.bfs(1);
            max=TheGra.bfs(max);
            max= TheGra.dist[max];
            cost=0;
            if(max>100)
                cost=100;
            if(max>1000)
                cost = 1000;
            if(max>10000)
                cost = 10000;

            p.println(cost+" "+max);
        }
        p.flush();
        p.close();
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
class Graph {
    Map<Integer, List<Node>> gra;
    int[] dist;

    Graph(int vertex) {
        gra = new HashMap<Integer, List<Node>>();
        for (int i = 1; i <= vertex; i++)
            gra.put(i, new LinkedList<Node>());
    }

    void setEdge(int s, int d, int wt) {
        List<Node> th = gra.get(s);
        th.add(new Node(d, wt));
        th = gra.get(d);
        th.add(new Node(s, wt));
    }

    int bfs(int s) {
        dist = new int[gra.size() + 1];
        Arrays.fill(dist, -1);
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);
        dist[s]=0;
        int tem1;
        Node temp2;
        while (!q.isEmpty()) {
            tem1 = q.removeFirst();
            Iterator it = gra.get(tem1).iterator();
            while (it.hasNext()) {
                temp2 = (Node) it.next();
                if (dist[temp2.v] == -1) {
                    dist[temp2.v] = dist[tem1] + temp2.wt;
                    q.add(temp2.v);
                }
            }
        }
        int max = -1, ind=0;
        for (int i =1;i<dist.length;i++) {
            //System.out.print(i+" ");
            if (max < dist[i]) {
                max = dist[i];
                ind = i;
            }
        }
        //System.out.println();
        return ind;
    }
}
class Node{
    int v, wt;
    Node(int x, int y){
        v=x;
        wt=y;
    }
}