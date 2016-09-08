package com.zzst.action.meeting.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * 通过客户端请求的url查询出该功能的funcId
 * @author xiongshun
 *
 */
public class FuncFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;
	private FilterConfig filterConfig;
	
	public FuncFilter(){}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest re = (HttpServletRequest)request;
    	HttpServletResponse rs = (HttpServletResponse)response;
    	
    	HttpSession session = re.getSession();
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
    	String url = re.getRequestURL().toString();
    	String funcId = "";
    	/**
		 * 20140819操作按钮可控制的优化
		 * 1登录后第一次使用时将所有funcUrl信息存入缓存Map，
		 * 2每次需要的时候直接取出来使用，不再依次查询数据库，
		 * 3退出登录的时候清除此map
		 */
    	try {
    		if(userVO!=null){
    			if(url.indexOf("/userLogin.action")<0){
    	    		if(url.indexOf(".action")>-1 && url.indexOf("/icmp")>-1){
    	    			int indexStart = url.indexOf("/icmp");
                		int indexEnd = url.indexOf(".action");
                		String funcURL = url.substring(indexStart,indexEnd+7);
                		if(userVO.getFuncMap().size()==0){
    	    			//if(funcMap.size()==0){
    	    				FuncVO funcVO = new FuncVO();
    	    				List<FuncVO> fList = new ArrayList<FuncVO>();
    	    				Map<String, String> parIdMap = new HashMap<String, String>();
    	    				Map<String, FuncVO> funcVOMap = new HashMap<String, FuncVO>();
    	    				Map<String, String> funcMap = new HashMap<String, String>();
    	    				
    	    				fList = ServiceFactory.getFuncService().query(funcVO, null);
    	    				for(FuncVO vo:fList){
    	    					parIdMap.put(vo.getParent_id(), vo.getFunc_id());
    	    					funcVOMap.put(vo.getFunc_id(), vo);
    	    				}
    	    				
    	    				ArrayList<FuncVO> lst_fun = userVO.getFuncVOList(); //FuncDAO.getFuncList(null, null);
    	    				for(int i=0;i<lst_fun.size();i++){
    	    					FuncVO vo = lst_fun.get(i);
    	    					if(vo.getFuncNo()!=null){
    	    						String urlTemp = funcVOMap.get(vo.getParent_id()).getFunc_url();
    	        					if(urlTemp!=null){
    	        						if(funcMap.get(urlTemp)==null){
    	        							funcMap.put(urlTemp, vo.getFuncNo());
    	        						}else{
    	        							funcMap.put(urlTemp, funcMap.get(urlTemp)+";"+vo.getFuncNo());
    	        						}
    	        					}
    	    					}
    	    				}
    	    				funcId = funcMap.get(funcURL);
    	    				userVO.setFuncMap(funcMap);
    	    				session.setAttribute(UserEnum.USER_SESSION_ID, userVO);
    	    			}else{
    	            		funcId = userVO.getFuncMap().get(funcURL);
    	    			}
    	        	}
        		}
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	/**
    	if(url.indexOf("/userLogin.action")<0){
    		if(url.indexOf(".action")>-1 && url.indexOf("/icmp")>-1){
        		int indexStart = url.indexOf("/icmp");
        		int indexEnd = url.indexOf(".action");
        		String funcURL = url.substring(indexStart,indexEnd+7);
        		FuncVO funcVO = new FuncVO();
        		List<FuncVO> fList = new ArrayList<FuncVO>();
            	funcVO.setFunc_url(funcURL);
            	try {
            		fList = ServiceFactory.getFuncService().query(funcVO, null);
    				if(fList!=null&&fList.size()>0){
    					for(int i=0;i<fList.size();i++){
    						funcId += fList.get(i).getFunc_id();
    						if(i < fList.size()-1){
    							funcId += ";";
    						}
    					}
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        	}
    	}
    	*/
    	if(funcId==null){
    		funcId = "";
    	}
    	re.setAttribute("funcId", funcId);
		if(true){
			filterChain.doFilter(re, rs);
		}else{
			re.getRequestDispatcher("/index3.jsp").forward(re, rs);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void destroy(){
		filterConfig = null;
    }

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
}
