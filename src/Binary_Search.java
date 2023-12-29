public class Binary_Search {
    public static void main(String[] args) {
//        정렬이 되어있어야 이분탐색이 가능하다.
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int start = 0, end = arr.length - 1;
        int index = 0;
        int find = 13;
        while (true) {
            int middle = (start + end) / 2;
            if (start > end) {
                break;
            }
            if (arr[middle] == find) {
                index = middle;
                break;
            }
            if (arr[middle] > find) {
                end = middle - 1;
            }
            if (arr[middle] < find) {
                start = middle + 1;
            }
        }
        System.out.println(index);
    }
}
