package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Dict;
import com.ooqiu.gaming.server.web.admin.dto.DataTable;
import com.ooqiu.gaming.service.admin.api.DictService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 字典管理
 * <p>Title: DictController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/2 7:15
 */
@Controller
@RequestMapping(value = "dict")
public class DictController {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private DictService dictService;

    /**
     * 跳转字典列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "modules/dict/list";
    }

    /**
     * 跳转字典表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "modules/dict/form";
    }

    /**
     * 保存字典
     *
     * @param dict
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Dict dict) {
        int result = dictService.save(dict);
        return "redirect:/dict/list";
    }

    /**
     * Ajax 请求用数据集
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "data")
    public DataTable<Dict> data(HttpServletRequest request) {
        String strPageNum = request.getParameter("datatable[pagination][page]");
        String strPageSize = request.getParameter("datatable[pagination][perpage]");

        // 遍历 POST 请求参数
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            String value = request.getParameter(name);
//
//            System.out.println("name:" + name + "   value:" + value);
//        }

        int pageNum = StringUtils.isBlank(strPageNum) ? 1 : Integer.parseInt(strPageNum);
        int pageSize = StringUtils.isBlank(strPageSize) ? 10 : Integer.parseInt(strPageSize);

        PageInfo<Dict> pageInfo = dictService.page(pageNum, pageSize);
        return new DataTable<Dict>(pageInfo);
    }
}
