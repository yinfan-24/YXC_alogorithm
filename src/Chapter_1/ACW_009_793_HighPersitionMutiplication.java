package Chapter_1;
import java.util.*;
public class ACW_009_793_HighPersitionMutiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b = input.next();

        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0 ; i--) num1.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) num2.add(b.charAt(i) - '0');

//        中间结果：
        for (int i = 0; i < num2.size(); i++) {
//            进位
            int current_carry = 0;
//            每行的结果
            List<Integer> row_list = new ArrayList<>();
//            先补齐每行末尾的0
            for (int j = 0; j < i; j++) row_list.add(0);
            for (int j = 0; j < num1.size(); j++) {
                int current_num = (num2.get(i) * num1.get(j) + current_carry) % 10;
                current_carry = (num2.get(i) * num1.get(j) + current_carry) / 10;
                row_list.add(current_num);
            }
//            如果还有进位，则再进一位
            if (current_carry != 0) row_list.add(current_carry);
            res.add(row_list);
        }

//        中间结果的加法：
        List<Integer> ans = new ArrayList<>();
        List<Integer> longet_list = res.get( res.size()-1 );

        int current_carry = 0;
        for (int col_index = 0; col_index < longet_list.size() ; col_index++) {
//            先加进位
            int current_num = current_carry;
//            结果式的每行相加
            for (int row_index = 0; row_index < num2.size(); row_index++) {
                if (col_index < res.get(row_index).size()) {
                    current_num += res.get(row_index).get(col_index);
                }
            }
            current_carry = current_num / 10;
            current_num = current_num % 10;
            ans.add(current_num);
        }
        if (current_carry != 0) ans.add(current_carry);

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