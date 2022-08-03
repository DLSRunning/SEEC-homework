import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;


public class testCSVFile {

    public static void main(String[] args) {
        StringBuffer[] infor = new StringBuffer[10];
        int index = 0;
        for (int i = 0;i < 10;i++){
            infor[i] = new StringBuffer();
        }
        try (Scanner scanner = new Scanner(Paths.get(args[0]).toFile())) {

            while (scanner.hasNext()) {
                infor[index].append(scanner.nextLine());
                index++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String[][] list = new String[index][5];
        for(int i = 0;i < index;i++){
            list[i] = new String(infor[i]).split(",");
        }

        Scanner scan = new Scanner(System.in);

        String input = null;
        if(scan.hasNext()) {
            input = scan.nextLine();
        }
        String[] order = input.split(" ");
        String[] select = order[1].split(",");

        int[] output_index = new int[5];
        for(int i = 0;i < 5;i++){
            output_index[i] = i;
        }

        if (input.contains("order")){
            String judge = null;
            if(input.contains("limit")){
                judge = order[order.length - 3];
            }else {
                judge = order[order.length - 1];
            }
            int judge_index = 0;

            if(Objects.equals(judge, "Salary")){
                judge_index = 2;
            } else if (Objects.equals(judge, "Employee_id")) {
                judge_index = 4;
            }

            for(int i = 0;i < index;i++){
                for(int j = i;j < index;j++){
                    if(Integer.parseInt(list[output_index[i]][judge_index]) < Integer.parseInt(list[output_index[j]][judge_index])){
                        int tmp = output_index[i];
                        output_index[i] = output_index[j];
                        output_index[j] = tmp;
                    }
                }
            }

        }
        if(input.contains("limit")){
            index = Integer.parseInt(order[order.length - 1]);
        }
        if(Objects.equals(select[0], "*")){
            System.out.println("Last_name    First_name    Salary    Department    Employee_id");
            for (int i = 0;i < index;i++){
                for (int j = 0;j < 5;j++){
                    System.out.print(list[output_index[i]][j]);
                    if(j != 4){
                        System.out.print("    ");
                    }
                }
                if(i != index - 1){
                    System.out.println();
                }
            }
        }else {
            int[] number = new int[5];
            int last = 0;
            if(order[1].contains("Last_name")){
                number[0] = 1;
                last = 0;
            }
            if(order[1].contains("First_name")){
                number[1] = 1;
                last = 1;
            }
            if(order[1].contains("Salary")){
                number[2] = 1;
                last = 2;
            }
            if(order[1].contains("Department")){
                number[3] = 1;
                last = 3;
            }
            if(order[1].contains("Employee_id")){
                number[4] = 1;
                last = 4;
            }

            for(int i = 0;i < select.length;i++){
                System.out.print(select[i]);
                if(i != select.length - 1){
                    System.out.print("    ");
                }
            }
            System.out.println();

            for (int i = 0;i < index;i++) {
                for (int j = 0; j < 5; j++) {
                    if (number[j] == 1) {
                        System.out.print(list[output_index[i]][j]);
                        if (j != last) {
                            System.out.print("    ");
                        }
                    }
                }
                if (i != index - 1) {
                    System.out.println();
                }
            }
        }
    }

}
