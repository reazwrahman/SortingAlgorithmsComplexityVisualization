public class MyQuickSort
{

    // NOTE: THE COMMENTED PRINTING LINES ARE FOR DEBUGGING PURPOSES

    public void print_array(int[] array)
    {
        for (int i=0; i<array.length-1; i++)
        {
            //System.out.print(array[i]+",");
        }
        //System.out.print(array[array.length-1]);
        //System.out.println();
    }

    public int ascending_partition(int[] a, int lb, int ub)
    {
        // we will make our first element as pivot
        int pivot = a[lb];
        //System.out.println("Pivot element is "+pivot);
        // i and j will be lb and ub
        int i = lb + 1;
        int j = ub;

        while (i < j)
        {
            if (a[i] <= pivot)
            {
                i += 1; // we will put all smaller element of pivot to its left
            } else
            {
                int istop = a[i];  // we found something bigger, now lets move j
                //System.out.println("i stopping at " + i + " : value of " + istop);

                if (a[j] > pivot)
                {
                    j -= 1; // move all bigger elements to the right of pivot
                } else
                {
                    // we found something smaller
                    int jstop = a[j];
                    //System.out.println("j stopping at " + j + " : value of " + jstop);

                    //let's swap the values now
                    //System.out.println("Swapping " + istop + " with " + jstop);
                    a[i] = jstop;
                    a[j] = istop;
                    i += 1;
                    j -= 1;
                }
            }

        }

        // check if our stopping point is indeed smaller than pivot, if not we gotta move 1 to the left
        // this may happen if i and j crossed one more after the termination of the while loop
        int stop_position=i;
        if (a[i]>=pivot)
        {
            stop_position=i-1;
        }

        int stop_element=a[stop_position];
        // lets swap pivot with stop element
        //System.out.println("Swapping pivot <"+pivot+"> with stop element <"+stop_element+">");
        a[lb]=stop_element;
        a[stop_position]=pivot;

        //print_array(a);

        return stop_position;
    }


    public int [] ascending_quick_sort(int[] a, int lb, int ub)
    {
        if (lb<ub)
        {
            //System.out.println("lb "+lb+" is less than "+ub);
            int stop_position=ascending_partition(a,lb,ub);
            a=ascending_quick_sort(a,lb,stop_position);
            a=ascending_quick_sort(a,stop_position+1,ub);
        }

        else
        {
            //System.out.println("lb "+lb+" is NOT LESS than "+ub);
            //System.out.println("Stopping condition reached");
        }

        //System.out.println("Final sorted list");
        //print_array(a);

        return a;
    }




    //-------------------------------------------------//

    //-------------DESCENDING MIRROR COPY--------------//

    //-------------------------------------------------//

    public int descending_partition(int[] a, int lb, int ub)
    {
        // we will make our first element as pivot
        int pivot = a[lb];
        //System.out.println("Pivot element is "+pivot);
        // i and j will be lb and ub
        int i = lb + 1;
        int j = ub;

        while (i < j)
        {
            if (a[i] >= pivot)
            {
                i += 1; // we will put all smaller element of pivot to its left
            } else
            {
                int istop = a[i];  // we found something bigger, now lets move j
                //System.out.println("i stopping at " + i + " : value of " + istop);

                if (a[j] < pivot)
                {
                    j -= 1; // move all bigger elements to the right of pivot
                } else
                {
                    // we found something smaller
                    int jstop = a[j];
                    //System.out.println("j stopping at " + j + " : value of " + jstop);

                    //let's swap the values now
                    //System.out.println("Swapping " + istop + " with " + jstop);
                    a[i] = jstop;
                    a[j] = istop;
                    i += 1;
                    j -= 1;
                }
            }

        }

        // check if our stopping point is indeed BIGGER than pivot, if not we gotta move 1 to the left
        // this may happen if i and j crossed one more after the termination of the while loop
        int stop_position=i;
        if (a[i]<=pivot)
        {
            stop_position=i-1;
        }

        int stop_element=a[stop_position];
        // lets swap pivot with stop element
        //System.out.println("Swapping pivot <"+pivot+"> with stop element <"+stop_element+">");
        a[lb]=stop_element;
        a[stop_position]=pivot;

        //print_array(a);

        return stop_position;
    }


    public int [] descending_quick_sort(int[] a, int lb, int ub)
    {
        if (lb<ub)
        {
            //System.out.println("lb "+lb+" is less than "+ub);
            int stop_position=descending_partition(a,lb,ub);
            a=descending_quick_sort(a,lb,stop_position);
            a=descending_quick_sort(a,stop_position+1,ub);
        }

        else
        {
            //System.out.println("lb "+lb+" is NOT LESS than "+ub);
            //System.out.println("Stopping condition reached");
        }

        //System.out.println("Final sorted list");
        //print_array(a);

        return a;
    }



}
