package Ad_Hoc;

import java.util.Scanner;

public class Ad_Hoc
{

    public static int[] create_array_int(Scanner sc) {
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int created_arr[] = new int[n];
        System.out.println("Enter elements");
        for (int iterator_i = 0; iterator_i < n; iterator_i++)
            created_arr[iterator_i] = sc.nextInt();
        return created_arr;
    }

    /*******************************************************************************************************************
     *Q1. Kadane's Algorithm for Largest Sum Contiguous SubArray
     ******************************************************************************************************************/

    public static int KadaneLargestSum(int[] input_arr)
    {
        int max_till_now=0,current_max=0;
        for(int iterator_i=1;iterator_i<input_arr.length;iterator_i++)
        {
            current_max += input_arr[iterator_i]-input_arr[iterator_i-1];
            current_max = Math.max(current_max,0);
            max_till_now = Math.max(max_till_now,current_max);
        }
        return max_till_now;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // Runner for Q1
        System.out.println("Kadane's Algorithm");
        int input_arr[] = create_array_int(sc);
        System.out.println("Largest Sum is:"+KadaneLargestSum(input_arr));
    }
}
