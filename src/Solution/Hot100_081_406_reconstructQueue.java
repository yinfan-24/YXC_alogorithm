package Solution;

import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;

public class Hot100_081_406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x1, x2)->{
            if (x1[0] == x2[0]) return x1[1] - x2[1];
            else return x2[0] - x1[0];
        });

        int i = 0;
        while (i < people.length){
            int[] temp = people[i];
            System.arraycopy(people, temp[1], people, 1+temp[1], i-temp[1]);
            people[temp[1]] = temp;
            i++;
        }
        return people;
    }

}
