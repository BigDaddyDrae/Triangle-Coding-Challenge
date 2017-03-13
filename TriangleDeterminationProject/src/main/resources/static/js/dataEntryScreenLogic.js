/**
 * 
 */

var titles = ["Side 1","Side 2","Side 3", "Response"];
var r_index
var standard_row_default = 2;
var total_correct =0;
var total_incorrect =0;
var data_set = null;

function createGrid(rows, columns)
{
	    var i = 0;
	    var grid = document.createElement('table');
	    grid.setAttribute("id", "gridz");
	    
	    var rindex = 0;
	    grid.className = 'grid';
	    var cell;
	    var val_index = 0;
	    var val_index_sub = 0;
    	var old_data = "";
    	var old_data_parsed = [];
    	
	    for (var r=0; r < rows; r++)
	    {
	    	//alert("data_set: " + data_set);
	    	//alert("data_set.length: " + data_set.length);
	    	
	    	if(data_set != null && data_set.length != 0 
	    		&& val_index < data_set.length && r!=0 )
	    	{
	    		//console.log("data_set[val_index]: " + data_set[val_index])
	    		old_data = data_set[val_index];
	    		old_data_parsed = old_data.split("*");
	    		val_index++;
	    		val_index_sub = 0;
	    		////alert("here: " + old_data_parsed);
	    	}//end if
	    	
	        var tr = grid.appendChild(document.createElement('tr'));
	        tr.setAttribute("contenteditable", false);
	        
	        var type ="";
	        for (var c=0; c < columns; c++)
	        {          
	            if(r != 0)
	            {                    	
	            	var x = document.createElement("td");
	            	//x.setAttribute("type", "text");
	            	//x.setAttribute("contenteditable", true);
	            	var sub_x;	            	
	            	if(c != 3)
	            	{
	            		//Changed this due to IE not supporting setting td cells uneditable(A.N.)
	            		sub_x = x.appendChild(document.createElement("INPUT"));
	            		sub_x.setAttribute("id", "sub_x" + r + "," + (c +1));
	            		//sub_x.setAttribute("disabled", false);
	            		//sub_x.setAttribute("contenteditable", true);
	            		//sub_x.setAttribute("readonly", false);
	            		
	            		//Doesn't work on td, can be removed(A.N.)
	            		//Removed again because object has changed, and causes real-time validation.
	            		//Which is cool but taxing to track, when validation is already done on submit(A.N.)
	            		//sub_x.setAttribute("onchange", "validateNumeric(this)");
	            		
	            		////alert("There: " + old_data_parsed);
	            		////alert(old_data_parsed.length != 0)
	            		////console.log("data_set: " + data_set[0]);
	            		
	            		if(data_set != null &&  data_set[0] !== undefined &&
	            				val_index_sub != old_data_parsed.length)
	            		{
		            		//console.log("val_index_sub: " + val_index_sub);
		            		//console.log("old_data_parsed: " + old_data_parsed);
		            		//alert("check log");
	            		}//end if
	            		
	        	    	if((data_set != null &&  data_set[0] !== undefined) && old_data_parsed.length != 0 &&  
	        	    		val_index_sub < old_data_parsed.length)
	        	    	{
	        	    		//console.log("old_data_parsed[val_index_sub]: " + 
	        	    		//		old_data_parsed[val_index_sub]);
	        	    		//alert("Check Log");
	        	    		sub_x.value = old_data_parsed[val_index_sub];
	        	    		val_index_sub++
	        	    	}//end if
	            	}//end if
	            	else
	            	{
	            		x.setAttribute("disabled", true);
	            		x.setAttribute("contenteditable", false);
	            		x.setAttribute("readonly", true);
	            		
	            	}//end else
	            	//Must remain "data" because its part of the table cell id which holds the input
	            	//field/cell that hold the actual data(A.N.)
	            	x.setAttribute("id", "data" + r + "," + (c +1));
	            	
	            	cell = tr.appendChild(x);
	            	cell.style.width = "45px";

		    	}// end main if
			    else
		    	{
			    	cell = null;
			    	var y = document.createElement('th');
			    	
			    	//cell = null;
			    	cell = tr.appendChild(y);
			    	cell.innerHTML = titles[rindex];
			    	if(c != 3)
			    		cell.style.width = "150px";
			    	else
			    		cell.style.width = "200px";
			    	rindex++;
		    	}//end main else
	           
	       }//end inner for loop
	    }//end outer for

	    return grid;
 } //end createGrid


function initializeGrid(row_, col_)
{
	var drae = createGrid(row_,col_);
	var element = document.getElementById("grid_container");
	
	if(element != null)
	{
		if(element.childNodes != null && element.childNodes.length != 0)
		{
			element.removeChild(element.childNodes[0]);
		}//end if
		element.appendChild(drae);
	}//end if 
	else
		{
			alert("Fatal Error Please Contact System Administrator")
			System.out.println("Developer Notes: The grid_container attribute " +
					"is missing from the html page. " +
					"Please add it back and restart server.")
		
		
		}//end else 
	
}//end initializeGrid

function validateNumeric()
{
	//system.out.println("Validating here");
	var r_ow_total = document.getElementById("gridz").rows.length;
	total_correct =0;
	total_incorrect =0;
	
	for(var u = 0; u < r_ow_total; u++)
	{
		for(var q =0; q < titles.length; q++)
		{
			if(u == 0)
				continue;
			
			if(q != 3)
			{
				//console.log("VN-data: " +"sub_x" + u + "," + (q +1));
				var value_data_entry = document.getElementById("sub_x" + u + "," + (q +1));
				//var sub_value = value;
				//alert("v: " + value_data_entry)
				//console.log("value.childNode: " + value.childNode);
				//alert("v-s: " + value_data_entry.value)
				  if(value_data_entry != null &&  value_data_entry.value != "" 
					  && isNaN(value_data_entry.value) == false)
				  {
					  total_correct++;
					  if(value_data_entry.style.backgroundColor == "red")
						  value_data_entry.style.backgroundColor = "white";
					  
					  if(value_data_entry.style.color == "red")
						  value_data_entry.style.color = "black";
				  }//end if					 
				  else
				  {
					  total_incorrect++;
					  ////alert(value);
					  if(value_data_entry != null && value_data_entry.value != "" 
						  &&  value_data_entry.style.backgroundColor != "red")
						  value_data_entry.style.color = "red";
					  else
						  value_data_entry.style.backgroundColor = "red";
				  }//end else
		
			}//end if			
		
		}//end inner for loop
	}//end outer for loop
	
}//end validateNumeric

function addRow()
{

	var oreo = document.getElementById("gridz").rows.length;
	cloneData()
	initializeGrid(oreo +1, titles.length);
	
}//end addRow

function setDefaultGrid()
{
	data_set = [];
	initializeGrid(standard_row_default,titles.length);
}//end setDefaultGrid

function setColorSchemes()
{
	var btn_add = document.getElementById("addRow");
	btn_add.style.backgroundColor = "blue";
	
	var btn_submit = document.getElementById("submit");
	btn_submit.style.backgroundColor = "green";
	
	var btn_clear = document.getElementById("clear");
	btn_clear.style.backgroundColor = "red";
}//end setColorSchemes

function processDataRunProgram()
{
	validateNumeric();
	cloneData();
	if(total_incorrect == 0)
	{
		//alert("All Data Correct....wiz bang bang click DONE!!!");
		//console.log(" data_set.toString(); " +  data_set.toString());
		//console.log("JSON.stringify(data_set.toString()): " + JSON.stringify(data_set.toString()));
		 $.ajax({
			    url: "/processData",
			    type: "GET",
			    //dataType: "json",
			    data: {"data_list": (JSON.stringify(data_set.toString()))},
			    //processData: false,
			    success: function(data) {
			    	//alert("Working");
			    	//if(data.includes("*Error:")) //Removed not compatible with IE.smh(A.N.)
			    	if(data.indexOf("*Error:") > -1)
			    		alert(data);
			    	else
			    	{
			    		//alert("print results out");
			    		//console.log(data)
			    		reloadGridData(data);
			    	}//end else
			    },
			    error: function(data) {
			    	//alert("Broke");
			    	alert(data.value);

			    }
			});

	}//end if
	else
	{
		alert("Invalid Data Exist, Please Correct Invalid Cells And Re-Submit");
	}//end else
}//end processDataRunProgram

function cloneData()
{
	data_set = [];
	var r_ow_total = document.getElementById("gridz").rows.length;
	var data_seg = "";
	//alert("r_ow_total: " + r_ow_total);
	
	for(var g = 0; g < r_ow_total; g++)
	{
		for(var s =0; s < titles.length; s++)
		{
			if(g == 0)
				continue;
			
			if(s != 3)
			{
				//console.log("CD-data: " +"sub_x" + g + "," + (s +1));
				var value_entry = document.getElementById("sub_x" + g + "," + (s +1));
				//console.log("value_entry.value: " + value_entry.value);
				
				if(s !=2)
					data_seg += value_entry.value + "*";
				else
					data_seg += value_entry.value;
		
			}//end if	
			else
			{
				//alert("data_seg: " +data_seg);
				data_set.push(data_seg);
				data_seg = "";
			}//end else
		
		}//end inner for loop
	}//end outer for loop
	//alert("data_seg: " +data_seg);
}//end cloneData

function reloadGridData(x)
{
//	console.log("data_set.length: " + data_set.length);
//	console.log("data_set: " + data_set);
	
	var json = JSON.parse(x);
	//console.log("x: " + json.toString());
	for(var v = 0; v < data_set.length; v++)
	{
		for(var b =3; b < titles.length; b++)
		{
			//console.log("RN-data: " +"data" + (v+1) + "," + (b));
			
			var value = document.getElementById("data" + (v+1) + "," + (b+1));
			if(/*value != null ||*/ value != undefined)
			{
				//.log("value: " + value);
				//console.log("result_value: " + json[v].tri_result);
				value.innerHTML = json[v].tri_result;
			}//end if
			else
				console.log("Developer Note: Index Is Off For Results, Check JSONConverter Class");
			
		}//end inner for
	}//end main for
	
}//end reloadGridData