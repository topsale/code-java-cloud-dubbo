package com.ooqiu.gaming.server.web.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 前端树控件
 * <p>Title: TreeView</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/3/2 9:19
 */
@Data
public class TreeView implements Serializable {
    private String id;
    private String icon;
    private String text;
    private boolean children;
}
