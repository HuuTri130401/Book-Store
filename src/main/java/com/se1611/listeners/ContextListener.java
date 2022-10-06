/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.listeners;

import com.se1611.utils.PropertiesFileHelper;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String siteMapLocation = context.getInitParameter(
                "SITEMAP_PROPERTIES_FILE_LOCATION");
        String authenticationPropertyLocation = context.getInitParameter(
                "AUTHENTICATION_PROPERTIES_FILE_LOCATION");
        
        Properties siteMapProperty = PropertiesFileHelper.getProperties(context, siteMapLocation);
        Properties authenticationProperty = PropertiesFileHelper.getProperties(context, authenticationPropertyLocation);
        
        context.setAttribute("SITE_MAP", siteMapProperty);
        context.setAttribute("AUTHENTICATION_LIST", authenticationProperty);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
