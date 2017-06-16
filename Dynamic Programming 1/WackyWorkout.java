import java.math.BigInteger;
import java.util.*;

public class WackyWorkout {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long n;
        for (int i = 0; i < N; i++) {
            n = in.nextLong();
            solve.fibo(BigInteger.valueOf(n+1l));
        }
    }

    static class solve {
        static BigInteger[][] matrixExpo(BigInteger n) {
            BigInteger tempx;
            BigInteger tempy;
            BigInteger tempz;
            BigInteger tempw;
            BigInteger[][] result = new BigInteger[2][2];
            result[0][0] = BigInteger.ONE;
            result[0][1] = BigInteger.ZERO;
            result[1][0] = BigInteger.ZERO;
            result[1][1] = BigInteger.ONE;

            BigInteger[][] M = new BigInteger[2][2];

            M[0][0] = BigInteger.ZERO;
            M[0][1] = BigInteger.ONE;
            M[1][0] = BigInteger.ONE;
            M[1][1] = BigInteger.ONE;

            while (n.compareTo(BigInteger.ZERO) > 0) {
                if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                    tempw = result[0][0].multiply(M[0][0]).add(result[0][1].multiply(M[1][0]));
                    tempx = result[0][0].multiply(M[0][1]).add(result[0][1].multiply(M[1][1]));
                    tempy = result[1][0].multiply(M[0][0]).add(result[1][1].multiply(M[1][0]));
                    tempz = result[1][0].multiply(M[0][1]).add(result[1][1].multiply(M[1][1]));

                    result[0][0] = tempw.mod(BigInteger.valueOf(1000000007));
                    result[0][1] = tempx.mod(BigInteger.valueOf(1000000007));
                    result[1][0] = tempy.mod(BigInteger.valueOf(1000000007));
                    result[1][1] = tempz.mod(BigInteger.valueOf(1000000007));
                }
                tempw = M[0][0].multiply(M[0][0]).add(M[0][1].multiply(M[1][0]));
                tempx = M[0][0].multiply(M[0][1]).add(M[0][1].multiply(M[1][1]));
                tempy = M[1][0].multiply(M[0][0]).add(M[1][1].multiply(M[1][0]));
                tempz = M[1][0].multiply(M[0][1]).add(M[1][1].multiply(M[1][1]));

                M[0][0] = tempw.mod(BigInteger.valueOf(1000000007));
                M[0][1] = tempx.mod(BigInteger.valueOf(1000000007));
                M[1][0] = tempy.mod(BigInteger.valueOf(1000000007));
                M[1][1] = tempz.mod(BigInteger.valueOf(1000000007));
                n = n.divide(BigInteger.valueOf(2));
            }
            return result;
        }

        static void fibo(BigInteger n) {
            if (n.compareTo(BigInteger.ONE) < 0) {
                System.out.println("1");
                return;
            }
            BigInteger[][] exp = solve.matrixExpo(n.subtract(BigInteger.ONE));
            System.out.println((exp[0][1].add(exp[1][1])).mod(BigInteger.valueOf(1000000007)));
        }
    }
}