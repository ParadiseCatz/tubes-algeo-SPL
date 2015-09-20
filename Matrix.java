import java.util.*;
import java.math.*;

public class Matrix {

  final static double eps = 1e-6;

  private double[][] M;
  private int n, m;

  public Matrix(int n, int m) {
    this.n = n;
    this.m = m;
    M = new double[n][m];
  }

  public void setM(double[][] M) {
    this.M = M;
  }

  public double[][] getM() {
    return M;
  }

  public void eliminateUsingGaussMethod() throws Exception{
    for (int k = 0; k < Math.min(n,m); ++k) {
      System.out.println("ASD");
      int i_max = k;
      for (int i = k+1; i < n; ++i) {
        System.out.println(i_max + " " + i);
        i_max = Math.abs(M[i][k]) - Math.abs(M[i_max][k]) > eps ? i : i_max;
      }
      System.out.println("ASDsad");
      if (M[i_max][k] == 0) {
        throw new Exception("Matrix is singular!");
      }
      swapRow(k, i_max);
      for (int i = k+1; i < n; ++i) {
        for (int j = k+1; j < m; ++j) {
          M[i][j]  = M[i][j] - M[k][j] * (M[i][k] / M[k][k]);
        }
        M[i][k] = 0;
      }
    }
  } 

  public void swapRow(int a, int b) {
    double[] tmp;
    tmp = M[a];
    M[a] = M[b];
    M[b] = tmp;
  }
}
