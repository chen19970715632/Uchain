package com.example.uchain.interceptor;

import cn.hutool.json.JSONObject;
import com.example.uchain.demo.Result;
import com.example.uchain.utils.JwtUtils;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源运行前运行 返回true     放行 放回false 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求url
        String url = request.getRequestURI();
        log.info("请求的url:{}",url);

        //判断请求url中是否包含login，如果包含，说明是登录操作 放行
        if (url.contains("login")||url.contains("members")||url.contains("information")){
            return true;
        }

        //获取请求头中的令牌(token)
        String jwt =request.getHeader("token");


        //判断令牌是否存在 如果不存在返回错误结果
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头  token为空，未登陆");
            Result error = Result.error("NOT_LOGIN");

            //手动转换对象 --json
            String notLogin = String.valueOf(new JSONObject(error));
            response.getWriter().write(notLogin);
            return false;
        }

        //解析token 如果解析失败 返回错误结果
        try{
            JwtUtils.parseJWT(jwt);

        } catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换对象 --json
            String notLogin = String.valueOf(new JSONObject(error));
            response.getWriter().write(notLogin);
            return false;
        }

        //放行
        log.info("令牌合格,放行");

        return true;
    }

    @Override//标资源方法运行后放行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

    }

    @Override//视图渲染完毕后放行 最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
