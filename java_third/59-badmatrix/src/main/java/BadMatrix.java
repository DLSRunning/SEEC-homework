

import java.util.Arrays;


public class BadMatrix {
	private int[][] data;


	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}



    public int[][] plus(int[][] b){

		int[][] result = new int[data.length][data[0].length];

		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < data[0].length;j++){
				result[i][j] = data[i][j] + b[i][j];
			}
		}

		return result;
	}
        

	public int[][] times(int[][] b){

		int[][] result = new int[data.length][b[0].length];

		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < b[0].length;j++){
				for(int m = 0;m < data[0].length;m++){
						result[i][j] = result[i][j] + data[i][m] * b[m][j];

				}
			}
		}

		return result;
	}


	public void print(){
		System.out.print(this.toString());
	}


	public String toString(){
		StringBuffer pr = new StringBuffer("\n");

		for(int i = 0;i < data.length;i++){
			for(int j = 0;j < data[0].length;j++){
				pr.append(data[i][j]);
				if(j != data[0].length - 1){
					pr.append(' ');
				}
			}
			pr.append('\n');
		}

		return new String(pr);
	}


	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
