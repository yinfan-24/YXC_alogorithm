package Chapter_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW_009_793_HighPersitionMutiplicationYXC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        int b = input.nextInt();

        List<Integer> num1 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

//        实际数值：末尾索引为0
        for (int i = a.length() - 1; i >= 0 ; i--) num1.add(a.charAt(i) - '0');

        int current_carry = 0;
        for (int i = 0; i < a.length() ; i++) {
            int current_num = (num1.get(i) * b + current_carry);
//            System.out.println(current_num);
            current_carry = current_num / 10;
            current_num = current_num % 10;
            ans.add(current_num);
//            System.out.println(current_num);
        }
        if (current_carry!=0) ans.add(current_carry);

        boolean no_zero = false;
//        去掉首0：
        int ans_index = ans.size()-1;
        while (ans_index > 0 && no_zero == false){
            if (no_zero == false && ans.get(ans_index) == 0) ans.remove(ans_index);
            else no_zero = true;
            ans_index--;
        }

//        输出结果：
        ans_index = ans.size() - 1;
        while (ans_index >= 0){
            System.out.print(ans.get(ans_index) + "");
            ans_index--;
        }
    }


}

/*
245
9243
 */