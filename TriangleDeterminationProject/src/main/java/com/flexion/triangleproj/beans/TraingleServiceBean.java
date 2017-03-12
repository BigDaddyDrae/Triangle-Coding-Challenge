package com.flexion.triangleproj.beans;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexion.triangleproj.calculation.TriangleClassCalculator;
import com.flexion.triangleproj.util.JSONConverter;

@Service
public class TraingleServiceBean 
{
	@Autowired
	TriangleClassCalculatorBean triangleClassCalculatorBean;
	
	public TraingleServiceBean()
	{
		System.out.println("Autowired using default constructor {TraingleServiceBean}");
	}//end Default Constructor

	public String getTriangleClass(String tri_list) throws IllegalAccessException, JSONException 
	{
		
		return triangleClassCalculatorBean.classifyTriangle(tri_list);				
	}//end getTriangleClass	

}//end class TraingleServiceBean
