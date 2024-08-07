class Activity_Selection{
    public static int getMaximumActivity(int start_time[], int end_time[]){
        int max_activity = 1;
        int last_selected_activity = end_time[0];

        // here we will use for loop
        for(int i=0; i<start_time.length; i++){
            if(start_time[i] >= last_selected_activity){
                max_activity++;
                last_selected_activity = end_time[i];
            }
        }
        return max_activity;
    }
    public static void main(String[] args) {
        int start_time[] = {1,3,0,5,8,5};
        int end_time[] = {2,4,6,7,9,9};

        int max_activity = getMaximumActivity(start_time, end_time);
        System.out.println("Maximum Activity any one perform "+ max_activity);


    }
}