public class Game {

    public Result playGame(String s) {
        int n = 3;
        char player = 'X';
        char[][] cells;

        cells = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = '_';
            }
        }

        String[] moves = s.split(",");

        for (String move : moves) {
            int m = move.charAt(1) - '1';
            int k = move.charAt(0) - 'A';
            cells[m][k] = player == 'X' ? 'X' : 'O';
            player = player == 'X' ? 'O' : 'X';
            System.out.print(" ");
            for (int i = 65;i < n + 65;i++){
                char ch = (char)i;
                System.out.print(" " + ch);
            }
            System.out.println();
            for(int i=0 ;i<n; i++){
                System.out.print(i+1);
                for(int j=0; j<n; j++){
                    System.out.print(" "+cells[i][j]);
                }
                System.out.println();
            }
            boolean win_judge = false;
            char winChar = 0;

            for (int i = 0; i < n; i++) {
                int win_X_H = 0;
                int win_O_H = 0;
                int win_X_V = 0;
                int win_O_V = 0;
                for (int j = 0; j < n; j++) {
                    if (cells[i][j] == 'X') {
                        win_X_H++;
                    } else {
                        win_X_H = 0;
                    }

                    if (cells[i][j] == 'O') {
                        win_O_H++;
                    } else {
                        win_O_H = 0;
                    }

                    if (cells[j][i] == 'X') {
                        win_X_V++;
                    } else {
                        win_X_V = 0;
                    }

                    if (cells[j][i] == 'O') {
                        win_O_V++;
                    } else {
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
                if (win_judge) {
                    break;
                }
            }
            if(!win_judge){
                for (int i = 0;i < n - 2;i++){
                    for (int j = 0;j < n - 2;j++) {
                        if(cells[i][j] == 'X' && cells[i + 1][j + 1] == 'X' && cells[i + 2][j + 2] == 'X'){
                            win_judge = true;
                            winChar = 'X';
                            break;
                        }
                        if(cells[i + 2][j] == 'X' && cells[i + 1][j + 1] == 'X' && cells[i][j + 2] == 'X'){
                            win_judge = true;
                            winChar = 'X';
                            break;
                        }
                        if(cells[i][j] == 'O' && cells[i + 1][j + 1] == 'O' && cells[i + 2][j + 2] == 'O'){
                            win_judge = true;
                            winChar = 'O';
                            break;
                        }
                        if(cells[i + 2][j] == 'O' && cells[i + 1][j + 1] == 'O' && cells[i][j + 2] == 'O'){
                            win_judge = true;
                            winChar = 'O';
                            break;
                        }
                    }
                    if (win_judge){
                        break;
                    }
                }
            }
            switch (winChar) {
                case 'X':
                    return Result.X_WIN;
                case 'O':
                    return Result.O_WIN;
                default:
                    break;
            }
        }
        return Result.DRAW;
    }
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}
