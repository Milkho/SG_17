package complementary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Пошук комплементарних пар
 */
public class ComplementaryPairSearcher {

    /**
     * Шукає К-комплементарні пари в масиві
     *
     * @param array вхідний масив
     * @param k значення
     * @throws java.lang.Exception
     */
    public static void searchForComplementaryPair(int[] array, int k) throws Exception{
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int s = array[first] + array[last];
            if (s == k) {
                System.out.println(array[first] + "" + array[last]);
                first++;
                last--;
            } else {
                if (s < k) {
                    first++;
                } else {
                    last--;
                }
            }
        }
    }
}
