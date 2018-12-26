package sort;

public class SortCompare {
    public static void main(String[] args) {
        int n = 50000;
        int[] numberToSort;
        long start;
        long end;

        // test bubble sort
        numberToSort = getRandomNums(n);
        start = System.nanoTime();
        numberToSort = bubbleSort(numberToSort, n);
        end = System.nanoTime();
        System.out.println("bubble sort time: " + (end - start)/1000/1000 + "ms");
        logArray(numberToSort, n);

        // test insertion sort
        numberToSort = getRandomNums(n);
        start = System.nanoTime();
        numberToSort = insertSort(numberToSort, n);
        end = System.nanoTime();
        System.out.println("insertion sort time: " + (end - start)/1000/1000 + "ms");
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
        for (int i=0; i<n; ++i) {
            boolean flag = false;
            for (int j=0; j<n-i-1; ++j) {
                if (datas[j] > datas[j+1]) {
                    int temp = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = temp;
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
        for (int i=1; i<n; ++i) {
            int tmp = datas[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (tmp < datas[j]) {
                    datas[j+1] = datas[j];
                } else {
                    break;
                }
            }
            datas[j+1] = tmp;
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
