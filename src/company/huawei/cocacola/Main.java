package company.huawei.cocacola;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        while(scanner.hasNext()){
            int cur = scanner.nextInt();
            if(cur == 0) {
                break;
            }
            list.add(cur);
        }

        for(Integer i : list){
            if(i <= 2){
                res.add(0);
            } else if(i % 2 ==0){
                res.add(i / 2);
            } else {
                res.add(i / 2);
            }
        }
        for(int curRes : res){
            System.out.println(curRes);
        }



    }
}