import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = 0;
        int n = 0;
        if(scan.hasNextInt()){
            m = scan.nextInt();
        }
        if(scan.hasNextInt()){
            n = scan.nextInt();
        }
        int[][] before = new int[m][n];
        for (int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                before[i][j] = scan.nextInt();
            }
        }
        int angel = 0;
        if(scan.hasNextInt()){
            angel = scan.nextInt() % 360;
        }

        if(angel == 0){
            for (int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    System.out.print(before[i][j]);
                    if(j != n - 1){
                        System.out.print(' ');
                    }
                }
                if(i != m - 1){
                    System.out.println();
                }
            }
        } else if (angel == 90) {
            for(int i = 0;i < n;i++){
                for(int j = m - 1;j >= 0;j--){
                    System.out.print(before[j][i]);
                    if(j != 0){
                        System.out.print(' ');
                    }
                }
                if(i != n - 1){
                    System.out.println();
                }
            }
        } else if (angel == 180) {
            for (int i = m - 1;i >= 0;i--){
                for(int j = n - 1;j >= 0;j--){
                    System.out.print(before[i][j]);
                    if(j != 0){
                        System.out.print(' ');
                    }
                }
                if(i != 0){
                    System.out.println();
                }
            }
        }else if(angel == 270){
            for(int i = n - 1;i >= 0;i--){
                for(int j = 0;j < m;j++){
                    System.out.print(before[j][i]);
                    if(j != m - 1){
                        System.out.print(' ');
                    }
                }
                if(i != 0){
                    System.out.println();
                }
            }
        }
    }
}
