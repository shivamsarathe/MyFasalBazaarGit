package controllers;

import javax.servlet.*;
import javax.servlet.http.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import java.io.IOException;

public class GenerateOtpServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
				String OTP = Integer.toString((int)(Math.random()*10000));
				

				String mobile = request.getParameter("mobile");
				System.out.println("91"+mobile);

		///////// Sending OTP ////////////
				String username = "GGITSS";
				String password = "89411599";
				String message  = "Welcome to FasalBazar, your one time password(OTP) is: "+OTP;
				System.out.println(message);
				String sender = "GGITSS";

				//http://smscgateway.com/messageapi.asp?username=username&
				//password=password&sender=ABC&mobile=9999999989,9999999990,9999999991&message=Hello;
				try{

					  // Build URL encoded query string
					  String encoding = "UTF-8";
					  String queryString = "username=" + URLEncoder.encode(username, encoding)
						+ "&password=" + URLEncoder.encode(password, encoding)
						+ "&sender=" + URLEncoder.encode(sender, encoding)
						+ "&mobile=" + mobile //URLEncoder.encode(mobile, encoding)
						+ "&message=" + URLEncoder.encode(message, encoding);

						System.out.println(queryString);

					  // Send request to the API servers over HTTPS
					  URL url = new URL("http://smscgateway.com/messageapi.asp?"+queryString);
					  URLConnection conn = url.openConnection();
					  conn.setDoOutput(true);
					  OutputStreamWriter wr = 
					  new OutputStreamWriter(conn.getOutputStream());
					  wr.write(queryString);
					  wr.flush();

					  // The response from the gateway is going to look like this:
					  // id: a4c5ad77ad6faf5aa55f66a
					  // 
					  // In the event of an error, it will look like this:
					  // err: invalid login credentials
					  BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					  String result = rd.readLine();
					  wr.close();
					  rd.close();

					  if(result == null) {
						System.out.println("No response received");
					  }
					  else if(result.startsWith("id:")) {
						System.out.println("Message sent successfully");
					  } 
					  else {
						System.out.println("Error - " + result);
					  }
				} 
				catch (Exception e) {
					System.out.println("Error - " + e);
				}
				response.getWriter().write(OTP);
			}
}