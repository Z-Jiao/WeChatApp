package com.wechatapp.freamwork.web;

import com.wechatapp.project.system.user.domain.Student;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

///**
// * web层通用数据处理
// *
// * @author ruoyi
// */
//public class BaseController
//{
//    /**
//     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
//     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder)
//    {
//        // Date 类型转换
//        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
//        {
//            @Override
//            public void setAsText(String text)
//            {
//                try {
//                    setValue(DateUtils.parseDate(text));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * 设置请求分页数据
//     */
////    protected void startPage()
////    {
////        PageDomain pageDomain = TableSupport.buildPageRequest();
////        Integer pageNum = pageDomain.getPageNum();
////        Integer pageSize = pageDomain.getPageSize();
////        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
////        {
////            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
////            PageHelper.startPage(pageNum, pageSize, orderBy);
////        }
////    }
//
//    /**
//     * 响应请求分页数据
//     */
////    @SuppressWarnings({ "rawtypes", "unchecked" })
////    protected TableDataInfo getDataTable(List<?> list)
////    {
////        TableDataInfo rspData = new TableDataInfo();
////        rspData.setCode(0);
////        rspData.setRows(list);
////        rspData.setTotal(new PageInfo(list).getTotal());
////        return rspData;
////    }
////
//
//    /**
//     * 页面跳转
//     */
//
//    public Student getSysUser()
//    {
//        return ShiroUtils.getSysUser();
//    }
//
//}
