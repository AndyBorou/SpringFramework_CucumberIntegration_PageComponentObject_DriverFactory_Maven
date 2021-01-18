package automation.example.spring;

//will make page factory intit elements

import automation.example.framework.driver.DriverProvider;
import automation.example.site.Loadable;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.tools.StandardJavaFileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component //@Component - регистрация обекта в контексте
public class PageInitializationPBB implements BeanPostProcessor {

    @Autowired
    private DriverProvider driverProvider;


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
// init driver in bean object of the page objects
        if (bean instanceof Loadable){
            if(!bean.getClass().isAnnotationPresent(SkipInit.class)) {
                PageFactory.initElements(driverProvider.getInstance(), bean);
            }
        }
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
