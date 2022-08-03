package cn.edu.nju.TicTacToe;

import java.util.Objects;

public class Board {
	protected char[][] cells;
	protected GameChessStrategy chessStrategy= new GameChessStrategy();
	protected GameWinStrategy_HVD winStrategy_hvd = new GameWinStrategy_HVD();;
	protected GameWinStrategy_HV winStrategy_hv = new GameWinStrategy_HV();;
	protected Player player = Player.X;

	public Board(int n){
		cells = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				cells[i][j] = '_';
			}
		}
	}


	public Result nextMove(String move, String kind, int n) {
		chessStrategy.putChess(cells, nextPlay(), move);

		if(Objects.equals(kind, "00") || Objects.equals(kind, "10")) {
			return winStrategy_hvd.check(cells, n);
		}
		else{
			return winStrategy_hv.check(cells, n);
		}
	}

	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}

	public void print(int n){
		System.out.print(" ");
		for (int i = 65;i < n + 65;i++){
			char s = (char)i;
			System.out.print(" " + s);
		}
		System.out.println();
		for(int i=0 ;i<n; i++){
			System.out.print(i+1);
			for(int j=0; j<n; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}