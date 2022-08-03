package cn.nju.test9arrivalofgeneral2;


public class ArrivalOfGeneral {

    public static int calculate(int num, int[] heightArr) {
        int max_index = 0;
        int min_index = 0;
        for(int i = 0;i < num;i++){
            if (heightArr[max_index] <= heightArr[i]){
                max_index = i;
            }
            if(heightArr[min_index] >= heightArr[i]){
                min_index = i;
            }
        }

        int change_num = max_index > min_index ? max_index + num - min_index - 2: max_index + num - min_index - 1;
        return change_num;
    }
}
