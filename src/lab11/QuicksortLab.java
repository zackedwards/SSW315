package lab11;

import java.util.Vector;

/**
 * Modify this implementation of Quicksort. Change the private method
 * quicksort() so it is implemented WITHOUT the two vectors, and it their place
 * uses a single array named "extra".
 * 
 */
public class QuicksortLab {
	int[] items = new int[100];

	public void quickSort(int[] arrayToSort) {
		items = arrayToSort;
		quicksort(0, items.length - 1);
		for (int index = 0; index <= items.length - 1; index++) {
			System.out.print(items[index] + " ");
		}
		System.out.println();
	}

	private void quicksort(int from, int to) {
		int pivot = from;
		int pivotValue = items[pivot];

		System.out.print("(" + from + "," + to + ") ");
		for (int index = from; index <= to; index++) {
			System.out.print(items[index] + " ");
		}
		System.out.println();

		int[] temp = items.clone();
		int backIndex = to;
		int frontIndex = from;
		int frontSize = 0;
		int backSize = 0;

		for (int i = from; i <= to; i++) {
			if (i != pivot) {
				if (items[i] < pivotValue) {
					temp[frontIndex] = items[i];
					frontIndex++;
					frontSize++;
				} else {
					temp[backIndex] = items[i];
					backIndex--;
					backSize++;
				}
			}
		}
		if (backIndex == frontIndex) {
			temp[frontIndex] = pivotValue;
			items = temp;
			System.out.println("Success");
		} else {
			System.out.println("bad result");
		}
		if (frontSize > 1) {
			quicksort(from, from + frontSize - 1);
		}
		if (backSize > 1) {
			quicksort(frontSize + 1 + from, frontSize + from + backSize);
		}
//   Vector leftPartition = new Vector();
//   Vector rightPartition = new Vector();
//   
//   for (int i = from; i <= to; i++)
//   {
//       if (i != pivot)
//       {
//           if (items[i] < pivotValue)
//           {
//               leftPartition.addElement(new Integer(items[i]));
//           }
//           else
//           {
//               rightPartition.insertElementAt(new Integer(items[i]),0);
//           }
//        }
//    }
//     
//    for (int i = from; i <= to; i++)
//    {
//        if ( (i-from) < leftPartition.size())
//        {
//            items[i] = ((Integer)leftPartition.elementAt(i-from)).intValue();
//        }
//        else if ( (i-from) == leftPartition.size())
//        {
//            items[i] = pivotValue;
//        }
//        else
//        {
//            items[i] =  ((Integer)rightPartition.elementAt(i-from-leftPartition.size()-1)).intValue();
//        }
//    }
// 
//    if (leftPartition.size() > 1)
//    {
//        quicksort(from, from+leftPartition.size()-1);
//    }
//    if (rightPartition.size() > 1)
//    {
//        quicksort(leftPartition.size()+1+from, 
//                  leftPartition.size()+from+rightPartition.size());
//    }

	}

	public static void main(String[] Args) {

		QuicksortLab sort = new QuicksortLab();

		// test 1
		System.out.println("Test 1");
		int[] test1 = { 9, 4, 6, 2, 7, 4, 6, 5, 2, 1, 6, 8, 7, 9 };
		sort.quickSort(test1);
		System.out.println("After Sorting: ");
		for(int i = 0; i < test1.length - 1; i++) {
		   System.out.print(sort.items[i] + ", ");
	    }
		System.out.println(sort.items[test1.length - 1]);

		// test 2
		System.out.println(" ");
		System.out.println("Test 2");
		int[] test2 = { 1, 2, 2, 4, 4, 5, 6, 6, 6, 7, 7, 8, 9, 9 };
		sort.quickSort(test2);
		System.out.println("After Sorting: ");
		for(int i = 0; i < test2.length - 1; i++) {
		   System.out.print(sort.items[i] + ", ");
	    }
		System.out.println(sort.items[test2.length - 1]);

		// test 3
		System.out.println(" ");
		System.out.println("Test 3");
		int[] test3 = { 8, 7, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2,
				1 };
		sort.quickSort(test3);
		System.out.println("After Sorting: ");
		for(int i = 0; i < test3.length - 1; i++) {
		   System.out.print(sort.items[i] + ", ");
	    }
		System.out.println(sort.items[test3.length - 1]);
	}

}
