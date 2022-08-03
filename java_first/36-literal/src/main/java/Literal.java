import java.util.Scanner;

public class Literal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if(scan.hasNextInt()){
            System.out.println("integer");
        }
        else if(scan.hasNextDouble()) {
            System.out.println("double");
        }
        else if(scan.hasNextBoolean()){
            System.out.println("boolean");
        }
        else if(scan.hasNext()){
            String result = scan.nextLine();
            int len = result.length();
            char judge = result.charAt(len - 1);
            if(judge == 'L'){
                System.out.println("long");
            }
            else if(judge == 'f'){
                System.out.println("float");
            }else {
                System.out.println("char");
            }
        }
        scan.close();
    }
}
