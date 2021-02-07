public class SortingUnitTestDriver
{
    public void print_array(int[] array)
    {
        for (int i=0; i<array.length-1; i++)
        {
            System.out.print(array[i]+",");
        }
        System.out.print(array[array.length-1]);
        System.out.println();
    }

    // bubble sorts are used as test units to see if my code passes
    // the unit tests
    public int [] bubble_sort_test_ascending(int [] array)
    {
        for (int i=0; i<array.length-1;i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j]<array[i])
                {
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }

        return array;
    }

    public int [] bubble_sort_test_descending(int [] array)
    {
        for (int i=0; i<array.length-1;i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j]>array[i])
                {
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }

        return array;
    }

    public boolean array_comparison(int[]a, int []b)
    {
        boolean equal=true;
        if (a.length!=b.length)
        {
            equal=false;
            return false;
        }
        else
        {
            for (int i=0; i<a.length;i++)
            {
                if (a[i]!=b[i])
                {
                    equal=false;
                }
            }
        }
        return equal;
    }

    public void insertion_sort_test_driver(int [] array)
    {
        System.out.println("MY INSERTION SORT ALGORITHM");
        MyInsertionSort myInsertionSort =new MyInsertionSort();
        System.out.println("Insertion sort ascending order below: ");

        int[]a=myInsertionSort.ascending_sort(array);
        int[]b=bubble_sort_test_ascending(array);
        print_array(a);
        if (array_comparison(a,b)==false)
        {
            System.err.println("----ATTN!! INSERTION ASCENDING UNIT TEST HAS FAILED-----");
        }
        else
        {
            System.err.println((char)27 + "[32m"+"---- GOOD JOB! INSERTION ASCENDING UNIT TEST HAS PASSED -----");
        }


        System.out.println("Insertion sort descending order  below: ");
        int[]a1=myInsertionSort.descending_sort(array);
        int[]b1=bubble_sort_test_descending(array);
        print_array(a1);
        if (array_comparison(a1,b1)==false)
        {
            System.err.println("----ATTN!! INSERTION DESCENDING UNIT TEST HAS FAILED-----");
        }
        else
        {
            System.err.println((char)27 + "[32m"+"---- GOOD JOB! INSERTION DESCENDING UNIT TEST HAS PASSED -----");
        }


    }

    public void merge_sort_test_driver (int [] array)
    {
        System.out.println("MY MERGE SORT ALGORITHM");
        MyMergeSort myMergeSort= new MyMergeSort();
        System.out.println("MERGE sort ascending order below: ");

        int[]a=myMergeSort.ascending_merge_sort(array);
        int[]b=bubble_sort_test_ascending(array);
        print_array(a);
        if (array_comparison(a,b)==false)
        {
            System.err.println("----ATTN!! MERGESORT ASCENDING UNIT TEST HAS FAILED-----");
        }
        else
        {
            System.err.println((char)27 + "[32m"+"---- GOOD JOB! MERGESORT ASCENDING UNIT TEST HAS PASSED -----");
        }


        System.out.println("MERGE sort descending order below: ");
        int[]a1=myMergeSort.descending_merge_sort(array);
        int[]b1=bubble_sort_test_descending(array);
        print_array(a1);
        if (array_comparison(a1,b1)==false)
        {
            System.err.println("----ATTN!! MERGESORT DESCENDING UNIT TEST HAS FAILED-----");
        }
        else
        {
            System.err.println((char)27 + "[32m"+"---- GOOD JOB! MERGESORT DESCENDING UNIT TEST HAS PASSED -----");
        }

    }

    public void quick_sort_test_drive(int[] array)
    {
        System.out.println("MY QUICK SORT SORT ALGORITHM");
        MyQuickSort myQuickSort =new MyQuickSort();
        System.out.println("QUICK SORT sort ascending order below: ");


        int[]a=myQuickSort.ascending_quick_sort(array,0,array.length-1);
        int[]b=bubble_sort_test_ascending(array);
        print_array(a);
        if (array_comparison(a,b)==false)
        {
            System.err.println("----ATTN!! QUICK SORT ASCENDING UNIT TEST HAS FAILED-----");
        }
        else
        {
            System.err.println((char)27 + "[32m"+"---- GOOD JOB! QUICK SORT ASCENDING UNIT TEST HAS PASSED -----");
        }

        System.out.println("QUICK SORT sort descending order  below: ");
        int[]a1=myQuickSort.descending_quick_sort(array,0,array.length-1);
        int[]b1=bubble_sort_test_descending(array);
        print_array(a1);
        if (array_comparison(a1,b1)==false)
        {
            System.err.println("----ATTN!! QUICK SORT DESCENDING UNIT TEST HAS FAILED-----");
        }
        else
        {
            System.err.println((char)27 + "[32m"+"---- GOOD JOB! QUICK SORT DESCENDING UNIT TEST HAS PASSED -----");
        }

    }
}
