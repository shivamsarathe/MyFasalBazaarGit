package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import models.City;
import org.json.*;
import java.io.*;


public class CityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		String citint = request.getParameter("city");

		Iterator <City> itr = City.collectCities(citint).iterator();
		JSONArray ja = new JSONArray();
		int i=0;
		while(itr.hasNext()){
			City city=itr.next();
		JSONObject jo = new JSONObject();
		jo.put("cityid",city.getCityId());
		jo.put("citynm",city.getCity());
		jo.put("statenm",city.getState());
		ja.put(i++,jo);
		}
	
		response.getWriter().write(ja.toString());
	}
}