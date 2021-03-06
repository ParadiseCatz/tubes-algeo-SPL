import java.util.*;
import java.io.*;

public class SistemPersamaanLinear{
	private int jmlVariabel;
	private int jmlPersamaan;
	private Matrix matriks;
	private TreeMap <String,Integer> mapVariabel;
	private boolean solved;
	private String[] listVariabel;
	
	public SistemPersamaanLinear(int jmlVariabel, int jmlPersamaan){
		this.jmlVariabel = jmlVariabel;
		this.jmlPersamaan = jmlPersamaan;
		matriks = new Matrix(jmlPersamaan,jmlVariabel+1);
		mapVariabel = new TreeMap<String,Integer>();
		solved = false;
		listVariabel = new String[jmlVariabel];
	}
	
	public Matrix getMatriks(){
		return this.matriks;	 
	}

	public void setMatriks(Matrix matriks){
		this.matriks = matriks;
	}

	public void read(InputReader in) throws IOException {
		
		int cnt = 0;
		for (int i=0;i<jmlPersamaan;i++) {
			double num = in.nextDouble();
			String var = in.nextString();
			String op = in.nextString();
			
			if (!mapVariabel.containsKey(var)) {
				mapVariabel.put(var,cnt);
				listVariabel[cnt] = var;
				++ cnt;
				
			}
			matriks.setEl(i,mapVariabel.get(var),op.equals("-") ? -num : num);
			while (!op.equals("=")) {
				num = in.nextDouble();
				var = in.nextString();
				op = in.nextString();
				
				if (!mapVariabel.containsKey(var)) {
					mapVariabel.put(var,cnt);
					listVariabel[cnt] = var;
					++ cnt;
				}
				matriks.setEl(i,mapVariabel.get(var),op.equals("-") ? -num : num);

			}
			num = in.nextDouble();
			matriks.setEl(i,jmlVariabel,num);
		}
		
		int cntFiller = 1;
		for (; cnt < jmlVariabel; ++cnt) {
			while (mapVariabel.containsKey("variabel" + cntFiller))
				cntFiller++;
			mapVariabel.put("variabel" + cntFiller,cnt);
			listVariabel[cnt] = "variabel" + cntFiller;
		}
	}
	
	public void solve() {

    	try {
    		matriks.eliminateUsingGaussJordanMethod();
    		if (jmlPersamaan <= jmlVariabel)
    			solved = true;
    		if (jmlPersamaan > jmlVariabel) {
				if (matriks.getEl(jmlVariabel, jmlVariabel) == 0)
					solved = true;
			}
    	} catch (Exception e) {
    		Matrix temp = new Matrix(jmlVariabel, jmlVariabel+1);
    		for (int i = 0; i < jmlVariabel; ++i) {
    			for (int j = 0; j <= jmlVariabel; ++j) {
    				temp.setEl(i,j,matriks.getEl(i,j));
    			}
    		}
    		matriks = temp;
    		try {
    			matriks.eliminateUsingGaussJordanMethod();
    			solved = true;
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}

    	}

    	

    }
		
	public void write(BufferedWriter writer) throws IOException {
		if (solved) {
			for(int j = 0; j < Math.min(jmlVariabel, jmlPersamaan); ++j) {
				String variableName = listVariabel[j];
				Integer row = j;

				writer.write(variableName + " = ");

				for (int i = Math.min(jmlVariabel, jmlPersamaan); i < jmlVariabel; ++i) {
					if (matriks.getEl(row, i) == 0) {
						continue;
					}
					if (matriks.getEl(row, i) == 1) {
						writer.write(listVariabel[i] + " + ");
						continue;
					}
					writer.write(matriks.getEl(row, i) + listVariabel[i] + " + ");
				}
				writer.write(Double.toString(matriks.getEl(row, jmlVariabel)));
				writer.newLine();
			}
			writer.flush();
		} else {
			System.out.println("Sistem Persamaan belum di selesaikan");
		}
	}
	
}