package sort;

public class SortCompare {
    public static void main(String[] args) {
        int n = 50000;
        int[] numberToSort = getRandomNums(n);
        long start = System.nanoTime();
        numberToSort = insertSort(numberToSort, n);
        long end = System.nanoTime();
        System.out.println("sort time: " + (end - start)/1000/1000 + "ms");
        logArray(numberToSort, n);
    }

    /* 获取指定位数的随机数组 */
    public static int[] getRandomNums(int length) {
        int[] result = new int[length];
        int pos = 0;
        while (pos < length) {
            result[pos] = (int) Math.ceil(Math.random() * length);
            pos ++;
        }
        return result;
    }

    /* 冒泡排序 */
    public static int[] bubbleSort(int[] datas, int n) {
        if (n <= 1) {
            return datas;
        }
        /* 提前退出标志位 */
        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (datas[j] > datas[j+1]) {
                    int tmp = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return datas;
    }

    /* 插入排序 */
    public static int[] insertSort(int[] datas, int n) {
        if (n <= 1) {
            return datas;
        }
        for (int i = 1; i < n; ++i) {
            int val = datas[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (datas[j] > val) {
                    datas[j+1] = datas[j];
                } else {
                    break;
                }
            }
            datas[j + 1] = val;
        }
        return datas;
    }

    public static void logArray(int[] datas, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(datas[i]);
            if (i > 20) {
                break;
            }
        }
    }

}
