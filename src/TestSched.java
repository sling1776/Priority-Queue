import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestSched {


    public static void readTasks(String filename,
                          ArrayList<Task> task1, ArrayList<Task> task2,
                                 ArrayList<Task> task3) throws FileNotFoundException {
        // Create lists where base type is different
        File f = new File(filename);

        Scanner scanner = new Scanner(f);
        int taskID = 1;
        while(scanner.hasNext()){
            int start = scanner.nextInt();
            int deadline = scanner.nextInt();
            int duration = scanner.nextInt();
            Task1 t1 = new Task1(taskID, start, deadline, duration);
            Task2 t2 = new Task2(taskID, start, deadline, duration);
            Task3 t3 = new Task3(taskID, start, deadline, duration);
            task1.add(t1);
            task2.add(t2);
            task3.add(t3);
            taskID++;
        }

    }

    public static void main(String args[]) throws FileNotFoundException {
        Scheduler s = new Scheduler();
        String [] files = {"taskset1.txt","taskset2.txt","taskset3.txt","taskset4.txt","taskset5.txt" };
        for (String f : files) {
            ArrayList<Task> t1 = new ArrayList();    // elements are Task1
            ArrayList<Task> t2 = new ArrayList();    // elements are Task2
            ArrayList<Task> t3 = new ArrayList();    // elements are Task3
            readTasks(f, t1, t2, t3);
            System.out.println("\nPriority Deadline: " + f);
            s.makeSchedule( t1);
            System.out.println("\nPriority StartTime: " + f);
            s.makeSchedule(t2);
            System.out.println("\nPriority Duration: " + f);
            s.makeSchedule( t3);
       }

    }
}
