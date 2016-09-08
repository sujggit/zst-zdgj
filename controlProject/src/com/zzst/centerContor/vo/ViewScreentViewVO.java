package com.zzst.centerContor.vo;


/**
 *@Description
 *@date 2012-3-20上午10:17:05
 *@author ryan
 */
public class ViewScreentViewVO {

	public	static	int	def_size = 30;	
	private	String id;
	private	String left;
	private	String top;
	private	String width;
	private	String height;
	
	private	String model;//如：3*5*300

	private String viewStr;
	
	public String getViewStr(int def_px) {
		if(def_px!=Integer.MIN_VALUE)
			def_size = def_px;
		if(id!=null&&id.length()>0)
//			viewStr = getImgStr(model);
			viewStr = getDivStr();
			//viewStr= "<div alt='"+id+"' id='"+id+"' style='position:absolute;border:#989fa4 1px solid;padding-left:"+getSize(left)+"px;padding-top:"+getSize(top)+"px;width:"+getSize(width)+"px;height:"+getSize(height)+"px; background-image:/icmp/images/blue/defu.png'>测试模式</div>";
		return viewStr;
	}
	
	private String  getImgStr(){
		String str ="";
		str  = "<img src='/icmp/images/blue/model_defu.png' alt='"+id+"' id='"+id+"' style='" +
//				"position:absolute;" +
//				"border:1px solid #fff;" +
				"left:"+getSize(left)+"px;" +
				"top:"+getSize(top)+"px;" +
				"width:"+getSize(width)+"px;" +
				"height:"+getSize(height)+"px; " +
				//"background-image:/icmp/images/blue/defu.png";
				"background-color:red;";
//		if(model!=null&&model.equalsIgnoreCase("900")&&top.equalsIgnoreCase("1"))
//			str += "float:left";	
//		if(model!=null&&model.equalsIgnoreCase("900")&&left.equalsIgnoreCase("4"))
//			str += "float:left";	
		str += "'/>";
		return str;
	}
	
	private String  getDivStr(){
		String str ="";
		str  = "<div alt='"+id+"' id='"+id+"' style='";
		str += "position:absolute;";
		//viewStr += "float:inherit;";//left
	//border-left:solid 180px #f00;
	    //viewStr += "margin:-"+getSize2(height)+"px 0 0 -"+getSize2(width)+"px;";
		//viewStr += "border-l:#989fa4 2px solid;" +
		//viewStr += "border:#989fa4 0px solid;" +
		str += "" +
				"border:1px solid #000000;margin-left:"+getSize(left)+"px;" +
				"margin-top:"+getSize(top)+"px;" +
				"width:"+getSize(width)+"px;" +
				"height:"+getSize(height)+"px; " +
				//"background-image:/icmp/images/blue/defu.png";
				"background-color:#FFD306;";
//		if(model!=null&&model.indexOf("900")>0&&left.equalsIgnoreCase("0"))
//			str += "float:left;";	
//		if(model!=null&&model.indexOf("900")>0&&left.equalsIgnoreCase("1"))
//			str += "float:right;";	
//		if(model!=null&&model.indexOf("900")>0&&left.equalsIgnoreCase("4"))
//			str += "float:left;";	
		str += "'/></div>";
		
		return str;
	}
	
	private String getSize(String str){
		Double l = 0.0 ;
		if(str!=null&&str.length()>0){
			l = Double.valueOf(str)*def_size;
		}
		return l.toString(); 
	}
	
	private int getSize2(String str){
		if(str!=null&&str.length()>0){
			return (Integer.valueOf(str)*def_size)/2;
		}
		return 0;
	}
	
	public void setViewStr(String viewStr) {
		this.viewStr = viewStr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
