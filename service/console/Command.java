import java.util.Map;

public class Command {
	public enum CommandName {
		ADD, REMOVE, START, STOP, EXIT;
	}
	
	public enum CommandArg {
		TASK, MODULE;
	}
	
	private CommandName name;
	private CommandArg type;
	private Map<String, String> args;
	
	public Command() {
		
	}
	
	public Command(CommandName name, CommandArg type, Map<String, String> args) {
		this.name = name;
		this.type = type;
		this.args = args;
	}
	
	public CommandName getName() {
		return this.name;
	}
	
	public void setName(CommandName name) {
		this.name = name;
	}
	
	public CommandArg getType() {
		return this.type;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

	public void setType(CommandArg type) {
		this.type = type;
	}
	
	
}