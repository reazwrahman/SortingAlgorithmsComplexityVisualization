import java.util.Random;

public class RandomArrayGenerator
{

     public int[] random_list_generator(int size)
     {
          int [] random_list = new int[size];
          Random random= new Random();
          for (int i=0; i<size;i++)
          {
               random_list[i]=random.nextInt();
          }

          return random_list;
     }

     public int[] consecutive_ascending_list_generator(int size)
     {
          int [] list= new int[size];
          for (int i=0; i<size;i++)
          {
               list[i]=i;
          }
          return list;

     }

     public int[] consecutive_descending_list_generator(int size)
     {
          int [] list= new int[size];
          for (int i=0; i<size;i++)
          {
               list[i]=size-i-1;
          }
          return list;
     }

     public int[] repetitive_list_generator(int size)
     {
          int[] random_list = new int[size];
          Random random = new Random();
          for (int i = 0; i < size; i++)
          {
               random_list[i] = random.nextInt(9);
          }
          return random_list;
     }
}
