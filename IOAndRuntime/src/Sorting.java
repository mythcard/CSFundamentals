import java.util.ArrayList;
import java.util.List;

public class Sorting {
    /*
     * Sorting in ascending order
     * To optimise: stop the iterations if no swapping exists.
     * */
    public static void bubblesort(List<Long> list) {
        int len = list.size();
        //for each iteration, number of iterations = size of array
        for (int i = 0; i < len; i++) {
            //compare the neighbours from j=0 to last value-i
            for (int j = 0; j < len - i - 1; j++) {
                //if any two values are in opposite order swap
                if (list.get(j) > list.get(j + 1)) {
                    swap(list, j, j + 1);
                }
            }
        }
    }
    public static void swap(List<Long> list, int first, int second) {
        Long temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    public static List<Long> mergesort(List<Long> list) {
        return mergeSort(list, 0, list.size() - 1);
    }
    public static List<Long> mergeSort(List<Long> list, int start, int end) {
        List<Long> result = new ArrayList<Long>();
        if (end == start) {
            result.add(list.get(start));
            return result;
        }
        //divide into two halves
        int len = end - start + 1;
        //call mergesort on each
        List<Long> listA = mergeSort(list, start, start + len / 2 - 1 );
        List<Long> listB = mergeSort(list, start + (len / 2) , end);
        //merge the two halves
        result = merge(listA, listB);
        return result;
    }
    public static List<Long> merge(List<Long> listA, List<Long> listB) {
        List<Long> result = new ArrayList<Long>();
        int lenA = listA.size();
        int lenB = listB.size();
        int a = 0;
        int b = 0;
        while (a < lenA && b < lenB) {
            if (listA.get(a) < listB.get(b)) {
                result.add(listA.get(a));
                a++;
            } else {
                result.add(listB.get(b));
                b++;
            }
        }
        while(a < lenA){
            result.add(listA.get(a));
            a++;
        }
        while(b < lenB){
            result.add(listB.get(b));
            b++;
        }
        return result;
    }
    //testing
//    public static void main(String[] args) {
//        List<Long> arr = new ArrayList<Long>(List.of((long) 5, (long) 3, (long) 4, (long) 6, (long) 1));
//        System.out.println("List before sorting");
//        for (Long val : arr) {
//            System.out.println(val);
//        }
//        arr = mergesort(arr);//bubblesort(arr);
//        System.out.println("List after sorting");
//        for (Long val : arr) {
//            System.out.println(val);
//        }
//    }
}














