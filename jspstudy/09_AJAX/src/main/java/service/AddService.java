package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.MemberDTO;
import repository.MemberDAO;

public class AddService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		
		MemberDTO member = MemberDTO.builder()
				.id(id)
				.name(name)
				.gender(gender)
				.address(address)
				.build();
		
		int res = MemberDAO.getInstance().insertMember(member);
		
		// 응답 데이터 형식
		// JSON
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 예시
		// 형식 {"res": res}
		// 성공 {"res": 1}
		// 실패 {"res": 0}
		
		// 1. 라이브러리를 사용하지 않는 경우
		// String responseText = "{\"res\": " + res + "}";
		
		// 2. 라이브러리(JSON IN JAVA)를 사용하는 경우
		JSONObject obj = new JSONObject();
		obj.put("res", res);
		String responseText = obj.toString();
		
		// 응답 데이터 상세
		// res : 회원의 등록이 성공하면 1, 실패하면 0을 저장한다.
		

	}

}
