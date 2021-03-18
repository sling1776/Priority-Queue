import java.lang.reflect.Array;
import java.util.ArrayList;

public class Scheduler {
    leftistMinHeap<Task> queue;

    public Scheduler(){
        queue = new leftistMinHeap<Task>();
    }


    public void makeSchedule(ArrayList<Task> tasks){
        //set up initial conditions
        if(tasks == null){
            System.out.println("Some one messed with the code in the Test Document"); return;}

        int time = 0;
        if(tasks.size()>0){
            queue.Insert(tasks.get(0));
            tasks.remove(0);

        }
        Task curTask = null;
        int durationCount = 1;
        int lateTasks = 0;
        int lateMinutes = 0;
        int taskMarker = 0;

        //time loop
        while( !queue.isEmpty() || curTask != null || taskMarker < tasks.size()){
            time ++;
            //insert all needed tasks

            for(int i = 0; i < tasks.size(); i++){
                if (time == tasks.get(i).start){
                    queue.Insert(tasks.get(i));
                    taskMarker ++;
                }
            }

//            if(!tasks.isEmpty()){
//                while(time == tasks.get(0).start){ // assuming the tasks are in order by start time as I checked....
//                    queue.Insert(tasks.get(0));
//                    tasks.remove(0);
//                }
//            }

            durationCount++;
            if(curTask == null) {
                curTask = queue.removeMin();
                durationCount = 1;
            }

            //declare time function
            StringBuilder stringBuilder = new StringBuilder();
            //if there is a current task:
            if(curTask !=null) {
                stringBuilder.append("Time ");
                stringBuilder.append(time);
                stringBuilder.append(": Task ");
                stringBuilder.append(curTask.ID);




                if (curTask.duration == durationCount) {
                    stringBuilder.append(" **");
                    if (curTask.deadline < time) {
                        stringBuilder.append("Late by: ");
                        stringBuilder.append(time - curTask.deadline);
                        lateMinutes += time - curTask.deadline;
                        lateTasks++;
                    }
                    curTask = null;

                }
            //no current task then skip.
            }else {
                stringBuilder.append("Time ");
                stringBuilder.append(time);
                stringBuilder.append(": Task NONE");
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println("Late Tasks:" + lateTasks + " Late Minutes: " + lateMinutes);

    }




}
