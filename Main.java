public class Main {
	public static void main(String args[]) {
		try {
			System.out.println("Starting CTT");
			
			new ConsoleService().run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}