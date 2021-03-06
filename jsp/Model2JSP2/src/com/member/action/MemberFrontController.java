package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 제일 먼저 만나는 Controller
// 개발에서 사용되는 중요 개념 -> 도메인

// 컨트롤러 -> 서블릿으로 이동
// http://localhost:8088/Model2JSP2/loginForm.me
public class MemberFrontController extends HttpServlet{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController_doProcess() 호출\n\n\n");
		
		// 주소를 비교해서, 주소에 따른 페이지 처리
		
		/******************* 1. 페이지 주소 파싱 *******************/
		// 가상 주소 가져오기 (.jsp, .html 이 아닌 애들은 다 가상 주소)
		String requestURI = request.getRequestURI();
		String requestURL = request.getRequestURL()+"";
		
		// /Model2JSP2/*.me
		// /Model2JSP2/itwill.me
		// /Model2JSP2/itwill22.me
		System.out.println("request URI : " + requestURI);
		// System.out.println("request URL" + requestURL);
		// -> 프로젝트명 빼고 가상 주소만 받고 싶을 땐 어떻게 할까?
		
		
		// 1. 프로젝트명 받아오기 getContextPath()
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath );
		
		// 2. 프로젝트명을 제외한 가상 주소만 잘라 얻기
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : "+ command);
		
		/******************* 1. 페이지 주소 파싱 *******************/
		
		/******************* 2. 페이지 주소 매핑(연결) *******************/
		// DB 사용 여부에 따라서 페이지 구성
		ActionForward forward = null;
		Action action = null; 	// Action 레퍼런스 하나 준비!
		
		
		// command 내가 주소창에서 친 부분을 계산 한다!
		if(command.equals("/MemberJoin.me")){
			// 회원가입 페이지 -> view 페이지로 보여주기 !
			// 1. response를 이용한 이동 (주소이동O, 페이지O 변경)
			//	   -> response.sendRedirect("주소")
			// 2. forword를 이용한 이동 (주소이동X, 페이지O 변경)
			//	   -> fis.forward(request, response); 
			// -----> 페이지 이동을 위한 객체를 하나 만들자! -> ActionForward.java 생성
			System.out.println(" 2 : /MemberJoin.me 주소 호출 ");
			
			// 링크 준비 하기
			forward = new ActionForward();
			forward.setPath("./member/insertForm.jsp"); // 여기서 .은 상위폴더 의미
			forward.setRedirect(false);	// 주소가 바뀌면 안되는 상황이므로 false(forward)로 넘겨주기
			
			
		}
		else if(command.equals("/MemberJoinAction.me")){
			// 회원가입 Action 페이지
			// ./MemberJoinAction.me 랑 다른 경로임!!
			// 위에서 .을 빼고 단순 가상 경로만 비교한다
			System.out.println("2: MemberJoinAction.me 호출");
			// Controller 는 주소를 받아서, 어디로 가라는 명령밖에 못함
			// 직접적인 처리 못함-> 회원가입 처리 : 별도의 객체 생성-> 동작실행
			// 같은 패키지 안에  MemberJoin() 객체 생성 !
			// MemberJoinAction.java에서 req, resp을 어떻게 받는가 했더만
			// 여기서 MemberJoinAction 객체 만들어서 execute호출해서 파라미터로 전달해줌!
			
			try {
				// DB를 써야한다! 
				//MemberJoinAction mja = new MemberJoinAction();
				//mja.execute(request, response);
				// new MemberJoinAction().execute(request,response); 형태 가능하지만 가비지 생성때매 사용하지 않는것을 권장
				action = new MemberJoinAction();	// 업캐스팅->MemberJoinAction이 Action을 상속하고 있기 떄문에 사용 가능
				forward = action.execute(request, response);
				// -> MemberJoinAction.java의 execute 실행 후, ActionForward 객체 반환받음~!
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/MemberLogin.me")){
			System.out.println("c : /MemberLogin.me 호출!");
			// 화면을 보여주기 -> view 페이지로 이동
			forward = new ActionForward();
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/MemberLoginAction.me")){
			System.out.println("C : /MemberLoginAction.me 호출!");
			// DB 사용한다> MemberLoginAction() 객체 생성 해야함
			action = new MemberLoginAction();
			System.out.println("C : 로그인 처리 메소드 호출! ");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
		else if (command.equals("/Main.me")){
			System.out.println("C : /Main.me 호출");
			forward = new ActionForward();
			forward.setPath("./main/main.jsp");
			forward.setRedirect(false); // main.jsp 페이지가 Main.me로 보여야하므로
		
		}
		
		else if(command.equals("/MemberLogout.me")){
			System.out.println("C:/MemberLogout.me 호출!");
			// MemberLogoutAction() 객체 생성
			// 	 	DB에 연결하는 것은 아니지만,어떤 '동작'이기 때문에 객체 생성
			action = new MemberLogoutAction();
			
			try {
				forward  = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/MemberInfo.me")){
			System.out.println("C:/MemberInfo.me 호출!");
			// DB 정보를 가져와서 view 페이지에 출력
			// MemberInfoAction () 객체 생성
			action = new MemberInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
		else if(command.equals("/MemberUpdate.me")){
			System.out.println("C : /MemberUpdate.me 호출!");
			
			// DB 정보를 -> 화면(view) 출력 -> ./member/updateForm.jsp
			
			// DB 접속할거니까, MemberUpdateAction() 객체 생성 
			action = new MemberUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/MemberUpdateProAction.me")){
			System.out.println("C : /MemberUpdateProAction.me 호출!");
			// 입력받은 정보를 DB 에 저장 -> (정보 수정 후!) => 메인페이지로 이동
			///MemberUpdateProAction.me() 객체 생성
			// MemberUpdateAction()은 데이터 불러오는 객체임
			// 헷갈리지 않도록 주의할 것!! 
			action = new MemberUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/MemberDelete.me")){
			System.out.println("C: /MemberDelete.me 호출");
			// 정보 입력 -> View -> DB 처리
			forward = new ActionForward();
			forward.setPath("./member/deleteForm.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/MemberDeleteAction.me")){
			System.out.println("C : /MemberDeleteAction.me 호출 !");
			// 정보를 전달받아서 DB에서 삭제
			// MemberDeleteAction() 객체 생성
			action = new MemberDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(command.equals("/MemberList.me")){
			System.out.println("C : /MemberList.me 호출");
			
			// DB 사용해서 해당 View 페이지에 출력
			// MemberListAction() 객체
			
			action = new MemberListAction();
			try {
				// 컨트롤러가 세가지 어떤 액션을 컨트롤 한다고?
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/******************* 2. 페이지 주소 매핑(연결) *******************/
		
		
		/******************* 3. 페이지 주소 이동 종류를 정하기 (제어) *******************/
		if(forward != null){
			// forward 객체 있음 => 페이지 이동 정보가 있음
			if(forward.isRedirect()){ 	// true
				System.out.println("3 : [MemberFrontController] >> sendRedirect() 이동");
				response.sendRedirect(forward.getPath());
			} else {
				System.out.println("3 : [MemberFrontController] >> forward() 이동");
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		/******************* 3. 페이지 주소 이동 *******************/
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController_doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController_doPost() 호출");
		doProcess(request, response);
	}
	
}
