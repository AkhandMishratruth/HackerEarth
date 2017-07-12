import java.io.*;
import java.util.*;

public class Micro_and_Maze {
    static int[][] mat;
    static boolean[][] visited;
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int n = in.nextInt(), m = in.nextInt();
        mat = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mat[i][j] = in.nextInt();
        if(DFS(0,0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean DFS(int x, int y){
        if(x<0 || y<0)
            return false;
        if(x>mat.length-1 || y > mat[0].length)
            return false;
        if(mat[x][y]==0)
            return false;
        if(x==mat.length-1 && y == mat[0].length-1)
            return true;
        if(visited[x][y])
            return false;
        visited[x][y]=true;
        if(DFS(x+1,y))
            return true;
        if(DFS(x-1,y))
            return true;
        if(DFS(x,y+1))
            return true;
        if(DFS(x,y-1))
            return true;
        return false;

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