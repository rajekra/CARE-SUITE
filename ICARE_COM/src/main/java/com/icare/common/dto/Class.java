package com.icare.common.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Class {
private String name;
private BigDecimal stidentId;

List<Student> students ;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public BigDecimal getStidentId() {
	return stidentId;
}
public void setStidentId(BigDecimal stidentId) {
	this.stidentId = stidentId;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}

}
