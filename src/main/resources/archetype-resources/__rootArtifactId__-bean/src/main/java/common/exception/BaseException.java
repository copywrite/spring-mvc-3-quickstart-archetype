package ${package}.common.exception;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 6411783744379345452L;

	protected ExcsEnum excsEnum;

	protected Map<String, Object> attributeMap;

	protected Long sellerId;

	protected String desc;

	public BaseException(ExcsEnum excsEnum, Throwable cause) {
		super(excsEnum.getCode() + " : " + excsEnum.getMessage() + ", " + excsEnum.getDesc(), cause);
		this.excsEnum = excsEnum;
	}

	public ExcsEnum getExcsEnum() {
		return excsEnum;
	}

	public Map<String, Object> getAttributeMap() {
		return attributeMap;
	}

	public Object getAttributeValue(String key) {
		if (attributeMap == null) {
			return null;
		}
		return attributeMap.get(key);
	}

	public BaseException addAttribute(String key, Object value) {
		if (key != null) {
			if (attributeMap == null) {
				attributeMap = new HashMap<String, Object>();
			}
			attributeMap.put(key, value);
		}
		return this;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
