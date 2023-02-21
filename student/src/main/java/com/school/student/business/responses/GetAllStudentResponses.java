package com.school.student.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentResponses {
	private int id;
	private String tc;
	private String name;
	private String surName;
	
}
