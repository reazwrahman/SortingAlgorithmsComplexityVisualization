import java.util.Arrays;

public class MyMergeSort
{

    // NOTE: THE COMMENTED PRINTING LINES ARE FOR DEBUGGING PURPOSES

    public int[] ascending_merge_sort(int [] a)
    {
        //System.out.println("merge function called");
        int midpoint=(int) a.length/2;
        int [] left= Arrays.copyOfRange(a,0,midpoint);
        int [] right= Arrays.copyOfRange(a,midpoint,a.length);

        //System.out.println("left array");
        //print_array(left);
        //System.out.println("right array");
        //print_array(right);

        if (left.length!=1 || right.length!=1)
        {
            //System.out.println("calling merge again");
            if (left.length!=1)
            {
                left = ascending_merge_sort(left);
            }
            if (right.length!=1)
            {
                right = ascending_merge_sort(right);
            }

            a=ascending_sort(left,right);
        }

        else
        {
            //System.out.println("reached stopping condition");
            a=ascending_sort(left,right);
            //print_array(a);
        }



        //System.out.println("Finished merge function");
        //print_array(a);
        return a;
    }

    int [] ascending_sort(int [] left, int[] right)
    {
        //System.out.println("--------------------------------"+"Entering Sort");


        //System.out.println("comparing left =");
        //print_array(left);
        //System.out.println("comparing right =");
        //print_array(right);

        // initialize the result array to put the sorted list
        int[] result = new int[left.length + right.length];

        // find the upper bound between the left and right
        int limit = 0;
        if (left.length > right.length)
        {
            limit = left.length;
        } else
        {
            limit = right.length;
        }

        // start the comparisons
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < limit)
        {
            //System.out.println("i is at" + i);
            while (j < limit)
            {
                //System.out.println("j is at" + j);
                //System.out.println("checking if "+left[i]+"is less than "+right[j]);
                if (left[i] <= right[j])
                {
                    result[k] = left[i];
                    k += 1;
                    i += 1;
                    //print_array(result);
                }

                // check if we have reached the end of left,
                // if so, dump the rest of the other guy into result
                if (i == left.length)
                {
                    //System.out.println("i reached limit at "+i);
                    // begin dumping
                    while (j < right.length)
                    {
                        result[k] = right[j];
                        j += 1;
                        k += 1;
                    }
                    //print_array(result);
                    i=limit;
                    j=limit;
                    break;
                }

                //System.out.println("checking if "+right[j]+"is less than "+left[i]);
                if (right[j] < left[i])
                {
                    result[k] = right[j];
                    j += 1;
                    k += 1;
                    //print_array(result);
                }

                // check if we have reached the end of either right,
                // if so, dump the rest of the other guy into result
                if (j == right.length)
                {
                    //System.out.println("j reached limit at "+j);
                    //begin dumping
                    while (i < left.length)
                    {
                        result[k] = left[i];
                        i += 1;
                        k += 1;
                    }
                    //print_array(result);
                    i=limit;
                    j=limit;
                    break;
                }
            }
        }

        //print_array(result);
        //System.out.println("--------------------------------"+"Exiting Sort");
        return result;
    }

    public static void print_array(int[] array)
    {
        for (int i=0; i<array.length-1; i++)
        {
            //System.out.print(array[i]+",");
        }
        //System.out.print(array[array.length-1]);
        //System.out.println();
    }


    // --------------- DESCENDING MIRROR COPY -------------------



    public int[] descending_merge_sort(int [] a)
    {
        //System.out.println("merge function called");
        int midpoint=(int) a.length/2;
        int [] left= Arrays.copyOfRange(a,0,midpoint);
        int [] right= Arrays.copyOfRange(a,midpoint,a.length);

        //System.out.println("left array");
        //print_array(left);
        //System.out.println("right array");
        //print_array(right);

        if (left.length!=1 || right.length!=1)
        {
            //System.out.println("calling merge again");
            if (left.length!=1)
            {
                left = descending_merge_sort(left);
            }
            if (right.length!=1)
            {
                right = descending_merge_sort(right);
            }

            a=descending_sort(left,right);
        }

        else
        {
            //System.out.println("reached stopping condition");
            a=descending_sort(left,right);
            //print_array(a);
        }



        //System.out.println("Finished merge function");
        //print_array(a);
        return a;
    }

    int [] descending_sort(int [] left, int[] right)
    {
        //System.out.println("--------------------------------"+"Entering Sort");


        //System.out.println("comparing left =");
        //print_array(left);
        //System.out.println("comparing right =");
        //print_array(right);

        // initialize the result array to put the sorted list
        int[] result = new int[left.length + right.length];

        // find the upper bound between the left and right
        int limit = 0;
        if (left.length > right.length)
        {
            limit = left.length;
        } else
        {
            limit = right.length;
        }

        // start the comparisons
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < limit)
        {
            //System.out.println("i is at" + i);
            while (j < limit)
            {
                //System.out.println("j is at" + j);
                //System.out.println("checking if "+left[i]+"is less than "+right[j]);
                if (left[i] >= right[j])
                {
                    result[k] = left[i];
                    k += 1;
                    i += 1;
                    //print_array(result);
                }

                // check if we have reached the end of left,
                // if so, dump the rest of the other guy into result
                if (i == left.length)
                {
                    //System.out.println("i reached limit at "+i);
                    // begin dumping
                    while (j < right.length)
                    {
                        result[k] = right[j];
                        j += 1;
                        k += 1;
                    }
                    //print_array(result);
                    i=limit;
                    j=limit;
                    break;
                }

                //System.out.println("checking if "+right[j]+"is less than "+left[i]);
                if (right[j] > left[i])
                {
                    result[k] = right[j];
                    j += 1;
                    k += 1;
                    //print_array(result);
                }

                // check if we have reached the end of right,
                // if so, dump the rest of the other guy into result
                if (j == right.length)
                {
                    //System.out.println("j reached limit at "+j);
                    //begin dumping
                    while (i < left.length)
                    {
                        result[k] = left[i];
                        i += 1;
                        k += 1;
                    }
                    //print_array(result);
                    i=limit;
                    j=limit;
                    break;
                }
            }
        }

        //print_array(result);
        //System.out.println("--------------------------------"+"Exiting Sort");
        return result;
    }


}
