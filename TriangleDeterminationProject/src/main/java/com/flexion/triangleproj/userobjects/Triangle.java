package com.flexion.triangleproj.userobjects;

import java.math.BigDecimal;

import com.flexion.triangleproj.calculation.TriangleClassCalculator;

public class Triangle {
	
	private BigDecimal side_1,side_2,side_3;
	private String classification;
	private TriangleClassCalculator tri_calc = new TriangleClassCalculator();
	
	public Triangle()
	{
		
	}//end default constructor
	
	public Triangle(String side_a, String side_b, String side_c)
	{
		if(tri_calc.validateBigDecimal(side_a))
			side_1 = new BigDecimal(side_a);
		
		if(tri_calc.validateBigDecimal(side_b))
			side_2 = new BigDecimal(side_b);
		
		if(tri_calc.validateBigDecimal(side_c))
			side_3 = new BigDecimal(side_c);
		
	}//end constructor
	
	public BigDecimal getSide_1() 
	{
		return side_1;
	}

	public void setSide_1(BigDecimal side_1)
	{
		this.side_1 = side_1;
	}

	public BigDecimal getSide_2()
	{
		return side_2;
	}

	public void setSide_2(BigDecimal side_2)
	{
		this.side_2 = side_2;
	}

	public BigDecimal getSide_3() 
	{
		return side_3;
	}

	public void setSide_3(BigDecimal side_3) 
	{
		this.side_3 = side_3;
	}

	public String getClassification() 
	{
		return classification;
	}

	public void setClassification(String classification) 
	{
		this.classification = classification;
	}

	public TriangleClassCalculator getTri_calc() 
	{
		return tri_calc;
	}

	public void setTri_calc(TriangleClassCalculator tri_calc) 
	{
		this.tri_calc = tri_calc;
	}


	
	
	
	

}//end Triangle
