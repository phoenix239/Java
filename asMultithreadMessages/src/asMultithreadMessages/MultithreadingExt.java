package asMultithreadMessages;

public class MultithreadingExt extends Thread{
	String id;
	int reps;
	
	public MultithreadingExt(String inputId, int inputReps) {
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
