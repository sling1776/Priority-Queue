public class Task3  extends Task {
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }
    // Prioirity is duration unless tie, then deadline.
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task1 compareTo");
        if(duration == t2.duration){
            return deadline - t2.deadline;
        }
        return duration-t2.duration;
    }

}
