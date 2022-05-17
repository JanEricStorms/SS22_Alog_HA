package uebungen.jan.übung9jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeClasse {

    public static void main(String[] args) {
        int[] arr = new int[]{-17,10,20,37,19,47,35,-3,7,12,22,-23,-14,13,1,9,42,27,18,48};
        System.out.println(Arrays.toString(getTwoSum(arr,30)));
    }

    public static int[] getTwoSum(int[] arr, int sum){
        int first = 0;
        int last = arr.length-1;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
         while(true){
             if(first == last || first == arr.length-1){
                 break;
             }
             if(sortedArr[first] + sortedArr[last] == sum){
                 return getValuePosition(arr, sortedArr[first], sortedArr[last]);
             }else{
                 if(sortedArr[first] + sortedArr[last] < sum){
                     first++;
                 }
                 last--;
             }
         }
         return null;

    }

    private static int[] getValuePosition(int[] arr, int first, int last){
        System.out.println(first + " " + last);
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return new int[]{list.indexOf(first), list.indexOf(last)};
    }
}
