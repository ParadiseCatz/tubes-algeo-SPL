import java.util.*;
import java.io.*;

public class Interpolasi {
	private int jmlTitik;
	SistemPersamaanLinear persamaan = new SistemPersamaanLinear();

	public void read(InputReader in) throws IOException {
		Matrix m = new Matrix(jmlTitik-1,jmlTitik);
		
		for (int i=0;i<jmlTitik;i++) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double temp = 1;

			for (int j=0;j<jmlTitik;j++) {
				m.setEl(i,j,temp);
				temp = temp * x;
			}
			m.setEl(i,jmlTitik,y);

		}
		persamaan.setMatriks(m);
	}

	public void solve() {
		persamaan.solve();
	}

	public void write() {
		for (int i=0;i<jmlTitik;i++)
		{
			writer.write(" + " + matriks[i][jmlTitik] + " x^" + i);
		}
		writer.write(" = " + matriks[jmlTitik-1][jmlTitik])
	}
}