package javaapplication2;
import javax.swing.DefaultListModel;
public class SortAlgorithms
{
    private static DefaultListModel bubbleSort(DefaultListModel arr, int n)
    {

        for (int i = 0; i < arr.size() - 1; i++)
        {
            for (int j = 0; j < arr.size() - i - 1; j++)
            {
                if((Double)arr.get(j) > (Double)arr.get(j + 1))
                {
                    Object temp = arr.get(j);
                    arr.set(j,arr.get(j + 1));
                    arr.set(j + 1,temp);
                }
            }
        }
        return arr;
    }
    public static DefaultListModel selectionSort(DefaultListModel arr)
    {
        //int n = arr.length;
        for (int i = 0; i < arr.size() - 1; i++)
        {
            int min_arry_index = i;
            for (int j = i + 1; j < arr.size(); j++)
            {
                if ((Double)arr.get(j) < (Double)arr.get(min_arry_index))
                {
                    min_arry_index = j;
                }
            }
            Object temp = arr.get(min_arry_index);
            arr.set(min_arry_index,arr.get(i));
            arr.set(i,temp);
        }
        return arr;
    }
    public static DefaultListModel heapSort(DefaultListModel arr)
    {
        for (int i = arr.size(); i > 0; i--)
        {
            max_heapify(arr, i);
            Object temp = arr.get(0);
            arr.set(0,arr.get(i - 1));
            arr.set(i - 1,temp);
        }
        return arr;
    }
    private static void max_heapify(DefaultListModel arr, int limit) {
        if (arr.size() <= 0 || arr.size() < limit)
        {
            return;
        }
        int parentIdx = limit / 2;

        for (; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 >= limit) {
                continue;
            }
            int left = parentIdx * 2;
            int right = (left + 1) >= limit ? left : (left + 1);

            int maxChildId = (Double)arr.get(left) >= arr[right] ? left : right;
            if (arr[maxChildId] > arr[parentIdx]) {
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
    }
      public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];
        while (left < right){
            while(left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }
}