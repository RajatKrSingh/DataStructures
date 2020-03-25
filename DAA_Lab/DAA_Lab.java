package DAA_Lab;
import DS_Lab.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
public class DAA_Lab {

    static int efficiency_count = 0;
    /*******************************************************************************************************************
     DAA LAB Week 2 : Fundamentals of algorithmic problem solving
     Ques 1: Implement GCD using Euclid's algorithm
     Ques 2: Implement GCD using consecutive integer checking algorithm
     Ques 3: Implement GD using middle school procedure
     Ques 4: Compute sq_root(n)using only basic operations
     Ques 5: Implement tower of hanoi(DS lab W3.Q7)
     Ques 6: Calculate primes using Sieve of Eratosthenes
     Ques 7: Compute nth Fibonacci number recursively (DS lab W3.Q3)
     ******************************************************************************************************************/

    public static int compute_gcd_euclid(int m, int n) {
        efficiency_count++;// for each comparison
        if (n == 0)
            return m;
        else if (m == 0)
            return -1;
        if (m > n) {
            return compute_gcd_euclid(n, m % n);
        }
        return compute_gcd_euclid(m, n % m);
    }

    public static int compute_gcd_conseccheck(int m, int n) {
        int iterator_i = Math.min(m, n);
        while (iterator_i > 1)
        {
            efficiency_count++; //Each mod operation is a basic operation. Therefore either 1 or 2 depending on condition satisfied
            if (m % iterator_i == 0 && n % iterator_i == 0)
                return iterator_i;
            iterator_i--;
        }
        return iterator_i;
    }

    public static int compute_gcd_mschool(int m, int n) {
        HashMap<Integer, Integer> primeMap = new HashMap<>();
        int iterator_i = 2, gcd_product = 1;
        while (m != 1) {
            while (m % iterator_i == 0) {
                if (primeMap.containsKey(iterator_i))
                    primeMap.put(iterator_i, primeMap.get(iterator_i) + 1);
                else
                    primeMap.put(iterator_i, 1);
                m /= iterator_i;
            }
            iterator_i++;
        }
        iterator_i = 2;
        while (n != 1) {
            while (n % iterator_i == 0) {
                if (primeMap.containsKey(iterator_i) && primeMap.get(iterator_i) > 0) {
                    gcd_product *= iterator_i;
                    primeMap.put(iterator_i, primeMap.get(iterator_i) - 1);
                }
                n /= iterator_i;
            }
            iterator_i++;
        }

        return gcd_product;
    }

    public static int sq_root(int input_val) {
        for (int iterator_i = 1; iterator_i <= (int) (input_val / 2); iterator_i++) {
            if (iterator_i * iterator_i <= input_val && (iterator_i + 1) * (iterator_i + 1) > input_val)
                return iterator_i;
        }
        return Integer.MIN_VALUE;
    }

    public static void sieve_eratosthenes(int n) {
        int prime_arr[] = new int[n + 1];
        for (int iterator_i = 1; iterator_i <= n; iterator_i++) {
            prime_arr[iterator_i] = 1;
        }
        for (int iterator_i = 2; iterator_i < n; iterator_i++) {
            int counter_val = 2;
            while (iterator_i * counter_val <= n) {
                prime_arr[iterator_i * counter_val] = 0;
                counter_val++;
            }
        }

        for (int iterator_i = 1; iterator_i <= n; iterator_i++) {
            if (prime_arr[iterator_i] == 1)
                System.out.print(iterator_i + " ");
        }
    }

    /*******************************************************************************************************************
     DAA LAB Week 3 : Brute Force techniques
     Ques 1: Sort using Bubble Sort
     Ques 2: Sort using selection sort
     Ques 3: Return first occurrence of string using brute force string matching
     ******************************************************************************************************************/

    public static int[] create_array_int(Scanner sc) {
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int created_arr[] = new int[n];
        System.out.println("Enter elements");
        for (int iterator_i = 0; iterator_i < n; iterator_i++)
            created_arr[iterator_i] = sc.nextInt();
        return created_arr;
    }

    public static int[] bubble_sort(int input_arr[]) {
        for (int iterator_i = 0; iterator_i < input_arr.length; iterator_i++) {
            for (int iterator_j = 0; iterator_j < input_arr.length - iterator_i - 1; iterator_j++) {
                if (input_arr[iterator_j] > input_arr[iterator_j + 1]) {
                    int temp = input_arr[iterator_j];
                    input_arr[iterator_j] = input_arr[iterator_j + 1];
                    input_arr[iterator_j + 1] = temp;
                }
            }
        }
        return input_arr;
    }

    public static int[] selection_sort(int input_arr[])
    {
        for(int iterator_i=0;iterator_i<input_arr.length;iterator_i++)
        {
            int min_pos = iterator_i;
            for(int iterator_j=iterator_i+1;iterator_j<input_arr.length;iterator_j++)
            {
                if(input_arr[min_pos]>input_arr[iterator_j])
                    min_pos = iterator_j;
            }
            int temp = input_arr[min_pos];
            input_arr[min_pos] = input_arr[iterator_i];
            input_arr[iterator_i] = temp;
        }
        return input_arr;
    }

    public static void display_array_int(int input_arr[])
    {
        for(int iterator_i=0;iterator_i<input_arr.length;iterator_i++)
            System.out.print(input_arr[iterator_i]+" ");
        System.out.println();
    }

    public static int brute_force_string_match(String input_str, String input_pattern)
    {
        for(int iterator_i=0;iterator_i<=input_str.length()-input_pattern.length();iterator_i++)
        {
            int iterator_j;
            for(iterator_j=0;iterator_j<input_pattern.length();iterator_j++)
            {
                if(input_str.charAt(iterator_j+iterator_i) != input_pattern.charAt(iterator_j))
                    break;
            }
            if(iterator_j==input_pattern.length())
                return iterator_i+1;
        }
        return -1;
    }

    /*******************************************************************************************************************
     DAA LAB Week 4 : Divide and Conquer
     Ques 1: Merge Sort
     Ques 2: Quick Sort
     Ques 3: Binary Search
    ******************************************************************************************************************/
    public static int binary_search(int arr[], int srch_ele)
    {
        int lb=0,ub=arr.length-1,mid;
        while(lb<=ub)
        {
            mid = (lb+ub)/2;
            if(arr[mid] == srch_ele)
                return mid+1;
            else if(arr[mid] > srch_ele)
                ub = mid - 1;
            else
                lb = mid + 1;
        }
        return -1;
    }

    public static int[] merge(int A_arr[], int B_arr[])
    {
        int A_index=0, B_index=0;
        int C_arr[] = new int[A_arr.length+B_arr.length];
        while(A_index<A_arr.length && B_index < B_arr.length)
        {
            if(A_arr[A_index]<B_arr[B_index])
                C_arr[A_index+B_index] = A_arr[A_index++];
            else
                C_arr[A_index+B_index] = B_arr[B_index++];
        }
        while(A_index<A_arr.length)   // can be replaced by simple for loop
            C_arr[A_index+B_index] = A_arr[A_index++];
        while(B_index<B_arr.length)
            C_arr[A_index+B_index] = B_arr[B_index++];
        return C_arr;
    }


    public static int[] mergeSort(int arr[])
    {
        while(arr.length > 1)
        {
            int A_arr[] = new int[(int)Math.ceil(arr.length/2)], B_arr[] = new int[(int)(arr.length- Math.ceil(arr.length/2))];
            for(int iterator_i=0; iterator_i < (int)Math.ceil(arr.length/2); iterator_i++)
                A_arr[iterator_i] = arr[iterator_i];
            for(int iterator_i=0; iterator_i < (int)(arr.length- Math.ceil(arr.length/2)); iterator_i++)
                B_arr[iterator_i] = arr[iterator_i + (int)(Math.ceil(arr.length/2))];
            A_arr = mergeSort(A_arr);
            B_arr = mergeSort(B_arr);
            return merge(A_arr,B_arr);
        }
        return arr;
    }

    public static int quickPartition(int arr[], int lb, int ub)
    {
        int pivot_index = lb;
        lb++;
        while(lb<=ub)
        {
            if(arr[pivot_index]>arr[lb])
                lb++;
            else if(arr[pivot_index]<=arr[ub])
                ub--;
            else
            {
                int temp = arr[lb];
                arr[lb] = arr[ub];
                arr[ub] = temp;
            }
        }
        int temp = arr[ub];
        arr[ub] = arr[pivot_index];
        arr[pivot_index] = temp;
        return ub;
    }

    public static int[] quickSort(int arr[],int lb, int ub)
    {
        if(lb<ub)
        {
            int split_position = quickPartition(arr, lb, ub);
            quickSort(arr, lb, split_position-1);
            quickSort(arr,split_position+1,ub);
        }
        return arr;
    }

    /*******************************************************************************************************************
     DAA LAB Week 5 : Decrease and Conquer
     Ques 1: Insertion Sort
     Ques 2: DFS Traversal(Iterative)
     Ques 3: Topological Sorting(Not degree-oriented)
     Ques 4: BFS Traversal
    ******************************************************************************************************************/

    public static int[] insertion_sort(int input_arr[])
    {
        for(int iterator_i = 1; iterator_i<input_arr.length;iterator_i++)
        {
            int current_val = input_arr[iterator_i];
            int iterator_j = iterator_i-1;
            while(iterator_j>=0 && current_val<input_arr[iterator_j])
            {
                efficiency_count++;
                input_arr[iterator_j+1] = input_arr[iterator_j];
                iterator_j--;
            }
            input_arr[iterator_j+1] = current_val;
        }
        return input_arr;
    }

    public static void stack_push(Stack stck,int stck_element)
    {
        if(stck.top == stck.max_top - 1 )
        {
            System.out.println("Stack overflow\n");
            return;
        }
        stck.arr[++(stck.top)] = stck_element;
    }

    public static void initialize_stack(Stack stck)
    {
        stck.top = -1;
        stck.arr = new int[stck.max_top + 1];
        stck.carr = new char[stck.max_top + 1];
        stck.darr = new double[stck.max_top + 1];
        stck.sarr = new String[stck.max_top + 1];
    }

    public static int stack_pop(Stack stck)
    {
        if(stck.top == -1)
        {
            System.out.println("Stack underflow\n");
            return -1;
        }
        stck.top--;
        return stck.arr[stck.top+1];
    }

    public static Graph create_graph(Scanner sc)
    {
        Graph return_graph = new Graph();
        System.out.println("Enter no.of vertices");
        return_graph.vertices = sc.nextInt();
        System.out.println("Enter no. of edges");
        return_graph.edges = sc.nextInt();
        return_graph.graph_matrix = new int[return_graph.vertices][return_graph.vertices];
        return_graph.visited = new boolean[return_graph.vertices];
        System.out.println("Enter edge start and end");
        for(int iterator_i=0; iterator_i<return_graph.edges; iterator_i++)
            return_graph.graph_matrix[sc.nextInt()-1][sc.nextInt()-1] = 1;
        return return_graph;
    }

    public static void dfs_traversal(Graph input_graph, int[] popped_order, int[] push_order)
    {
        int push_index = 1, pop_index = 1;
        Stack temp_stack = new Stack();
        initialize_stack(temp_stack);
        for(int iterator_i=0; iterator_i<input_graph.vertices; iterator_i++)
        {
            if(!input_graph.visited[iterator_i])
            {
                stack_push(temp_stack, iterator_i);
                push_order[iterator_i] = push_index++;
                input_graph.visited[iterator_i] = true;

                while (temp_stack.top > -1)
                {
                    int current_ele = stack_pop(temp_stack);
                    popped_order[current_ele] = pop_index++;
                    System.out.print((current_ele+1)+" ");
                    for(int iterator_j=input_graph.vertices-1; iterator_j>=0; iterator_j--)
                    {
                        if(!input_graph.visited[iterator_j] && input_graph.graph_matrix[current_ele][iterator_j]==1)
                        {
                            stack_push(temp_stack,iterator_j);
                            input_graph.visited[iterator_j] = true;
                            push_order[iterator_j] = push_index++;
                        }
                    }
                }
            }
        }
        System.out.println("\nPush Order is ");
        for(int iterator_i = 0; iterator_i<input_graph.vertices;iterator_i++)
            System.out.print(push_order[iterator_i]+" ");

        System.out.println("\nPop Order is ");
        for(int iterator_i = 0; iterator_i<input_graph.vertices;iterator_i++)
            System.out.print(popped_order[iterator_i]+" ");


    }


    public static void topological_sorting(Graph input_graph, int current_vertex)
    {
        input_graph.visited[current_vertex] = true;
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            if(!input_graph.visited[iterator_i] && input_graph.graph_matrix[current_vertex][iterator_i]==1)
            {
                topological_sorting(input_graph,iterator_i);
            }
        }
        System.out.print((current_vertex+1)+" ");
    }

    public static void initialize_queue(Queue q_instance)
    {
        q_instance.arr = new int[q_instance.max_length + 1];
        q_instance.sarr = new String[q_instance.max_length + 1];
        q_instance.front = -1;
        q_instance.rear = -1;
    }

    public static void enqueue_right(Queue input_q,int input)  // Basic Queue Operation
    {
        if(input_q.rear == -1 && input_q.front == -1)
        {
            input_q.rear = input_q.front = 0;
            input_q.arr[input_q.rear] = input;
            return;
        }
        else if(input_q.rear == input_q.max_length - 1 )
        {
            System.out.println("Queue Overflow");
            return;
        }
        input_q.arr[++(input_q.rear)] = input;
    }


    public static int dequeue_left(Queue input_q)
    {
        if(input_q.front == -1 || input_q.front>input_q.rear)
        {
            System.out.println("Queue Underflow");
            return Integer.MIN_VALUE;
        }
        int popped_ele = input_q.arr[input_q.front];
        input_q.front++;
        return popped_ele;
    }

    public static void bfs_traversal(Graph input_graph)
    {
        Queue bfs_q = new Queue();
        initialize_queue(bfs_q);

        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            enqueue_right(bfs_q, iterator_i);
            input_graph.visited[iterator_i] = true;
            while(bfs_q.front != -1 || bfs_q.front<=bfs_q.rear)
            {
                int current_ele = dequeue_left(bfs_q);
                for(int iterator_j=0; iterator_j<input_graph.vertices; iterator_j++)
                {
                    if (!input_graph.visited[iterator_j] && input_graph.graph_matrix[current_ele][iterator_j]==1)
                    {
                        enqueue_right(bfs_q, iterator_j);
                        input_graph.visited[iterator_j] = true;
                    }
                }

            }
        }

    }


    /*******************************************************************************************************************
     DAA LAB Week 6 : Transform and Conquer -- works ONLY FOR DAG
     Ques 1: Topological Sort(Already covered)
     Ques 2: AVL trees
     ******************************************************************************************************************/

    public static void dfs_topological_sort(int src_node, Graph input_graph, Stack pop_order )
    {
        input_graph.visited[src_node] = true;
        for(int iterator_i=0; iterator_i<input_graph.vertices; iterator_i++)
        {
            if(input_graph.graph_matrix[src_node][iterator_i]==1 && !input_graph.visited[iterator_i])
                dfs_topological_sort(iterator_i,input_graph, pop_order);
        }
        stack_push(pop_order,src_node);
    }

    public static void topological_sorting_6(Graph input_graph)
    {
        Stack pop_order = new Stack();
        initialize_stack(pop_order);
        for(int iterator_i=0; iterator_i<input_graph.vertices; iterator_i++)
        {
            if(!input_graph.visited[iterator_i])
                dfs_topological_sort(iterator_i, input_graph,pop_order);
        }
        System.out.println("Topological Sort is");
        while(pop_order.top != -1)
            System.out.print(stack_pop( pop_order)+1+" ");

    }

    public static int getTreeHeight(AVL_Tree input_tree)
    {
        if(input_tree == null)
            return 0;
        return 1 + Math.max(getTreeHeight(input_tree.lchild),getTreeHeight(input_tree.rchild));
    }

    public static AVL_Tree refreshTreeHeights(AVL_Tree input_tree)
    {
        if(input_tree==null)
            return input_tree;
        input_tree.height = getTreeHeight(input_tree);
        input_tree.lchild = refreshTreeHeights(input_tree.lchild);
        input_tree.rchild = refreshTreeHeights(input_tree.rchild);

        return input_tree;
    }

    public static AVL_Tree LL_transform(AVL_Tree input_node)
    {
        return  Right_rotate(input_node);
    }


    public static AVL_Tree LR_transform(AVL_Tree input_node)
    {
        // L rotation
        input_node.lchild = Left_rotate(input_node.lchild);
        System.out.println();
        inorder_display_tree(input_node);
        System.out.println();
        // R rotation
        return Right_rotate(input_node);
    }

    public static AVL_Tree RR_transform(AVL_Tree input_node)
    {
        return Left_rotate(input_node);
    }

    public static AVL_Tree RL_transform(AVL_Tree input_node)
    {
        // R rotation
        input_node.rchild = Right_rotate(input_node.rchild);
        // L rotation
        return Left_rotate(input_node);
    }

    public static AVL_Tree Left_rotate(AVL_Tree input_node)
    {
        AVL_Tree return_node = input_node.rchild, T1 = input_node.rchild.lchild;
        input_node.rchild.lchild = input_node;
        input_node.rchild = T1;

        // Rebalance Tree
        return return_node;
    }

    public static AVL_Tree Right_rotate(AVL_Tree input_node)
    {
        AVL_Tree return_node = input_node.lchild, T1 = input_node.lchild.rchild;
        input_node.lchild.rchild = input_node;
        input_node.lchild = T1;

        // Rebalance Tree
        return return_node;
    }


    public static AVL_Tree get_last_unbalanced_node(AVL_Tree input_tree,int insert_value)
    {
        AVL_Tree unbalanced_node = null;
        while(input_tree != null )
        {
            if(input_tree.value<=insert_value ) {
                if(input_tree.rchild!=null && Math.abs(input_tree.rchild.height - (input_tree.lchild==null ? 0: input_tree.lchild.height)) >=2)
                    unbalanced_node = input_tree;
                input_tree = input_tree.rchild;
            }
            else if(input_tree.value>insert_value ) {
                if(input_tree.lchild!=null && Math.abs((input_tree.rchild==null ? 0: input_tree.rchild.height) - input_tree.lchild.height) >=2)
                {
                    unbalanced_node = input_tree;
                    System.out.println(unbalanced_node.value + " "+unbalanced_node.lchild.height + " P" + (input_tree.rchild == null ? 0 : input_tree.rchild.height));
                    if(input_tree.rchild!=null)
                        System.out.println("U"+input_tree.rchild.value);
                }
                input_tree = input_tree.lchild;
            }
        }
        return unbalanced_node;
    }

    public static AVL_Tree insert_avl(AVL_Tree input_tree,int insert_value)
    {
        if(input_tree == null)
        {
            input_tree = new AVL_Tree();
            input_tree.value = insert_value;
            input_tree.height = 1;
            return input_tree;
        }
        AVL_Tree input_tree_cpy = input_tree;
        AVL_Tree prev_node =null;

        // Insert Node using BST logic
        while(input_tree_cpy != null)
        {
            prev_node = input_tree_cpy;
            if(input_tree_cpy.value<insert_value) {
                input_tree_cpy = input_tree_cpy.rchild;
            }
            else
            {
                input_tree_cpy = input_tree_cpy.lchild;
            }
        }
        AVL_Tree insert_node = new AVL_Tree();
        insert_node.value = insert_value;
        insert_node.height = 1;
        if(prev_node.value<insert_value)
            prev_node.rchild = insert_node;
        else
            prev_node.lchild = insert_node;

        // Rebalance heights
        input_tree = refreshTreeHeights(input_tree);

        // Debugging Check
        inorder_display_tree(input_tree);
        System.out.println();
        // Get x , y and z node

        AVL_Tree z_node = get_last_unbalanced_node(input_tree,insert_value);
        if(z_node != null)
            System.out.println("Unbalanced:"+z_node.value);
        AVL_Tree y_node = null, x_node = null;

        if(z_node == null)   // Return
            return input_tree;
        if(z_node.value>insert_value)
            y_node = z_node.lchild;
        else
            y_node = z_node.rchild;

        if(y_node == null)   // Return
            return input_tree;

        if(y_node.value>insert_value)
            x_node = y_node.lchild;
        else
            x_node = y_node.rchild;

        if(x_node == null) // return
            return input_tree;

        // Get z prev value
        input_tree_cpy = input_tree;
        prev_node = null;

        // AVL Transformation code
        while(z_node.value != input_tree_cpy.value)
        {
            prev_node = input_tree_cpy;
            if(input_tree_cpy.value<=z_node.value)
                input_tree_cpy = input_tree_cpy.rchild;
            else
                input_tree_cpy = input_tree_cpy.lchild;
        }

        // Check for the condition satisfied:- LL, LR, RR, RL
        if(y_node == z_node.lchild && x_node == y_node.lchild) // LL
        {
            System.out.println("LL Rotation");
            if(prev_node == null)
                input_tree = LL_transform(z_node);
            else if(prev_node.lchild == z_node)
                prev_node.lchild = LL_transform(z_node);
            else
                prev_node.rchild = LL_transform(z_node);
        }
        else if(y_node == z_node.lchild && x_node == y_node.rchild) //LR
        {
            System.out.println("LR Rotation");
            if(prev_node == null)
                input_tree = LR_transform(z_node);
            else if(prev_node.lchild == z_node)
                prev_node.lchild = LR_transform(z_node);
            else
                prev_node.rchild = LR_transform(z_node);
        }
        else if(y_node == z_node.rchild && x_node == y_node.rchild) // RR
        {
            System.out.println("RR Rotation");
            if(prev_node == null)
                input_tree = RR_transform(z_node);
            else if(prev_node.lchild == z_node)
                prev_node.lchild = RR_transform(z_node);
            else
                prev_node.rchild = RR_transform(z_node);
        }
        else if(y_node == z_node.rchild && x_node == y_node.lchild) // RL
        {
            System.out.println("RL Rotation");
            if(prev_node == null)
                input_tree = RL_transform(z_node);
            else if(prev_node.lchild == z_node)
                prev_node.lchild = RL_transform(z_node);
            else
                prev_node.rchild = RL_transform(z_node);
        }
        input_tree =  refreshTreeHeights(input_tree);
        return input_tree;
    }

    public static AVL_Tree create_avl_tree(Scanner sc)
    {
        System.out.println("Enter values. Enter -1 to exit");
        int insert_value;
        AVL_Tree tree = null ;
        do{
            System.out.println("\nEnter value:  ");
            insert_value = sc.nextInt();
            if(insert_value != -1)
                tree =insert_avl(tree,insert_value);
            inorder_display_tree(tree);
        }while(insert_value!=-1);

        return tree;
    }

    public static void inorder_display_tree(AVL_Tree input_tree)
    {
        if(input_tree==null)
            return;
        inorder_display_tree(input_tree.lchild);
        System.out.print(input_tree.value+","+input_tree.height+" ");
        inorder_display_tree(input_tree.rchild);

    }


    /*******************************************************************************************************************
     DAA LAB Week 7 : Transform and Conquer
     Ques 1: 2-3 trees
     Ques 2: Max Heap (Similar ogic for min heap)
     Ques 3: Heap Sort (Similar to heap construction)
     ******************************************************************************************************************/

    public static void heapify(int input_arr[],int position)
    {
        int swap_index = -1;
        if(input_arr.length > 2*(position+1))
            swap_index =  (input_arr[2*(position+1)]< input_arr[2*(position+1)-1])? 2*(position+1)-1 : 2*(position+1);
        else
            swap_index = 2*(position+1) - 1;
        if(swap_index>0 && input_arr[swap_index] > input_arr[position])
        {
            int temp = input_arr[swap_index];
            input_arr[swap_index] = input_arr[position];
            input_arr[position] = temp;
        }
        if(input_arr.length >= (swap_index+1)*2 && input_arr[2*(swap_index+1)-1] > input_arr[swap_index])
            heapify(input_arr,swap_index);
        else if(input_arr.length > (swap_index+1)*2 && input_arr[2*(swap_index+1)] > input_arr[swap_index])
            heapify(input_arr,swap_index);
    }

    public static void create_max_heap(int input_arr[])
    {
        for(int iterator_i=(int)(Math.floor(input_arr.length/2.0) - 1); iterator_i>=0; iterator_i--)
            heapify(input_arr,iterator_i);
    }


    /*******************************************************************************************************************
     DAA LAB Week 8 : Space and Time Tradeoffs
     Ques 1: Horspool Algorithm(Shift Table)
     Ques 2: Boyer-Moore Algorithm(Bad Suffix Table)
     Ques 3: Open Hash Table
     Ques 4: Closed Hash Table
     Ques 5: Sort using comparison counting
     ******************************************************************************************************************/

    public static int[] create_shift_table(String input_pattern)
    {
        int shift_table[] = new int[150];
        for(int iterator_i=0; iterator_i<150; iterator_i++)
            shift_table[iterator_i] = input_pattern.length();

        for(int iterator_i=0; iterator_i<input_pattern.length()-1; iterator_i++)
            shift_table[input_pattern.charAt(iterator_i)] = input_pattern.length() - 1 - iterator_i;

        return shift_table;
    }


    public static int Horspool(String input_str,String input_pattern)
    {
        int shift_table[] = create_shift_table(input_pattern);
        int iterator_str = input_pattern.length()-1;
        while(iterator_str<input_str.length())
        {
            int iterator_pattern = input_pattern.length()-1;
            while(iterator_pattern>=0 && input_str.charAt(iterator_str-(input_pattern.length()-iterator_pattern-1)) == input_pattern.charAt(iterator_pattern))
                iterator_pattern--;
            if(iterator_pattern<0)
                return iterator_str-input_pattern.length()+2;
            iterator_str += shift_table[input_str.charAt(iterator_str-(input_pattern.length()-iterator_pattern-1))];
        }
        return -1;
    }

    public static int[] create_bad_character_table(String input_pattern)
    {
        int bad_character_table[] = new int[150];
        for(int iterator_i=0; iterator_i<150;iterator_i++)
            bad_character_table[iterator_i] = input_pattern.length();
        for(int iterator_i=0; iterator_i<input_pattern.length(); iterator_i++)
            bad_character_table[iterator_i] = input_pattern.length() - 1 - iterator_i;
        return bad_character_table;
    }

    public static int[] create_good_suffix_table(String input_pattern)
    {
        int good_suffix_table[] = new int[input_pattern.length()-1];
        for(int iterator_k=0; iterator_k< input_pattern.length()-1; iterator_k++)
        {
            String pattern_k = input_pattern.substring(input_pattern.length()-1-iterator_k);
            int iterator_j = 0, iterator_i=0, iterator_i2=0;
            for(iterator_i=input_pattern.length()-1; iterator_i>=0; iterator_i--)
            {
                iterator_j=0;
                for(iterator_i2=iterator_i; iterator_i2 >=0; iterator_i2--)
                {
                    if (iterator_j == pattern_k.length() || pattern_k.charAt(pattern_k.length() - 1 - iterator_j) != input_pattern.charAt(iterator_i2))
                        break;
                    iterator_j++;
                }
                if(iterator_i2<0 || (iterator_j == pattern_k.length() && iterator_i != input_pattern.length()-1))
                {
                    good_suffix_table[iterator_k] = input_pattern.length()  - iterator_i -1;
                    break;
                }
            }
        }
        return good_suffix_table;
    }

    /*
    Slide Value expression:-
        d =     d1              if k=0,
                max{d1,d 2}     if k>0,
    */
    public static int Boyer_Moore(String input_str, String input_pattern)
    {
        int bad_character_table[] = create_bad_character_table(input_pattern);
        int good_suffix_table[] = create_good_suffix_table(input_pattern);

        int iterator_str=0, iterator_pattern=0;
        while(iterator_str<input_str.length())
        {
            iterator_pattern=0;
            while(iterator_pattern < input_pattern.length())
            {
                if(input_str.charAt(iterator_str+input_pattern.length()-iterator_pattern-1) !=  input_pattern.charAt(input_pattern.length()-1-iterator_pattern))
                {
                    iterator_str += Math.max(bad_character_table[input_str.charAt(input_pattern.length() - iterator_pattern - 1)], (iterator_pattern == 0 ? -1 : good_suffix_table[iterator_pattern - 1]));
                    break;
                }
                iterator_pattern++;
            }
            if(iterator_pattern == input_pattern.length())
                return iterator_str;

        }

        return -1;
    }

    public static void insertOpenHash(ListNode[] hash_table, int insert_value)
    {
        ListNode insertion_node = hash_table[insert_value%hash_table.length];
        if(insertion_node == null)
        {
            hash_table[insert_value%hash_table.length] = new ListNode(insert_value);
            return;
        }
        while(insertion_node.next != null)
            insertion_node = insertion_node.next;
        ListNode temp_node = new ListNode(insert_value);
        insertion_node.next = temp_node;
    }

    public static void displayOpenHashTable(ListNode[] hash_table)
    {
        for(int iterator_i=0; iterator_i< hash_table.length; iterator_i++)
        {
            ListNode current_bucket = hash_table[iterator_i];
            System.out.print(iterator_i+":  ");
            while(current_bucket!=null)
            {
                System.out.print(current_bucket.val+" ");
                current_bucket = current_bucket.next;
            }
            System.out.println();
        }
    }

    public static int deleteOpenhash(ListNode[] hash_table,int delete_value)
    {
        ListNode deletion_bucket = hash_table[delete_value%hash_table.length];
        if(deletion_bucket==null)
            return -1;
        ListNode previous_node=null;
        while(deletion_bucket!=null && deletion_bucket.val!=delete_value)
        {
            previous_node = deletion_bucket;
            deletion_bucket = deletion_bucket.next;
        }
        if(deletion_bucket!=null && deletion_bucket.val == delete_value)
        {
            if(previous_node == null)
                hash_table[delete_value%hash_table.length] = deletion_bucket.next;
            else
                previous_node.next = deletion_bucket.next;
            return 1;
        }
        return -1;
    }


    public static ListNode[] createOpenHashTable(int hash_parameter, Scanner sc)
    {
        ListNode hash_table[] = new ListNode[hash_parameter];
        for(int iterator_i=0; iterator_i<hash_parameter; iterator_i++)
            hash_table[iterator_i] = null;
        while(true)
        {
            System.out.println("1. Insert 2. Delete 3. Display ");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter number");
                    insertOpenHash(hash_table, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter deletion number");
                    if(deleteOpenhash(hash_table,sc.nextInt())== -1)
                        System.out.println("Delete Failed");
                    break;
                case 3:
                    displayOpenHashTable(hash_table);
                    break;
                default:
                    return hash_table;
            }
        }
    }

    public static void insertClosedHash(int[] hash_table,int[] deletion_flag, int insertion_value)
    {
        int insertion_index = insertion_value%hash_table.length,counter = 0;

        while(counter < hash_table.length && deletion_flag[(insertion_index+counter)%hash_table.length]==1)
            counter++;
        if(counter < hash_table.length)
        {
            deletion_flag[(insertion_index+counter)%hash_table.length] = 1;
            hash_table[(insertion_index+counter)%hash_table.length] = insertion_value;
        }
        else
            System.out.println("hash Table Overflow");
    }

    public static void displayClosedHashTable(int[] hash_table, int[] deletion_flag)
    {
        for(int iterator_i=0; iterator_i<hash_table.length; iterator_i++)
        {
            System.out.print(iterator_i+": ");
            System.out.println(deletion_flag[iterator_i]==0 ? "X":hash_table[iterator_i]);
        }
    }

    public static int deleteClosedhash(int[] hash_table, int[] deletion_flag,int deletion_value)
    {
        int deletion_index = deletion_value%hash_table.length,counter=0;
        while(counter<hash_table.length && hash_table[(deletion_index+counter)%hash_table.length]!=deletion_value)
            counter++;
        if(counter <hash_table.length)
        {
            deletion_flag[(deletion_index + counter)%hash_table.length] = 0;
            return 0;
        }

        return -1;
    }

    public static int[] createClosedHashTable(int hash_parameter,Scanner sc)
    {
        int hash_table[] = new int[hash_parameter];
        int deletion_flag[] = new int[hash_parameter]; //0 if deleted
        while(true)
        {
            System.out.println("1. Insert 2. Delete 3. Display ");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter number");
                    insertClosedHash(hash_table, deletion_flag, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter deletion number");
                    if(deleteClosedhash(hash_table, deletion_flag,sc.nextInt())== -1)
                        System.out.println("Delete Failed");
                    break;
                case 3:
                    displayClosedHashTable(hash_table,deletion_flag);
                    break;
                default:
                    return hash_table;
            }
        }
    }

    public static int[] comparisonCountSorting(int[] input_arr)
    {
        int count[] = new int[input_arr.length];
        int result_arr[] = new int[input_arr.length];
        for(int iterator_i=0; iterator_i<input_arr.length-1; iterator_i++)
        {
            for(int iterator_j=iterator_i+1; iterator_j<input_arr.length; iterator_j++)
            {
                if(input_arr[iterator_i]>=input_arr[iterator_j])
                    count[iterator_i]++;
                else
                    count[iterator_j]++;
            }
        }
        for(int iterator_i=0; iterator_i<input_arr.length;iterator_i++)
            result_arr[count[iterator_i]] = input_arr[iterator_i];
        return result_arr;
    }

    /*******************************************************************************************************************
     DAA LAB Week 9 : Dynamic Programming
     Ques 1:  Floyd’s algorithm for the All-Pairs- Shortest-Paths problem
     Ques 2: Warshall Algorithm
     ******************************************************************************************************************/

    public static Graph create_graph_distance(Scanner sc)
    {
        Graph return_graph = new Graph();
        System.out.println("Enter no.of vertices");
        return_graph.vertices = sc.nextInt();
        System.out.println("Enter no. of edges");
        return_graph.edges = sc.nextInt();
        return_graph.graph_matrix = new int[return_graph.vertices][return_graph.vertices];
        for(int iterator_i=0;iterator_i<return_graph.vertices;iterator_i++)
        {
            for (int iterator_j = 0; iterator_j < return_graph.vertices; iterator_j++)
                return_graph.graph_matrix[iterator_i][iterator_j] = Integer.MAX_VALUE;
            return_graph.graph_matrix[iterator_i][iterator_i] = 0;
        }
        return_graph.visited = new boolean[return_graph.vertices];
        System.out.println("Enter edge start ,end and distance");
        for(int iterator_i=0; iterator_i<return_graph.edges; iterator_i++)
            return_graph.graph_matrix[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();
        return return_graph;
    }

    public static int[][] FloydShortestPairs(Graph input_graph)
    {
        int distance_matrix[][] = input_graph.graph_matrix;
        for(int iterator_k=0;iterator_k<input_graph.vertices;iterator_k++)
        {
            for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
            {
                for(int iterator_j=0; iterator_j<input_graph.vertices; iterator_j++)
                {
                    if(distance_matrix[iterator_i][iterator_k] != Integer.MAX_VALUE && distance_matrix[iterator_k][iterator_j]!=Integer.MAX_VALUE &&
                            (distance_matrix[iterator_i][iterator_k] + distance_matrix[iterator_k][iterator_j] < distance_matrix[iterator_i][iterator_j]))
                        distance_matrix[iterator_i][iterator_j] = distance_matrix[iterator_i][iterator_k] + distance_matrix[iterator_k][iterator_j];
                }
            }

        }
        return distance_matrix;
    }


    public static int[][] WarshallTransitiveClosure(Graph input_graph)
    {
        int transitive_closure[][] = input_graph.graph_matrix;
        for(int iterator_k=0; iterator_k<input_graph.vertices; iterator_k++)
        {
            for(int iterator_i=0; iterator_i<input_graph.vertices; iterator_i++)
            {
                for(int iterator_j=0; iterator_j<input_graph.vertices;iterator_j++)
                    transitive_closure[iterator_i][iterator_j] =  (transitive_closure[iterator_i][iterator_k]==1 && transitive_closure[iterator_k][iterator_j]==1)? 1:transitive_closure[iterator_i][iterator_j];
            }
        }
        return transitive_closure;
    }

    /*******************************************************************************************************************
     DAA LAB Week 10 : Greedy Technique
     Ques 1: Minimum Cost Spanning Tree using Prim's algorithm
     Ques 2: Minimum Cost Spanning Tree using Kruskal's algorithm(quick find)
     Ques 3: Minimum Cost Spanning Tree using Kruskal's algorithm(quick union)
     Ques 4: Shortest path using Dijkstra algo
     Ques 5: Huffman Tree
     ******************************************************************************************************************/

    public static void AdjustVertexDistance(int[] vertex_distance ,int[] vertex_connection ,int new_vertex, Graph input_graph)
    {
        for(int iterator_i=0; iterator_i<vertex_distance.length;iterator_i++)
        {
            if(vertex_distance[iterator_i] > input_graph.graph_matrix[new_vertex][iterator_i] )
            {
                vertex_distance[iterator_i] = input_graph.graph_matrix[new_vertex][iterator_i];
                vertex_connection[iterator_i] = new_vertex;
            }
        }
    }

    public static int[][] PrimMST(Graph input_graph)
    {
        int edge_counter =0, added_vertex=0;
        int mst_edges[][] = new int[input_graph.vertices][2]; // u v
        int visited[] = new int[input_graph.vertices];
        visited[0] = 1;
        int remaining_vertex_distance[] = new int[input_graph.vertices];
        for(int iterator_i=0; iterator_i<input_graph.vertices; iterator_i++)
            remaining_vertex_distance[iterator_i] = Integer.MAX_VALUE;
        int remaining_vertex_connection[] = new int[input_graph.vertices];

        for(int iterator_i=1;iterator_i<input_graph.vertices;iterator_i++)
        {
            AdjustVertexDistance(remaining_vertex_distance,remaining_vertex_connection,added_vertex,input_graph);
            int min_index=-1;
            for(int iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
            {
                if(visited[iterator_j]!=1 && (min_index<0 || remaining_vertex_distance[iterator_j] < remaining_vertex_distance[min_index]))
                        min_index = iterator_j;
            }
            visited[min_index] = 1;
            mst_edges[edge_counter][0] = remaining_vertex_connection[min_index];
            mst_edges[edge_counter++][1] = min_index;
            added_vertex = min_index;
        }
        return mst_edges;
    }

    public static int findSet(ListNode[] input_sets, int find_vertex)
    {
        for(int iterator_i=0;iterator_i<input_sets.length;iterator_i++)
        {
            ListNode current_node = input_sets[iterator_i];
            while(current_node!=null)
            {
                if(current_node.val==find_vertex)
                    return iterator_i;
                current_node = current_node.next;
            }
        }
        return -1;
    }

    public static void unionSet(ListNode[] inputSets, int unionSet1, int unionSet2)
    {
        ListNode tempSet1 = inputSets[unionSet1];
        while(tempSet1.next!=null)
            tempSet1 = tempSet1.next;
        tempSet1.next = inputSets[unionSet2];
        inputSets[unionSet2] = null;
    }

    public static int[][] getEdges(Graph input_graph)
    {
        int edges[][] = new int[input_graph.edges][3],edge_counter=0;
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
            {
                if(input_graph.graph_matrix[iterator_i][iterator_j]!=Integer.MAX_VALUE && input_graph.graph_matrix[iterator_i][iterator_j]!=0)
                {
                    edges[edge_counter][0] = iterator_i;
                    edges[edge_counter][1] = iterator_j;
                    edges[edge_counter++][2] = input_graph.graph_matrix[iterator_i][iterator_j];
                }
            }
        }
        // Sort in non increasing order
        for(int iterator_i=0;iterator_i<input_graph.edges-1;iterator_i++)
        {
            int min_pos = iterator_i;
            for(int iterator_j=iterator_i+1;iterator_j<input_graph.edges;iterator_j++)
            {
                if(edges[iterator_j][2]<edges[min_pos][2])
                    min_pos = iterator_j;
            }
            int temp[] = edges[min_pos];
            edges[min_pos] = edges[iterator_i];
            edges[iterator_i] = temp;
        }
        return edges;
    }

    public static int[][] KruskalMST(Graph input_graph)
    {
        int vertex_origin[] = new int[input_graph.vertices];
        ListNode disjointSets[] = new ListNode[input_graph.vertices];
        int edges[][] = getEdges(input_graph);
        int mst_edges[][] = new int[input_graph.vertices][2],edge_counter=0;

        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            disjointSets[iterator_i] = new ListNode(iterator_i);
            vertex_origin[iterator_i] = iterator_i;
        }
        for(int iterator_i=0;iterator_i<input_graph.edges;iterator_i++)
        {
            int findpos_u = findSet(disjointSets,edges[iterator_i][0]);
            int findpos_v = findSet(disjointSets,edges[iterator_i][1]);
            if(findpos_u!=findpos_v)
            {
                mst_edges[edge_counter][0] = edges[iterator_i][0];
                mst_edges[edge_counter++][1] = edges[iterator_i][1];
                unionSet(disjointSets, findpos_u, findpos_v);
                vertex_origin[edges[iterator_i][1]] = findpos_u;
            }
        }
        return mst_edges;
    }

    public static int getParent(int[] parent_arr, int vertex)
    {
        int current_parent = vertex;
        while(current_parent!= parent_arr[current_parent])
            current_parent = parent_arr[current_parent];
        return current_parent;
    }

    public static int[][] KruskalMSTU(Graph input_graph)
    {
        int parent_arr[] = new int[input_graph.vertices];
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
            parent_arr[iterator_i] = iterator_i;

        int edges[][] = getEdges(input_graph);
        int mst_edges[][] = new int[input_graph.vertices][2],edge_counter=0;

        for(int iterator_i=0;iterator_i<input_graph.edges;iterator_i++)
        {
            int parent_u = getParent(parent_arr,edges[iterator_i][0]); // find
            int parent_v = getParent(parent_arr,edges[iterator_i][1]);
            if(parent_u != parent_v)        // union
            {
                mst_edges[edge_counter][0] = edges[iterator_i][0];
                mst_edges[edge_counter++][1] = edges[iterator_i][1];
                parent_arr[parent_u] = parent_v;
            }
        }
        return mst_edges;
    }

    public static void upDateDijkstraDistance(int[] return_distance,int[] return_vertex,int added_vertex, Graph input_graph)
    {
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            if(input_graph.graph_matrix[added_vertex][iterator_i]!=Integer.MAX_VALUE && return_distance[added_vertex]!=Integer.MAX_VALUE && input_graph.graph_matrix[added_vertex][iterator_i]!=0 && return_distance[iterator_i]>input_graph.graph_matrix[added_vertex][iterator_i]+return_distance[added_vertex])
            {
                return_distance[iterator_i] = input_graph.graph_matrix[added_vertex][iterator_i]+return_distance[added_vertex];
                return_vertex[iterator_i] = added_vertex;
            }
        }
    }

    public static int[] DijkstraDistance(Graph input_graph)
    {
        int return_distance[] = new int[input_graph.vertices],added_vertex=0;
        int return_vertex[] = new int[input_graph.vertices], visited[] = new int[input_graph.vertices];

        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            return_distance[iterator_i] = Integer.MAX_VALUE;
            return_vertex[iterator_i] = iterator_i;
        }
        return_distance[0] = 0;
        for(int iterator_i=1; iterator_i<input_graph.vertices; iterator_i++)
        {
            int min_pos = 0;
            visited[added_vertex] = 1;
            upDateDijkstraDistance(return_distance,return_vertex,added_vertex,input_graph);
            for(int iterator_j=1;iterator_j<return_distance.length;iterator_j++)
            {
                if(visited[iterator_j]==0 && return_distance[min_pos]!=0 && return_distance[min_pos] > return_distance[iterator_j])
                    min_pos = iterator_j;
                else if(visited[iterator_j]==0 && return_distance[min_pos]==0)
                    min_pos = iterator_j;
            }
            added_vertex = min_pos;
        }
        return return_distance;
    }

    public static void sortHuffmanTrees(HuffmanTreeNode[] pattern_tree)
    {
        for(int iterator_i=0; iterator_i<pattern_tree.length-1;iterator_i++)
        {
            int min_pos=iterator_i;
            for(int iterator_j=iterator_i+1;iterator_j<pattern_tree.length;iterator_j++)
            {
                if( pattern_tree[iterator_j]!=null && pattern_tree[min_pos]!=null && pattern_tree[iterator_j].val < pattern_tree[min_pos].val)
                    min_pos = iterator_j;
                else if(pattern_tree[min_pos]==null && pattern_tree[iterator_j]!=null)
                    min_pos = iterator_j;
            }
            HuffmanTreeNode temp = pattern_tree[iterator_i];
            pattern_tree[iterator_i] = pattern_tree[min_pos];
            pattern_tree[min_pos] = temp;
        }
    }

    public static void HuffmanMerge(HuffmanTreeNode[] pattern_tree)
    {
        HuffmanTreeNode new_node = new HuffmanTreeNode();
        new_node.val = pattern_tree[0].val + pattern_tree[1].val;
        new_node.left = pattern_tree[0];
        new_node.right = pattern_tree[1];
        pattern_tree[0] = new_node;
        pattern_tree[1] = null;
        sortHuffmanTrees(pattern_tree);
    }

    public static void inorderHuffman(HuffmanTreeNode input_tree)
    {
        if(input_tree==null)
            return;
        inorderHuffman(input_tree.left);
        System.out.print(input_tree.val);
        if(input_tree.left==null && input_tree.right==null)
            System.out.print(input_tree.terminal_symbol);
        System.out.println();
        inorderHuffman(input_tree.right);
    }

    public static void printHuffmanCodes(HuffmanTreeNode input_tree,String current_code)
    {
        if(input_tree==null)
            return;
        printHuffmanCodes(input_tree.left,current_code+"0");
        if(input_tree.left==null && input_tree.right==null)
            System.out.println(input_tree.terminal_symbol + ": "+current_code);
        printHuffmanCodes(input_tree.right,current_code+"1");
    }

    public static void HuffmanEncoding(char[] symbols,float[] probabilities)
    {
        HuffmanTreeNode pattern_tree[] = new HuffmanTreeNode[symbols.length];
        for(int iterator_i=0;iterator_i<pattern_tree.length;iterator_i++)
        {
            pattern_tree[iterator_i] = new HuffmanTreeNode();
            pattern_tree[iterator_i].val = probabilities[iterator_i];
            pattern_tree[iterator_i].terminal_symbol = symbols[iterator_i];
        }
        // Sort Trees with probabilities
        sortHuffmanTrees(pattern_tree);

        for(int iterator_i=0;iterator_i<pattern_tree.length-1;iterator_i++)
            HuffmanMerge(pattern_tree);
        printHuffmanCodes(pattern_tree[0],"");
    }

    /*******************************************************************************************************************
     DAA LAB Week 11 : Backtracking
     Ques 1: N queens problem
     Ques 2: Hamiltonian circuit
     Ques 3: Find solution to subset-sum problem
     ******************************************************************************************************************/

    public static boolean isPromising(int[][] chess_board,int input_row,int input_col)
    {
        //Diagonal Check
        int current_row = input_row -1;
        for(int iterator_i=input_col-1;iterator_i>=0;iterator_i--)
        {
            if(current_row>=0 && chess_board[current_row][iterator_i]==1)
                return false;
            current_row--;
        }
        current_row = input_row -1;
        for(int iterator_i=input_col+1;iterator_i<chess_board[0].length;iterator_i++)
        {
            if(current_row>=0 && chess_board[current_row][iterator_i]==1)
                return false;
            current_row--;
        }

        //Row Check
        for(int iterator_i=0;iterator_i<input_row;iterator_i++)
        {
            if(chess_board[iterator_i][input_col]==1)
                return false;
            current_row--;
        }
        return true;
    }

    public static void printNQueens(int[][] chess_board)
    {
        System.out.print("Queen Configuration: ");
        for(int iterator_i=0;iterator_i<chess_board[0].length;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<chess_board[0].length;iterator_j++)
            {
                if (chess_board[iterator_i][iterator_j] == 1)
                    System.out.print(iterator_i + "," + iterator_j + "  ");
            }
        }
        System.out.println();
    }

    public static void placeQueenRows(int[][] chess_board,int input_row)
    {
        for(int iterator_i=0;iterator_i<chess_board[0].length;iterator_i++)
        {
            if(isPromising(chess_board,input_row,iterator_i))
            {
                chess_board[input_row][iterator_i] = 1;
                if(input_row==chess_board[0].length-1)
                {
                    printNQueens(chess_board);
                    chess_board[input_row][iterator_i]=0;
                    return;
                }
                placeQueenRows(chess_board,input_row+1);
                chess_board[input_row][iterator_i]=0;
            }
        }
    }


    public static void NQueens(int input_n)
    {
        int chess_board[][] = new int[input_n][input_n];
        placeQueenRows(chess_board,0);
    }

    public static void buildHamCircuit(Graph input_graph,int[] visited,int new_vertex,String edge_sequence)
    {
        visited[new_vertex] = 1;
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            //System.out.println(edge_sequence+" : "+new_vertex);
            int count_visited = 0;
            for(int iterator_j=0;iterator_j<visited.length;iterator_j++)
            {
                if(visited[iterator_j]==1)
                    count_visited++;
            }
            if(count_visited==visited.length)
            {
                if(input_graph.graph_matrix[new_vertex][0]==1)
                {
                    edge_sequence += "-0";
                    System.out.println("Hamiltonian Path:"+edge_sequence);
                    return;
                }
            }
            else if(input_graph.graph_matrix[new_vertex][iterator_i]==1 && visited[iterator_i]==0)
            {
                edge_sequence += "-"+iterator_i;
                buildHamCircuit(input_graph,visited,iterator_i,edge_sequence);
                visited[iterator_i] = 0;
                edge_sequence = edge_sequence.substring(0,edge_sequence.lastIndexOf('-'));
            }
        }
    }

    public static void HamiltonianCircuit(Graph input_graph)
    {
        int visited[] = new int[input_graph.vertices];
        buildHamCircuit(input_graph,visited,0,"0");
    }

    public static void printSolution(int[] set_arr,int[] visited)
    {
        System.out.print("Subset : ");
        for(int iterator_i=0;iterator_i<set_arr.length;iterator_i++)
        {
            if(visited[iterator_i]==1)
                System.out.print(set_arr[iterator_i]+" ");
        }
        System.out.println();
    }

    public static void SubsetSpaceGeneration(int[] set_arr,int sum,int current_sum, int array_index,int[] visited)
    {
        if(array_index>=set_arr.length)
            return;
        if(current_sum+set_arr[array_index]<sum)
        {
            visited[array_index] = 1;
            SubsetSpaceGeneration(set_arr, sum, current_sum + set_arr[array_index], array_index + 1,visited);
            visited[array_index] = 0;
        }
        else if(current_sum+set_arr[array_index]==sum)
        {
            visited[array_index] = 1;
            printSolution(set_arr, visited);
            visited[array_index] = 0;
        }
        SubsetSpaceGeneration(set_arr, sum, current_sum, array_index + 1,visited);
    }

    public static void SubsetSumBackTrack(int[] set_arr,int sum)
    {
        int visited[] = new int[set_arr.length];
        SubsetSpaceGeneration(set_arr,sum,0,0,visited);
    }

    /*******************************************************************************************************************
     DAA LAB Week 12 : Branch and Bound
     Ques 1: Assignment Problem  using best first search
     Ques 2: Knapsack Problem using Branch and Bound
     Ques 3: Traveling Salesman Problem
     ******************************************************************************************************************/

    public static boolean isPositionVisited(int[] alloc_position,int position)
    {
        for(int iterator_i=0;iterator_i<alloc_position.length;iterator_i++)
        {
            if(position==alloc_position[iterator_i])
                return true;
        }
        return false;
    }

    public static int AssignmentBound(int[][] assignment_matrix,int[] alloc_position)
    {
        int bound_value =0;
        for(int iterator_i=0;iterator_i<alloc_position.length;iterator_i++)
        {
            if(alloc_position[iterator_i]==-1)
            {
                int min_temp = Integer.MAX_VALUE;
                for(int iterator_j=0;iterator_j<alloc_position.length;iterator_j++)
                {
                    if(min_temp>assignment_matrix[iterator_i][iterator_j] && !isPositionVisited(alloc_position,iterator_j))
                        min_temp = assignment_matrix[iterator_i][iterator_j];
                }
                bound_value += min_temp;
            }
            else
                bound_value += assignment_matrix[iterator_i][alloc_position[iterator_i]];
        }
        return bound_value;
    }

    public static void enqueue_assignment(AssignmentQueue input_q, AssignmentNode new_node)// Priority
    {
        if(input_q.rear == -1 && input_q.front == -1)
        {
            input_q.rear = input_q.front = 0;
            input_q.assignment_space[input_q.rear] = new_node;
            return;
        }
        else if(input_q.rear == input_q.max_length - 1 )
        {
            System.out.println("Queue Overflow");
            return;
        }
        int current_index = input_q.rear+1;
        while(current_index>0 && input_q.assignment_space[current_index-1].bound>new_node.bound)
        {
            input_q.assignment_space[current_index] = input_q.assignment_space[current_index-1];
            current_index--;
        }
        input_q.assignment_space[current_index] = new_node;
        input_q.rear++;
        return;
    }

    public static boolean isJobInitial(int[] min_bound_pos)
    {
        int zero_count = 0;
        for(int iterator_i=0;iterator_i<min_bound_pos.length;iterator_i++)
        {
            if(min_bound_pos[iterator_i]==0)
                zero_count++;
        }
        if(zero_count>1)
            return true;
        return false;
    }

    public static int[] AssignmentStateSpaceNode(int[][] assignment_matrix,int[] alloc_position,int current_person,int current_min,int[] current_min_pos)
    {
        if(current_person == alloc_position.length)
        {
            int bound_min=0;
            for (int iterator_i = 0; iterator_i < alloc_position.length; iterator_i++)
                bound_min += assignment_matrix[iterator_i][alloc_position[iterator_i]];
            if(current_min>bound_min)
            {
                current_min = bound_min;
                current_min_pos = alloc_position;
            }
            return current_min_pos;
        }
        AssignmentQueue assignment_bfs_queue = new AssignmentQueue();
        assignment_bfs_queue.assignment_space = new AssignmentNode[assignment_bfs_queue.max_length + 1];
        assignment_bfs_queue.front = -1;
        assignment_bfs_queue.rear = -1;
        // Breadth First Exploration for current node
        for(int iterator_i=0;iterator_i<assignment_matrix[0].length;iterator_i++)
        {
            boolean isOccupied = false;
            for(int iterator_j=0;iterator_j<alloc_position.length;iterator_j++)
            {
                if(iterator_i==alloc_position[iterator_j])
                    isOccupied = true;
            }
            if(!isOccupied)
            {
                alloc_position[current_person] = iterator_i;
                if(AssignmentBound(assignment_matrix, alloc_position)<current_min)
                    enqueue_assignment(assignment_bfs_queue, new AssignmentNode(alloc_position, AssignmentBound(assignment_matrix, alloc_position), current_person + 1));
                alloc_position[current_person] = -1;
            }
        }
        while(assignment_bfs_queue.front<=assignment_bfs_queue.rear && assignment_bfs_queue.front!=-1)
        {
            AssignmentNode current_space = dequeue_assignment(assignment_bfs_queue);
            int[] min_bound_pos = AssignmentStateSpaceNode(assignment_matrix,current_space.assignment_position,current_space.current_position,current_min,current_min_pos);
            if(!isJobInitial(min_bound_pos))
            {
                int bound_min =0;
                for (int iterator_i = 0; iterator_i < min_bound_pos.length; iterator_i++)
                    bound_min += assignment_matrix[iterator_i][min_bound_pos[iterator_i]];
                if(current_min>bound_min)
                {
                    current_min = bound_min;
                    current_min_pos = min_bound_pos;
                }
            }
        }
        return current_min_pos;
    }

    public static AssignmentNode dequeue_assignment(AssignmentQueue input_q)
    {
        if(input_q.front == -1 || input_q.front>input_q.rear)
        {
            System.out.println("Queue Underflow");
            return null;
        }
        AssignmentNode popped_ele = input_q.assignment_space[input_q.front];
        input_q.front++;
        return popped_ele;
    }

    public static void AssignmentBranchBound(int[][] assignment_matrix)
    {
        int alloc_position[] = new int[assignment_matrix[0].length];
        for(int iterator_i=0;iterator_i<assignment_matrix[0].length;iterator_i++)
            alloc_position[iterator_i] = -1;
        int minimal_configuration[] = AssignmentStateSpaceNode(assignment_matrix,alloc_position,0,Integer.MAX_VALUE,new int[assignment_matrix[0].length]);
        int minimal_cost=0;
        for(int iterator_i=0;iterator_i<minimal_configuration.length;iterator_i++)
        {
            System.out.println("Worker " + iterator_i + "  Job " + minimal_configuration[iterator_i]);
            minimal_cost += assignment_matrix[iterator_i][minimal_configuration[iterator_i]];
        }
        System.out.println("Cost: "+minimal_cost);
    }

    public static void sortKnapsackItems(int[] value,int[] weight)
    {
        for(int iterator_i=0;iterator_i<value.length-1;iterator_i++)
        {
            int max_pos = iterator_i;
            for(int iterator_j=iterator_i+1;iterator_j<value.length;iterator_j++)
            {
                if(1.0*value[iterator_j]/weight[iterator_j] >= 1.0*value[max_pos]/weight[max_pos])
                    max_pos = iterator_j;
                int temp = value[max_pos];
                value[max_pos] = value[iterator_i];
                value[iterator_i] = temp;
                temp = weight[max_pos];
                weight[max_pos] = weight[iterator_i];
                weight[iterator_i] = temp;
            }
        }
    }

    public static double knapsackBound(int[] value,int[] weight,int[] inclusion_array,int capacity)
    {
        double current_value_total = 0, current_weight_total = 0;
        for(int iterator_i=0;iterator_i<value.length;iterator_i++)
        {
            if(inclusion_array[iterator_i]==1)
            {
                current_value_total += value[iterator_i];
                current_weight_total += weight[iterator_i];
            }
            else if(inclusion_array[iterator_i]==0)
            {
                return current_value_total + (value[iterator_i]/weight[iterator_i])*(capacity-current_weight_total);
            }
        }
        return current_value_total;
    }


    public static int[] knapsackBranchBoundSpace(int[] value,int[] weight,int[] inclusionArray,int current_item,int current_maximum, int[] current_max_position,int capacity)
    {
        int new_value = 0;
        for(int iterator_i=0;iterator_i<inclusionArray.length;iterator_i++)
        {
            if(inclusionArray[iterator_i]==1)
                new_value += value[iterator_i];
        }
        int curr_max=0;
        for(int iterator_i=0;iterator_i<inclusionArray.length;iterator_i++)
        {
            if(current_max_position[iterator_i]==1)
                curr_max += value[iterator_i];
        }
        if(curr_max<=new_value && current_item==inclusionArray.length)
        {
            current_maximum = curr_max;
            int inclusionArray_cpy[] = new int[inclusionArray.length];
            for(int iterator_i=0;iterator_i<inclusionArray.length;iterator_i++)
                inclusionArray_cpy[iterator_i] = inclusionArray[iterator_i];
            current_max_position = inclusionArray_cpy;
        }

        if(current_item==inclusionArray.length)
            return current_max_position;
        int current_weight=0;
        for(int iterator_i=0;iterator_i<value.length;iterator_i++)
        {
            if(inclusionArray[iterator_i]==1)
                current_weight += weight[iterator_i];
        }
        if(current_weight+weight[current_item]<=capacity)
        {
            inclusionArray[current_item] = 1;
            int inclusionArray_cpy[] = new int[inclusionArray.length];
            for(int iterator_i=0;iterator_i<inclusionArray.length;iterator_i++)
                inclusionArray_cpy[iterator_i] = inclusionArray[iterator_i];
            double current_bound = knapsackBound(value,weight,inclusionArray,capacity);
            if(current_bound<current_maximum)
                return current_max_position;
            int new_pos[] = knapsackBranchBoundSpace(value,weight,inclusionArray_cpy,current_item+1,current_maximum,current_max_position,capacity);
            int returned_value = 0;
            for(int iterator_j=0;iterator_j<new_pos.length;iterator_j++)
            {
                if(new_pos[iterator_j]==1)
                    returned_value += value[iterator_j];
            }
            if(returned_value>=current_maximum)
            {
                current_max_position = new_pos;
                current_maximum = returned_value;
            }
        }
        inclusionArray[current_item] = -1;
        int inclusionArray_cpy[] = new int[inclusionArray.length];
        for(int iterator_i=0;iterator_i<inclusionArray.length;iterator_i++)
            inclusionArray_cpy[iterator_i] = inclusionArray[iterator_i];
        double current_bound = knapsackBound(value,weight,inclusionArray,capacity);
        if(current_bound<current_maximum)
            return current_max_position;
        int new_pos[] = knapsackBranchBoundSpace(value,weight,inclusionArray_cpy,current_item+1,current_maximum,current_max_position,capacity);
        int returned_value = 0;
        for(int iterator_j=0;iterator_j<new_pos.length;iterator_j++)
        {
            if(new_pos[iterator_j]==1)
                returned_value += value[iterator_j];
        }
        if(returned_value>=current_maximum)
        {
            current_max_position = new_pos;
            current_maximum = returned_value;
        }
        return current_max_position;
    }

    public static void KnapsackBranchBound(int[] value,int[] weight,int capacity)
    {
        sortKnapsackItems(value,weight);
        int inclusionArray[] = new int[value.length];
        int max_position[] = knapsackBranchBoundSpace(value,weight,inclusionArray,0,Integer.MIN_VALUE,new int[value.length],capacity);
        int max_value =0;
        for(int iterator_i=0;iterator_i<max_position.length;iterator_i++)
        {
            if(max_position[iterator_i]==1)
            {
                System.out.print(value[iterator_i]+" ");
                max_value += value[iterator_i];
            }
        }
        System.out.println("Value: "+max_value);
    }

    public static int TravellingSalesmanBound(Graph input_graph,int[] edge_connection)
    {
        int bound=0;
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            int min1_index=-1,min2_index=-1;
            for(int iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
            {
                if((min1_index==-1 || input_graph.graph_matrix[iterator_i][iterator_j]<input_graph.graph_matrix[iterator_i][min1_index]) && input_graph.graph_matrix[iterator_i][iterator_j]!=0)
                {
                    if(min1_index!=-1 )
                        min2_index = min1_index;
                    min1_index = iterator_j;
                }
                else if((min2_index==-1 || input_graph.graph_matrix[iterator_i][iterator_j]<input_graph.graph_matrix[iterator_i][min2_index]) && input_graph.graph_matrix[iterator_i][iterator_j]!=0)
                    min2_index = iterator_j;
            }
            int iterator_j;
            for(iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
            {
                if(edge_connection[iterator_j]==iterator_i)
                        break;
            }
            if(iterator_j<input_graph.vertices && edge_connection[iterator_i]!=-1) // No edges
            {
                bound += input_graph.graph_matrix[iterator_i][iterator_j];
                bound += input_graph.graph_matrix[iterator_i][edge_connection[iterator_i]];
            }
            else if(edge_connection[iterator_i]!=-1)    // One Edge
            {
                bound += input_graph.graph_matrix[iterator_i][edge_connection[iterator_i]];
                if(min1_index!=edge_connection[iterator_i])
                    bound += input_graph.graph_matrix[iterator_i][min1_index];
                else
                    bound += input_graph.graph_matrix[iterator_i][min2_index];
            }
            else if(iterator_j<input_graph.vertices)    //One Edge
            {
                bound+= input_graph.graph_matrix[iterator_i][iterator_j] + (min1_index!=iterator_j?input_graph.graph_matrix[iterator_i][min1_index]:input_graph.graph_matrix[iterator_i][min2_index]);
            }
            else
                bound += input_graph.graph_matrix[iterator_i][min1_index] + input_graph.graph_matrix[iterator_i][min2_index];

        }
        return (int)Math.ceil(bound/2.0);
    }

    public static boolean isVerticesVisited(int[] edge_connection)
    {
        int count_negative=0;
        for(int iterator_i=0;iterator_i<edge_connection.length;iterator_i++)
        {
            if(edge_connection[iterator_i]==-1)
                count_negative++;
        }
        if(count_negative==0)
            return true;
        return false;
    }

    public static int getLastVisited(int[] edge_connection)
    {
        int final_vertex = 0;
        while(edge_connection[final_vertex]!=-1)
            final_vertex = edge_connection[final_vertex];
        return final_vertex;
    }

    public static int TravellingSalesmanDistance(Graph input_graph,int[] edge_connection)
    {
        int current_vertex=0,cost=0;
        while(edge_connection[current_vertex]!=-1 && edge_connection[current_vertex]!=0)
        {
            cost += input_graph.graph_matrix[current_vertex][edge_connection[current_vertex]];
            current_vertex = edge_connection[current_vertex];
        }
        if(edge_connection[current_vertex]==-1)
            return Integer.MAX_VALUE;

        return cost+input_graph.graph_matrix[current_vertex][0];
    }

    public static int[] TravellingSalesmanBranchBoundSpace(Graph input_graph,int[] edge_connection,int[] current_min_edge)
    {
        if(TravellingSalesmanBound(input_graph,edge_connection)>=TravellingSalesmanDistance(input_graph,current_min_edge))
            return current_min_edge;
        if(isVerticesVisited(edge_connection) && TravellingSalesmanBound(input_graph,edge_connection)<=TravellingSalesmanDistance(input_graph,current_min_edge))
            return Arrays.copyOf(edge_connection,edge_connection.length);

        int current_vertex=1;
        for(int iterator_i=0;iterator_i<edge_connection.length;iterator_i++)
        {
            if(edge_connection[iterator_i]!=-1)
                current_vertex++;
        }
        if(current_vertex==edge_connection.length)
        {
            int last_vertex = getLastVisited(edge_connection);
            int edge_connection_cpy[] = Arrays.copyOf(edge_connection,edge_connection.length);
            edge_connection_cpy[last_vertex] = 0;
            if(TravellingSalesmanDistance(input_graph,edge_connection_cpy)<TravellingSalesmanDistance(input_graph,current_min_edge))
                return Arrays.copyOf(edge_connection_cpy, edge_connection.length);
            else
                return Arrays.copyOf(current_min_edge, current_min_edge.length);
        }

        // Recursive Logic
        int lastVisited = getLastVisited(edge_connection);
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            int temp_vertex=0,iterator_j=0;
            //Check if vertex iterator_i visited
            while(temp_vertex!=-1 && iterator_j<input_graph.vertices)
            {
                iterator_j++;
                temp_vertex = edge_connection[temp_vertex];
                if(temp_vertex==iterator_i)
                    break;
            }
            if(iterator_i!=temp_vertex && edge_connection[iterator_i]==-1 && lastVisited!=iterator_i)
            {
                int edge_connection_cpy[] = Arrays.copyOf(edge_connection,edge_connection.length);
                edge_connection_cpy[lastVisited] = iterator_i;
                current_min_edge =TravellingSalesmanBranchBoundSpace(input_graph,edge_connection_cpy,current_min_edge);
            }
        }
        return Arrays.copyOf(current_min_edge,current_min_edge.length);
    }

    public static void TravellingSalesman(Graph input_graph)
    {
        int edge_connection[] = new int[input_graph.vertices];
        for(int iterator_i=0;iterator_i<edge_connection.length;iterator_i++)
            edge_connection[iterator_i] = -1;
        edge_connection = TravellingSalesmanBranchBoundSpace(input_graph, Arrays.copyOf(edge_connection,edge_connection.length),Arrays.copyOf(edge_connection,edge_connection.length));
        for(int iterator_i=0;iterator_i<edge_connection.length;iterator_i++)
            System.out.print(edge_connection[iterator_i]+" ");
        System.out.println("Cost"+TravellingSalesmanDistance(input_graph,edge_connection));
    }

    /*******************************************************************************************************************
     Driver Main Method
     ******************************************************************************************************************/
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

    /*    // Runner for W2.Q1
        System.out.println("Compute GCD using Euclid's algorithm\nEnter 2 numbers");
        System.out.println("The GCD is:\t"+compute_gcd_euclid(sc.nextInt(),sc.nextInt()));
        System.out.println("Number of basic operations = "+efficiency_count);
        efficiency_count = 0;
    */

    /*    // Runner for W2.Q2
        System.out.println("Compute GCD using consecutive integer checking algorithm\nEnter 2 numbers");
        System.out.println("The GCD is:\t"+compute_gcd_conseccheck(sc.nextInt(),sc.nextInt()));
        System.out.println("Number of basic operations = "+efficiency_count);
        efficiency_count = 0;
    */

    /*    // Runner for W2.Q3
        System.out.println("Compute GCD using middle school algorithm\nEnter 2 numbers");
        System.out.println("The GCD is:\t"+compute_gcd_mschool(sc.nextInt(),sc.nextInt()));
    */

    /*    // Runner for W2.Q4
        System.out.println("Square Root of n using basic operations\nEnter n");
        System.out.println("Square root of n is:\t"+sq_root(sc.nextInt()));
    */

    /*    // Runner for W2.Q6
        System.out.println("Sieve of Eratosthenes\nEnter value of n");
        sieve_eratosthenes(sc.nextInt());
    */

    /*    // Runner for W3.Q1
        System.out.println("Bubble Sort");
        int arr[] = create_array_int(sc);
        arr = bubble_sort(arr);
        display_array_int(arr);
    */

    /*    // Runner for W3.Q2
        System.out.println("Selection Sort");
        int arr[] = create_array_int(sc);
        arr = selection_sort(arr);
        display_array_int(arr);
    */

    /*    // Runner for W3.Q3
        System.out.println("Brute Force String Matching\nEnter string");
        String input_str = sc.nextLine();
        System.out.println("Enter pattern to be searched");
        String input_pattern = sc.nextLine();
        System.out.println("First Position of pattern is:\t"+brute_force_string_match(input_str,input_pattern));
    */

    /*    // Runner for W4.Q1
        System.out.println("Merge Sort");
        int arr[] = create_array_int(sc);
        System.out.println("Sorted array is");
        arr = mergeSort(arr);
        for(int iterator_i=0; iterator_i<arr.length;iterator_i++)
            System.out.print(arr[iterator_i]+" ");
    */

    /*    // Runner for W4.Q2
        System.out.println("Quick Sort");
        int arr[] = create_array_int(sc);
        System.out.println("Sorted array is:");
        arr = quickSort(arr,0,arr.length-1);
        for(int iterator_i=0;iterator_i<arr.length;iterator_i++)
            System.out.print(arr[iterator_i]+" ");
    */

    /*    // Runner for W4.Q3
        System.out.println("Binary Search");
        int arr[] = create_array_int(sc);
        System.out.println("Enter Search element");
        int srch_ele = sc.nextInt();
        System.out.println("Search element found at position : "+ binary_search(arr,srch_ele));
    */

    /*    // Runner for W5.Q1
        int arr[] = create_array_int(sc) ;
        arr = insertion_sort(arr);
        System.out.println("The sorted array is:");
        display_array_int(arr);
        System.out.println("Number of basic operations =\t"+efficiency_count);
    */

    /*    // Runner for W5.Q2
        System.out.println("Depth First  Traversal"); // extend for search
        Graph graph1 = create_graph(sc);
        int popped_order[] = new int[graph1.vertices+1];
        int push_order[] = new int[graph1.vertices+1];
        dfs_traversal(graph1, popped_order,push_order);
    */

    /*    // Runner for W5.Q3
        System.out.println("Topological Sorting");
        Graph graph1 = create_graph(sc);
        topological_sorting(graph1,0);
    */

    /*    // Runner for W5.Q4
        System.out.println("BFS Traversal");
        Graph graph1 = create_graph(sc);
        bfs_traversal(graph1);
    */

    /*    // Runner for W6.Q5
        System.out.println("Topological Sorting");
        Graph graph1 = create_graph(sc);
        topological_sorting_6(graph1);
    */

    /*    // Runner for W6.Q2
        System.out.println("AVL Trees");
        AVL_Tree avl_tree1 = create_avl_tree(sc);
    */

    /*    // Runner for W7.Q2
        System.out.println("Max Heap");
        int input_arr[] = create_array_int(sc);
        create_max_heap(input_arr);
        System.out.println("Converted Heap is");
        display_array_int(input_arr);
    */

    /*    // Runner for W8.Q1
        System.out.println("Horspool String matching");
        System.out.println("Enter string");
        String input_str = sc.nextLine();
        System.out.println("Enter pattern");
        String input_pattern = sc.nextLine();
        System.out.println("Pattern found at position "+Horspool(input_str, input_pattern));
    */

    /*    // Runner for W8.Q2
        System.out.println("Boyer Moore String Matching");
        System.out.println("Enter string");
        String input_str = sc.nextLine();
        System.out.println("Enter Pattern");
        String input_pattern = sc.nextLine();
        System.out.println("Pattern found at position "+Boyer_Moore(input_str, input_pattern));

    */

    /*    // Runner for W8.Q3
        System.out.println("Open Hash Table"); // Using Linked Lists for overflow
        System.out.println("Enter hash coefficient");
        int hash_parameter = sc.nextInt();
        ListNode hash_table[] = createOpenHashTable(hash_parameter ,sc);
    */

    /*    // Runner for W8.Q4
        System.out.println("Closed hash Table--Open Addressing");
        System.out.println("Enter hash coefficients");
        int hash_parameter = sc.nextInt();
        int hash_table[] = createClosedHashTable(hash_parameter,sc);
    */

    /*    // Runner for W8.Q5
        System.out.println("Comparison Count Sorting");
        int input_arr[] = create_array_int(sc);
        display_array_int(comparisonCountSorting(input_arr));
    */

    /*    // Runner for W9.Q1
        System.out.println("Floyd Algorithm");
        Graph input_graph = create_graph_distance(sc);
        int floyd_matrix[][] = FloydShortestPairs(input_graph);
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
                System.out.print(floyd_matrix[iterator_i][iterator_j]+" ");
            System.out.println();
        }
    */

    /*    // Runner for W9.Q2
        System.out.println("Warshall Algorithm"); // Transitive Closure
        Graph input_graph = create_graph(sc);
        int transitiveClosure[][] = WarshallTransitiveClosure(input_graph);
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
                System.out.print(transitiveClosure[iterator_i][iterator_j]);
            System.out.println();
        }
    */

    /*    // Runner for W10.Q1
        System.out.println("Prim Algorithm for Minimum Spanning Trees");
        Graph input_graph = create_graph_distance(sc);
        int mst_edges[][] = PrimMST(input_graph);
        for(int iterator_i=0;iterator_i<input_graph.vertices-1;iterator_i++)
            System.out.println(mst_edges[iterator_i][0]+"->"+mst_edges[iterator_i][1]);
    */

    /*    // Runner for W10.Q2
        System.out.println("Kruskal Algorithm for Mimimum Spanning Tree");// quick find
        Graph input_graph = create_graph_distance(sc);
        int mst_edges[][] = KruskalMST(input_graph);
        for(int iterator_i=0;iterator_i<input_graph.vertices-1;iterator_i++)
            System.out.println(mst_edges[iterator_i][0]+"->"+mst_edges[iterator_i][1]);
    */

    /*    // Runner for W10.Q3
        System.out.println("Kruskal Algorithm for Mimimum Spanning Tree"); // quick union
        Graph input_graph = create_graph_distance(sc);
        int mst_edges[][] = KruskalMSTU(input_graph);
        for(int iterator_i=0;iterator_i<input_graph.vertices-1;iterator_i++)
            System.out.println(mst_edges[iterator_i][0]+"->"+mst_edges[iterator_i][1]);
    */

    /*    // Runner for W10.Q4
        System.out.println("Dijkstra Algorithm");
        Graph input_graph = create_graph_distance(sc);
        int shortest_paths[] = DijkstraDistance(input_graph);
        for(int iterator_i=0;iterator_i<shortest_paths.length;iterator_i++)
            System.out.println(iterator_i+": "+shortest_paths[iterator_i]);
    */

    /*    // Runner for W10.Q5
        System.out.println("Huffman Encoding");
        System.out.println("Enter number of characters");
        int size = sc.nextInt();
        float probabilities[] = new float[size];
        char symbols[] = new char[size];
        System.out.println("Enter characters and their probabilities");
        for(int iterator_i=0;iterator_i<size;iterator_i++)
        {
            symbols[iterator_i] = sc.next().charAt(0);
            probabilities[iterator_i] = sc.nextFloat();
        }
        HuffmanEncoding(symbols,probabilities);
    */

    /*    // Runner for W11.Q1
        System.out.println("N Queens");
        System.out.println("Enter value of N");
        int n = sc.nextInt();
        NQueens(n);
    */

    /*    // Runner for W11.Q2
        System.out.println("Hamiltonian Circuit");
        Graph input_graph = create_graph(sc);
        HamiltonianCircuit(input_graph);
    */

    /*    // Runner for W11.Q3
        System.out.println("Subset Sum Problem");
        int set_arr[] = create_array_int(sc);
        System.out.println("Enter sum");
        int sum = sc.nextInt();
        SubsetSumBackTrack(set_arr,sum);
    */

    /*    // Runner for W12.Q1
        System.out.println("Assignment Problem");
        System.out.println("Enter n");
        int n = sc.nextInt(), assignment_matrix[][]= new int[n][n];
        for(int iterator_i=0;iterator_i<n;iterator_i++)
            for(int iterator_j=0;iterator_j<n;iterator_j++)
                assignment_matrix[iterator_i][iterator_j] = sc.nextInt();
        AssignmentBranchBound(assignment_matrix);
    */

    /*    // Runner for W12.Q2
        System.out.println("Knapsack Problem");
        System.out.println("Enter no.of items");
        int n = sc.nextInt(),value[] = new int[n],weight[] = new int[n];
        System.out.println("Enter value and weight respectively for all items");
        for(int iterator_i=0;iterator_i<n;iterator_i++)
        {
            value[iterator_i] = sc.nextInt();
            weight[iterator_i] = sc.nextInt();
        }
        System.out.println("Enter Knapsack capacity");
        int capacity = sc.nextInt();
        KnapsackBranchBound(value,weight,capacity);
    */

    /*    // Runner for W12.Q3
        System.out.println("Travelling Salesman Problem");
        Graph input_graph = create_graph_distance(sc);
        TravellingSalesman(input_graph);
    */
    }
}
