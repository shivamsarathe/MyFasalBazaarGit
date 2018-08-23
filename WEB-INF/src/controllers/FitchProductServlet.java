package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.json.*;
import models.*;
public class FitchProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Commodity commodities = new Commodity();
		//System.out.println(session);
		
		int i=0;

		Iterator<Commodity> its = commodities.collectInfoForFarmer().iterator();
		JSONArray ar = new JSONArray();
		while(its.hasNext()){
			commodities = its.next();
			JSONObject obj = new JSONObject();
			obj.put("commodity",commodities.getCommodity());
			obj.put("quantity",commodities.getQuantity());
			obj.put("mrp",commodities.getMrp());
			obj.put("user",commodities.getUser().getUserName());
			obj.put("userId",commodities.getUser().getUserId());
			//System.out.println(commodities.getUser().getUserName());
			obj.put("description",commodities.getDescription());
			obj.put("rating",commodities.getRating());
			obj.put("qtleft",commodities.getQtLeft());
			//CommodityPics pics = new CommodityPics();
			//String picPath = pics.getCommodityPicByCommodity(commodities.getCommodityId());
			obj.put("commodity_id",commodities.getCommodityId());
			obj.put("commodity_pic",commodities.getCommodityPics().getPicPath());
			//System.out.println(commodities.getCommodityPics().getPicPath());
			

			ar.put(i++,obj);
		}
		response.getWriter().write(ar.toString());
	}
	
}