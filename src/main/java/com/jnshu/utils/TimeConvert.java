package com.jnshu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//时间转换器，将前台输入的String类型时间转换为long类型
public class TimeConvert implements Converter<String, Long> {
    //日志对象
    private static Logger logger = LoggerFactory.getLogger(TimeConvert.class);

    @Override
    public Long convert(String s) {

        //设置时间模式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long l=null;

        //将String类型时间转换为long
        try {
            if (!s.equals("")) {
                l = simpleDateFormat.parse(s).getTime() / 1000;
                return l;
            }else {
                logger.error("当前时间为null");
                l=(long)0;
                return l;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("当前时间格式转换失败");
//            l=null;
        }
        //参数绑定失败
        return null;
    }
}
