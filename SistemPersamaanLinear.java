import java.util.*;
import java.io.*;

public class SistemPersamaanLinear{
	private int jmlVariabel;
	private int jmlPersamaan;
	private Matrix matriks;
	private TreeMap <String,Integer> mapVariabel;
	private boolean solved;
	
	public SistemPersamaanLinear(int jmlVariabel, int jmlPersamaan){
		this.jmlVariabel = jmlVariabel;
		this.jmlPersamaan = jmlPersamaan;
		matriks = new Matrix(jmlPersamaan,jmlVariabel+1);
		mapVariabel = new TreeMap<String,Integer>();
		solved = false;
	}
	
	public Matrix getMatriks(){
		return this.matriks;	 
	}

	public void setMatriks(Matrix matriks){
		this.matriks = matriks;
	}

	public void read(InputReader in) throws IOException {
		
		for (int i=0;i<jmlPersamaan;i++) {
			double num = in.nextDouble();
			String var = in.nextString();
			String op = in.nextString();
			Integer cnt = 0;
			
			if (!mapVariabel.containsKey(var)) {
				mapVariabel.put(var,cnt);
				++ cnt;
				
			}
			matriks.setEl(i,mapVariabel.get(var),num);
			while (!op.equals("=")) {
				num = in.nextDouble();
				var = in.nextString();
				op = in.nextString();
				
				if (!mapVariabel.containsKey(var)) {
					mapVariabel.put(var,cnt);
					
					++ cnt;
				}
				matriks.setEl(i,mapVariabel.get(var),num);

			}
			num = in.nextDouble();
			matriks.setEl(i,jmlVariabel,num);
		}
		
	}
	
	public void solve() throws NumberFormatException, IOException {

    	try {
    		matriks.eliminateUsingGaussJordanMethod();
    		solved = true;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}


    }
		
	public void write(BufferedWriter writer) {
		if (solved) {
			for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
				String variableName = entry.getKey();
				Integer row = entry.getValue();

				System.out.println(variableName + " = ");

				for (int i = Math.min(jmlVariabel, jmlPersamaan); i < jmlVariabel; ++i) {
					
				}
			}
		} else {
			System.out.println("Sistem Persamaan belum di selesaikan");
		}
	}
	
}