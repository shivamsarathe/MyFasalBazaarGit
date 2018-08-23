package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.json.*;
import models.*;
public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		Category category = new Category();
		String cat = request.getParameter("search");
		System.out.println(category);
		int i=0;
		Iterator<Category> its = category.collectCategories(cat).iterator();
		JSONArray ar = new JSONArray();
		while(its.hasNext()){
			category = its.next();
			JSONObject obj = new JSONObject();
			obj.put("categotyId",category.getCategoryId());
			obj.put("category",category.getCategory());
			ar.put(i++,obj);
		}
		response.getWriter().write(ar.toString());
	}
	
}