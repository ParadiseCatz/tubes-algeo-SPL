import java.util.*;
import java.lang.reflect.Array;
import java.io.*;

public class TestMatrix {
	StringTokenizer tokenizer;
    BufferedReader in;
    static int NMAX = 100100;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            initVariable();
            solve();
        } catch (Exception e) {
            System.exit(9000);
        }
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                System.exit(0);
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws NumberFormatException, IOException {
    	return Long.parseLong(nextToken());
    }

    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    String nextString() throws IOException {
        return nextToken();
    }

    void initVariable() throws NumberFormatException {
    	
    }
 
    void solve() throws NumberFormatException, IOException {
    	int n = nextInt();
    	int m = nextInt();
    	double[][] mat = new double[n][m];
    	for (int i = 0; i < n; ++i) {
    		for (int j = 0; j < m; ++j) {
    			mat[i][j] = nextDouble();
    		}
    	}
    	Matrix testMatrix = new Matrix(n, m);
    	testMatrix.setM(mat);
    	try {
    		testMatrix.eliminateUsingGaussMethod();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	mat = testMatrix.getM();
    	for (int i = 0; i < n; ++i) {
    		for (int j = 0; j < m; ++j) {
    			System.out.print(mat[i][j] + " ");
    		}
    		System.out.println();
    	}
    }

	public static void main(String []args) {
		new TestMatrix().run();
	}
}