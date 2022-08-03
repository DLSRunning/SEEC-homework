import java.util.Scanner;

public class MyMatrix {
	private int[][] data;
	

	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}


	public MyMatrix plus(MyMatrix B){
		int[][] b = B.data;

		int[][] result = new int[data.length][data[0].length];

		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < data[0].length;j++){
				result[i][j] = data[i][j] + b[i][j];
			}
		}

		return new MyMatrix(result);
	}

	

	public MyMatrix times(MyMatrix B){
		int[][] b = B.data;

		int[][] result = new int[data.length][b[0].length];

		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < b[0].length;j++){
				for(int m = 0;m < data[0].length;m++){
					result[i][j] = result[i][j] + data[i][m] * b[m][j];

				}
			}
		}

		return new MyMatrix(result);

	}
	

	public MyMatrix times(int b){
		int[][] result = new int[data.length][data[0].length];

		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < data[0].length;j++){
				result[i][j] = b * data[i][j];
			}
		}

		return new MyMatrix(result);
	}

	public MyMatrix transpose(){
		int[][] result = new int[data[0].length][data.length];
		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < data[0].length;j++){
				result[i][j] = data[j][i];
			}
		}


		return new MyMatrix(result);
	}

	public MyMatrix plusFromConsole(){
		Scanner scan = new Scanner(System.in);
		int Am = scan.nextInt();
		int An = scan.nextInt();

		int[][] A = new int[Am][An];

		for(int i = 0;i < Am;i++){
			for(int j = 0;j < An;j++){
				A[i][j] = scan.nextInt();
			}
		}

		scan.close();

			int[][] result = new int[A.length][A[0].length];

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					result[i][j] = A[i][j] + data[i][j];
				}
			}

			return new MyMatrix(result);

	}

	public MyMatrix timesFromConsole(){
		Scanner scan = new Scanner(System.in);
		int Am = scan.nextInt();
		int An = scan.nextInt();

		int[][] A = new int[Am][An];

		for(int i = 0;i < Am;i++){
			for(int j = 0;j < An;j++){
				A[i][j] = scan.nextInt();
			}
		}

		scan.close();

			int[][] result = new int[A.length][data[0].length];

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					for (int m = 0; m < A[0].length; m++) {
						result[i][j] = result[i][j] + A[i][m] * data[m][j];

					}
				}
			}
			return new MyMatrix(result);
	}
	

	public void print(){
		System.out.println();
		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < data[0].length;j++){
				System.out.print(data[i][j]);
				if(j != data[0].length - 1){
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
