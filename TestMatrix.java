import java.util.*;
import java.lang.reflect.Array;
import java.io.*;

public class TestMatrix {
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
    	n = nextInt();
    	m = nextInt();
    	Matrix testMatrix = new Matrix(n, m);
        testMatrix.read(new InputReader(in));
    	try {
    		testMatrix.eliminateUsingGaussMethod();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    	testMatrix.write(writer);
    	System.out.println();

    	try {
    		testMatrix.eliminateUsingGaussJordanMethod();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	testMatrix.write(writer);
    }

	public static void main(String []args) {
		new TestMatrix().run();
	}
}