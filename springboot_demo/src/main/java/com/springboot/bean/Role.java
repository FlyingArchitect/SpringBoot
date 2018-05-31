package com.springboot.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*jpa实体类*/
@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 9102345365553241455L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String name;
	@Column
	private String descr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", descr=" + descr + "]";
	}
	
	

}
