/**
 * 
 */
package com.flexion.triangleproj.test.calculation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.flexion.triangleproj.userobjects.Triangle;

/**
 * @author anelson
 *
 */
public class TriangleClassCalculatorTest {

	@InjectMocks
	Triangle triangle;
	
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void test() 
	{
		//Should throw exception(A.N)
		String result_1 = triangle.getTri_calc().getTriClassificationAsString(any(BigDecimal.class), 
				any(BigDecimal.class), any(BigDecimal.class));
		
		String result_2 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(anyDouble()), 
				new BigDecimal(anyDouble()), new BigDecimal(anyDouble()));
		
		String result_3 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(5), 
				new BigDecimal(10), new BigDecimal(7));
	
		String result_4 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(10), 
				new BigDecimal(10), new BigDecimal(10));
		
		String result_5 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(12), 
				new BigDecimal(4), new BigDecimal(4));
		
		String result_6 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(6), 
				new BigDecimal(12), new BigDecimal(47));

		String result_7 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(7), 
				new BigDecimal(7), new BigDecimal(9));

		String result_8 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(5), 
				new BigDecimal(12), new BigDecimal(13));
		
		String result_9 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(29), 
				new BigDecimal(15), new BigDecimal(15));
		
		String result_10 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(2), 
				new BigDecimal(2.82842712), new BigDecimal(2));
		
		String result_11 = triangle.getTri_calc().getTriClassificationAsString(new BigDecimal(11.61), 
				new BigDecimal(29), new BigDecimal(30));
		
	
		assertFalse("The code has error-ed out, check log", !result_1.contains("*Error"));
		assertTrue("Results Of Test: ", result_1.contains("*Error") != false);
		System.out.println("Results #1"+ ": " + result_1);
		
		assertFalse("The code has error-ed out, check log", result_2.contains("*Error"));
		assertTrue("Results Of Test: ", result_2.contains("*Error") == false);
		System.out.println("Results #2: " + result_2);
		
		assertFalse("The code has error-ed out, check log", result_5.contains("*Error"));
		assertTrue("Results Of Test: ", result_5.contains("*Error") == false);
		System.out.println("Results #3: " + result_5);
		
		assertFalse("The code has error-ed out, check log", result_6.contains("*Error"));
		assertTrue("Results Of Test: ", result_6.contains("*Error") == false);
		System.out.println("Results #4: " + result_6);
	
		assertFalse("The code has error-ed out, check log", result_4.contains("*Error"));
		assertTrue("Results Of Test: ", result_4.contains("*Error") == false);
		System.out.println("Results #5: " + result_4);
		
		assertFalse("The code has error-ed out, check log", result_9.contains("*Error"));
		assertTrue("Results Of Test: ", result_9.contains("*Error") == false);
		System.out.println("Results #6: " + result_9);
		
		assertFalse("The code has error-ed out, check log", result_3.contains("*Error"));
		assertTrue("Results Of Test: ", result_3.contains("*Error") == false);
		System.out.println("Results #7: " + result_3);
			
		assertFalse("The code has error-ed out, check log", result_7.contains("*Error"));
		assertTrue("Results Of Test: ", result_7.contains("*Error") == false);
		System.out.println("Results #8: " + result_7);
		
		assertFalse("The code has error-ed out, check log", result_11.contains("*Error"));
		assertTrue("Results Of Test: ", result_11.contains("*Error") == false);
		System.out.println("Results #9: " + result_11);
				
		assertFalse("The code has error-ed out, check log", result_10.contains("*Error"));
		assertTrue("Results Of Test: ", result_10.contains("*Error") == false);
		System.out.println("Results #10: " + result_10);
		
		assertFalse("The code has error-ed out, check log", result_8.contains("*Error"));
		assertTrue("Results Of Test: ", result_8.contains("*Error") == false);
		System.out.println("Results #11: " + result_8);
				
		
		//fail("Operation Have Failed, Check Log");
	}//end test

}//end TriangleClassCalculatorTest
