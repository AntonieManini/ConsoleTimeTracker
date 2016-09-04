import java.util.Calendar;
import java.util.Date;

public class Task {
	private Calendar startTime;
	private Calendar endTime;	
	private Module module;	
	private String description;
	
	public Calendar getStartTime() {
		return this.startTime;
	}
	
	public Calendar getEndTime() {
		return this.endTime;
	}
	
	public Module getModule() {
		return this.module;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	
	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Task [startTime=" + startTime + ", endTime=" + endTime
				+ ", module=" + module + ", description=" + description + "]";
	}
	
	
}