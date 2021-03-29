/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.63
 * Generated at: 2021-03-24 03:59:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1> WebContent/jsp1/test3.jsp </h1>\r\n");
      out.write("\t\r\n");
      out.write("\t");

	  // p.177~
		
	  // 내장 객체 : JSP 자체적으로 내장되어있는 객체
	  // => 별도의 객체 생성없이 사용가능 (import문 사용없이도 사용가능)
	  // => 내장 객체는 JSP 페이지가 서블릿 클래스로 변환될 때
	  // 	_jspService() 메소드 안에서 가장먼저 선언된다.
		
		
	 
		
	  /* 
		[javax.servlet 패키지] - 8개의 내장 객체
		  request : 클라이언트의 요청 정보를 저장하는 객체(http요청, 파라미터)
		  response : 요청 정보에 대한 응답 정보를 처리하는 객체
		  session : 클라이언트의 세션 정보를 저장하는 객체
		  pageContext : 페이지에 실행을 할 때 필요한 정보를 저장하는 객체(프로젝트:StudyJSP)
		  out : 응답 페이지 전송을 위한 출력 스트림
		  application : 해당 애플리케이션의 컨텍스트 정보를 저장한 객체(프로젝트-더 큰개념)
		  config : 해당 페이지의 서블릿 설정 정보를 저장하는 객체
		  page : 해당 페이지의 서블릿 객체 (인스턴스-java, class파일 ...)
		  
		[java.lang 패키지] - 1개의 내장 객체
		  exeception : 예외 처리 객체

		
	  */

	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> request 내장 객체 </h3>\r\n");
      out.write("\t<!-- 요청하는 거의 모든 정보를 가지고 있는 객체 -->\r\n");
      out.write("\t\r\n");
      out.write("\t서버 도메인명 : ");
      out.print(request.getServerName() );
      out.write(" <br>\r\n");
      out.write("\t서버 포트번호 : ");
      out.print(request.getServerPort() );
      out.write(" <br>\r\n");
      out.write("\tURL : ");
      out.print(request.getRequestURL() );
      out.write(" <br>\r\n");
      out.write("\tURI : ");
      out.print(request.getRequestURI() );
      out.write(" <br> <!-- 프로토콜,호스트명,포트 번호 뺀 나머지 경로 -->\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t클라이언트 호스트명 : ");
      out.print(request.getRemoteHost() );
      out.write("<br>\r\n");
      out.write("\t클라이언트 ip : ");
      out.print(request.getRemoteAddr() );
      out.write("<br>\r\n");
      out.write("\t\r\n");
      out.write("\t프로토콜 : ");
      out.print(request.getProtocol() );
      out.write("<br>\r\n");
      out.write("\t\r\n");
      out.write("\t페이지 요청(전송)방식 : ");
      out.print(request.getMethod() );
      out.write(" <br>\r\n");
      out.write("\t\r\n");
      out.write("\t프로젝트 경로(컨텍스트 경로,내프로젝트명) : ");
      out.print(request.getContextPath() );
      out.write(" <br>\r\n");
      out.write("\t\r\n");
      out.write("\t물리적 경로 : ");
      out.print(request.getRealPath("/") );
      out.write(" <br>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\thttp 헤더(user-agent) : ");
      out.print(request.getHeader("user-agent") );
      out.write(" <br>\r\n");
      out.write("\thttp 헤더(accept-language) : ");
      out.print(request.getHeader("accept-language") );
      out.write(" <br>\r\n");
      out.write("\thttp 헤더(host) : ");
      out.print(request.getHeader("host") );
      out.write(" <br>\r\n");
      out.write("\thttp 헤더(connection) : ");
      out.print(request.getHeader("connection") );
      out.write(" <br>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> response 내장 객체 </h3>\r\n");
      out.write("\t");

		// response.setHeader("해더이름", value);
		// response.addCookie("쿠키값"); -> 홈페이지 유지 가능토록 함
		// response.sendRedirect("URL 주소"); -> 해당 페이지 이동 가능
		// response.setContentType("MIME 타입");
	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> session 내장 객체 </h3>\r\n");
      out.write("\t   세션 ID값 : ");
      out.print(session.getId() );
      out.write(" <br>\r\n");
      out.write("\t   세션 생성 시간 : ");
      out.print(session.getCreationTime() );
      out.write(" <br>\r\n");
      out.write("\t   세션 최종 접속 시간 : ");
      out.print(session.getLastAccessedTime() );
      out.write(" <br>\r\n");
      out.write("\t   세션 유지 시간(1800초,30분) : ");
      out.print(session.getMaxInactiveInterval() );
      out.write(" <br>\r\n");
      out.write("\t   \r\n");
      out.write("\t   ");

	   	// 세션 유지 시간 변경 30분 -> 1시간
	   	session.setMaxInactiveInterval(3600);
	   
	   
      out.write("\r\n");
      out.write("\t  \r\n");
      out.write("\t\r\n");
      out.write("\t세션 유지 시간(3600초,60분) : ");
      out.print(session.getMaxInactiveInterval() );
      out.write(" <br>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> application 내장 객체 </h3>\r\n");
      out.write("\t서버 정보 : ");
      out.print(application.getServerInfo() );
      out.write(" <br>\r\n");
      out.write("\t물리적 경로 : ");
      out.print(application.getRealPath("/") );
      out.write(" <br>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
