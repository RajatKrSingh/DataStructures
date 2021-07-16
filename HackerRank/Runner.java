package HackerRank;

import LeetCode.LeetCode;
import com.sun.deploy.util.ArrayUtil;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import LeetCode.LeetCode.*;

public class Runner
{
    // Complete the equal function below.
    static int equal(int[] arr) {

        int min_element = Arrays.stream(arr).min().getAsInt();
        /* Offset of minimum element and operations offset is as follows
            1 -> 1 operation (-1)
            2 -> 1 operation (-2)
            3 -> 2 operations (-2 -1)
            4 -> 2 operations (-2 -2)
            >=5 -> not needed since equal operations(array size) will be done
         */
        int offset_operations[] = {0,0,0,0,0};
        for(int iterator_min_offset = 0;iterator_min_offset<5;iterator_min_offset++)
        {
            for(int array_ele: arr) // Loop over all array elements
            {
                int curr_ele_diff = array_ele - min_element + iterator_min_offset;
                offset_operations[iterator_min_offset] += curr_ele_diff/5 + (curr_ele_diff%5)/2 + (curr_ele_diff%5)%2;
            }
            System.out.println(offset_operations[iterator_min_offset]);
        }
        return Arrays.stream(offset_operations).min().getAsInt();
    }

    static ArrayList<Integer>[] createAdjacencyList(int[][] edges)
    {
        int vertices = edges.length+1;
        ArrayList<Integer> adjacency_list[] = new ArrayList[vertices+1];
        for(int iterator_i=1;iterator_i<adjacency_list.length;iterator_i++)
            adjacency_list[iterator_i] = new ArrayList<>();
        for(int iterator_i=0;iterator_i<vertices-1;iterator_i++)
        {
            adjacency_list[edges[iterator_i][0]].add(edges[iterator_i][1]);
            adjacency_list[edges[iterator_i][1]].add(edges[iterator_i][0]);
        }
        return adjacency_list;
    }

    static void dfs_default_parent(int current_vertex,int current_root,int[] parent, ArrayList<Integer>[] adjacency_list)
    {
        parent[current_vertex] = current_root;
        for(Integer connected_vertex:adjacency_list[current_vertex])
        {
            if(parent[connected_vertex] == 0)
                dfs_default_parent(connected_vertex,current_vertex,parent,adjacency_list);
        }
    }

    static int calculateWinningStates(int k,int[] correct_guesses,int correct_guesses_till_parent,int current_vertex,ArrayList<Integer>[] adjacency_list, boolean[] visited)
    {
        int total_winning_states=0;
        int current_correct_guesses = correct_guesses_till_parent + correct_guesses[current_vertex];
        visited[current_vertex] = true;
        for(Integer connected_vertex:adjacency_list[current_vertex])
        {
            if(!visited[connected_vertex])
                total_winning_states += calculateWinningStates(k,correct_guesses,current_correct_guesses,connected_vertex,adjacency_list,visited);
        }
        return total_winning_states + ((current_correct_guesses>=k)?1:0);
    }

    static int gcd(int a,int b)
    {
        if(a%b==0) return b;
        return gcd(b,a%b);
    }

    static int computeCorrectGuesses(int k,int[][] guesses,int[] parent,int current_guesses_parent,ArrayList<Integer>[] adjacency_list)
    {
        int correct_guesses[] = new int[parent.length],root=1;
        for(int iterator_i=0;iterator_i<guesses.length;iterator_i++)
        {
            if(guesses[iterator_i][0] == parent[guesses[iterator_i][1]])
            {
                correct_guesses[root]++;
                correct_guesses[guesses[iterator_i][1]]--;
            }
            else
                correct_guesses[guesses[iterator_i][0]]++;
        }

        return calculateWinningStates(k,correct_guesses,0,root,adjacency_list,new boolean[parent.length]);

    }

    static String storyOfATree(int n, int[][] edges, int k, int[][] guesses)
    {
        // Adjacency list is not mutally compatible since u->v and v->u are both represented
        // Consistency check done using boolean visited array
        ArrayList<Integer>[] adjacency_list = createAdjacencyList(edges);

        // Set Parent of each vertex
        int parent[] = new int[n+1], root = 1;
        dfs_default_parent(root,-1,parent,adjacency_list);

        int win_total = computeCorrectGuesses(k,guesses,parent,0,adjacency_list);

        //Convert to fraction
        int gcd = gcd(win_total,n);

        return (win_total/gcd) +"/"+ (n/gcd) ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {

//        System.out.println("Enter array length and array");
//        LeetCode obj = new LeetCode();
//        int arr[] = obj.create_array_int(scanner);
//        System.out.println(equal(arr));

        System.out.println("Enter n");
        int n = scanner.nextInt();
        int edges[][] = new int[n-1][2];
        for (int iterator_i = 0; iterator_i < n-1; iterator_i++)
        {
            edges[iterator_i][0] = scanner.nextInt();
            edges[iterator_i][1] = scanner.nextInt();
        }
        System.out.println("Enter g and k");
        int g = scanner.nextInt(), k = scanner.nextInt();
        int guesses[][] = new int[g][2];
        for(int iterator_i=0;iterator_i<g;iterator_i++)
        {
            guesses[iterator_i][0] = scanner.nextInt();
            guesses[iterator_i][1] = scanner.nextInt();
        }
        System.out.println(storyOfATree(n,edges,k,guesses));
    }
}
