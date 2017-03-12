package com.flexion.triangleproj.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONConverter 
{
	
    public static String toJSON(Object object) throws JSONException, IllegalAccessException 
    {
        String str = "";
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) 
        {
            field.setAccessible(true);
            String name = field.getName();
            String value = String.valueOf(field.get(object));
            jsonObject.put(name, value);
        }//end for
        //System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }//end toJSON

    public static String toJSON(List list) throws JSONException, IllegalAccessException 
    {
        JSONArray jsonArray = new JSONArray();
        for (Object i : list) 
        {
            String jstr = toJSON(i);
            JSONObject jsonObject = new JSONObject(jstr);
            jsonArray.put(jsonObject);
        }//end for
        return jsonArray.toString();
        //return list.toString();
    }//end toJSON
    
    public static String toJSONForSingleStringProcessor(String string_) throws JSONException, IllegalAccessException 
    {
        JSONObject jsonObject = new JSONObject(/*"{" + string_ + "}"*/);
        jsonObject.put("tri_result", string_);
        
        //System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }//end toJSONForSingleStringProcessor
    
    
    public static String toJSONForSingleList(List list_string_) throws JSONException, IllegalAccessException 
    {
        JSONArray jsonArray = new JSONArray();
        
        for(Object str: list_string_)
        {
            String jstr = toJSONForSingleStringProcessor((String) str);
            JSONObject jsonObject = new JSONObject(jstr);
           	jsonArray.put(jsonObject);       
        }//end for
        
       // System.out.println(jsonObject.toString());
        return jsonArray.toString();
        
    }//end toJSONForSingleList
    
    public static String toJSONForSingleString(String string_) throws JSONException, IllegalAccessException 
    {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List temp = new ArrayList<String>();
        temp.add(string_);
        String jstr = toJSONForSingleStringProcessor((String) temp.get(0));
        jsonObject = new JSONObject(jstr);
       	jsonArray.put(jsonObject);
            
         
        //System.out.println(jsonObject.toString());
        return jsonArray.toString();
        
    }//end toJSONForSingleList
    
    
}//end JSONConverter
