package com.ironman.exceptionHandler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 16:21 2017/10/19 0019
 * @Modified by:
 **/
public class CustomExceptionHandler extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex){
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			// Apply HTTP status code for error views, if specified.
			// Only apply it if we're processing a top-level request.
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			return getModelAndView(viewName, ex, request);
		} else {
			return null;
		}
	}
}
