import java.util.*;
import java.io.*;

public class Interpolasi {
	private int jmlTitik;
	SistemPersamaanLinear persamaan = new SistemPersamaanLinear();

	public void read(InputReader in) throws IOException {
		
		
		for (int i=1;i<=jmlTitik;i++) {
			double x = in.nextDouble();
			double y = in.nextDouble();

			for (int j=1;j<=jmlTitik;j++) {
				setmatriks(i,j,temp);
				temp = temp * x;
			}
			setmatriks(i,jmlTitik+1,y);

		}
		
	}

	public void solve() {
		persamaan.solve();

	}

	public void write() {
		for (int i=1;i<=jmlTitik;i++)
		{
			//write matriks[i][jmlTitik+1] x^i
		}
	}
}