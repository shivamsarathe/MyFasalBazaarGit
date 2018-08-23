package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import java.util.ArrayList;

import models.State;
import models.Category;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event){
			/*
		ArrayList<State> states = State.collectStates();

	
		event.getServletContext().setAttribute("states",states);
		System.out.println("States has been set ");
		*/

		ArrayList<Category> categories = Category.collectCategories();
		event.getServletContext().setAttribute("categories",categories);
		System.out.println("Categories has been set ");
		
		Category cat = (Category)categories.get(0);
		System.out.println(cat.getCategoryId()+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

	public void contextDestroyed(ServletContextEvent event){
		
	}
}