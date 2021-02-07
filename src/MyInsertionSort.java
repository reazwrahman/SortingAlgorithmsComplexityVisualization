public class MyInsertionSort
{
    public int[] ascending_sort(int[] a)
    {
        int i=1;
        int j;

        while (i<a.length)
        {
            int current=a[i];
            j=i-1;
            while (j>=0)
            {
                if (current<a[j])
                {
                    a[j+1]=a[j]; //create a copy of it
                    j-=1;
                }
                else
                {
                    break;
                }
            }
            // at the end of the while loop put current in its proper position
            a[j+1]=current;
            i+=1;
        }

        return a;
    }


    public int[] descending_sort(int[] a)
    {
        int i=1;
        int j;

        while (i<a.length)
        {
            int current=a[i];
            j=i-1;
            while (j>=0)
            {
                if (current>a[j])
                {
                    a[j+1]=a[j]; //create a copy of it
                    j-=1;
                }
                else
                {
                    break;
                }
            }
            // at the end of the while loop put current in its proper position
            a[j+1]=current;
            i+=1;
        }

        return a;
    }
}
