package com.jnshu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 用于页面 jstl时间格式化s
 */
public class DateTag extends TagSupport {

    private String value;
    private static Logger logger = LoggerFactory.getLogger(DateTag.class);

    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try {
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time*1000);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("转换失败");
        }
        return super.doStartTag();
    }

    //传入String格式的时间戳
    public void setValue(String value) {
        this.value = value;
    }

}