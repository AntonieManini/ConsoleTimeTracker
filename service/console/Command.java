public class Command {
	public enum CommandName {
		ADD, REMOVE, START, STOP, EXIT
	}
	
	public enum CommandArg {
		TASK, MODULE
	}
	
	private CommandName commandName;
	private Map<String, String> args;
	
	public getCommandName() {
		return this.commandName;
	}
	
	public setCommandName(CommandName commandName) {
		this.commandName = commandName;
	}
}