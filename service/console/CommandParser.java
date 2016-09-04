import java.util.HashMap;
import java.util.Map;

public class CommandParser {
	private Map<String, String> argsMap = new HashMap<String, String>();
	
	public Command parse(String args) {
		String[] argsData = args.split("[ \t]+");
		
		if (argsData.length > 0) {
			Command.CommandName name = Command.CommandName.valueOf(argsData[0].toUpperCase());
			Command.CommandArg type = null;
			
			if (name.equals(Command.CommandName.ADD)) {
				type = Command.CommandArg.valueOf(argsData[1].toUpperCase());
				
				String description = new String("");
				int index = 2;
				while (!argsData[index].startsWith("--")) {
					description += argsData[index] + " ";
					index++;
				}
				
				argsMap.put("description", description.trim());
				
				String key = new String("");
				String value = new String("");
				for (int i = index; i < argsData.length; i++) {
					if (argsData[i].startsWith("--")) {
						key = argsData[i];
					}
					else {
						value = argsData[i];
					}
					
					if (!key.isEmpty() && !value.isEmpty()) {
						argsMap.put(key, value);
						
						key = new String("");
						value = new String("");
					}
				}
			}
			else {
				new Command(name, null, null);
			}
			
			return new Command(name, type, argsMap);
		}
		else {
			return null;
		}
		
	}
}