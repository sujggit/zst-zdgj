jQuery(document).ready(function(){
								
	///// TRANSFORM CHECKBOX /////							
	
	//jQuery('input:checkbox').uniform();
	///// LOGIN FORM SUBMIT /////
	
	jQuery('#login').submit(function(){
		jQuery('.nopassword,.nousername,.nopassword1').hide();
		if(jQuery('#username').val() == '' && jQuery('#password').val() == '') {
			jQuery('.nousername,.nopassword').fadeIn();
			//jQuery('.nopassword').fadeIn();
			return false;	
		}
		if(jQuery('#username').val() != '' && jQuery('#password').val() == '') {
			jQuery('.nopassword').fadeIn();
			return false;
		}
		if(jQuery('#username').val() == '' && jQuery('#password').val() != '') {
			jQuery('.nousername').fadeIn();
			return false;
		}
		/**if(jQuery('#username').val() != jQuery('userVO.loginName')&&jQuery('#username').val()!='' ) {
			alert(jQuery('userVO.loginName').val());
			jQuery('.nopassword1').fadeIn();
			return false;
		}*/
		
		
	});
	
	///// ADD PLACEHOLDER /////
	jQuery('#username').attr('placeholder','Username');
	jQuery('#password').attr('placeholder','Password');
});
