package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.server.domain.Dict;
import com.ooqiu.gaming.server.web.admin.dto.DataTable;
import com.ooqiu.gaming.service.admin.api.ArticleService;
import com.ooqiu.gaming.service.admin.api.DictService;
import com.ooqui.gaming.server.commons.constant.DubboVersionConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章管理
 * <p>Title: ArticleController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/3 14:10
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private ArticleService articleService;

    /**
     * 跳转文章列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "modules/article/list";
    }

    /**
     * 跳转文章表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "modules/article/form";
    }

    /**
     * 保存文章
     *
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Article article, HttpServletRequest request) {
        List<String> imageList = Lists.newArrayList();
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");

        if (!StringUtils.isBlank(image1)) {
            imageList.add(image1);
        }

        if (!StringUtils.isBlank(image2)) {
            imageList.add(image2);
        }

        if (!StringUtils.isBlank(image3)) {
            imageList.add(image3);
        }

        article.setCover(imageList.toString());

        int result = articleService.save(article);
        return "redirect:/article/list";
    }

    /**
     * 分页查询
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "data")
    public DataTable<Article> data(HttpServletRequest request) {
        String strPage = request.getParameter("datatable[pagination][page]");
        String strPageSize = request.getParameter("datatable[pagination][perpage]");

        // 遍历客户端 POST 请求的参数
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            String value = request.getParameter(name);
//            System.out.println("name=" + name + "     value=" + value);
//        }

        int page = 1;
        int pageSize = 10;

        if (!StringUtils.isBlank(strPage)) {
            page = Integer.parseInt(strPage);
        }
        if (!StringUtils.isBlank(strPageSize)) {
            pageSize = Integer.parseInt(strPageSize);
        }

        PageInfo<Article> pageInfo = articleService.page(page, pageSize);
        return new DataTable<Article>(pageInfo);
    }
}
