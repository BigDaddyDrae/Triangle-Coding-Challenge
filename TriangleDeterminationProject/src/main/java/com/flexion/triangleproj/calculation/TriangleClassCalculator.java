package com.flexion.triangleproj.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;


public class TriangleClassCalculator {
	
	public TriangleClassCalculator()
	{
		
	}//end default constructor
	
	public String getTriClassificationAsString(BigDecimal side_1, BigDecimal side_2, BigDecimal side_3)
	{
		int counter = 0;
		String temp = "";
		try
		{
			
		
			if((side_2.add(side_3)).compareTo(side_1) == 1)
			{
				counter++;
			}//end if
			
			if((side_1.add(side_3)).compareTo(side_2) == 1)
			{
				counter++;
			}//end if
				
			if((side_1.add(side_2)).compareTo(side_3) == 1)
			{
				counter++;
			}//end if
			
			if(counter != 3)
				temp += "Not A Triangle.";
			else
			{
				counter = 0;
				if(side_1.compareTo(side_2) == 0)
				{
					counter++;
					if(side_2.compareTo(side_3) == 0)
					{
						temp += "Equilateral.";
					}//end if
					else 
						temp += "Isosceles.";
					
				}
				else if(side_2.compareTo(side_3) == 0 || (side_1.compareTo(side_3) == 0))
				{
					temp += "Isosceles.";
				}
				else 
					temp += "Scalene.";
			}//end else
		}//end try
		catch(Throwable thw)
		{
			//thw.printStackTrace();
			return "*Error: " + thw.getMessage() + ", Invalid Data";
			
		}//end catch
		
		return calulateAnglesReturnAngleClass(side_1, side_2, side_3, temp);
		
	}//end getTriClassificationAsString

	public List getTriClassificationAsStringFromArray(String[] data_entries)
	{
		List results = new ArrayList<String>();
		
		try
		{
			for(int x =0; x< data_entries.length; x++)
			{
				//Must use escape on * to avoid java.util.regex.PatternSyntaxException: Dangling meta character
				//* means zero/is wild card/hot key(A.N.)
				String temp_array[] = data_entries[x].split("\\*");
				String temp = getTriClassificationAsString(new BigDecimal(temp_array[0]), 
						new BigDecimal(temp_array[1]), new BigDecimal(temp_array[2]));
				
				results.add(temp);
				temp = "";
			}//end for
			
		}//end try
		catch(Throwable thw)
		{
			thw.printStackTrace();
		}//end catch
		//return (String[]) results.toArray();
		return results;
		
	}//end getTriClassificationAsStringFromArray
	
	
    private String calulateAnglesReturnAngleClass(BigDecimal s1, BigDecimal s2, BigDecimal s3, String triangle_status) 
    {
    	//Prevents division by zero and by negative(A.N.)
    	if(!s1.equals(BigDecimal.ZERO) && !s2.equals(BigDecimal.ZERO) && !s3.equals(BigDecimal.ZERO)
    	&& s1.compareTo(BigDecimal.ZERO) != -1 && s2.compareTo(BigDecimal.ZERO) != -1 && 
    	s3.compareTo(BigDecimal.ZERO) != -1)
    	{
 
    	String temp = "";
        double s1_double = s1.doubleValue(), s2_double = s2.doubleValue(), s3_double = s3.doubleValue();

        //System.out.println("hmmmm: " +Math.acos((s1_double * s1_double + s3_double *s3_double -)));
        //
        try
        {
        	
        
	        double angle_1 = new BigDecimal((Math.toDegrees(Math.acos((s2_double * s2_double + s3_double * s3_double - s1_double * s1_double) 
	        		/ (2 * s2_double * s3_double))))).setScale(2, RoundingMode.HALF_UP)
	        	    .doubleValue();
	        
	        double angle_2 = new BigDecimal((Math.toDegrees(Math.acos((s1_double * s1_double + s3_double* s3_double - s2_double * s2_double) 
	        		/ (2 * s1_double * s3_double))))).setScale(2, RoundingMode.HALF_UP)
	        	    .doubleValue();
	        
	        
	        double angle_3 = new BigDecimal(Math.toDegrees(Math.acos((s1_double * s1_double + s2_double * s2_double - s3_double * s3_double) 
        		/ (2 * s1_double * s2_double)))).setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	        
	        if(Math.ceil(angle_1 + angle_2 + angle_3) != 180 && Math.floor(angle_1 + angle_2 + angle_3) != 180)
	        {
	        	//System.out.println("Mathematical Issue");
	        	temp += "Invalid Triangle Angles (" + angle_1 + "," + angle_2 + "," + angle_3 + "),  ";
	        }//end if
	        else if((((Math.ceil(angle_1 + angle_2 + angle_3) == 180) || (Math.floor(angle_1 + angle_2 + angle_3) == 180)))
	        		&& triangle_status.equalsIgnoreCase("Not A Triangle."))
	        	temp += /*"Valid Triangle Angles (" + angle_1 + "," + angle_2 + "," + angle_3 + "), "*/ ""; //Wording Maybe confusing to user(A.N.)      
	        else
	        {
		        if(angle_1 == angle_2 && angle_2 == angle_3)
		        	temp += "Equiangular ";
		        else if(angle_1 == 90 || angle_2 == 90 || angle_3 == 90)
		        	temp += "Right ";
		        else if(angle_1 > 90 || angle_2 > 90 || angle_3 > 90)
		        	temp += "Obtuse ";
		        else if(angle_1 < 90 || angle_2 < 90 || angle_3 < 90)
		        	temp += "Acute ";
		        else
		        {
		        	//do nothing because the triangle doesn't meet requirements
		        }//end else
	        }//end else
        }//end try
        catch(java.lang.NumberFormatException nfe)
        {
        	temp += "Invalid Angles, ";
        }//end 

        
        return temp + triangle_status ;
    	}//end if
    	else
    	{
    		return "No Side Length Can Be Zero Or Negative, " + triangle_status;
    	}//end main else
    }//calulateAngles
    

    public boolean validateBigDecimal(String raw_data)
    {
    	try
    	{
    		BigDecimal bd = new BigDecimal(raw_data);
    		return true;
    	}//end try
    	catch(Throwable thw)
    	{
    		return false;
    	}//end catch
    }//end validateBigDecimal
}//end TriangleClassCalculator
