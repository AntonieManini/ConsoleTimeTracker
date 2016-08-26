public class ConsoleService implements Runnable {
	private Scanner scanner;
	
	public ConsoleService() {
		try {
			scanner = new Scanner(System.in);
		}
		catch (Exception e) {
			
		}
	}
	
	@Override
	public void run {
		Command currentCommand = new Command();
		
		while (currentCommand.getCommandName() != EXIT) {
			String stringCommand = scanner.getLine();
			
			currentCommand = CommandParser.parse(stringCommand);
			
			switch (currentCommand) {
				case ADD: 
			}
		}
	}
	
	private void add(Map<String, String> args) {
		
	}
	
	private void remove(Map<String, String> args) {
		
	}

	private void start(Map<String, String> args) {
		
	}

	private void stop(Map<String, String> args) {
		
	}	
	
	public void start() throws Exception {
		new Thread(this).start();
	}
}