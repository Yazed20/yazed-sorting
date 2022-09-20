/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazed_main;

/**
 *
 * @author yazed
 */
import javax.swing.DefaultListModel;
public class SortingAlgorithms {
      public static void BubbleSort(DefaultListModel<Double> arr)
    {
        for (int i = 0; i < arr.size() - 1; i++)
        {
            for (int j = 0; j < arr.size() - i - 1; j++)
            {
                if(arr.get(j) > arr.get(j + 1))
                {
                	Double temp = arr.get(j);
                    arr.set(j,arr.get(j + 1));
                    arr.set(j + 1,temp);
                }
            }
        }
    }
    public static void SelectionSort(DefaultListModel<Double> arr)
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
            Double temp = arr.get(min_arry_index);
            arr.set(min_arry_index,arr.get(i));
            arr.set(i,temp);
        }
    }
    private static void Swap(DefaultListModel<Double> List1 , int A , int B)
	{
    	Double Temp = List1.get(A);
		List1.set(A, List1.get(B));
		List1.set(B, Temp);
		Temp=null;
	}
	private static void Heapify(DefaultListModel<Double> List1 , int Size , int Curr)
	{
		while(true)
		{
			int Left = Curr*2 + 1;
			int Right = Curr*2 + 2;
			int Max = Curr;
			if(Left < Size &&(double)List1.get(Left)>(double)List1.get(Max))Max = Left;
			if(Right < Size &&(double)List1.get(Right)> (double)List1.get(Max))Max = Right;
			if(Max!=Curr)
			{
				Swap(List1,Max,Curr);
				Curr = Max;
				continue;
			}
			break;
		}
	}
	static void HeapSort(DefaultListModel<Double> List1)
	{
		int Size = List1.getSize();
		for(int i=(Size - 2)/2;i>=0;i--)Heapify(List1, Size , i);
		for(int i=Size-1;i>=0;i--)
		{
			Swap(List1,i,0);
			Heapify(List1, i , 0);
		}
	}
	static int Partition(DefaultListModel<Double> List1 , int L , int R)
	{
		double Pivot =List1.get(L);
		int j = L - 1;
		for(int i=L;i<=R;i++)
		{
			if(List1.get(i)<=Pivot)
			{
				j++;
				Swap(List1,i,j);
			}
		}
		Swap(List1,j,L);
		return j;
	}
	static void QuickSort(DefaultListModel List1 , int L , int R)
	{
		if(R<=L)return;
		int Mid = Partition(List1 , L , R);
		QuickSort(List1 , L , Mid - 1);
		QuickSort(List1 , Mid + 1 , R);
	}
	static void QuickSort(DefaultListModel List1)
	{
		QuickSort(List1 , 0 , List1.getSize() - 1);
	}
}
