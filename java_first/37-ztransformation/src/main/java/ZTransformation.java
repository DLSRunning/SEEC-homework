import java.util.Scanner;

public class ZTransformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String order = null;
        int line = 0;

        if (scan.hasNext()) {
            order = scan.next();
        }
        if(scan.hasNextInt()) {
            line = scan.nextInt();
        }
        int len = order.length();

        if(line > 1 && len > line) {
            StringBuffer[] result = new StringBuffer[line];
            for (int i = 0; i < line; i++) {
                result[i] = new StringBuffer();
                for (int j = 0; j < 2 * len; j++) {
                    result[i].append(' ');
                }
            }

            int x = 0;
            int y = -2;

            for (int i = 0; i < len; i++) {
                if (i % (2 * line - 2) < line) {
                    if (i % (2 * line - 2) == 0) {
                        x = -1;
                        y += 2;
                    }
                    x++;
                    result[x].setCharAt(y, order.charAt(i));
                } else {
                    x--;
                    y += 2;
                    result[x].setCharAt(y, order.charAt(i));

                }
            }


            for (int i = 0; i < line; i++) {
                int index = 0;
                for (int j = 2 * len - 1; j >= 0; j--) {
                    if (result[i].charAt(j) != ' ') {
                        index = j;
                        break;
                    }
                }
                System.out.println(result[i].substring(0, index + 1));
            }
        }else if(line == 1){
            for(int i = 0;i < len - 1;i++){
                System.out.print(order.charAt(i) + " ");
            }
            System.out.print(order.charAt(len - 1));
        }else {
            for(int i = 0;i < len;i++){
                System.out.println(order.charAt(i));
            }
        }
    }
}
