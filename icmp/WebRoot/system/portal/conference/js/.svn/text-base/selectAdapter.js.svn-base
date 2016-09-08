/**
 * config class
 * author:wangrl
 * time:20111101
 * @type 
 */
var selectConfig = {
	separator:"-"
}
/**
 * select class
 * author:wangrl
 * time:20111101
 * @type 
 */
var select = {
	
	/**
	 * get selected index
	 * return array
	 * @param {} selectObj
	 * @return {}
	 */
      getSelectedIndex:function(selectObj){
    
                     var selectedIndexArray = new Array(); 
                     var arrayIndex = 0;
				       for ( var i = 0; i < selectObj.options.length; i++) { 
				           if (selectObj.options[i].selected){ 
				                  selectedIndexArray[arrayIndex] = i.toString();
				                  arrayIndex++;
				           }
				       }
			         return selectedIndexArray;
				},
	  getSelectedText:function(selectObj){
		                 var selectedTextArray = new Array(); 

	                     var arrayIndex = 0;
				         for ( var i = 0; i < selectObj.options.length; i++) { 
				           if (selectObj.options[i].selected){ 
				                  selectedTextArray[arrayIndex] = selectObj.options[i].text;
				                  arrayIndex++;
				           }
				       }
				       
				       return selectedTextArray;
	               },
	 getSelectedValue:function(selectObj){
		                 var selectedValueArray = new Array(); 
	                 
	                     var arrayIndex = 0;
				         for ( var i = 0; i < selectObj.options.length; i++) { 
				           if (selectObj.options[i].selected){ 
				                  selectedValueArray[arrayIndex] = selectObj.options[i].value;
				                  arrayIndex++;
				           }
				       }
				     
				       return selectedValueArray;
	               },
	 getAllOptions:function(selectObj){
	 	
	 	                 var optionValueArray = new Array(); 
				         for ( var i = 0; i < selectObj.options.length; i++) { 
				                  optionValueArray[i] = selectObj.options[i].value;
				         }
				         return optionValueArray;
	 },
	   /**
	    * delete select index
	    * @param {} selectObj
	    * @param {} index
	    */
    deleteByIndex:  function(selectObj,index){
                              selectObj.options.remove(index);
                          },
    deleteOptionByValue: function(selectObj,value){
    	                     var optionLength = selectObj.options.length;
                             for ( var i = 0; i <optionLength ; i++) {
                             
	                         	 if(selectObj.options[i].value==value){
	                         	 	 this.deleteByIndex(selectObj,selectObj.options[i].index)
	                         	 	 //重新赋予初始值
	                         	 	 i=0;
	                         	 	 optionLength = selectObj.options.length;
	                         	 }
	                         }
	                     
                          },                    
    addOption          :  function(selectObj,text,value){
                             selectObj.options.add(new Option(text,value));
                          },
                          
    hasOptionText       : function(selectObj,text){
    	                     var optionLength = selectObj.options.length
                             for ( var i = 0; i <optionLength ; i++) { 
	                         	 if(selectObj.options[i].text==text){
	                         	 	   //contains
	                         	 	   return true;
	                         	 }
	                         }
	                         return false;
                          },
    hasOptionValue       : function(selectObj,value){
    	                     var optionLength = selectObj.options.length;
                             for ( var i = 0; i <optionLength ; i++) { 
	                         	 if(selectObj.options[i].value==value){
	                         	 	   //contains
	                         	 	   return true;
	                         	 }
	                         }
	                         return false;
                          },   
    hasOptionVT       : function(selectObj,value,text){
    	                     var optionLength = selectObj.options.length
                             for ( var i = 0; i <optionLength ; i++) { 
	                         	 if(selectObj.options[i].value==value&&selectObj.options[i].text==text){
	                         	 	   //contains
	                         	 	   return true;
	                         	 }
	                         }
	                         return false;
                          }, 
    deleteAllOption    :function(selectObj){ 
	                         for ( var i = 0; i < selectObj.options.length; i++) { 
	                         	 selectObj.options.length=0;
	                         }
                        }
       
};
