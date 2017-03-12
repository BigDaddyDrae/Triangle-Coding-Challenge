package com.flexion.triangleproj.beans;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.flexion.triangleproj.calculation.TriangleClassCalculator;
import com.flexion.triangleproj.util.JSONConverter;

@Service
public class TriangleClassCalculatorBean 
{
	TriangleClassCalculator triangleClassCalculator = new TriangleClassCalculator();

	public TriangleClassCalculatorBean()
	{
		System.out.println("Autowired using default constructor {TriangleClassCalculator}");
	}//end TriangleClassCalculatorBean

	public String classifyTriangle(String tri_list) throws IllegalAccessException, JSONException {
	
		//Forward and Back slashes also require escapes(An.N.)
		tri_list = tri_list.replaceAll("\"", "").replaceAll("\\/", "");
		
		if(tri_list.contains(","))
		{
			List temp = triangleClassCalculator.getTriClassificationAsStringFromArray
			(/*(String[])new ArrayList(tri_list).toArray()*/ tri_list.split(","));
			
			return JSONConverter.toJSONForSingleList(temp);
		}//end if
		else
		{
			//Must use escape on * to avoid java.util.regex.PatternSyntaxException: Dangling meta character
			//* means zero/is wild card/hot key(A.N.)
			String[] str_array = tri_list.split("\\*");
			String temp = triangleClassCalculator.getTriClassificationAsString(new BigDecimal(str_array[0]), 
					new BigDecimal(str_array[1]), new BigDecimal(str_array[2]));
			
			//return JSONConverter.toJSON(temp);
			return JSONConverter.toJSONForSingleString(temp);
		}//end else
		
	}//end classifyTriangle
	
	
}//end TriangleClassCalculatorBean
