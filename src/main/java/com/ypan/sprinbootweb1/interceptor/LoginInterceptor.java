package com.ypan.sprinbootweb1.interceptor;

import com.ypan.sprinbootweb1.config.Constants;
import com.ypan.sprinbootweb1.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("---------------------开始进入请求地址拦截--- 从session获取数据如果存在就放行不存在就抛出异常拦截-------------------------");
        if (null == redisUtils) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtils = (RedisUtils) factory.getBean("redisUtils");
        }
        HttpSession session = request.getSession();
        if (!StringUtils.isEmpty(session.getAttribute("token"))) {
            String token = (String) session.getAttribute("token");
            if (redisUtils.hasKey(token)) {
                redisUtils.expire(token, Constants.INTEGER_NUM.INTEGER_900.getVal());
                return true;
            } else {
                return false;
            }
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");
            return false;

        }
    }
}
