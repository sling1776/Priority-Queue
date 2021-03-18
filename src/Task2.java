public class Task2  extends Task {
    public Task2(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }
    // Prioirity is start time unless tie, then deadline
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task1 compareTo");
        if(start == t2.start){
            return deadline - t2.deadline;
        }
        return start-t2.start;
    }

}
