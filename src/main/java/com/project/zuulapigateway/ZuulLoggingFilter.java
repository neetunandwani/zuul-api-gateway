package com.project.zuulapigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    private Logger logger= Logger.getLogger(ZuulLoggingFilter.class.getName());
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
       HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
       logger.log(Level.INFO, String.format("request uri is %s", request.getRequestURI()));
        return request;
    }
}
