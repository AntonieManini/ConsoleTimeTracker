import Command.CommandName;

public class ConsoleService implements Runnable {
	private Scanner scanner;
	private Task task;
	private Thread thread;
	
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
		
		while (currentCommand.getName() != EXIT) {
			String stringCommand = scanner.getLine();
			
			currentCommand = CommandParser.parse(stringCommand);
			
			if (currentCommand != null) {
				switch (currentCommand.getName()) {
					case ADD: 
						add(currentCommand);
						break;
					case START:
						start();
						break;
					case STOP:
						stop();
						break;
					case EXIT:
						exit();
						break;
				}				
			}			
		}
	}
	
	private void add(Command cmd) {
		if (cmd.getType())
		task = new Task();		
		
		this.task.setDescription(cmd.getArgs().get("description"));
		this.task.setModule(new Module(cmd.getArgs().get("module")));
	}
	
	private void remove(Map<String, String> args) {
		//will be implemented later
	}

	private void start() {
		this.task.setStartTime(new Date());
	}

	private void stop() {
		this.task.setEndTime(new Date());
		//write to text file
	}	
	
	public void launch() throws Exception {
		thread = new Thread(this);
		thread.start();
	}
	
	public void exit() {
		this.thread.interrupt();
	}
}