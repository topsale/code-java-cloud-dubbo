package com.ooqiu.gaming.service.admin.api;

import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Dict;

import java.util.List;

/**
 * 字典管理
 * <p>Title: DictService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/2 11:06
 */
public interface DictService {
    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 笔数
     * @return
     */
    public PageInfo<Dict> page(int pageNum, int pageSize);

    /**
     * 保存字典
     *
     * @param dict
     * @return
     */
    public int save(Dict dict);

    /**
     * 根据字典类型查询
     * @param type
     * @return
     */
    public List<Dict> selectByType(String type);
}
