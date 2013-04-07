package com.sap.nic.mytaxi.resteasyApp;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.sap.nic.mytaxi.servlet.OrderServlet;

/**
 * 
 * @author i058959
 */
public class RSApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(OrderServlet.class);
		return classes;
	}
}