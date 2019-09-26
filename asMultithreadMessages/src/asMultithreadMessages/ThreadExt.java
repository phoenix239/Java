package asMultithreadMessages;

public class ThreadExt extends Thread{
	String id;
	int reps;
	
	public ThreadExt(String inputId, int inputReps) {
		id = inputId;
		reps = inputReps;
	}

	public void run() 
    {
		while(reps > 0) {
			System.out.print(id); 
			reps--;
			}
		}

}
