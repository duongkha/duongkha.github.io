/**
 * 
 */
package com.students.domain;

import java.io.Serializable;
import javax.validation.constraints.Size;
/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(min=3,max=3,message="{Size.area}")
 	private Integer area;
	@Size(min=3,max=3,message="{Size.prefix}")
 	private Integer prefix;
	@Size(min=4,max=4,message="{Size.number}")
 	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
