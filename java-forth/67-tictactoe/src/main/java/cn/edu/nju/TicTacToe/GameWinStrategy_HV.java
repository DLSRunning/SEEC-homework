package cn.edu.nju.TicTacToe;

public class GameWinStrategy_HV {

	public Result check(char[][] cells, int n)
	{
		boolean win_judge = false;

		char winChar = 0;

		for(int i = 0;i < n;i++){
			int win_X_H = 0;
			int win_O_H = 0;
			int win_X_V = 0;
			int win_O_V = 0;
			for(int j = 0;j < n;j++) {
				if (cells[i][j] == 'X') {
					win_X_H++;
				}else {
					win_X_H = 0;
				}

				if (cells[i][j] == 'O') {
					win_O_H++;
				}else {
					win_O_H = 0;
				}

				if (cells[j][i] == 'X') {
					win_X_V++;
				}else {
					win_X_V = 0;
				}

				if (cells[j][i] == 'O') {
					win_O_V++;
				}else {
					win_O_V = 0;
				}

				if (win_X_H == 3 || win_X_V == 3) {
					winChar = 'X';
					win_judge = true;
					break;

				}

				if (win_O_H == 3 || win_O_V == 3) {
					winChar = 'O';
					win_judge = true;
					break;
				}
			}
			if (win_judge){
				break;
			}
		}
		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}
		return Result.DRAW;
	}
}