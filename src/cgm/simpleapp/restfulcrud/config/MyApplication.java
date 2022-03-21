package cgm.simpleapp.restfulcrud.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
	public MyApplication() {
		// TODO Auto-generated constructor stub
		
		//ResourceConfig s;
		//s.packages(packages)

		// if there are more than two packanges then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("cgm.simpleapp.restfulcrud.service");
		
		//cgm.simpleapp.restfulcrud.service
		//jersey.config.server.provider.packages
		//jersey.con
	}
}