package basic.sort;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more) {
            if(arr[l] < arr[r]) {
               swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]) {
                swap(arr, --more, l);
            }else {
                l++;
            }
        }
        // 把arr[r]放在一起
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void main(String args[]) {
        int[] arr = {0, 4, 1, 5, 6, 3, 9, 7, 8, 2};
        for(int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        quickSort(arr);
        for(int i : arr) {
            System.out.print(i);
        }
    }
}
