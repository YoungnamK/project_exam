package mypkg.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러 인터페이스 : 모든 컨트롤러들의 상위개념
//요청(request)이 들어오면 특정한 컨트롤러(동작)을 수행해주는 인터페이스
public interface SuperController {
	// 모든 비즈니스 로직을 처리해주는 추상메소드 정의 
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException;
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
}
