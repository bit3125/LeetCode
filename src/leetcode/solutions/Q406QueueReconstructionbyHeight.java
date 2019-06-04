/**算法分析：最终果然还是使用分治法。Tn = On^2, Sn = O1
 * 以 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] 为例
 * 将people按照height分为若干组
 * 先取出height最大的组：[7,0],[7,1]
 * 将该组按照k从小到大逐个放入result数组进行排序。由于此时result数组中没有比它们小的数
 * ，故其k就是其在这个result中当前应该放的position
 * 注意要按照k从小到大进行insert，否则如果先插入[7,1]就会找不到正确下标1（此时result数组length为1，只有下标0）
 *
 * 接下来依次对6,5,4,3,2,1.....进行同样的插入排序，每次插入时result数组中都没有比curPerson.height要大的person
 * 故curPerson在当前状态下的最终position就是其k值
 * 且每次插入的curPerson的height都比当前result中存在的person的height要小，故无论插在哪里都不会对当前存在result
 * 中的person的位置的正确性造成影响
 * 以此类推，则能对整个数组进行排序
 *
 * 在实现的时候选择了先对people按照下方的Comparator的规则进行了inplace排序
 * 排序完初始状态是[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
 * 然后从左往右挨个插入（往右挪）
 * 总复杂度是On^2
 *
 * 非常精妙的算法，实在想不到
 * */

package leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class Q406QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        if (people==null || people.length==0)
            return new int[0][];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?Integer.compare(o2[0], o1[0]):Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < people.length; i++) {
            int[] curPerson = people[i];
            int j = i;
            while (j > curPerson[1]) {
                people[j] = people[j - 1];
                j--;
            }
            people[j] = curPerson;
        }
        return people;
    }
}
