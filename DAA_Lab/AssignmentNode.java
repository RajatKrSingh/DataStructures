package DAA_Lab;

public class AssignmentNode {
    int[] assignment_position;
    int bound,current_position;

    public AssignmentNode(int[] assignment_position,int bound,int current_position)
    {
        this.assignment_position = new int[assignment_position.length];
        for(int iterator_i=0;iterator_i<assignment_position.length;iterator_i++)
            this.assignment_position[iterator_i] = assignment_position[iterator_i];
        this.bound = bound;
        this.current_position = current_position;
    }
}
