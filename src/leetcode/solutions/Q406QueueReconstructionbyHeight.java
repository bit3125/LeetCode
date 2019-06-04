/**�㷨���������չ�Ȼ����ʹ�÷��η���Tn = On^2, Sn = O1
 * �� [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] Ϊ��
 * ��people����height��Ϊ������
 * ��ȡ��height�����飺[7,0],[7,1]
 * �����鰴��k��С�����������result��������������ڴ�ʱresult������û�б�����С����
 * ������k�����������result�е�ǰӦ�÷ŵ�position
 * ע��Ҫ����k��С�������insert����������Ȳ���[7,1]�ͻ��Ҳ�����ȷ�±�1����ʱresult����lengthΪ1��ֻ���±�0��
 *
 * ���������ζ�6,5,4,3,2,1.....����ͬ���Ĳ�������ÿ�β���ʱresult�����ж�û�б�curPerson.heightҪ���person
 * ��curPerson�ڵ�ǰ״̬�µ�����position������kֵ
 * ��ÿ�β����curPerson��height���ȵ�ǰresult�д��ڵ�person��heightҪС�������۲������ﶼ����Ե�ǰ����result
 * �е�person��λ�õ���ȷ�����Ӱ��
 * �Դ����ƣ����ܶ����������������
 *
 * ��ʵ�ֵ�ʱ��ѡ�����ȶ�people�����·���Comparator�Ĺ��������inplace����
 * �������ʼ״̬��[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
 * Ȼ��������Ұ������루����Ų��
 * �ܸ��Ӷ���On^2
 *
 * �ǳ�������㷨��ʵ���벻��
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
