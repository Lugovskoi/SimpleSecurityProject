package by.lugovskoi.tryproject;

import by.lugovskoi.tryproject.config.DaoConfiguration;
import by.lugovskoi.tryproject.config.SecurityConfiguration;
import by.lugovskoi.tryproject.config.ServiceConfiguration;
import by.lugovskoi.tryproject.config.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {DaoConfiguration.class, ServiceConfiguration.class, WebConfiguration.class, SecurityConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
