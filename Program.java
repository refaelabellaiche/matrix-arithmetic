
public class Program {

	public static void main(String[] args) throws MatrixException {

		Matrix m1 = new Matrix(3, 3);
		Matrix m2 = new Matrix(3, 3);

		m1.read();
		m2.read();

		System.out.println("First matrix");
		m1.write();
		System.out.println("Second matrix");
		m2.write();

		try {
			Matrix m3 = (Matrix) m1.add(m2);
			System.out.println("Sum of m1 and m2 : ");
			m3.write();
		} catch (IncompatibleDimensionsException e) {
			System.out.println("Error of sum : " + e.getMessage());
		}

		try {
			Matrix m4 = (Matrix) m2.sub(m1);
			System.out.println("Substraction of m1 and m2 : ");
			m4.write();
		} catch (IncompatibleDimensionsException e) {
			System.out.println("Error of sub : " + e.getMessage());
		}

		try {
			boolean isEqual = m1.equals(m2);
			System.out.println("Are the first and second matrices equals ? " + isEqual);
		} catch (IllegalComparisonException e) {
			System.out.println("Error of comparison : " + e.getMessage());
		}

		System.out.println("The clone of m1 is m5 : ");
		Matrix m5 = (Matrix) m1.clone();
		m5.write();
		
		try {
			int val = m1.valueAt(1, 0);
			System.out.println("The value at (1,0) of the matrix is : "+val);
		}
		catch(MatrixException e) {
			System.out.println("Error of indexes : "+ e.getMessage() );
		}
	}
}
