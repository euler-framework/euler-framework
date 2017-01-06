package net.eulerframework.web.module.basic.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.eulerframework.web.module.basic.service.IBaseDataService;
import net.eulerframework.web.module.basic.service.impl.BaseDataService;

@Component
public class BaseDataListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        WebApplicationContext rwp = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        
        IBaseDataService baseDataService= (BaseDataService)rwp.getBean("baseDataService");
        try {
            baseDataService.createCodeDict();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        baseDataService.loadBaseData();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}