package basic.sort;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        buildMaxHeap(arr);

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        int index = (int) Math.floor(arr.length / 2);
        for(int i = index; i >=0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String args[]) {
        int[] arr = {0, 4, 1, 5, 6, 3, 9, 7, 8, 2};
        for(int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        heapSort(arr);
        for(int i : arr) {
            System.out.print(i);
        }
    }
}
