package org.example.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ExecutionTimeInterceptor implements HandlerInterceptor {

    private static Logger LOGGER = LoggerFactory.getLogger("ExecutionTimeInterceptor category");

    private long PREHANDLE_TIME = 0;
    private long POSTHANDLE_TIME = 0;
    private long AFTER_COMPLETE_TIME = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        PREHANDLE_TIME = System.currentTimeMillis();

        LOGGER.info("info message PREHANDLE_TIME is: " + PREHANDLE_TIME);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        POSTHANDLE_TIME = System.currentTimeMillis();

        LOGGER.info("info message POSTHANDLE_TIME is: " + POSTHANDLE_TIME);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        AFTER_COMPLETE_TIME = System.currentTimeMillis();

        LOGGER.info("info message AFTER_COMPLETE_TIME is: " + AFTER_COMPLETE_TIME);

        long HANDLER_EXECUTION_TIME = POSTHANDLE_TIME - PREHANDLE_TIME;
        long TOTAL_EXECUTION_TIME = AFTER_COMPLETE_TIME - PREHANDLE_TIME;

        LOGGER.info("info message HANDLER_EXECUTION_TIME is: " + HANDLER_EXECUTION_TIME);
        LOGGER.info("info message TOTAL_EXECUTION_TIME is: " + TOTAL_EXECUTION_TIME);
    }
}
