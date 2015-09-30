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

  public void setEl(int i, int j, double x) {
    M[i][j] = x;
  }

  public double[][] getM() {
    return M;
  }

  public double getEl(int i, int j) {
    return M[i][j];
  }

  public void eliminateUsingGaussMethod() throws Exception{
    for (int k = 0; k < Math.min(n,m); ++k) {
      int i_max = k;
      for (int i = k+1; i < n; ++i) {
        i_max = Math.abs(M[i][k]) - Math.abs(M[i_max][k]) > eps ? i : i_max;
      }
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

  public void eliminateUsingGaussJordanMethod() throws Exception{
    eliminateUsingGaussMethod();
    for (int k = 0; k < Math.min(n,m); ++k) {
      double tmp = 1/M[k][k];
      for (int i = k+1; i < m; ++i) {
        M[k][i] *= tmp;
      }
      M[k][k] = 1;
    }
    for (int k = 1; k < Math.min(n,m); ++k) {
      for (int i = 0; i < k; ++i) {
        for (int j = k+1; j < m; ++j) {
          M[i][j]  = M[i][j] - M[k][j] * (M[i][k] / M[k][k]);
        }
        M[i][k] = 0;
      }
    }
  }
}
