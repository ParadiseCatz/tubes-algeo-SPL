import java.util.*;
import java.io.*;

public class Interpolasi {
	private int jmlTitik;
	private SistemPersamaanLinear persamaan;

	public Interpolasi(int jmlTitik) {
		this.jmlTitik = jmlTitik;
		persamaan = new SistemPersamaanLinear(jmlTitik,jmlTitik);
	}
	
	public void read(InputReader in) throws IOException {
		Matrix m = new Matrix(jmlTitik,jmlTitik+1);
		
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

	public void solve() throws IOException {
		persamaan.solve();
	}

	public void write(BufferedWriter writer) throws IOException {
		writer.write(Double.toString(persamaan.getMatriks().getEl(0,jmlTitik)));
		for (int i=1;i<jmlTitik;i++)
		{
			writer.write(" + " + persamaan.getMatriks().getEl(i,jmlTitik) + " x^" + i);
		}
		writer.write(" = y");
		writer.newLine();
		writer.flush();
	}

	public double findY(double x) {
		double temp = 1;
		double ans = 0;

		for (int i=0;i<jmlTitik;i++)
		{
			ans = ans + (temp * persamaan.getMatriks().getEl(i,jmlTitik));
			temp = temp * x;
		}
		return ans;
	}
}