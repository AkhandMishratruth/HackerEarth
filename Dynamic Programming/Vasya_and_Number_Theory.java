import java.util.*;
import java.io.*;

public class  Vasya_and_Number_Theory {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] min = new int[n], dp = new int[n];
        Integer[] ar = new Integer[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        Arrays.sort(ar, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        Arrays.fill(dp,1);
        min[0]=ar[0];
        dp[0]=1;
        int[] his = new int[n];
        for(int i =1;i<n;i++) {
            for (int j = 0; j < i; j++) {
                if (min[j] % ar[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    min[i] = ar[i];
                    his[i]=j;
                } else
                    min[i] = Math.min(min[i], ar[j]);
            }
        }/*
        int j=n-1;
        while(j!=0){
            System.out.print(ar[j]+" ");
            j=his[j];
        }*/
        p.println(dp[n-1]);
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
class Graph{
    int vertexPerUniverse;
    HashMap<Integer, LinkedList<Integer>> Gra = new HashMap<Integer, LinkedList<Integer>>();
    HashMap<Integer, LinkedList<Integer>> ideal = new HashMap<Integer, LinkedList<Integer>>();
    Graph(int v){
        vertexPerUniverse=v;
    }
    void createIdeal(int s, int d){
        if(!ideal.containsKey(s))
            ideal.put(s,new LinkedList<Integer>());
        ideal.get(s).add(d);
        if(!ideal.containsKey(d))
            ideal.put(d, new LinkedList<Integer>());
        ideal.get(d).add(s);
    }
    void setEdge(int s, int d){
        if(!Gra.containsKey(s))
            Gra.put(s, new LinkedList<Integer>());
        Gra.get(s).add(d);
        if(!Gra.containsKey(d))
            Gra.put(d, new LinkedList<Integer>());
        Gra.get(d).add(s);
    }
    void adduni(int u1, int u2) {
        if (!Gra.containsKey(vertexPerUniverse * (u1 - 1) + 1))
            for (int i = 0; i < vertexPerUniverse; i++)
                Gra.put(vertexPerUniverse * (u1 - 1) + i + 1, new LinkedList<Integer>());

        for(int i =1;i<=vertexPerUniverse;i++) {
            //System.out.println(i);
            Iterator it = ideal.get(i).iterator();
            while(it.hasNext())
                Gra.get(vertexPerUniverse * (u1 - 1) + i).add(vertexPerUniverse * (u1 - 1) + (int)it.next());
        }

        if (!Gra.containsKey(vertexPerUniverse * (u2 - 1) + 1))
            for (int i = 0; i < vertexPerUniverse; i++)
                Gra.put(vertexPerUniverse * (u2 - 1) + i + 1, new LinkedList<Integer>());

        for(int i =1;i<=vertexPerUniverse;i++) {
            Iterator it = ideal.get(i).iterator();
            while(it.hasNext())
                Gra.get(vertexPerUniverse * (u2 - 1) + i).add(vertexPerUniverse * (u2 - 1) + (int)it.next());
        }
    }

    int distance(int p1, int u1, int p2, int u2){
        int s = p1+(u1-1)*vertexPerUniverse, d = p2 + (u2-1)*vertexPerUniverse;
        if(Gra.containsKey(s) && Gra.containsKey(d)) {
            HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
            HashMap<Integer, Boolean> visi = new HashMap<Integer, Boolean>();
            Iterator itt = Gra.keySet().iterator();
            int te;
            while (itt.hasNext()){
                te = (int)itt.next();
                dist.put(te,Integer.MAX_VALUE);
                visi.put(te, false);
            }
            LinkedList<Integer> q = new LinkedList<Integer>();
            q.add(s);
            dist.put(s,0);
            visi.put(s,true);
            int tem1, tem2;
            while (!q.isEmpty()) {
                tem1 = q.poll();
                Iterator it = Gra.get(tem1).iterator();
                while (it.hasNext()) {
                    tem2 = (int) it.next();
                    if (!visi.get(tem2)) {
                        visi.put(tem2,true);
                        dist.put(tem2,Math.min(dist.get(tem2), dist.get(tem1) + 1));
                        q.add(tem2);
                    }
                }
            }
            return dist.get(d);
        }
        else if(u1==u2){
            return this.distance(p1,1,p2,1);
        }
        return Integer.MAX_VALUE;
    }
}