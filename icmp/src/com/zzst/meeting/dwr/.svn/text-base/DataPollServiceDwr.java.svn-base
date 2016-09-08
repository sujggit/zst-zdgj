package com.zzst.meeting.dwr;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.information.InformationVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.message.MessageVO;

public class DataPollServiceDwr {
	ServletContext context = null;

	ScriptSession scriptSession = null;
	
	private static int number=0;

	//----给所有的页面推数据，通过Brower.withAllSessions，适合全部页面--------------------------
	public DataPollServiceDwr() {
		HttpServletRequest request = WebContextFactory.get()
				.getHttpServletRequest();
		HttpSession session = request.getSession();
		//初始化工作，目的是用一个服务器级的容器来装scriptsession，便于跨浏览器操作
		context = session.getServletContext();
	}

	@SuppressWarnings("unchecked")
	public void initScriptSession() {
		//System.out.println("into initScriptSession!");
		//创建一个session，只要页面调用这个方法
		ScriptSession scriptSession = WebContextFactory.get()
				.getScriptSession();
		// scriptSession.setAttribute("allpages", scriptSession);
		//拿到放在scriptSessions中的scriptsession
		List<ScriptSession> scriptSessions = (List<ScriptSession>) context
				.getAttribute("scriptSessions");
		if (scriptSessions == null) {
			scriptSessions = new ArrayList<ScriptSession>();
		}
		//添加一个新的scriptsession
		scriptSessions.add(scriptSession);
		context.setAttribute("scriptSessions", scriptSessions);
	}

	@SuppressWarnings("unchecked")
	public void pollDataToAllPage() {
		if(MeetingAppConfig.DataPoll){
		int index = 0;
		if(number==0){
		do{
			index++;
//			System.out.println("====index===:"+index);
//		System.out.println("into pollDataToAllPage!");
		//	 拿出所有的session 
		final List<ScriptSession> scriptSessions = (List<ScriptSession>) context
				.getAttribute("scriptSessions");
		if (scriptSessions == null) {
			System.out.println("scriptSessions:"+scriptSessions);
			return;
		}
//		System.out.println("scriptSessions.size()=" + scriptSessions.size());
		Browser.withAllSessions(new Runnable() {
			ScriptBuffer scriptBuffer = new ScriptBuffer();

			public void run() {
//					System.out.println("=====run()=====");
					MessageVO mVO = new MessageVO();
					InformationVO ifVO = new InformationVO();
					ifVO.setScanStatus(InformationEnum.scanStatus_no);
					ArrayList<InformationVO> ifList= new ArrayList<InformationVO>();
					StringBuffer titles = new StringBuffer();
					StringBuffer contents = new StringBuffer();
					StringBuffer ids = new StringBuffer();
					try {
						ifList = ServiceFactory.getInformationService().queryNew(ifVO, null);
						if(ifList!=null&&ifList.size()>0){
							for(int i=0;i<ifList.size();i++){
								titles.append(ifList.get(i).getTitle()+",");
								contents.append(ifList.get(i).getContent()+",");
								ids.append(ifList.get(i).getInfoID()+",");
							}
						}
					mVO.setIds(ids.toString());
					mVO.setContents(contents.toString());
					mVO.setTitles(titles.toString());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				//	 掉用浏览器客户端的js函数，实现推送数据
//				System.out.println("run");
				//	  只要有页面有这个js函数，即可以推送
				if(ifList!=null&&ifList.size()>0){
					scriptBuffer.appendScript("polledDataByServer(").appendData(mVO).appendScript(");");
//					System.out.println("======"+ifVO.getContent());
					for (ScriptSession scriptSession : scriptSessions) {
						//	 推送数据
						scriptSession.addScript(scriptBuffer);
					}
						//推送完消息，更改数据库状态
					for(int j=0;j<ifList.size();j++){
						ifVO = ifList.get(j);
						ifVO.setScanStatus(InformationEnum.scanStatus_yes);
						try {
							ServiceFactory.getInformationService().modify(ifVO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		});
//		System.out.println("结束！！！！！");
//		定时查询数据库
		try {
			if(number==0){
				number=1;
			}
			Thread.sleep(MeetingAppConfig.MessageTime*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}while(index>0);
		}
		}
	}
	

	//	 -------------------------------给D页面推数据，通过Brower.withSession,通过sessionId来定位，适合指定页面-------------

	//创建一个sessionId属于D页面的
	public void createSessionId() {
		ScriptSession scriptSession = WebContextFactory.get()
				.getScriptSession();
		//	   scriptSession.setAttribute("", arg1);
		//  sessionIdString = scriptSession.getId();
		//通过sessionid来定位
		context.setAttribute("sessionId", scriptSession.getId());
		context.setAttribute("scriptSession", scriptSession);
		System.out.println("into createSessionId! sessonId= "
				+ scriptSession.getId());

	}

	public void pollDataToSpePage() {

		//执行和操作的scriptSessionId 必须是由createSessionId创建的session所产生，因此需要在创建session的时候，将scriptsesson保留在context里面
		final ScriptSession scriptSession = (ScriptSession) context
				.getAttribute("scriptSession");
		String sesssionId = (String) context.getAttribute("sessionId");
		System.out.println("into pollDataToSpePage sessionId=" + sesssionId
				+ "  scriptSession=" + scriptSession);

		Browser.withSession(sesssionId, new Runnable() {

			ScriptBuffer scriptBuffer = new ScriptBuffer();

			public void run() {
//				System.out.println("run");
				InformationVO ifVO = new InformationVO();
				ifVO.setContent("全体大会即将结束");
				//	  只要有页面有这个js函数，即可以推送
				scriptBuffer.appendScript("polledDataToOneByServer(")
						.appendData(ifVO).appendScript(");");

				//	 推送数据,
				scriptSession.addScript(scriptBuffer);

			}
		});

	}
}
