package com.ooqiu.gaming.server.web.admin.config.thymeleaf.tag;

import com.ooqiu.gaming.server.domain.Dict;
import com.ooqiu.gaming.server.web.admin.utils.DubboContextUtils;
import com.ooqiu.gaming.service.admin.api.DictService;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.List;

/**
 * 字典标签
 * <p>Title: ThSysDictTagProcessor</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/5 9:59
 */
public class ThSysDictTagProcessor extends AbstractElementTagProcessor {

    // 标签名
    private static final String TAG_NAME = "dict";

    // 优先级
    private static final int PRECEDENCE = 10000;

    public ThSysDictTagProcessor(String dialectPrefix) {
        super(
                // 此处理器将仅应用于HTML模式
                TemplateMode.HTML,

                // 要应用于名称的匹配前缀
                dialectPrefix,

                // 标签名称：匹配此名称的特定标签
                TAG_NAME,

                // 将标签前缀应用于标签名称
                true,

                // 无属性名称：将通过标签名称匹配
                null,

                // 没有要应用于属性名称的前缀
                false,

                // 优先(内部方言自己的优先)
                PRECEDENCE
        );
    }

    @Override
    protected void doProcess(ITemplateContext iTemplateContext, IProcessableElementTag iProcessableElementTag, IElementTagStructureHandler iElementTagStructureHandler) {
        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext(iTemplateContext);
        DictService dictService = applicationContext.getBean(DubboContextUtils.class).getDictService();

        // 查询参数
        String dictType = iProcessableElementTag.getAttributeValue("type");
        List<Dict> dictList = dictService.selectByType(dictType);

        // 下拉框样式
        String dictClass = iProcessableElementTag.getAttributeValue("class");
        // 表单元素的 name
        String dictName = iProcessableElementTag.getAttributeValue("name");

        // 创建将替换自定义标签的 DOM 结构
        IModelFactory modelFactory = iTemplateContext.getModelFactory();
        IModel model = modelFactory.createModel();

        model.add(modelFactory.createOpenElementTag(String.format("select name='%s' class='%s'", dictName, dictClass)));
        for (Dict dict : dictList) {
            model.add(modelFactory.createOpenElementTag(String.format("option value='%s'", dict.getValue())));
            model.add(modelFactory.createText(dict.getLabel()));
            model.add(modelFactory.createCloseElementTag("option"));
        }
        model.add(modelFactory.createCloseElementTag("select"));

        // 利用引擎替换整个标签
        iElementTagStructureHandler.replaceWith(model, false);
    }
}
