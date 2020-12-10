package com.cido.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 获取参数
        String language = httpServletRequest.getParameter("language");
        // 初始化一个默认的Locale对象
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            // 若参数不为空，则解析参数，并使用参数初始化一个Locale对象
            // zh_CN
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
