
public class Main
{


    // a simple unit test (tested against bubble sort) to check whether my code
    // for the three algorithms are working as expected
    public static void unit_test_for_sortAlgorithms()
    {
        RandomArrayGenerator rag= new RandomArrayGenerator();
        int [] array= rag.repetitive_list_generator(100);

        SortingUnitTestDriver sortingUnitTestDriver = new SortingUnitTestDriver();

        sortingUnitTestDriver.insertion_sort_test_driver(array);
        sortingUnitTestDriver.merge_sort_test_driver(array);
        sortingUnitTestDriver.quick_sort_test_drive(array);
    }


    public static void timing_analysis_central(int start, int end)
    {
        TimingAnalysis timingAnalysis = new TimingAnalysis();

        timingAnalysis.insertion_sort_cycle(start,end);
        timingAnalysis.merge_sort_cycle(start,end);
        timingAnalysis.quick_sort_cycle(start,end);
    }

    public static void main(String[] args)
    {

        unit_test_for_sortAlgorithms();
        timing_analysis_central(10,10000);


    }


}



