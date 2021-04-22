/**
 * 
 */
package com.students.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Min(value = 100, message = "This must be exact at 3 digits")
	@Max(value = 999, message = "This must be exact at 3 digits")
	//@Digits(integer = 3, fraction = 0, message = "This must be exact at {2} digits")
 	private Integer area;

	@NotNull
	@Min(value = 100, message = "This must be exact at 3 digits")
	@Max(value = 999, message = "This must be exact at 3 digits")
 	private Integer prefix;

	@NotNull
	@Min(value = 1000,  message = "This must be exact at 4 digits")
	@Max(value = 9999,  message = "This must be exact at 4 digits")
	//@Digits(integer = 4, fraction = 0, message = "This must be exact at {2} digits")
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
