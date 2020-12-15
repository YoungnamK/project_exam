package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.board.BoardListController;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberLoginController extends SuperClass {
		private String id =null;
		private String password=null;
		
		@Override
		public boolean validate(HttpServletRequest request) {
			boolean isCheck=true; //기본값은 true
			//만일 유효성 검사에 문제가 있으면, false로 변경
			if (this.id.length()<4 || this.id.length()>10) {
				request.setAttribute(super.PREFIX +"id", "아이디는 4글자 이상 10글자 이하입니다. ");
				isCheck=false;
			}
			if (this.password.length()<4 || this.password.length()>10) {
				request.setAttribute(super.PREFIX +"password", "비밀번호는 4글자 이상 10글자 이하입니다. ");
				isCheck=false;
			}
			
			return isCheck;
		}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.id =request.getParameter("id");
		this.password = request.getParameter("password");

		
		String gotopage="";
		
		if (this.validate(request)==false) {
			//유효성 검사 통과 못함
			gotopage ="member/meLoginForm.jsp";
			request.setAttribute("id", this.id);
			request.setAttribute("password", this.password);
			super.doPost(request, response);
			super.GotoPage(gotopage);
			
		}else {// 유효성 검사 통과
			MemberDao dao = new MemberDao();
			Member bean = dao.SelectData(id, password);
			String message=""; //오류 내용을 알려줄 메세지
			super.doPost(request, response);
			if (bean==null) { //로그인 실패
				gotopage="member/meLoginForm.jsp";
				message ="아이디나 비밀번호가 잘못됐습니다.";
				super.setErrorMessage(message);
				super.GotoPage(gotopage);
			}else { //로그인 성공
				
				//로그인이 되었으므로, 세션영역에 로그인 정보를 바인딩
				//이 바인딩 내용은 common.jsp 파일에서 참조함
				super.session.setAttribute("loginfo", bean);
				//게시물목록보기
				//gotopage="/board/boList.jsp";
				new BoardListController().doGet(request, response);
			}
			
		}
//		System.out.println(gotopage);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("회원 로그인 호출됨");
		
		super.doPost(request, response);
		String gotopage="/member/meLoginForm.jsp";
		super.GotoPage(gotopage);
	}
	
	
}
