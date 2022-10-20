package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {
    //Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class); : @Slf4j로 생략됨

    @Override
    //실제 어떤동작할지 지정
    //사용자 요청이 들어올때마다 먼저 실행
    public Object run() throws ZuulException {
        log.info("**************** printing log: ");

        //이 필터안에 request객체 존재하지 않으므로 RequestContest에서 request 가져옴
        RequestContext currentContext = RequestContext.getCurrentContext();
        //사용자가 갖고 있는 request정보 얻어옴
        HttpServletRequest request = currentContext.getRequest();
        log.info("**************** " + request.getRequestURI());

        return null;
    }

    @Override
    //사전필터 or 사후필터 결정
    public String filterType() {
        return "pre";
    }

    @Override
    //여러개의 필터가 있을때 순서
    public int filterOrder() {
        return 1;
    }

    @Override
    //원하는 옵션에 따라 사용할지 여부 정함
    public boolean shouldFilter() {
        return true;
    }
}
