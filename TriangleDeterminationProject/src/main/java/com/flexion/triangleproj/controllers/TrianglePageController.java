package com.flexion.triangleproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flexion.triangleproj.beans.TraingleServiceBean;

@Controller
public class TrianglePageController 
{
	@Autowired
	TraingleServiceBean traingleServiceBean;
	
	@RequestMapping(value = "/home", method = {RequestMethod.GET})
	//@ResponseBody
	public String loadMainPage(ModelMap model)
	{
		//return "UserDataEntryPages/dataEntryScreenView";
		return "dataEntryScreenView";
	}//end loadMainPage
	
	@RequestMapping(value = "/", method = {RequestMethod.GET})
	//@ResponseBody
	public String loadMainPage1(ModelMap model)
	{
		//return "UserDataEntryPages/dataEntryScreenView";
		return "dataEntryScreenView";
	}//end loadMainPage
	
	@RequestMapping(value = "/processData", method = {RequestMethod.GET})
	@ResponseBody
	public String processTriangleData(@RequestParam(value = "data_list", required = true) String tri_list)
	{
		try
		{
			return traingleServiceBean.getTriangleClass(tri_list);
		}//end try
		catch(Throwable thw)
		{
			thw.printStackTrace();
			return "*Error: " +  thw.getMessage();
		}//end catch
		
	}//end processTriangleData	
	

}//end TrianglePageController
