import java.util.ArrayList;
import java.util.Collections;

public class Job_Sequencing {
    public static ArrayList getMaximumJob(int job_seq[][]){
        ArrayList<Job>arr = new ArrayList<>();

        // here we will add all job
        for(int i =0; i<job_seq.length; i++){
            arr.add(new Job(job_seq[i][0],job_seq[i][1] , i));
        }

        // here we will sort based on deadline
        Collections.sort(arr, (obj1, obj2) -> obj2.time - obj1.time);

        ArrayList<Integer>seq = new ArrayList<>();
        // int last selected time
        int time = 0;
        for(int i =0; i<arr.size(); i++){
           Job curr = arr.get(i);
           if(curr.deadline > time){
                seq.add(curr.idx);
                time=curr.deadline;
           }
        }

        return seq;
    }   
    public static void main(String args[]){
        int job_seq[][] = {{4,20}, {1,10}, {1,40}, {1,30}};

        ArrayList max_job_done = getMaximumJob(job_seq);
        System.out.println(max_job_done);
    }
}

class Job{
    int time;
    int deadline;
    int idx;

    public Job(int time, int deadline, int idx){
        this.time = time;
        this.deadline = deadline;
        this.idx = idx;
    }
}
