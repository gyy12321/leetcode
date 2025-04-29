package others;
import java.util.*;

public class jielongshulie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }

        scanner.close();

        // 进行 K 次操作
        for (int i = 0; i < K; i++) {
            // 找到最小值及其索引
            int minIndex = 0;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            // 取出最小值
            int minValue = list.get(minIndex);

            // 删除最小值，并将其加到剩余的元素上
            list.remove(minIndex);
            for (int j = 0; j < list.size(); j++) {
                list.set(j, list.get(j) + minValue);
            }
        }

        // 输出结果
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}