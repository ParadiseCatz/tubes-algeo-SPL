import java.util.*;
import java.lang.reflect.Array;
import java.io.*;

public class TestSistemPersamaanLinear {
	StringTokenizer tokenizer;
    BufferedReader in;
    static int NMAX = 100100;

    int n, m;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            initVariable();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
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
        System.out.print("Jumlah Variabel: ");
    	n = nextInt();
        System.out.print("Jumlah Persamaan: ");
    	m = nextInt();
    	SistemPersamaanLinear spl = new SistemPersamaanLinear(n,m);
        spl.read(new InputReader(new BufferedReader(new InputStreamReader(System.in))));

        printMatrix(spl.getMatriks());
        spl.solve();
        printMatrix(spl.getMatriks());
    }

    void printMatrix(Matrix mat) {
        double[][] ar2d = mat.getM();
    	for (int i = 0; i < m; ++i) {
    		for (int j = 0; j <= n; ++j) {
    			System.out.print(ar2d[i][j] + " ");
    		}
    		System.out.println();
    	}
    }

	public static void main(String []args) {
		new TestSistemPersamaanLinear().run();
	}
}