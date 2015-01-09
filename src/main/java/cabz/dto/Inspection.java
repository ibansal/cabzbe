package cabz.dto;

public class Inspection {

	private long inspectionDate;
	
	private String inspector;
	
	private String inspectionLocation;
	
	private long startTime;
	
	private long endTime;
	
	private String inspectionComments;

	public long getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(long inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public String getInspectionLocation() {
		return inspectionLocation;
	}

	public void setInspectionLocation(String inspectionLocation) {
		this.inspectionLocation = inspectionLocation;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getInspectionComments() {
		return inspectionComments;
	}

	public void setInspectionComments(String inspectionComments) {
		this.inspectionComments = inspectionComments;
	}
	
	
}
