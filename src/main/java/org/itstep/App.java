package org.itstep;

import org.itstep.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.register(AppConfig.class);
    	
    }
}
