package edu.nju;

import java.util.Scanner;
public class MatrixCalculation {
	

	public int[][] plus(int[][] A, int[][] B){

		int[][] result = new int[A.length][A[0].length];

		for(int i = 0;i < A.length;i++){
			for(int j = 0;j < A[0].length;j++){
				result[i][j] = A[i][j] + B[i][j];
			}
		}

		return result;

	}
	

	public int[][] times(int[][] A, int[][] B){
		int[][] result = new int[A.length][B[0].length];

		for(int i = 0;i < A.length;i++){
			for(int j = 0;j < B[0].length;j++){
				for(int m = 0;m < A[0].length;m++){
					result[i][j] = result[i][j] + A[i][m] * B[m][j];

				}
			}
		}

		return result;

	}

	public int [][] plusFromConsole(){
		Scanner scan = new Scanner(System.in);
		int Am = scan.nextInt();
		int An = scan.nextInt();

		int[][] A = new int[Am][An];

		for(int i = 0;i < Am;i++){
			for(int j = 0;j < An;j++){
				A[i][j] = scan.nextInt();
			}
		}

		int Bm = scan.nextInt();
		int Bn = scan.nextInt();

		int[][] B = new int[Bm][Bn];

		for(int i = 0;i < Bm;i++){
			for(int j = 0;j < Bn;j++){
				B[i][j] = scan.nextInt();
			}
		}

		scan.close();

		if(Am > 0 && An > 0) {
			int[][] result = new int[A.length][A[0].length];

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					result[i][j] = A[i][j] + B[i][j];
				}
			}

			return result;
		}else {
			return new int[0][0];
		}




	}


	public int[][] timesFromConsole(){
		Scanner scan = new Scanner(System.in);
		int Am = scan.nextInt();
		int An = scan.nextInt();

		int[][] A = new int[Am][An];

		for(int i = 0;i < Am;i++){
			for(int j = 0;j < An;j++){
				A[i][j] = scan.nextInt();
			}
		}

		int Bm = scan.nextInt();
		int Bn = scan.nextInt();

		int[][] B = new int[Bm][Bn];

		for(int i = 0;i < Bm;i++){
			for(int j = 0;j < Bn;j++){
				B[i][j] = scan.nextInt();
			}
		}

		scan.close();

		if(Am > 0 && Bn > 0) {
			int[][] result = new int[A.length][B[0].length];

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B[0].length; j++) {
					for (int m = 0; m < A[0].length; m++) {
						result[i][j] = result[i][j] + A[i][m] * B[m][j];

					}
				}
			}
			return result;
		}else {
			return new int[0][0];
		}
	}


	public void print(int[][] A){
		System.out.println();
		for(int i = 0;i < A.length;i++){
			for(int j = 0;j < A[0].length;j++){
				System.out.print(A[i][j]);
				if(j != A[0].length - 1){
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
}
