package mypkg.utility;

public class pageTest {
	public static void main(String[] args) {
		//총 33건 중에서 2페이지를 확인해보겠습니다 .
		String _pageNumber = "3";
		String _pageSize ="10";
		int totalCount=33;
		String url = "boList.jsp";
		String mode = "";	//검색 모드
		String keyword = "";//검색 키워드
		
		Paging pageInfo = new Paging(_pageNumber, _pageSize, totalCount, url, mode, keyword) ;
		
		//pageTest.jsp파일을 만드시고 아래 결과물을 <body> 태그에 넣어서 실행해 보세요
		System.out.println(pageInfo.getPagingHtml());
	}	
}
