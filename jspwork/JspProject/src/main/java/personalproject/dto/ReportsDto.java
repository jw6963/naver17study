package personalproject.dto;

import java.sql.Timestamp;

public class ReportsDto {
	private int reportId;
	private String reporter;
	private TargetType targetType;
	private String reason;
	private Timestamp reportAt;
	private Status status;
	
	// Enum for targetType
    public enum TargetType {
        POST, COMMENT, MESSAGE;
    }

    // Enum for status
    public enum Status {
        PENDING, REVIEWED, ACTION_TAKEN;
    }
    
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public TargetType getTargetType() {
		return targetType;
	}
	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Timestamp getReportAt() {
		return reportAt;
	}
	public void setReportAt(Timestamp reportAt) {
		this.reportAt = reportAt;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
