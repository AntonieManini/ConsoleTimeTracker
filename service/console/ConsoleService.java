import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

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
	public void run() {
		Command currentCommand = new Command();
		
		while (currentCommand.getName() != Command.CommandName.EXIT) {
			System.out.print(">> ");			
			String stringCommand = scanner.nextLine();
			
			CommandParser parser = new CommandParser();
			currentCommand = parser.parse(stringCommand);
			
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
		if (cmd.getType().equals(Command.CommandArg.TASK)) {
			task = new Task();		
			
			this.task.setDescription(cmd.getArgs().get("description"));
			this.task.setModule(new Module(cmd.getArgs().get("--module")));
			
			System.out.println(this.task);
		}
	}
	
	private void remove(Map<String, String> args) {
		//will be implemented later
	}

	private void start() {
		this.task.setStartTime(Calendar.getInstance());
		
		System.out.println(this.task);
	}

	private void stop() {
		this.task.setEndTime(Calendar.getInstance());
		
		FileWriter writer = null;		
		try {
			File outputFile = new File(String.format("%d_%02d_%02d.txt", this.task.getStartTime().get(Calendar.YEAR), 
					this.task.getStartTime().get(Calendar.MONTH) + 1, this.task.getStartTime().get(Calendar.DAY_OF_MONTH)));
			
			writer = new FileWriter(outputFile.getAbsoluteFile(), true);

			writer.write(this.task.getStartTime().get(Calendar.HOUR_OF_DAY) + ":" + this.task.getStartTime().get(Calendar.MINUTE) + System.lineSeparator());
			writer.write(this.task.getEndTime().get(Calendar.HOUR_OF_DAY) + ":" + this.task.getEndTime().get(Calendar.MINUTE) + System.lineSeparator());
			writer.write(this.task.getDescription() + System.lineSeparator());
			writer.write(this.task.getModule().getName() + System.lineSeparator());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
	public void launch() throws Exception {
		thread = new Thread(this);
		thread.start();
	}
	
	public void exit() {
		System.out.println("Exiting.");
		System.exit(0);
	}
}