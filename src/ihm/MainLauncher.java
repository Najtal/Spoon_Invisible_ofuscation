package ihm;

public class MainLauncher {

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		System.out.println(args.toString());
		
		if (args.length == 3) {
			new Controller(new Model(args[0], args[1], args[2])).actionProceed();
		} else {
			new Model();	
		}
		
	}
	
}
