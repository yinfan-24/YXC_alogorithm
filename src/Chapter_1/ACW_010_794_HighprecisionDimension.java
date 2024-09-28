package Chapter_1;

import java.util.*;

public class ACW_010_794_HighprecisionDimension {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b = input.next();
        int num2 = Integer.parseInt(b);

        List<Integer> num1 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) num1.add(a.charAt(i) - '0');

        int index = 0, quotient = 0;
        while (index < num1.size()){
            quotient = quotient * 10 + num1.get(index);
            if (quotient >= num2){
                ans.add(quotient / num2);
                quotient = quotient % num2;
            } else if (index + 1 > b.length()) {
                ans.add(0);
            }
            index++;
        }
        if (ans.size()>0) for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i));
        else System.out.print(0);
        System.out.print("\n");
        System.out.println(quotient);

    }
}
