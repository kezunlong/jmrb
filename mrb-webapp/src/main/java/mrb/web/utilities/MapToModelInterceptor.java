package mrb.web.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * This interceptor is used to
 * get the current action url in the JSP
 * 
 * For example:
 * mapping page /User/Index.jsp to controller action /User in Spring MVC
 * ${pageContext.request.requestURL} will return the first url(.jsp) 
 * We use this interceptor to save the action url to ${actionURL}
 */
public class MapToModelInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
         modelAndView.addObject("actionURL", request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}