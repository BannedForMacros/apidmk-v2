package DbPeru.Posm.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   protected Class[] getRootConfigClasses() {
      return new Class[0];
   }

   protected Class[] getServletConfigClasses() {
      return new Class[]{WebMvcConfig.class};
   }

   protected String[] getServletMappings() {
      return new String[]{"/"};
   }
}
