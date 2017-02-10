package ${package}.common.exception;

public enum CommonExcs implements ExcsEnum {

	DB_ERROR(2, "Database Error", "Database Error")

	;
	
	private int code;

	private String desc;

	private String message;

	CommonExcs(int code, String desc, String message) {
		this.code = code;
		this.desc = desc;
		this.message = message;
	}

	CommonExcs(int code, String message) {
		this(code, null, message);
	}

	public String toString() {
		return code + ":" + desc + ":" + message;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
