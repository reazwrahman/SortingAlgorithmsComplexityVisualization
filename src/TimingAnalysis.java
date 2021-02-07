
    // ------------------------------------------------------------------ //

    // Test Plan: for each sorting algorithm,
    //      a) we will apply 4 different types of lists from the internal
    //          RandomArrayGenerator class
    //      b) for each of the 4 lists we will step up the size
    //          by an increment of 100 (10,110,210 etc.)
    //            b.1) the four lists themselves will be 10 apart, so that we don't
    //                  have multiple data points in one place
    //      Example:
    //      Cycle 1
    //      Mergesort (Random list of size 10)
    //      Mergesort (ascending consecutive list of size 20)
    //      Mergesort (descending consecutive list of size 30)
    //      Mergesort (repetitive list of size 40)
    //
    //      Cycle 2:
    //      Mergesort( ... size 100)
    //      Mergesort ( ... size 110)
    //      Mergesort ( ... size 130)
    //      Mergesort (... size 140);
    //
    //
    //      c) we will store the results into three text files,
    //          one for each algorithm
    //      d) we will write a program in Python to
    //          automate the graphing from text files
    // ------------------------------------------------------------------ //
public class TimingAnalysis
{
    public long quick_sort_timer_unit(int[] random_list)
    {
        MyQuickSort quickSort = new MyQuickSort();
        long start_time = System.nanoTime();
        quickSort.ascending_quick_sort(random_list,0, random_list.length-1);
        long end_time = System.nanoTime();
        long duration = end_time - start_time;

        return duration;
    }

    public long merge_sort_timer_unit(int[] random_list)
    {
        MyMergeSort mergeSort = new MyMergeSort();
        long start_time = System.nanoTime();
        mergeSort.ascending_merge_sort(random_list);
        long end_time = System.nanoTime();
        long duration = end_time - start_time;

        return duration;
    }

    public long insertion_sort_timer_unit(int[] random_list)
    {
        MyInsertionSort insertion= new MyInsertionSort();
        long start_time=System.nanoTime();
        insertion.ascending_sort(random_list);
        long end_time=System.nanoTime();
        long duration= end_time-start_time;

        return duration;
    }


    public void insertion_sort_cycle(int start,int end)
    {
        RandomArrayGenerator rag= new RandomArrayGenerator();
        //initialize a text file for logging results
        FileReadWrite logger= new FileReadWrite();
        String logfile= "insertionsort_timing_logger.txt";
        logger.writer(logfile,"Size, Time(ns)");
        logger.appender(logfile,System.getProperty("line.separator"));

        for (int i=start;i<=end+100;i+=100)
        {
            long duration1=insertion_sort_timer_unit(rag.random_list_generator(i));
            System.out.println("Size: "+i+", Time(ns): "+duration1);
            logger.appender(logfile,i+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration2=merge_sort_timer_unit(rag.consecutive_ascending_list_generator(i+10));
            System.out.println("Size: "+(i+10)+", Time(ns): "+duration2);
            logger.appender(logfile,(i+10)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration3=merge_sort_timer_unit(rag.consecutive_descending_list_generator(i+20));
            System.out.println("Size: "+(i+20)+", Time(ns): "+duration3);
            logger.appender(logfile,(i+20)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration4=merge_sort_timer_unit(rag.repetitive_list_generator(i+30));
            System.out.println("Size: "+(i+30)+", Time(ns): "+duration4);
            logger.appender(logfile,(i+30)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));
        }
    }


    public void merge_sort_cycle(int start,int end)
    {
        RandomArrayGenerator rag= new RandomArrayGenerator();
        //initialize a text file for logging results
        FileReadWrite logger= new FileReadWrite();
        String logfile= "mergesort_timing_logger.txt";
        logger.writer(logfile,"Size, Time(ns)");
        logger.appender(logfile,System.getProperty("line.separator"));

        for (int i=start;i<=end+100;i+=100)
        {
            long duration1=merge_sort_timer_unit(rag.random_list_generator(i));
            System.out.println("Size: "+i+", Time(ns): "+duration1);
            logger.appender(logfile,i+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration2=merge_sort_timer_unit(rag.consecutive_ascending_list_generator(i+10));
            System.out.println("Size: "+(i+10)+", Time(ns): "+duration2);
            logger.appender(logfile,(i+10)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration3=merge_sort_timer_unit(rag.consecutive_descending_list_generator(i+20));
            System.out.println("Size: "+(i+20)+", Time(ns): "+duration3);
            logger.appender(logfile,(i+20)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration4=merge_sort_timer_unit(rag.repetitive_list_generator(i+30));
            System.out.println("Size: "+(i+30)+", Time(ns): "+duration4);
            logger.appender(logfile,(i+30)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));
        }
    }

    public void quick_sort_cycle(int start,int end)
    {
        RandomArrayGenerator rag= new RandomArrayGenerator();
        //initialize a text file for logging results
        FileReadWrite logger= new FileReadWrite();
        String logfile= "quicksort_timing_logger.txt";
        logger.writer(logfile,"Size, Time(ns)");
        logger.appender(logfile,System.getProperty("line.separator"));

        for (int i=start;i<=end+100;i+=100)
        {
            long duration1=quick_sort_timer_unit(rag.random_list_generator(i));
            System.out.println("Size: "+i+", Time(ns): "+duration1);
            logger.appender(logfile,i+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration2=merge_sort_timer_unit(rag.consecutive_ascending_list_generator(i+10));
            System.out.println("Size: "+(i+10)+", Time(ns): "+duration2);
            logger.appender(logfile,(i+10)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration3=merge_sort_timer_unit(rag.consecutive_descending_list_generator(i+20));
            System.out.println("Size: "+(i+20)+", Time(ns): "+duration3);
            logger.appender(logfile,(i+20)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));

            long duration4=merge_sort_timer_unit(rag.repetitive_list_generator(i+30));
            System.out.println("Size: "+(i+30)+", Time(ns): "+duration4);
            logger.appender(logfile,(i+30)+","+duration1);
            logger.appender(logfile,System.getProperty("line.separator"));
        }
    }
}
