public class CommandParser {
	private Map<String, String> args = new HashMap<String, String>();
	
	public static Command parse(String args) {
		String[] argsData = args.split("[ \t]+");
		
		if (argsData.length > 0) {
			CommandName name = CommandName.valueOf(argsData[0]);
			CommandArg = null;
			
			if (commandName.equal(CommandName.ADD) {
				type = CommandArg.valueOf(argsData[1]);
				
				args.put("description", args[2]);
				
				String key = new String("");
				String value = new String("");
				for (int i = 3; i < argsData.length; i++) {
					if (argsData[i].startsWith("--")) {
						key = argsData[i];
					}
					else {
						value = argsData[i];
					}
					
					if (!key.isEmpty() && !value.isEmpty()) {
						args.put(key, value);
						
						key = new String("");
						value = new String("");
					}
				}
			}
			else {
				new Command(name, null, null);
			}
			
			return new Command(name, type, args);
		}
		else {
			return null;
		}
		
	}
}