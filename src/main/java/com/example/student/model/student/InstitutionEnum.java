package com.example.student.model.student;

public enum InstitutionEnum {
    NOT_YET("Not Set"),
    PRIMARY_SCHOOL("Primary School"),
    SECONDATY_SCHOOL("Secondary School"),
    POLYTECHNIC("Polytechnic"),
    UNIVERSITY("University"),
    MONOTECHNIC("Monotechnic"),
    OTHER("Other");

    
    private String value;
	
	private InstitutionEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
