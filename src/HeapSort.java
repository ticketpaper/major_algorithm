import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7};
//        최초 힙 구성 n/2번 만큼 heapify

        for (int i = arr.length/2-1; i >=0 ; i--) {
            heapify(arr, arr.length, i);
        }
        System.out.println(Arrays.toString(arr));
        //    최초 힙구성 이후에 root노드와 마지막 노드와 change
        sort(arr, arr.length, 0);

        System.out.println(Arrays.toString(arr));
    }


    static void heapify(int[] arr, int n, int root) {
////        ~ 조건일때 change 로직 : left와 right비교해서 자리 change
//        int left = root * 2 + 1;
//        int right = root * 2 + 2;
//        int max = root;
//        if (left < n && right < n) {
//            max = arr[left] < arr[right] ? right : left;
//        }
//        if (max != root) {
//            int temp = arr[root];
//            arr[root] = arr[max];
//            arr[max] = temp;
//            heapify(arr, n, max);
//        }

        int max_index = root;
        int left = root*2 + 1;
        int right = root*2 + 2;
        if(left<n && arr[max_index] < arr[left]){
            max_index = left;
        }
        if(right<n && arr[max_index] < arr[right]){
            max_index = right;
        }
        if(max_index != root){
            int temp = arr[root];
            arr[root] = arr[max_index];
            arr[max_index] = temp;
            heapify(arr,n,max_index);
        }
    }

    static void sort(int[] arr, int n, int root) {
        for (int i = n-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;
            heapify(arr, i, root);
        }
    }
}
