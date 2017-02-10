package ${package}.common.exception;

import java.io.Serializable;

public interface ExcsEnum extends Serializable {

	int getCode();

	String getDesc();

	String getMessage();
	
	String getTitle();
	
}
