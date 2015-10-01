import java.util.*;
import java.io.*;
	
public class InputReader{	
	private StringTokenizer tokenizer;
    private BufferedReader in;
	
	public InputReader(BufferedReader in) {
		this.in = in;
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
	
    char nextChar() throws IOException {
        return (char)in.read();
    }
	
}