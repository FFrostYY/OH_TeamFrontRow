package App;

public class Main {

	public static void main(String[] args) {
		ProtoMain communication = new ProtoMain();
		Pseudomain_Planner planner = new Pseudomain_Planner();
		communication.programCommunicator();
		planner.Pseudomain();
	}

}
