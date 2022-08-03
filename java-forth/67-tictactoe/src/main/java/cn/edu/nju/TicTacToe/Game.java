package cn.edu.nju.TicTacToe;
public class Game {

    public Result playGame(String gameMode, String moveStr, int size){
    	Board board = new Board(size);
    	
    	String[] moves = moveStr.split(",");
    	Result res = Result.GAMING;

		int step = 0;

    	for(String move: moves){
			step++;
			if (gameMode.charAt(0) == '1' && step > 10){
				int i = moves[step - 11].charAt(1) - '1';
				int j = moves[step - 11].charAt(0) - 'A';
				board.cells[i][j] = '_';
			}
			res = board.nextMove(move, gameMode, size);
			int judge = 0;
			for (int i = 0;i < size;i++){
				for (int j = 0;j < size;j++){
					if(board.cells[i][j] == '_'){
						judge++;
					}
				}
			}

			if(judge + step == size * size + 1 && gameMode.charAt(0) == '0'){
				res = Result.ERROR;
			}

			if(((judge + step == size * size + 1 && step < 11) || (judge == size * size - 9 && step > 10)) && gameMode.charAt(0) == '1'){
				res = Result.ERROR;
			}

			board.print(size);

    		if( !res.equals(Result.GAMING) ) {
				break;
			}
    	}
    	return res;
    }
}