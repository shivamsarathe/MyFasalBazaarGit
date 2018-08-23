package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.json.*;
import models.*;
public class SupplierDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		Commodity commodities = new Commodity();
		Integer commodityId = Integer.parseInt(request.getParameter("commodityId"));
		int i=0;
		Iterator<Commodity> its = commodities.collectInfo(commodityId).iterator();
		JSONArray ar = new JSONArray();
		while(its.hasNext()){
			commodities = its.next();
			JSONObject obj = new JSONObject();
			obj.put("commodity",commodities.getCommodity());
			obj.put("quantity",commodities.getQuantity());
			obj.put("mrp",commodities.getMrp());
			obj.put("user",commodities.getFarmer());
			obj.put("description",commodities.getDescription());
			obj.put("rating",commodities.getRating());
			obj.put("qtleft",commodities.getQtLeft());
			//CommodityPics pics = new CommodityPics();
			//String picPath = pics.getCommodityPicByCommodity(commodities.getCommodityId());
			//obj.put("commodity_id",commodities.getCommodityId());
			//obj.put("commodity_pic",picPath);
			
			System.out.println(commodities.getFarmer());
			ar.put(i++,obj);
		}
		response.getWriter().write(ar.toString());
	}
	
}