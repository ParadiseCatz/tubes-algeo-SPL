import java.util.*;
import java.io.*;

public class SistemPersamaanLinear{
	private int jmlVariabel;
	private int jmlPersamaan;
	private Matrix matriks;
	private TreeMap <String,Integer> mapVariabel; 	
	
	public SistemPersamaanLinear(int jmlVariabel, int jmlPersamaan){
		this.jmlVariabel = jmlVariabel;
		this.jmlPersamaan = jmlPersamaan;
		matriks = new Matrix(jmlPersamaan,jmlVariabel+1);
		mapVariabel = new TreeMap<String,Integer>();
	}
	
	public Matrix getMatriks(){
		return this.matriks;	
	}

	public void setMatriks(Matrix matriks){
		this.matriks = matriks;
	}

	public void read(InputReader in) throws IOException {
		
		
		for (int i=1;i<=this.jmlPersamaan;i++) {
			double num = in.nextDouble();
			String var = in.nextString();
			String op = in.nextString();
			Integer cnt = 0;
			
			if (!mapVariabel.containsKey(var)) {
				mapVariabel.put(var,cnt);
				matriks.setEl(i,mapVariabel.get(var),num);
				++ cnt;
				
			}
			while (op!="=" && in.tokenizer.hasMoreTokens()) {
				num = in.nextDouble();
				var = in.nextString();
				op = in.nextString();
				
				if (!mapVariabel.containsKey(var)) {
					mapVariabel.put(var,cnt);
					matriks.setEl(i,mapVariabel.get(var),num);
					++ cnt;
				}
			}
		}
		
	}
	
	public void solve() throws NumberFormatException, IOException {
    	int n,m;
		
		
    	try {
    		matriks.eliminateUsingGaussMethod();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println();

    	try {
    		matriks.eliminateUsingGaussJordanMethod();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
		
		
		

	
	
	
}