import java.util.*;
import java.io.*;

public class Interpolasi {
	private int jmlTitik;
	SistemPersamaanLinear persamaan;

	public Interpolasi(int jmlTitik) {
		this.jmlTitik = jmlTitik;
		persamaan = new SistemPersamaanLinear();
	}
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
		in.close();
	}

	public void solve() {
		persamaan.solve();
	}

	public void write() {
		writer.write(Double.toString(matriks[i][jmlTitik]));
		for (int i=1;i<jmlTitik;i++)
		{
			writer.write(" + " + matriks[i][jmlTitik] + " x^" + i);
		}
		writer.write(" = y");
		writer.newLine();
		writer.flush();
		writer.close();
	}

	public double findY(double x) {
		double temp = 1;
		double ans = 0;

		for (int i=0;i<jmlTitik;i++)
		{
			ans = ans+(temp*matriks[i][jmlTitik]);
			temp = temp*x;
		}
		return ans;
	}
}