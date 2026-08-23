import java.util.Scanner;
import java.util.InputMismatchException;

public class Matrix implements Arithmetic, InputOutput, Cloneable {
	int[][] data;
	int row;
	int col;
	
	public Matrix(int row, int col) {
		if(row<=0 || col<=0) {
			throw new InvalidMatrixSizeException("The rows and columns must be positive");
		}
		this.row = row;
		this.col = col;
		this.data = new int[row][col];
		}
	
	public Object add(Object o) {
		Matrix other = (Matrix) o;
		if(this.row != other.row || this.col != other.col) {
			throw new IncompatibleDimensionsException("The two matrixes must be of same dimension");
		}
		Matrix result = new Matrix(row,col);
		
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<col; j++)
				result.data[i][j] = this.data[i][j] + other.data[i][j];
		}
		return result;
	}
	
	public Object sub(Object o) {
		Matrix other = (Matrix) o;
		if(this.row != other.row || this.col != other.col) {
			throw new IncompatibleDimensionsException("The two matrixes must be of same dimension");
		}
		Matrix result = new Matrix(row,col);
		
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<col; j++)
				result.data[i][j] = this.data[i][j] - other.data[i][j];
		}
		return result;
	}
	
	public Object mul(Object o) {
		throw new MultOperationNotSupported("You cant multiply two matrixes");
	}
	
	public Object div(Object o) {
		throw new DivOperationNotSupported("You cant divide two matrixes");
	}
	
	public void write() {
		for(int i=0; i<data.length;i++) {
			for(int j=0; j<data[0].length; j++)
				System.out.println(data[i][j]+" ");
		}
	}
	
	public void read() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the matrixe's values : "+data.length+"x"+data[0].length);
		for(int i=0; i<row; i++) {
			for(int j=0; j<col;j++) {
				while(true) {
					try {
						int n = s.nextInt();
						data[i][j]=n;
						break;
					}
					catch(InputMismatchException e) {
						System.out.println("All values must be int");
						s.next();
					}
				}
			}
		}
	}
	
	public boolean equals(Object o) {
		boolean ans = true;
		if (!(o instanceof Matrix)) {
			throw new IllegalComparisonException("You cannot compare a matrix with an object of another type");
		}
		Matrix other = (Matrix) o;
		if(this.row != other.row || this.col != other.col) {
			throw new IncompatibleDimensionsException("The two matrixes must have the same dimension");
		}
		
		for(int i=0; i<row;i++) {
			for(int j=0; j<col;j++) {
				if(this.data[i][j] != other.data[i][j]) {
					ans = false;
				}
			}
		}
		return ans;
	}
	
	public Matrix clone() {
		try {
			Matrix copy = (Matrix) super.clone();
			copy.data = new int[row][col];
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					copy.data[i][j]=this.data[i][j];
				}
			}
			return copy;
		}
		catch (CloneNotSupportedException e) {
			throw new RuntimeException("Impossible to clone");
		}
	}
	
	public int valueAt(int i, int j) {
		if(i<0 || j<0) {
			throw new MatrixException("The indexes must be greater or equals than 0");
		}
		if(i>row-1 ||j>col-1) {
			throw new MatrixException("The indexes must be lesser than the maximum of indexes");
		}
		int ans = this.data[i][j];
		return ans;
	}

}

