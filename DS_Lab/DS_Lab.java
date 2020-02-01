package DS_Lab;
import java.util.HashMap;
import java.util.Scanner;


public class DS_Lab {

    /* DS LAB Week 1 & 2: Basic Programs:
        1. Arrays can be passed normally and received in function inside pointer... traverse pointer and get absolute value using *
        2.Structure and variables need to be passed with &
        3. Use -> when address passed else use .
        4. Nested structures will have address of structure inside it and not the structure itself.
     */

    /*******************************************************************************************************************
    DS LAB Week 3 : Recursive
        Ques 1 : Decimal To Binary Conversion
        Ques 2: Factorial
        Ques 3: Fibonacci
        Ques 4: GCD
        Ques 5: Product of 2 numbers
        Ques 6: Sum of array of numbers
        Ques 7: Tower of Hanoi
     ******************************************************************************************************************/

    public static int dec_2_bin(int n)
    {
        if(n == 0 )
            return n;
        return n % 2 + 10 * dec_2_bin((int)n/2);
    }

    public static int factorial(int n)
    {
        if(n == 1)
            return n;
        else return n * factorial(n-1);
    }

    public static int fibonacci(int n)
    {
        if(n==0 || n==1)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int calc_gcd(int a, int b)
    {
        if(b == 0)
            return a;
        if(b>a)
            return calc_gcd(a, b%a);
        return calc_gcd(b, a%b);
    }

    public static int product_2_nums(int a,int b)
    {
        if(b == 0)
            return 0;
        return a + product_2_nums(a,b-1);
    }

    public static int sum_of_list(int arr[] , int size)
    {
        if(size == 1)
            return arr[0];
        else
            return arr[size-1] + sum_of_list(arr, size-1);
    }

    public static void tower_of_hanoi(int n, char source, char destination, char temp)
    {
        if(n == 0) // Base case
            return;
        //Step 1: Move n-1 blocks from source to temp
        tower_of_hanoi(n-1, source, temp, destination);
        //Step 2: Move 1 block(largest) from source to destination
        System.out.println("Disk "+n+" moved from "+source+" to "+destination);
        // Step 3: Move n-1 blocks from temp to destination
        tower_of_hanoi(n-1, temp, destination, source);
    }

    /*******************************************************************************************************************
     DS LAB Week 4 : Stacks Part 1
     Ques 1 : Decimal To Binary Conversion
     Ques 2:  Palindrome using stacks
     Ques 3:  Normal stack operations
     ******************************************************************************************************************/

    public static void stack_push(Stack stck,int stck_element)
    {
        if(stck.top == stck.max_top - 1 )
        {
            System.out.println("Stack overflow\n");
            return;
        }
        stck.arr[++(stck.top)] = stck_element;
    }

    public static void stack_push_char(Stack stck,char stck_element)
    {
        if(stck.top == stck.max_top - 1 )
        {
            System.out.println("Stack overflow\n");
            return;
        }
        stck.carr[++(stck.top)] = stck_element;
    }

    public static void stack_push_double(Stack stck,double stck_element)
    {
        if(stck.top == stck.max_top - 1 )
        {
            System.out.println("Stack overflow\n");
            return;
        }
        stck.darr[++(stck.top)] = stck_element;
    }

    public static void stack_push_string(Stack stck,String stck_element)
    {
        if(stck.top == stck.max_top - 1 )
        {
            System.out.println("Stack overflow\n");
            return;
        }
        stck.sarr[++(stck.top)] = stck_element;
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

    public static char stack_pop_char(Stack stck)
    {
        if(stck.top == -1)
        {
            //System.out.println("Stack underflow\n");
            return '$';
        }
        stck.top--;
        return stck.carr[stck.top + 1];
    }

    public static double stack_pop_double(Stack stck)
    {
        if(stck.top == -1)
        {
            //System.out.println("Stack underflow\n");
            return '$';
        }
        stck.top--;
        return stck.darr[stck.top + 1];
    }

    public static String stack_pop_string(Stack stck)
    {
        if(stck.top == -1)
        {
            //System.out.println("Stack underflow\n");
            return "$";
        }
        stck.top--;
        return stck.sarr[stck.top + 1];
    }

    public static void stack_display(Stack stck)
    {
        for(int iterator_i = 0; iterator_i<=stck.top; iterator_i++)
            System.out.print(stck.arr[iterator_i]+" ");
        System.out.println();
    }

    public static void stack_display_char(Stack stck)
    {
        for(int iterator_i = 0; iterator_i<=stck.top; iterator_i++)
            System.out.print(stck.carr[iterator_i]+" ");
        System.out.println();
    }

    public static void stack_display_double(Stack stck)
    {
        for(int iterator_i = 0; iterator_i<=stck.top; iterator_i++)
            System.out.print(stck.darr[iterator_i]+" ");
        System.out.println();
    }

    public static void stack_display_string(Stack stck)
    {
        for(int iterator_i = 0; iterator_i<=stck.top; iterator_i++)
            System.out.print(stck.sarr[iterator_i]+" ");
        System.out.println();
    }

    public static Stack dec_to_binary_stack(int input)
    {
        Stack stck = new Stack();
        stck.carr = new char[stck.max_top + 1];
        stck.top = -1;
        stck.arr = new int[stck.max_top + 1];
        while(input != 0) {
            stack_push_char(stck, (char) ((input % 2) + 48));
            input = input / 2;
        }
        return stck;
    }


    public static int check_palindrome_stack(String str)
    {
        Stack stck = new Stack();
        stck.arr = new int[stck.max_top + 1];
        stck.carr = new char[stck.max_top + 1];
        for (int iterator_i = 0; iterator_i < (int)Math.floor(str.length() / 2.0); iterator_i++)
            stack_push_char(stck, str.charAt(iterator_i));
        for (int iterator_i = (int) Math.ceil(str.length() / 2.0); iterator_i < str.length(); iterator_i++) {
            if (stack_pop_char(stck) != str.charAt(iterator_i))
              return 0;
        }
        return 1;
    }


    /*******************************************************************************************************************
     DS LAB Week 5 : Stacks Part 2
     Ques 1 : Infix To Prefix
     Ques 2:  Infix To Postfix
     Ques 3:  Postfix Evaluation
     Ques 4: Prefix evaluation
     Ques 5: Postfix to Prefix
     Ques 6: Prefix to Postfix
     ******************************************************************************************************************/

    public static void initialize_stack(Stack stck)
    {
        stck.top = -1;
        stck.arr = new int[stck.max_top + 1];
        stck.carr = new char[stck.max_top + 1];
        stck.darr = new double[stck.max_top + 1];
        stck.sarr = new String[stck.max_top + 1];
    }

    public static boolean is_operand(char cval)
    {
        if((cval == '+')||(cval == '-')||(cval == '*')||(cval == '/'))
            return true;
        return false;
    }

    public static boolean is_open_brackets(char cval)
    {
        if((cval == '{') || (cval == '[') || (cval == '(') )
            return true;
        return false;
    }

    public static boolean is_closed_brackets(char cval)
    {
        if((cval == '}') || (cval == ']') || (cval == ')'))
            return true;
        return false;
    }

    public static int get_precedence(char operator)
    {
        if(operator == '+' )
            return 1;
        else if (operator == '-')
            return 1;
        else if (operator == '*')
            return 2;
        else if (operator == '/')
            return 2;
        return -1;
    }

    public static int evaluate_operator(char operator1, char operator2)
    {
        if(get_precedence(operator1) == get_precedence(operator2))
            return 0;
        else if(get_precedence(operator1) < get_precedence(operator2))
            return -1;

        return 1;
    }

    public static Stack infix_to_postfix(String str)
    {
        Stack output_stack = new Stack();
        Stack temp_stack = new Stack();
        initialize_stack(output_stack);
        initialize_stack(temp_stack);

        for(int iterator_i=0; iterator_i<str.length(); iterator_i++ )
        {
            if(Character.isLetterOrDigit(str.charAt(iterator_i)))
                stack_push_char(output_stack,str.charAt(iterator_i));
            else if(is_operand(str.charAt(iterator_i)))
            {
                do
                {
                    char operand_top = stack_pop_char(temp_stack);
                    if(operand_top == '$' )
                    {
                        stack_push_char(temp_stack,str.charAt(iterator_i));
                        break;
                    }
                    else if(is_open_brackets(operand_top))
                    {
                        stack_push_char(temp_stack,operand_top);
                        stack_push_char(temp_stack,str.charAt(iterator_i));
                        break;
                    }
                    else if(is_operand(operand_top))
                    {
                        if(get_precedence(str.charAt(iterator_i)) <= get_precedence(operand_top) )
                        {
                            //pop operand and push to output stack
                            stack_push_char(output_stack,operand_top);
                        }
                        else
                        {
                            //place popped operand back on temp_stack and push current operator as well
                            stack_push_char(temp_stack,operand_top);
                            stack_push_char(temp_stack,str.charAt(iterator_i));
                            break;
                        }
                    }
                }
                while(true);
            }
            else if(is_open_brackets(str.charAt(iterator_i)))
                stack_push_char(temp_stack,str.charAt(iterator_i));
            else if(is_closed_brackets(str.charAt(iterator_i)))
            {
                do
                {
                    char operand_top = stack_pop_char(temp_stack);
                    if(is_open_brackets(operand_top))
                        break;
                    stack_push_char(output_stack,operand_top);
                }
                while(true);
            }
        }
        // pop all elements from temp stack
        do
        {
            char operand_top = stack_pop_char(temp_stack);
            if(operand_top == '$')
                break;
            stack_push_char(output_stack,operand_top);
        }
        while(true);
        return  output_stack;
    }

    public static Stack infix_to_prefix(String infix_exp)
    {
        String str = new StringBuilder(infix_exp).reverse().toString();

        Stack output_stack = new Stack();
        Stack temp_stack = new Stack();
        initialize_stack(output_stack);
        initialize_stack(temp_stack);

        for(int iterator_i=0; iterator_i<str.length(); iterator_i++ )
        {
            if(Character.isLetterOrDigit(str.charAt(iterator_i)))
                stack_push_char(output_stack,str.charAt(iterator_i));
            else if(is_operand(str.charAt(iterator_i)))
            {
                do
                {
                    char operand_top = stack_pop_char(temp_stack);
                    if(operand_top == '$' )
                    {
                        stack_push_char(temp_stack,str.charAt(iterator_i));
                        break;
                    }
                    else if(is_closed_brackets(operand_top))
                    {
                        stack_push_char(temp_stack,operand_top);
                        stack_push_char(temp_stack,str.charAt(iterator_i));
                        break;
                    }
                    else if(is_operand(operand_top))
                    {
                        if(get_precedence(str.charAt(iterator_i)) < get_precedence(operand_top) )
                        {
                            //pop operand and push to output stack
                            stack_push_char(output_stack,operand_top);
                        }
                        else
                        {
                            //place popped operand back on temp_stack and push current operator as well
                            stack_push_char(temp_stack,operand_top);
                            stack_push_char(temp_stack,str.charAt(iterator_i));
                            break;
                        }
                    }
                }
                while(true);
            }
            else if(is_closed_brackets(str.charAt(iterator_i)))
                stack_push_char(temp_stack,str.charAt(iterator_i));
            else if(is_open_brackets(str.charAt(iterator_i)))
            {
                do
                {
                    char operand_top = stack_pop_char(temp_stack);
                    if(is_closed_brackets(operand_top))
                        break;
                    stack_push_char(output_stack,operand_top);
                }
                while(true);
            }
        }
        // pop all elements from temp stack
        do
        {
            char operand_top = stack_pop_char(temp_stack);
            if(operand_top == '$')
                break;
            stack_push_char(output_stack,operand_top);
        }
        while(true);

        // Reverse output
        initialize_stack(temp_stack);
        do
        {
            char curr_val = stack_pop_char(output_stack);
            if(curr_val == '$')
                break;
            stack_push_char(temp_stack,curr_val);
        }
        while(true);
        return  temp_stack;
    }

    public static double evaluate_postfix(String postfix_str)
    {
        Stack operand_stck = new Stack();
        initialize_stack(operand_stck);
        double result  =0.0;
        for(int iterator_i=0; iterator_i < postfix_str.length() ; iterator_i++)
        {
            //stack_display(operand_stck);
            if(Character.isDigit(postfix_str.charAt(iterator_i)))
                stack_push_double(operand_stck,((int)(postfix_str.charAt(iterator_i)))-48);
            else if(is_operand(postfix_str.charAt(iterator_i)))
            {
                double operand2 = stack_pop_double(operand_stck);
                double operand1 = stack_pop_double(operand_stck);
                switch(postfix_str.charAt(iterator_i))
                {
                    case '+':
                        stack_push_double(operand_stck,operand1 + operand2);
                        break;
                    case '-':
                        stack_push_double(operand_stck,operand1 - operand2);
                        break;
                    case '*':
                        stack_push_double(operand_stck,operand1 * operand2);
                        break;
                    case '/':
                        stack_push_double(operand_stck, operand1 / operand2);
                }
            }
            else
            {
                System.out.println("Invalid Character");
                return Integer.MAX_VALUE;
            }
        }
        return stack_pop_double(operand_stck);
    }

    public static double evaluate_prefix(String prefix_str)
    {
        String prefix_expr = new StringBuilder(prefix_str).reverse().toString();
        Stack operand_stck = new Stack();
        initialize_stack(operand_stck);
        double result  =0.0;
        for(int iterator_i=0; iterator_i < prefix_expr.length() ; iterator_i++)
        {
            //stack_display(operand_stck);
            if(Character.isDigit(prefix_expr.charAt(iterator_i)))
                stack_push_double(operand_stck,((int)(prefix_expr.charAt(iterator_i)))-48);
            else if(is_operand(prefix_expr.charAt(iterator_i)))
            {
                double operand2 = stack_pop_double(operand_stck);
                double operand1 = stack_pop_double(operand_stck);
                switch(prefix_expr.charAt(iterator_i))
                {
                    case '+':
                        stack_push_double(operand_stck,operand1 + operand2);
                        break;
                    case '-':
                        stack_push_double(operand_stck,operand1 - operand2);
                        break;
                    case '*':
                        stack_push_double(operand_stck,operand1 * operand2);
                        break;
                    case '/':
                        stack_push_double(operand_stck, operand1 / operand2);
                }
            }
            else
            {
                System.out.println("Invalid Character");
                return Integer.MAX_VALUE;
            }
        }
        return stack_pop_double(operand_stck);
    }

    public static Stack postfix_to_prefix(String postfix_str)
    {
        Stack prefix_stack = new Stack();
        initialize_stack(prefix_stack);
        for(int iterator_i = 0; iterator_i < postfix_str.length(); iterator_i++)
        {
            if(Character.isLetter(postfix_str.charAt(iterator_i)))
                stack_push_string(prefix_stack, Character.toString(postfix_str.charAt(iterator_i)));
            else if(is_operand(postfix_str.charAt(iterator_i)))
            {
                String operand2 = stack_pop_string(prefix_stack);
                String operand1 = stack_pop_string(prefix_stack);
                stack_push_string(prefix_stack, postfix_str.charAt(iterator_i)+ operand1 + operand2);
            }
        }
        return prefix_stack;
    }

    public static void prefix_to_postfix(String postfix_str)
    {
        String postfix_expr = new StringBuilder(postfix_str).reverse().toString(), temp_str = "",result="";
        Stack postfix_stck = new Stack();
        initialize_stack(postfix_stck);
        Stack postfix_stck_reverse = new Stack();
        initialize_stack(postfix_stck_reverse);

        for(int iterator_i = 0; iterator_i < postfix_expr.length(); iterator_i++)
        {
            if(Character.isLetter(postfix_expr.charAt(iterator_i)))
                stack_push_string(postfix_stck, Character.toString(postfix_expr.charAt(iterator_i)));
            else if(is_operand(postfix_expr.charAt(iterator_i)))
            {
                String operand2 = stack_pop_string(postfix_stck);
                String operand1 = stack_pop_string(postfix_stck);
                stack_push_string(postfix_stck, postfix_expr.charAt(iterator_i)+ operand1 + operand2);
            }
        }
        do
        {
            temp_str = stack_pop_string(postfix_stck);
            if(temp_str.equals("$"))
                break;
            for(int iterator_i = temp_str.length() - 1; iterator_i >=0; iterator_i-- )
                result  += temp_str.charAt(iterator_i);
        }
        while(true);
        System.out.println(result);
    }


    /*******************************************************************************************************************
     DS LAB Week 6 : Queues Part 1
     Ques 1: Basic Queue Operations
     Ques 2: Full Queue Operations(all enqueue and dequeue)
     Ques 3:  Circular Queue for Strings
     Ques 4:  Circular Queue using 2 queues(Skipped - very vague and shit exercise)
     ******************************************************************************************************************/

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

    public static void enqueue_left(Queue input_q, int input)
    {
        if(input_q.front <= 0)
        {
            System.out.println("Queue Overflow");
            return;
        }
        input_q.arr[--(input_q.front)] = input;
    }

    public static void circular_enqueu_str(Queue input_q, String input)
    {
        if(input_q.rear == -1 && input_q.front == -1)
        {
            input_q.rear = input_q.front = 0;
            input_q.sarr[input_q.rear] = input;
            return;
        }
        else if((input_q.rear > input_q.front) && ((input_q.rear+1)%input_q.max_length == input_q.front%input_q.max_length  ))
        {
            System.out.println("Queue Overflow");
            return;
        }

        input_q.sarr[(++(input_q.rear)) % input_q.max_length] = input;
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

    public static int dequeue_right(Queue input_q)
    {
        if(input_q.rear < input_q.front || input_q.rear == -1 )
        {
            System.out.println("Queue Underflow");
            return Integer.MIN_VALUE;
        }
        int popped_ele = input_q.arr[input_q.rear];
        input_q.rear--;
        return popped_ele;
    }

    public static String circular_dequeue_str(Queue input_q)
    {
        if((input_q.front > input_q.rear)|| input_q.rear == -1 )
        {
            System.out.println("Queue Underflow");
            return "$";
        }
        String popped_ele = input_q.sarr[input_q.front%input_q.max_length];
        input_q.front++;
        return popped_ele;
    }

    public static void queue_display(Queue input_q)
    {
        if(input_q.front > input_q.rear ||  input_q.rear==-1)
        {
            System.out.println("Queue is Empty");
            return;
        }
        for(int iterator_i = input_q.front; iterator_i <= input_q.rear; iterator_i++)
            System.out.print(input_q.arr[iterator_i]);
        System.out.println();
    }

    public static void circular_display_str(Queue input_q)
    {
        if((input_q.front > input_q.rear) ||  input_q.rear==-1)
        {
            System.out.println("Queue is Empty");
            return;
        }
        for(int iterator_i=input_q.front; iterator_i<=input_q.rear ; iterator_i++)
            System.out.print(input_q.sarr[iterator_i%input_q.max_length]+" ");
        System.out.println();
    }

    /*******************************************************************************************************************
     DS LAB Week 7 : Queues Part 2
     Ques 1 : Queue Operations:- 1. Enqueue Left 2. Enqueue Right 3. Dequeue Left 4. Dequeue Right(Covered in W6.Q2)
     Ques 2:  Ascending Priority Queue
     Ques 3:  Implement a stack and a queue of strings using an output restricted  dequeue.(no deleteRight) (queue implementation skipped)
     Ques 4: Implement a stack and a queue of integers using an input restricted dequeue.(no addRight)
     ******************************************************************************************************************/

    public static void asc_priority_q_insert(Queue input_q, int input_ele) // Tradeoff for engueue operation
    {
        if(input_q.front == -1)
        {
            input_q.front = input_q.rear = 0;
            input_q.arr[0] = input_ele;
            return;
        }
        else if(input_q.rear == input_q.max_length - 1 )
        {
            System.out.println("Queue Overflow");
            return;
        }
        int iterator_i = input_q.front;
        while(input_ele > input_q.arr[iterator_i] && iterator_i<= input_q.rear)
            iterator_i++;
        input_q.rear++;
        for(int iterator_j=input_q.rear; iterator_j>iterator_i; iterator_j--)
            input_q.arr[iterator_j] = input_q.arr[iterator_j - 1];
        input_q.arr[iterator_i] = input_ele;
    }

    public static int asc_priority_q_dequeue(Queue input_q)
    {
        return dequeue_left(input_q);
    }

    public static void enqueu_for_stack_or(Queue input_q, int input_ele)
    {
        enqueue_right(input_q, input_ele);
    }

    public static Queue dequeu_for_stack_or(Queue input_q)
    {
        // Since dequeue_right is not allowed :
        // Step 1: - Dequeue left(Initial Queue)
        // Step 2: - Enqueue right(Temp Queue)
        // Repeat Step1 and 2 except for last element
        Queue final_q = new Queue();
        initialize_queue(final_q);
        while(input_q.front != input_q.rear)
            enqueue_right(final_q,dequeue_left(input_q));
        System.out.println("Popped Element\t"+dequeue_left(input_q));
        return final_q;
    }

    public static Queue enqueu_for_stack_ir(Queue input_q, int input_ele)
    {
        Queue final_queue = new Queue();
        initialize_queue(final_queue);
        if(input_q.rear == input_q.max_length -1)
        {
            System.out.println("Queue Overflow");
            return input_q;
        }
        // Use alteration of queue parameters to make spatial queue
        int no_of_elements = input_q.rear - input_q.front + 1;
        if(no_of_elements == 0 || (input_q.front == -1))
        {
            final_queue.rear = final_queue.front = 0;
            final_queue.arr[0] = input_ele;
            return final_queue;
        }

        final_queue.rear =  no_of_elements ;
        final_queue.front = no_of_elements + 1;
        enqueue_left(final_queue, input_ele);
        while(input_q.front <= input_q.rear)
            enqueue_left(final_queue,dequeue_right(input_q));
        return final_queue;
    }

    public static int dequeu_for_stack_ir(Queue input_q)
    {
        return dequeue_right(input_q);
    }

    public static Queue enqueu_for_q_ir(Queue input_q, int input_ele)
    {
        return enqueu_for_stack_ir(input_q, input_ele);
    }

    public static int dequeu_for_q_ir(Queue input_q)
    {
        return dequeue_left(input_q);
    }

    /*******************************************************************************************************************
     DS LAB Week 8 : Linked List Part 1
     Ques 1 : Stack using Linked List
     Ques 2:  Queues using Linked List and header node
     Ques 3:  Merge 2 sorted circular linked list with header node
     Ques 4: Union using singly circular linked list
     Ques 5: Intersection using doubly linked list
     ******************************************************************************************************************/

    public static void initialize_singlylinkedlist(SinglyLinkedList input_list)
    {
        input_list.val = Integer.MIN_VALUE;
        input_list.right_node = null;
    }

    public static void initialize_doublelinkedlist(DoublyLinkedList input_list, int input_val)
    {
        input_list.left = null;
        input_list.right = null;
        input_list.val = input_val;
    }

    public static SinglyLinkedList linkedlist_stck_push(SinglyLinkedList input_list, int input_val)
    {
        SinglyLinkedList final_list = new SinglyLinkedList(), push_node = new SinglyLinkedList();
        initialize_singlylinkedlist(push_node);
        final_list = input_list;
        if(input_list == null)
        {
            input_list = new SinglyLinkedList();
            input_list.val = input_val;
            input_list.right_node = null;
            return input_list;
        }
        while(final_list.right_node != null)
            final_list = final_list.right_node;
        push_node.val = input_val;
        push_node.right_node = null;
        final_list.right_node = push_node;
        return input_list;
    }

    public static SinglyLinkedList linkedlist_stck_pop(SinglyLinkedList input_list)
    {
        int popped_val;
        SinglyLinkedList temp_list = input_list;
        if(input_list == null )
        {
            System.out.println("Stack Underflow");
            return null;
        }
        else if(input_list.right_node == null)
        {
            popped_val = input_list.val;
            input_list = null;
            return input_list;
        }
        else
        {
            while (input_list.right_node.right_node != null)
                input_list = input_list.right_node;
            popped_val = input_list.right_node.val;
            input_list.right_node = null;
        }
        System.out.println("Popped element is\t"+popped_val);
        return temp_list;
    }

    public static void linkedlist_display(SinglyLinkedList input_list)
    {
        while(input_list != null)
        {
            System.out.print(input_list.val+"\t");
            input_list = input_list.right_node;
        }
        System.out.println();
    }

    public static SinglyLinkedList linkedlist_q_enqueue(SinglyLinkedList input_list, int input_val)
    {
        SinglyLinkedList temp_list = input_list;
        if(temp_list == null)
        {
            input_list = new SinglyLinkedList();
            temp_list = new SinglyLinkedList();
            input_list.val = input_val;
            input_list.right_node = null;
            temp_list.val = 1;
            temp_list.right_node = input_list;
            return temp_list;
        }
        int no_of_elements = temp_list.val;
        if(no_of_elements == input_list.max_for_stack)
        {
            System.out.println("Stack Overflow");
            return input_list;
        }
        temp_list.val = temp_list.val + 1;
        for(int iterator_i=0; iterator_i< no_of_elements ; iterator_i++ )
            temp_list = temp_list.right_node;
        SinglyLinkedList newnode = new SinglyLinkedList();
        newnode.val = input_val;
        newnode.right_node = null;
        temp_list.right_node = newnode;
        return  input_list;
    }

    public static SinglyLinkedList linkedlist_q_dequeue(SinglyLinkedList input_list)
    {
        int no_of_elements = input_list.val;
        if(no_of_elements == 0)
        {
            System.out.println("Stack Underflow");
            return input_list;
        }
        input_list.val = input_list.val - 1;
        SinglyLinkedList temp_list = input_list;
        for(int iterator_i=1; iterator_i< no_of_elements ; iterator_i++ )
            temp_list = temp_list.right_node;
        System.out.println("Popped Element is\t"+temp_list.right_node.val);
        temp_list.right_node = null;
        return  input_list;
    }

    public static SinglyLinkedList create_circular_linked_listh(Scanner sc)
    {
        SinglyLinkedList return_list = new SinglyLinkedList();
        System.out.println("Enter no. of elements");
        return_list.val = sc.nextInt();

        if(return_list.val==0)
        {
            return_list.right_node = return_list;
            return return_list;
        }
        SinglyLinkedList temp_node = null;
        for(int iterator_i = 0 ; iterator_i < return_list.val; iterator_i++)
            temp_node = linkedlist_stck_push(temp_node, sc.nextInt());
        return_list.right_node = temp_node;
        while(temp_node.right_node!= null)
            temp_node = temp_node.right_node;
        temp_node.right_node = return_list.right_node;
        return return_list;

    }

    public static void display_circular_linked_listh(SinglyLinkedList input_q)
    {
        int no_of_elements = input_q.val;
        for(int iterator_i=0; iterator_i < no_of_elements ; iterator_i++)
        {
            input_q = input_q.right_node;
            System.out.print(input_q.val+"\t");
        }
        System.out.println();
    }

    public static SinglyLinkedList merge_circ_listh(SinglyLinkedList list1, SinglyLinkedList list2)
    {
        int total_elements1 = list1.val, total_elements2 = list2.val;
        SinglyLinkedList result_node = list1;
        SinglyLinkedList prev_node = list1;
        int iterator_i=0, iterator_j =0;
        list1 = list1.right_node;
        list2 = list2.right_node;

        while(iterator_i<total_elements1 && iterator_j<total_elements2)
        {
            if(list1.val <= list2.val)
            {
                prev_node = list1;
                list1 = list1.right_node;
                iterator_i++;
            }
            else
            {
                SinglyLinkedList insertion_node = new SinglyLinkedList();
                insertion_node.val = list2.val;
                insertion_node.right_node = list1;
                prev_node.right_node = insertion_node;
                iterator_j++;
                list2 = list2.right_node;
                prev_node = prev_node.right_node;
            }
        }
        while (iterator_j<total_elements2)
        {
            SinglyLinkedList insertion_node = new SinglyLinkedList();
            insertion_node.val = list2.val;
            insertion_node.right_node = list1;
            prev_node.right_node = insertion_node;
            iterator_j++;
            list2 = list2.right_node;
            prev_node = prev_node.right_node;
        }
        result_node.val = total_elements1 + total_elements2;
        return result_node;

    }

    public static SinglyLinkedList union_circ_linked_listh(SinglyLinkedList list1, SinglyLinkedList list2)
    {
        SinglyLinkedList result_node = list1;
        HashMap<Integer,Integer> h_map = new HashMap<>();
        int no_of_elements = list1.val;
        for(int iterator_i = 0; iterator_i<no_of_elements; iterator_i++ )
        {
            list1 = list1.right_node;
            h_map.put(list1.val,1);
        }
        no_of_elements = list2.val;
        for(int iterator_i = 0; iterator_i<no_of_elements; iterator_i++)
        {
            list2 = list2.right_node;
            if(!h_map.containsKey(list2.val))
            {
                SinglyLinkedList temp_node = new SinglyLinkedList();
                temp_node.val = list2.val;
                temp_node.right_node = result_node.right_node;
                result_node.right_node = temp_node;
                result_node.val++;
            }
        }
        return result_node;

    }

    public static DoublyLinkedList create_doubly_linked_list(Scanner sc)
    {
        DoublyLinkedList return_list = null;
        DoublyLinkedList final_list = null;
        System.out.println("Enter no. of elements");
        int no_of_elements = sc.nextInt();
        if(no_of_elements==0)
            return null;
        DoublyLinkedList temp_node = null;
        DoublyLinkedList prev_node = null;

        for(int iterator_i = 0 ; iterator_i < no_of_elements; iterator_i++)
        {
            temp_node = new DoublyLinkedList();
            temp_node.val = sc.nextInt();
            temp_node.left = prev_node;
            temp_node.right = null;
            prev_node = temp_node;
            if(return_list == null)
            {
                final_list = temp_node;
                return_list = temp_node;
            }
            else
            {
                return_list.right = temp_node;
                return_list = return_list.right;
            }

        }
        return final_list;
    }

    public static void dlinkedlist_display(DoublyLinkedList input_list)
    {
        DoublyLinkedList inverted_list=null;
        System.out.println("Left to Right Display");
        while(input_list!=null)
        {
            inverted_list = input_list;
            System.out.print(input_list.val);
            input_list = input_list.right;
        }
        System.out.println("\nRight to Left Display");
        while(inverted_list!= null)
        {
            System.out.print(inverted_list.val);
            inverted_list = inverted_list.left;
        }
    }

    public static DoublyLinkedList intersection_dlink_list(DoublyLinkedList list1, DoublyLinkedList list2)
    {
        DoublyLinkedList result_node = null;
        DoublyLinkedList final_list = null;
        HashMap<Integer,Integer> h_map = new HashMap<>();
        while(list1!=null)
        {
            h_map.put(list1.val,1);
            list1 = list1.right;
        }
        while(list2!=null)
        {
            if(h_map.containsKey(list2.val))
            {
                DoublyLinkedList temp_node = new DoublyLinkedList();
                temp_node.val = list2.val;
                temp_node.right = null;
                if(result_node == null)
                {
                    temp_node.left = null;
                    result_node = temp_node;
                    final_list = temp_node;
                }
                else
                {
                    temp_node.left = result_node;
                    result_node.right = temp_node;
                    result_node = result_node.right;
                }
            }
            list2 = list2.right;
        }
        return final_list;
    }

    /*******************************************************************************************************************
     DS LAB Week 9 : Linked List Part 2
     Ques 1 : Use menu driven approach to input two polynomials, add, subtract, multiply and display the result
     Ques 2 : Add two long positive integers represented using circular doubly linked list with header node.
     Ques 3 : Reverse a doubly linked list containing words in the data field.(Assumed integers)
     Ques 4: Reverse a singly linked list
     ******************************************************************************************************************/

    public static SinglyLinkedList create_polynomial_list(Scanner sc)
    {
        SinglyLinkedList return_list = null;
        System.out.println("Enter maximum degree of Polynomial 1 and then enter coefficients starting from highest degree");
        for(int iterator_i=0, poly_degree = sc.nextInt(); iterator_i<=poly_degree; iterator_i++)
            return_list = linkedlist_stck_push(return_list,sc.nextInt());
        return return_list;
    }

    public static int get_highest_degree(SinglyLinkedList input_list)
    {
        int degree_val = 0;
        while(input_list != null)
        {
            degree_val++;
            input_list = input_list.right_node;
        }
        return degree_val-1;
    }

    public static void add_polynomials(SinglyLinkedList list1, SinglyLinkedList list2)
    {
        int degree_1 = get_highest_degree(list1);
        int degree_2 = get_highest_degree(list2);
        for(int iterator_i=0; iterator_i< degree_2 - degree_1; iterator_i++)
        {
            SinglyLinkedList temp_node  =new SinglyLinkedList();
            temp_node.val = 0;
            temp_node.right_node = list1;
            list1 = temp_node;
        }
        SinglyLinkedList result_node = list1;
        while(degree_1 > degree_2)
        {
            degree_1--;
            list1 = list1.right_node;
        }
        while(degree_2>=0)
        {
            list1.val = list1.val + list2.val;
            list1 = list1.right_node;
            list2 = list2.right_node;
            degree_2--;
        }
        linkedlist_display(result_node);

    }

    public static void sub_polynomials(SinglyLinkedList list1, SinglyLinkedList list2)
    {
        int degree_1 = get_highest_degree(list1);
        int degree_2 = get_highest_degree(list2);
        for(int iterator_i=0; iterator_i< degree_2 - degree_1; iterator_i++)
        {
            SinglyLinkedList temp_node  =new SinglyLinkedList();
            temp_node.val = 0;
            temp_node.right_node = list1;
            list1 = temp_node;
        }
        SinglyLinkedList result_node = list1;
        while(degree_1 > degree_2)
        {
            degree_1--;
            list1 = list1.right_node;
        }
        while(degree_2>=0)
        {
            list1.val = list1.val - list2.val;
            list1 = list1.right_node;
            list2 = list2.right_node;
            degree_2--;
        }
        linkedlist_display(result_node);
    }

    public static SinglyLinkedList linked_list_insert_pos(SinglyLinkedList input_list, int pos, int insert_val)
    {
        System.out.println(pos+ " "+ insert_val);
        SinglyLinkedList temp_node, final_list = input_list;
        while(pos>0)
        {
            input_list = input_list.right_node;
            pos--;
            if(pos==0 && input_list==null)
            {
                System.out.println("Reached End. Insert Failed");
                return input_list;
            }
        }
        input_list.val += insert_val;
        return final_list;
    }

    public static void mul_polynomials(SinglyLinkedList list1, SinglyLinkedList list2)
    {
        SinglyLinkedList final_result = null, list2_cpy = list2;
        int degree_1 = get_highest_degree(list1);
        int degree_2 = get_highest_degree(list2);
        int highest_degree = degree_1 + degree_2, degree_2cpy = degree_2;
        for(int iterator_i=0; iterator_i<= degree_2 + degree_1; iterator_i++)
        {
            final_result =  linkedlist_stck_push(final_result,0);
        }
        while(degree_1>=0)
        {
            list2 = list2_cpy;
            degree_2 = degree_2cpy;
            while(degree_2>=0)
            {
                final_result = linked_list_insert_pos(final_result, highest_degree - (degree_1+degree_2), list1.val * list2.val);
                list2 = list2.right_node;
                degree_2--;
            }
            degree_1--;
            list1 = list1.right_node;
        }
        linkedlist_display(final_result);
    }

    public static DoublyLinkedList create_circular_dlinked_list(Scanner sc)
    {
        DoublyLinkedList return_list = new DoublyLinkedList(),temp_node=null,pointer_temp = null;
        System.out.println("Enter length of number");
        return_list.val = sc.nextInt();
        return_list.left = null;
        pointer_temp = return_list;
        for(int iterator_i=0; iterator_i<return_list.val; iterator_i++)
        {
            temp_node = new DoublyLinkedList();
            temp_node.val = sc.nextInt();
            temp_node.left = pointer_temp;
            pointer_temp.right = temp_node;
            temp_node.right = null;
            pointer_temp = pointer_temp.right;
        }
        temp_node.right = return_list.right;
        return_list.right.left = temp_node;
        return return_list;
    }

    public static void display_circular_dlinked_listh(DoublyLinkedList input_list)
    {
        int no_of_elements = input_list.val;
        for(int iterator_i=0; iterator_i<no_of_elements; iterator_i++)
        {
            input_list = input_list.right;
            System.out.print(input_list.val+"\t");
        }

        System.out.println();
    }

    public static DoublyLinkedList add_long_numbers(DoublyLinkedList list1, DoublyLinkedList list2)
    {
        int length1 = list1.val, length2 = list2.val;
        int iterator_i = 0, iterator_j = 0,carry=0;
        DoublyLinkedList lsd_list1 = list1.right.left;
        DoublyLinkedList lsd_list2 = list2.right.left;
        while(iterator_i<length1 && iterator_j<length2)
        {
            int new_carry = (lsd_list1.val + lsd_list2.val+carry)/10;
            lsd_list1.val = (lsd_list1.val + lsd_list2.val + carry)%10;
            carry = new_carry;
            lsd_list1 = lsd_list1.left;
            lsd_list2 = lsd_list2.left;
            iterator_i++;
            iterator_j++;
            display_circular_dlinked_listh(list1);
        }
        while(iterator_j<length2 )
        {
            DoublyLinkedList tmp_node = new DoublyLinkedList();
            tmp_node.val = (lsd_list2.val + carry)%10;
            carry = (lsd_list2.val+ carry)/10;
            tmp_node.left = list1.right.left;
            tmp_node.right = list1.right;
            list1.right.left.right = tmp_node;
            list1.right = tmp_node;
            iterator_j++;
            lsd_list2 = lsd_list2.left;
            list1.val = list1.val + 1;
        }
        while(carry == 1)
        {
            DoublyLinkedList tmp_node = new DoublyLinkedList();
            if(iterator_i < length1)
            {
                lsd_list1.val = (lsd_list1.val + carry) % 10;
                if (lsd_list1.val == 0)
                    carry = 1;
                else
                    carry = 0;
                lsd_list1 = lsd_list1.left;
                iterator_i++;
            }
            else {
                tmp_node.val = carry;
                tmp_node.left = list1.right.left;
                tmp_node.right = list1.right;
                list1.right.left.right = tmp_node;
                list1.right = tmp_node;
                list1.val = list1.val + 1;
                carry = 0;
            }
        }
        return list1;
    }

    public static DoublyLinkedList reverse_doubly_linked_list(DoublyLinkedList input_list)
    {
        DoublyLinkedList final_list = input_list, prev_node=null;
        while(input_list != null)
        {
            DoublyLinkedList next_node = input_list.right;
            prev_node = input_list.left;
            input_list.left = next_node;
            input_list.right = prev_node;
            input_list= input_list.left;
        }
        return prev_node.left;
    }

    public static SinglyLinkedList create_singly_linked_list(Scanner sc)
    {
        System.out.println("Enter no. of elements");
        SinglyLinkedList final_list= null;
        int no_of_ele = sc.nextInt();
        for(int iterator_i=0; iterator_i<no_of_ele; iterator_i++)
            final_list = linkedlist_stck_push(final_list,sc.nextInt());
        return final_list;
    }

    public static SinglyLinkedList reverse_singly_linked_list(SinglyLinkedList input_list)
    {
        SinglyLinkedList prev_node = null, next_node = null;
        while(input_list!=null)
        {
            next_node = input_list.right_node;
            input_list.right_node = prev_node;
            prev_node = input_list;
            input_list = next_node;
        }
        return prev_node;
    }

    /*******************************************************************************************************************
     DS LAB Week 10 : Tress Part 1
     Ques 1 : Create binary tree using recursion
     Ques 2 : Search for node in tree
     Ques 3 : Inorder, preoder and postorder traversal on the binary tree created using iteration and recursion
     Ques 4: Check if 2 trees are equal
     ******************************************************************************************************************/

    public static TreeNode create_binary_tree(TreeNode input_treenode, Scanner sc)
    {
        System.out.println("Enter value");
        int val = sc.nextInt();
        if(val==-1)
            return input_treenode;
        input_treenode = new TreeNode();
        input_treenode.val = val;
        System.out.println("Left Node of "+val);
        input_treenode.left =  create_binary_tree(input_treenode.left,sc);
        System.out.println("Right node of "+val);
        input_treenode.right = create_binary_tree(input_treenode.right,sc);
        return input_treenode;
    }

    public static void display_binary_tree(TreeNode input_tree)
    {
        if(input_tree==null)
            return;
        System.out.print(input_tree.val);
        display_binary_tree(input_tree.left);
        display_binary_tree(input_tree.right);
    }

    public static boolean search_in_binary_tree(TreeNode input_tree, int srch_ele)
    {
        if(input_tree==null)
            return false;
        if(input_tree.val == srch_ele)
            return true;
        return (search_in_binary_tree(input_tree.left,srch_ele) || search_in_binary_tree(input_tree.right,srch_ele));
    }

    public static void inorder_traversal_rcur(TreeNode input_tree)
    {
        if(input_tree==null)
            return;
        inorder_traversal_rcur(input_tree.left);
        System.out.print(input_tree.val+" ");
        inorder_traversal_rcur(input_tree.right);
    }

    public static void preorder_traversal_rcur(TreeNode input_tree)
    {
        if(input_tree==null)
            return;
        System.out.print(input_tree.val+" ");
        preorder_traversal_rcur(input_tree.left);
        preorder_traversal_rcur(input_tree.right);
    }

    public static void postorder_traversal_rcur(TreeNode input_tree)
    {
        if(input_tree==null)
            return;
        postorder_traversal_rcur(input_tree.left);
        postorder_traversal_rcur(input_tree.right);
        System.out.print(input_tree.val+" ");
    }

    public static void perform_rcur_traversals(TreeNode input_tree)
    {
        System.out.println("Inorder Traversal:\t");
        inorder_traversal_rcur(input_tree);
        System.out.println("\nPreOrder Traversal:\t");
        preorder_traversal_rcur(input_tree);
        System.out.println("\nPostorder Traversal:\t");
        postorder_traversal_rcur(input_tree);
    }

    public static void inorder_traversal_iter(TreeNode input_tree)
    {
        TreeNode ele_arr[] = new TreeNode[100];
        int arrpos=-1;
        do
        {
            while(input_tree != null)
            {
                ele_arr[++arrpos] = input_tree;
                input_tree = input_tree.left;
            }
            input_tree = ele_arr[arrpos--];
            System.out.print(input_tree.val+" ");
            input_tree = input_tree.right;
        }
        while(arrpos>=0 || input_tree!=null);
    }

    public static void preorder_traversal_iter(TreeNode input_tree)
    {
        TreeNode ele_arr[] = new TreeNode[100];
        int arrpos=-1;
        do
        {
            while(input_tree != null)
            {
                System.out.print(input_tree.val+" ");
                ele_arr[++arrpos] = input_tree;
                input_tree = input_tree.left;
            }
            input_tree = ele_arr[arrpos--];
            input_tree = input_tree.right;
        }
        while(arrpos>=0 || input_tree!=null);
    }
    public static void postorder_traversal_iter(TreeNode input_tree)
    {
        TreeNode ele_arr[] = new TreeNode[100];
        int arrpos=-1;
        do
        {
            while(input_tree != null)
            {
                if(input_tree.right!=null)
                    ele_arr[++arrpos] = input_tree.right;
                ele_arr[++arrpos] = input_tree;
                input_tree = input_tree.left;
            }
            input_tree = ele_arr[arrpos--];
            if(arrpos>-1 && input_tree.right == ele_arr[arrpos])
            {
                TreeNode temp = ele_arr[arrpos];
                ele_arr[arrpos] = input_tree;
                input_tree = temp;
            }
            else
            {
                System.out.print(input_tree.val + " ");
                input_tree = null;
            }
        }
        while(arrpos>=0 || input_tree!=null);
    }


    public static void perform_iter_traversals(TreeNode input_tree)
    {
        System.out.println("Inorder Traversal:\t");
        inorder_traversal_iter(input_tree);
        System.out.println("\nPreOrder Traversal:\t");
        preorder_traversal_iter(input_tree);
        System.out.println("\nPostorder Traversal:\t");
        postorder_traversal_iter(input_tree);
    }

    public static boolean compare_binary_trees(TreeNode tree1, TreeNode tree2)
    {
        if(tree1 == null && tree2!=null)
            return false;
        if(tree2 == null && tree1!=null)
            return false;
        if(tree1 == null && tree2 == null)
            return true;
        if(tree1.val != tree2.val)
            return false;
        return compare_binary_trees(tree1.left,tree2.left) && compare_binary_trees(tree1.right,tree2.right);
    }

    /*******************************************************************************************************************
     DS LAB Week 11 : Tress Part 2
     Ques 1 : Insert in BST
     Ques 2 : Delete in BST
     Ques 3 : Find the depth, height, number of leaves, nodes in a BST
     Ques 4 : Level Order Traversal on BST
     Ques 5 : Create tree for postfix expression and evaluate it
     ******************************************************************************************************************/

    public static TreeNode insert_into_bst(TreeNode input_tree, int input_ele)
    {
        if(input_ele==-1)
            return input_tree;
        if(input_tree==null)
        {
            input_tree = new TreeNode();
            input_tree.val = input_ele;
            return input_tree;
        }
        TreeNode prev_node =null;
        TreeNode result_node = input_tree;
        while(input_tree!=null)
        {
            prev_node = input_tree;
            if(input_ele<input_tree.val)
                input_tree = input_tree.left;
            else
                input_tree = input_tree.right;
        }
        TreeNode insertion_node = new TreeNode();
        insertion_node.val = input_ele;
        if(input_ele<prev_node.val)
            prev_node.left = insertion_node;
        else
            prev_node.right = insertion_node;
        return result_node;
    }

    public static TreeNode create_bst(Scanner sc)
    {
        TreeNode return_tree = null;
        int input_ele;
        do
        {
            System.out.println("Enter value to insert");
            input_ele = sc.nextInt();
            return_tree =insert_into_bst(return_tree,input_ele);
        }
        while(input_ele!=-1);
        return return_tree;
    }

    public static TreeNode search_node_in_bst(TreeNode tree1, int srch_ele)
    {
        if(tree1.val == srch_ele)
            return tree1;
        if(srch_ele<tree1.val)
            return search_node_in_bst(tree1.left, srch_ele);
        return search_node_in_bst(tree1.right, srch_ele);
    }

    public static TreeNode delete_node_from_bst(TreeNode input_tree, int del_ele)
    {
        TreeNode del_node = search_node_in_bst(input_tree,del_ele);
        TreeNode prev_node = null, replacement_node = del_node;
        if(del_node==null)
        {
            System.out.println("Node not found");
            return input_tree;
        }
        while(del_node.left !=null)
        {
            prev_node = del_node;
            del_node = del_node.left;
        }
        while(del_node.right != null)
        {
            prev_node = del_node;
            del_node = del_node.left;
        }
        if(del_node != replacement_node)
        {
            replacement_node.val = del_node.val;
            if(prev_node.left == del_node)
                prev_node.left = null;
            else
                prev_node.right = null;
        }
        else
        {
            TreeNode temp_tree = input_tree;
            while(del_node.val != temp_tree.val)
            {
                prev_node = temp_tree;
                if(del_node.val<temp_tree.val)
                    temp_tree = temp_tree.left;
                else
                    temp_tree = temp_tree.right;
            }
            if(del_node.val == prev_node.left.val)
                prev_node.left = null;
            else
                prev_node.right = null;
        }
        return input_tree;
    }

    public static int calc_nodes_tree(TreeNode input_tree)
    {
        if(input_tree == null)
            return 0;
        return 1 + calc_nodes_tree(input_tree.left)+ calc_nodes_tree(input_tree.right);
    }

    public static int calc_leaf_nodes_tree(TreeNode input_tree)
    {
        if(input_tree == null)
            return 0;
        if(input_tree.left == null && input_tree.right == null)
            return 1;
        return calc_leaf_nodes_tree(input_tree.left) + calc_leaf_nodes_tree(input_tree.right);
    }

    public static int calc_height_tree(TreeNode input_tree)
    {
        if(input_tree == null)
            return 0;
        return 1 + Math.max(calc_height_tree(input_tree.left), calc_height_tree(input_tree.right));
    }

    public static void level_order_traversal(TreeNode input_tree)
    {
        TreeNode tree_q[] = new TreeNode[100];
        int q_rear = -1, q_front = 0;
        if(input_tree == null)
            return;
        do
        {
            if(input_tree.left != null)
                tree_q[++q_rear] = input_tree.left;
            if(input_tree.right != null)
                tree_q[++q_rear] = input_tree.right;
            System.out.print(input_tree.val+" ");
            input_tree = tree_q[q_front++];
        }
        while(q_rear>=q_front || input_tree!=null);
    }

    public static TreeNode_c create_postfix_tree(String postfix_str)
    {
        TreeNode_c result_tree[] = new TreeNode_c[100];
        int result_top = -1;
        Stack postfix_stck = new Stack();
        initialize_stack(postfix_stck);
        for(int iterator_i=0; iterator_i<postfix_str.length();iterator_i++)
        {
            if(is_operand(postfix_str.charAt(iterator_i)))
            {
                TreeNode_c right_child = result_tree[result_top--];
                TreeNode_c left_child = result_tree[result_top--];
                TreeNode_c root = new TreeNode_c();

                root.val = postfix_str.charAt(iterator_i);
                root.left = left_child;
                root.right = right_child;
                result_tree[++result_top] = root;
            }
            else
            {
                TreeNode_c push_node = new TreeNode_c();
                push_node.val = postfix_str.charAt(iterator_i);
                result_tree[++result_top] = push_node;
            }
        }
        return result_tree[0];
    }

    public static void inorder_traversal_rcur_c(TreeNode_c input_tree)
    {
        if(input_tree==null)
            return;
        inorder_traversal_rcur_c(input_tree.left);
        System.out.print(input_tree.val+" ");
        inorder_traversal_rcur_c(input_tree.right);
    }

    public static float evaluate_postfix_expr_tree(TreeNode_c expr_tree)
    {
        if(is_operand(expr_tree.val))
        {
            float left_val = evaluate_postfix_expr_tree(expr_tree.left);
            float right_val = evaluate_postfix_expr_tree(expr_tree.right);
            switch(expr_tree.val)
            {
                case '+':
                    return left_val+right_val;
                case '-':
                    return left_val-right_val;
                case '*':
                    return left_val*right_val;
                case '/':
                    return left_val/right_val;
            }
        }
        else
            return (float)(expr_tree.val-48);
        return Integer.MIN_VALUE;
    }

    /*******************************************************************************************************************
     DS LAB Week 12 : Graphs
     Ques 1 : DFS
     Ques 2 : BFS
     Ques 3 : Find shortest path using Djikstra's algorithm(Leave: Done in Algo lab)
     Ques 5 : Sort numbers using merge sort (Leave : Done in ALgo Lab )
     Ques 6 : Sort numbers using insertion sort (Leave: Done in Algo lab)
     ******************************************************************************************************************/

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

    public static void dfs_traversal_iter(Graph input_graph , int starting_vertex)
    {
        Stack dfs_stack = new Stack();
        initialize_stack(dfs_stack);
        stack_push(dfs_stack,starting_vertex);

        while(dfs_stack.top>-1)  // Disconnected graphs not covered
        {
            int curr_vertex = stack_pop(dfs_stack);
            System.out.print((curr_vertex+1)+" ");
            input_graph.visited[curr_vertex] = true;
            for(int iterator_i=input_graph.vertices-1;iterator_i>=0;iterator_i--)
            {
                if(!input_graph.visited[iterator_i] && input_graph.graph_matrix[curr_vertex][iterator_i]==1)
                {
                    stack_push(dfs_stack,iterator_i);
                    input_graph.visited[iterator_i] = true;
                }
            }
        }

    }

    public static void dfs_traversal_rcur(Graph input_graph,int current_vertex)
    {
        System.out.print((current_vertex+1)+" ");
        input_graph.visited[current_vertex] = true;
        for(int iterator_i=0; iterator_i<input_graph.vertices; iterator_i++)
        {
            if(!input_graph.visited[iterator_i] && input_graph.graph_matrix[current_vertex][iterator_i]==1)
            {
                input_graph.visited[iterator_i] = true;
                dfs_traversal_rcur(input_graph,iterator_i);
            }
        }
    }

    public static void bfs_traversal_iter(Graph input_graph,int start_vertex)
    {
        Queue bfs_q = new Queue();
        initialize_queue(bfs_q);
        enqueue_right(bfs_q,start_vertex);
        input_graph.visited[start_vertex] = true;

        while(bfs_q.front<=bfs_q.rear)
        {
            int dqueued_ele = dequeue_left(bfs_q);
            System.out.print((dqueued_ele+1)+" ");
            for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
            {
                if(input_graph.graph_matrix[dqueued_ele][iterator_i]==1 && !input_graph.visited[iterator_i])
                {
                    enqueue_right(bfs_q,iterator_i);
                    input_graph.visited[iterator_i] = true;
                }
            }
        }
    }

    public static void display_adj_matrix(Graph input_graph)
    {
        for(int iterator_i=0;iterator_i<input_graph.vertices;iterator_i++)
        {
            for(int iterator_j=0;iterator_j<input_graph.vertices;iterator_j++)
                System.out.print(input_graph.graph_matrix[iterator_i][iterator_j]+" ");
            System.out.println();
        }
    }

    /*******************************************************************************************************************
             START OF MAIN
     ******************************************************************************************************************/
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

    /******************************************************************************************************************
             WEEK 3
     *****************************************************************************************************************/

    /*    // Runner for W3.Q1
        System.out.println("Decimal To Binary Conversion");
        int n = sc.nextInt();
        System.out.println("Decimal Number:\t"+n+"\nBinary Number:\t"+dec_2_bin(n));
    */

    /*    // Runner for W3.Q2
        System.out.println("Factorial Computation\nEnter n:\t");
        int n = sc.nextInt();
        System.out.println("Factorial of \t"+n+"\t is \t"+factorial(n));
    */

    /*    //Runner for W3.Q3
        System.out.println("Fibonacci Term\nEnter value of n\n");
        int n = sc.nextInt();
        System.out.println("nth Fibonacci term is\t"+fibonacci(n-1));
    */

    /*    // Runner for W3.Q4
        System.out.println("GCD Computation\nEnter 2 number a and b\t");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("GCD of the number "+a+" and "+b+" is\t"+calc_gcd(a,b));
    */

    /*    // Runner for W3.Q5
        System.out.println("Product of 2 numbers\nEnter 2 number a and b\t");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("The product of 2 numbers is\t"+product_2_nums(a,b));
    */

    /*    // Runner for W3.Q6
        System.out.println("Sum Of List\nEnter length or array\t");
        int size = sc.nextInt();
        System.out.println("Enter numbers");
        int arr[] = new int[size];
        for(int iterator_i = 0; iterator_i < size; iterator_i++)
            arr[iterator_i] = sc.nextInt();
        System.out.println("The sum of list is\t"+sum_of_list(arr,size));
    */

    /*    // Runner for W3.Q7
        System.out.println("Tower of Hanoi\nEnter value of n\t:");
        int n = sc.nextInt();
        System.out.println("Sequence of steps are :\n");
        tower_of_hanoi(n,'A','C','B');
    */

    /******************************************************************************************************************
         WEEK 4
    *****************************************************************************************************************/


    /*    // Runner for W4.Q1
        System.out.println("Decimal to Binary Conversion\nEnter String\t");
        Stack bin_stck = dec_to_binary_stack(sc.nextInt());
        System.out.println("Binary Representation:\n");
        stack_display_char(bin_stck);
    */

    /*    // Runner for W4.Q2
        System.out.println("Check For Palindrome\nEnter string");
        String inp_str = sc.nextLine();
        switch(check_palindrome_stack(inp_str))
        {
            case 0:
                System.out.println("Palindrome Rejected");
                break;
            case 1:
                System.out.println("Palindrome Accepted");
                break;
        }
    */

     /*   // Runner for W4.Q3

        Stack stck = new Stack();
        stck.top = -1;
        stck.carr = new char[stck.max_top + 1];
        stck.arr = new int[stck.max_top + 1];
        int ch;
        do
        {
            System.out.println("Enter your choice\n1. Push\n2. Pop\n3. Display \n4. Exit");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Enter number to push:\t");
                    stack_push(stck, sc.nextInt());
                    break;
                case 2:
                    stack_pop(stck);
                    break;
                case 3:
                    stack_display(stck);
                    break;
                case 4:

            }
        }
        while (ch  != 4);
        */

     /******************************************************************************************************************
         WEEK 5
     *****************************************************************************************************************/
     /*   // Runner for W5.Q1
        System.out.println("Infix to Prefix\nEnter infix expression");
        String infix_expr = sc.nextLine();
        System.out.println("Prefix_expression:");
        stack_display_char(infix_to_prefix(infix_expr));
     */

     /*   // Runner for W5.Q2
        System.out.println("Infix to Postfix\nEnter infix expression");
        String infix_expr = sc.nextLine();
        System.out.println("Postfix Expression is:");
        stack_display_char(infix_to_postfix(infix_expr));
        // 1+2*3 = 123*+   4*(1+2)*3 = 412+*3*  1/2*3 = 12/3* (if op >= top pop stack)
     */

     /*   //Runner for W5.Q3
        System.out.println("Postfix Evaluation\nEnter postfix expression");
        String postfix_expr = sc.nextLine();
        System.out.println("The postfix evaluation is:\t"+ evaluate_postfix(postfix_expr));
     */

     /*   // Runner for W5.Q4
        System.out.println("Prefix Evaluation\nEnter prefix expression");
        String prefix_expr = sc.nextLine();
        System.out.println("The prefix evaluation is:\t"+ evaluate_prefix(prefix_expr));
     */

     /*   // Runner for W5.Q5
        System.out.println("Postfix to Prefix Conversion\nEnter Postfix Expression");
        String postfix_str = sc.nextLine();
        System.out.println("The prefix equivalent is");
        stack_display_string(postfix_to_prefix(postfix_str));
     */

     /*   // Runner for W5.Q6
        System.out.println("Prefix to Postfix Conversion\nEnter Prefix Expression");
        String prefix_str = sc.nextLine();
        System.out.println("The postfix equivalent is");
        prefix_to_postfix(prefix_str);
     */

     /******************************************************************************************************************
        WEEK 6
     *****************************************************************************************************************/

     /*   // Runner for W6.Q1
        System.out.println("Basic Queue Operations");
        Queue basic_q = new Queue();
        int ip_choice;
        initialize_queue(basic_q);
        do
        {
            System.out.println("Enter you choice\n1. Enqueue\n2. Dequeue \n3. Display\n4. Exit");
            ip_choice = sc.nextInt();
            switch(ip_choice)
            {
                case 1:
                    System.out.println("Enter integer to enqueue\t");
                    enqueue_right(basic_q, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Dequeued element is\t"+dequeue_left(basic_q));
                    break;
                case 3:
                    queue_display(basic_q);
            }
        }
        while(ip_choice!=4);

     */

     /*   //Runner for W5.Q2
        System.out.println("Full Queue Operations");
        Queue fullop_q = new Queue();
        int ip_choice;
        initialize_queue(fullop_q);
        do
        {
            System.out.println("Enter you choice\n1. Enqueue right\n2. Enqueue left\n3. Dequeue right\n4. Dequeue left\n5. Display\n6. Exit");
            ip_choice = sc.nextInt();
            switch(ip_choice)
            {
                case 1:
                    System.out.println("Enter integer to enqueue");
                    enqueue_right(fullop_q, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer to enqueue");
                    enqueue_left(fullop_q, sc.nextInt());
                    break;
                case 3:
                    System.out.println("Dequeued element is\t"+dequeue_right(fullop_q));
                    break;
                case 4:
                    System.out.println("Dequeued element is\t"+dequeue_left(fullop_q));
                    break;
                case 5:
                    queue_display(fullop_q);
            }
        }
        while(ip_choice!=6);
    */

     /*   // Runner for W6.Q3
        System.out.println("Circular Queue for Strings");
        Queue circular_queue = new Queue();
        initialize_queue(circular_queue);
        int ip_choice;

        do
        {
            System.out.println("Enter choice\n1. Circular Enqueue\n2. Circular Dequeue\n3. Circular Display\n4. Exit");
            ip_choice = sc.nextInt();
            switch(ip_choice)
            {
                case 1:
                    System.out.println("Enter string to enqueue");
                    circular_enqueu_str(circular_queue,sc.next());
                    break;
                case 2:
                    System.out.println("Dequeued element is\t"+circular_dequeue_str(circular_queue));
                    break;
                case 3:
                    circular_display_str(circular_queue);
            }
        }
        while(ip_choice!=4);
    */

     /*   // Runner for W7.Q2
        System.out.println("Ascending Priority Queue");
        int input_ch ;
        Queue asc_prio_q = new Queue();
        initialize_queue(asc_prio_q);
        do
        {
            System.out.println("Enter choice\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            input_ch = sc.nextInt();
            switch(input_ch)
            {
                case 1:
                    System.out.println("Enter element to enter");
                    asc_priority_q_insert(asc_prio_q,sc.nextInt());
                    break;
                case 2:
                    System.out.println("Dequeued element is"+asc_priority_q_dequeue(asc_prio_q));
                    break;
                case 3:
                    queue_display(asc_prio_q);
                    break;
            }
        }
        while(input_ch != 4);
    */

     /*   // Runner for W7.Q3.partA
        System.out.println("Stacks using output restricted queue"); // No delete right
        Queue dequeu_stack = new Queue();
        initialize_queue(dequeu_stack);

        int input_ch;
        do
        {
            System.out.println("Enter choice\n1. Push\n2. Pop\n3. Display\n4. Exit");
            input_ch = sc.nextInt();
            switch(input_ch)
            {
                case 1:
                    System.out.println("Enter value to push");
                    enqueu_for_stack_or(dequeu_stack, sc.nextInt());
                    break;
                case 2:
                    dequeu_stack = dequeu_for_stack_or(dequeu_stack);
                    break;
                case 3:
                    queue_display(dequeu_stack);
                    break;
            }
        }
        while(input_ch != 4);
    */

     // Runner for W7.Q3PartB not required. All queue operations provided by deque

     /*   // Runner for W7.Q4PartA
        System.out.println("Stacks using input restricted deque"); // no insert right
        Queue dequeu_stack = new Queue();
        initialize_queue(dequeu_stack);

        int input_ch;
        do
        {
            System.out.println("Enter choice\n1. Push\n2. Pop\n3. Display\n4. Exit");
            input_ch = sc.nextInt();
            switch(input_ch)
            {
                case 1:
                    System.out.println("Enter value to push");
                    dequeu_stack = enqueu_for_stack_ir(dequeu_stack, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Popped element is\t"+dequeu_for_stack_ir(dequeu_stack));
                    break;
                case 3:
                    queue_display(dequeu_stack);
                    break;
            }
        }
        while(input_ch != 4);
    */

     /*   // Runner for W7.Q4PartB
        System.out.println("Queues using input restricted dequeue"); // no insert right
        Queue dequeu_q = new Queue();
        initialize_queue(dequeu_q);

        int input_ch;
        do
        {
            System.out.println("Enter choice\n1. Push\n2. Pop\n3. Display\n4. Exit");
            input_ch = sc.nextInt();
            switch(input_ch)
            {
                case 1:
                    System.out.println("Enter value to push");
                    dequeu_q = enqueu_for_q_ir(dequeu_q, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Dequeued element is\t"+dequeu_for_q_ir(dequeu_q));
                    break;
                case 3:
                    queue_display(dequeu_q);
                    break;
            }
        }
        while(input_ch != 4);
    */

    /******************************************************************************************************************
         WEEK 8
    *****************************************************************************************************************/

    /*    // Runner for W8Q1
        System.out.println("Implement stacks using linked list");
        SinglyLinkedList linklist_stck = null;
        int input_ch;
        do
        {
            System.out.println("Enter choice\n1. Push\n2. Pop\n3. Display\n4. Exit");
            input_ch = sc.nextInt();
            switch(input_ch)
            {
                case 1:
                    System.out.println("Enter element");
                    linklist_stck = linkedlist_stck_push(linklist_stck, sc.nextInt());
                    break;
                case 2:
                    linklist_stck =  linkedlist_stck_pop(linklist_stck);
                    break;
                case 3:
                    linkedlist_display(linklist_stck);
            }

        }
        while(input_ch != 4);
    */

    /*    // Runner for W8Q2
        System.out.println("Implement queues using linkedlist");
        SinglyLinkedList linklist_q = null;
        int input_ch;
        do
        {
            System.out.println("Enter choice\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            input_ch = sc.nextInt();
            switch(input_ch)
            {
                case 1:
                    System.out.println("Enter value to insert");
                    linklist_q = linkedlist_q_enqueue(linklist_q,sc.nextInt());
                    break;
                case 2:
                    linklist_q = linkedlist_q_dequeue(linklist_q);
                    break;
                case 3:
                    linkedlist_display(linklist_q);
            }
        }
        while(input_ch!=4);
    */

    /*    //  Runner for W8.Q3
        System.out.println("Merge 2 circular linked node with header node(sorted)");

        SinglyLinkedList list1 = create_circular_linked_listh(sc);
        SinglyLinkedList list2 = create_circular_linked_listh(sc);
        System.out.println("The merged circular list is");
        display_circular_linked_listh(merge_circ_listh(list1,list2));

    */

    /*    // Runner for W8.Q4
        System.out.println("Union using singlty circular linked list");
        SinglyLinkedList list1 = create_circular_linked_listh(sc);
        SinglyLinkedList list2 = create_circular_linked_listh(sc);

        display_circular_linked_listh(union_circ_linked_listh(list1, list2));
    */

    /*    // Runner for W8.Q5
        System.out.println("Intersection using doubly linked list");
        DoublyLinkedList list1 = create_doubly_linked_list(sc);
        DoublyLinkedList list2 = create_doubly_linked_list(sc);

        dlinkedlist_display(intersection_dlink_list(list1,list2));

    */

    /******************************************************************************************************************
         WEEK 9
    *****************************************************************************************************************/

    /*    // Runner for W9.Q1
        System.out.println("Menu Driven calculation on polynomials");
        SinglyLinkedList list1 = create_polynomial_list(sc);
        SinglyLinkedList list2 = create_polynomial_list(sc);
        int input_ch;
        do
        {
            System.out.println("Enter choice\n1. Add\n2. Subtract\n3. Multiply\n4. Exit");
            input_ch = sc.nextInt();

            switch(input_ch)
            {
                case 1:
                    System.out.println("Result of addition is\t");
                    add_polynomials(list1, list2);
                    break;
                case 2:
                    System.out.println("Result of subtraction is\t");
                    sub_polynomials(list1, list2);
                    break;
                case 3:
                    System.out.println("Result of multiplication is\t");
                    mul_polynomials(list1, list2);
                    break;
            }
        }
        while(input_ch!=4);
    */

    /*    // Runner for W9.Q2

        System.out.println("Add two positive integers represented using circular doubly linked list with header node.");
        DoublyLinkedList list1 =  create_circular_dlinked_list(sc);
        DoublyLinkedList list2 = create_circular_dlinked_list(sc);
        display_circular_dlinked_listh( add_long_numbers(list1, list2) );
    */

    /*    // Runner for W9.Q3
        System.out.println("Reverse doubly linked list");
        DoublyLinkedList list1 = create_doubly_linked_list(sc);
        dlinkedlist_display(list1);
        dlinkedlist_display(reverse_doubly_linked_list(list1));
    */

    /*    // Runner for W9.Q4
        System.out.println("Reverse singly linked list");
        SinglyLinkedList list1 = create_singly_linked_list(sc);
        linkedlist_display( reverse_singly_linked_list(list1));
    */

    /******************************************************************************************************************
         WEEK 10
    *****************************************************************************************************************/

    /*    // Runner for W10.Q1
        System.out.println("Create binary tree recursively");
        TreeNode tree1 = null;
        tree1 = create_binary_tree(tree1,sc);

        display_binary_tree(tree1);
    */

    /*    // Runner for W10.Q2
        System.out.println("Search for node in a tree");
        TreeNode tree1 = null;
        tree1 = create_binary_tree(tree1,sc);
        System.out.println("Enter element to be searched");
        System.out.println("Is Search Successful:\t"+search_in_binary_tree(tree1,sc.nextInt()));
    */

    /*    // Runner for W10.Q3 Part A
        System.out.println("Recursive Traversals: Inorder, Preorder, Postorder");
        TreeNode tree1 = null;
        tree1 = create_binary_tree(tree1,sc);
        //perform_rcur_traversals(tree1);


        // Runner for W10.Q4 Part B
        System.out.println("\nIterative traversals: Inorder, Preorder, Postorder");
        perform_iter_traversals(tree1);

    */

    /*    // Runner for W10.Q4
        System.out.println("Check if 2 binary trees are equal");
        System.out.println("Enter Tree 1");
        TreeNode tree1 = null, tree2 = null;
        tree1 = create_binary_tree(tree1,sc);
        System.out.println("Enter Tree 2");
        tree2 = create_binary_tree(tree2,sc);
        System.out.println("Are trees equal:\t"+compare_binary_trees(tree1,tree2));
    */

    /******************************************************************************************************************
         WEEK 11
    *****************************************************************************************************************/

        // Runner for W11.Q1
        System.out.println("Insert in BST");
        TreeNode tree1 = create_bst(sc);
        inorder_traversal_rcur(tree1);


    /*    // Runner for W11.Q2
        System.out.println("Delete node in BST");
        TreeNode tree1 = create_bst(sc);
        System.out.println("Enter node to be deleted");
        tree1 = delete_node_from_bst(tree1,sc.nextInt());
        inorder_traversal_rcur(tree1);
    */

    /*    // Runner for W11.Q3
        System.out.println("Print no. of nodes, leaves, height");
        TreeNode tree1 = create_bst(sc);
        System.out.println("No. of nodes are:\t"+calc_nodes_tree(tree1));
        System.out.println("No. of leaf nodes are:\t"+calc_leaf_nodes_tree(tree1));
        System.out.println("Height of tree is:\t"+calc_height_tree(tree1));
    */

    /*    // Runner for W11.Q4
        System.out.println("Level Order Traversal");
        TreeNode tree1 = create_bst(sc);
        System.out.println("Level Order Traversal is:");
        level_order_traversal(tree1);
    */

    /*    // Runner for W11.Q5
        System.out.println("Convert postfix expression to a tree and evaluate it");
        System.out.println("Enter postfix expression");
        String postfix_str = sc.nextLine();
        TreeNode_c tree1 = create_postfix_tree(postfix_str);
        //inorder_traversal_rcur_c(tree1);
        System.out.println("result of postfix expression is:\t"+evaluate_postfix_expr_tree(tree1));
    */

    /******************************************************************************************************************
         WEEK 12
    *****************************************************************************************************************/

    /*    // Runner for W12.Q1
        System.out.println("Depth First  Traversal"); // extend for search
        Graph graph1 = create_graph(sc);
        dfs_traversal_iter(graph1,0);
        dfs_traversal_rcur(graph1,0);
    */

    /*    // Runner for W12.Q2
        System.out.println("Breadth First Search");
        Graph graph1 = create_graph(sc);
        bfs_traversal_iter(graph1,0);
    */

    }
}
