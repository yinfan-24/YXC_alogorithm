package Solution;

import java.util.Arrays;

public class Hot100_081_406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
//        人只能看得到前面比他高的元素，所以从高到低排列，然后进行位置调换
//        按身高降序排列；身高相同则按前面人数升序排列
        Arrays.sort(people, (x1, x2) -> {
                    if (x1[0] == x2[0]) return x1[1] - x2[1];
                    else return x2[0] - x1[0];
                });
        int i = 0; // 排完序后从前向后插入，前i-1个元素都已经放好了相对位置
        while(i < people.length){
            int[] temp = people[i];
//            对于第i个元素，他的位置应该插入到前i-1的元素的temp[1]的位置
            System.arraycopy(people, temp[1], people, temp[1] + 1, i - temp[1]);
            people[temp[1]] = temp;
            i++;
        }
        return people;
    }
}
