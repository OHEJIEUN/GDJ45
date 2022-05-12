package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.StaffDAO;

public class ListService implements StaffService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("application/json; charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		obj.put("staffs", StaffDAO.getInstance().selectstaffList());
		
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
		
	}

}
