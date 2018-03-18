package com.ooqiu.gaming.server.database.domain;

import java.util.Date;
import javax.persistence.*;

public class Article {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 文章来源
     */
    private String source;

    /**
     * 投稿人
     */
    @Column(name = "source_name")
    private String sourceName;

    /**
     * 文章来源ID
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章类型
     */
    private String type;

    /**
     * 阅读数量
     */
    @Column(name = "read_count")
    private Integer readCount;

    /**
     * 分享数量
     */
    @Column(name = "share_count")
    private Integer shareCount;

    /**
     * 评论数量
     */
    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 文章链接
     */
    private String url;

    /**
     * 是否热门
     */
    @Column(name = "is_hot")
    private String isHot;

    /**
     * 是否置顶
     */
    @Column(name = "is_top")
    private String isTop;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 标签
     */
    private String tag;

    /**
     * 相册
     */
    private String cover;

    /**
     * 图片位置
     */
    @Column(name = "cover_show_type")
    private String coverShowType;

    /**
     * 分享类型
     */
    @Column(name = "share_type")
    private String shareType;

    /**
     * 允许评论
     */
    @Column(name = "can_comment")
    private String canComment;

    /**
     * 文章类型
     */
    @Column(name = "content_type")
    private String contentType;

    /**
     * 允许踩
     */
    @Column(name = "unlike_enable")
    private String unlikeEnable;

    /**
     * 显示评论
     */
    @Column(name = "show_comment")
    private String showComment;

    /**
     * 踩数量
     */
    @Column(name = "unlike_num")
    private Integer unlikeNum;

    /**
     * 赞数量
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 小提示
     */
    private String tips;

    /**
     * 标题颜色
     */
    @Column(name = "font_color")
    private String fontColor;

    /**
     * 标题加粗
     */
    @Column(name = "font_bold")
    private String fontBold;

    /**
     * 分享链接
     */
    @Column(name = "share_url")
    private String shareUrl;

    /**
     * 显示赞
     */
    @Column(name = "like_num_show")
    private String likeNumShow;

    /**
     * 显示踩
     */
    @Column(name = "unlike_num_show")
    private String unlikeNumShow;

    /**
     * 平台原创
     */
    @Column(name = "iNative")
    private String inative;

    /**
     * 允许跳过广告
     */
    @Column(name = "skip_ad")
    private String skipAd;

    /**
     * 是否H5
     */
    @Column(name = "is_h5")
    private String isH5;

    /**
     * 作者ID
     */
    @Column(name = "author_id")
    private Long authorId;

    /**
     * 是否显示
     */
    @Column(name = "show_article")
    private String showArticle;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 扩展字段
     */
    private String extend;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文章来源
     *
     * @return source - 文章来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置文章来源
     *
     * @param source 文章来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取投稿人
     *
     * @return source_name - 投稿人
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置投稿人
     *
     * @param sourceName 投稿人
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     * 获取文章来源ID
     *
     * @return source_id - 文章来源ID
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置文章来源ID
     *
     * @param sourceId 文章来源ID
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取文章类型
     *
     * @return type - 文章类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置文章类型
     *
     * @param type 文章类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取阅读数量
     *
     * @return read_count - 阅读数量
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * 设置阅读数量
     *
     * @param readCount 阅读数量
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取分享数量
     *
     * @return share_count - 分享数量
     */
    public Integer getShareCount() {
        return shareCount;
    }

    /**
     * 设置分享数量
     *
     * @param shareCount 分享数量
     */
    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    /**
     * 获取评论数量
     *
     * @return comment_count - 评论数量
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数量
     *
     * @param commentCount 评论数量
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取文章链接
     *
     * @return url - 文章链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文章链接
     *
     * @param url 文章链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取是否热门
     *
     * @return is_hot - 是否热门
     */
    public String getIsHot() {
        return isHot;
    }

    /**
     * 设置是否热门
     *
     * @param isHot 是否热门
     */
    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取是否置顶
     *
     * @return is_top - 是否置顶
     */
    public String getIsTop() {
        return isTop;
    }

    /**
     * 设置是否置顶
     *
     * @param isTop 是否置顶
     */
    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    /**
     * 获取简介
     *
     * @return introduction - 简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置简介
     *
     * @param introduction 简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取标签
     *
     * @return tag - 标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签
     *
     * @param tag 标签
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取相册
     *
     * @return cover - 相册
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置相册
     *
     * @param cover 相册
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取图片位置
     *
     * @return cover_show_type - 图片位置
     */
    public String getCoverShowType() {
        return coverShowType;
    }

    /**
     * 设置图片位置
     *
     * @param coverShowType 图片位置
     */
    public void setCoverShowType(String coverShowType) {
        this.coverShowType = coverShowType;
    }

    /**
     * 获取分享类型
     *
     * @return share_type - 分享类型
     */
    public String getShareType() {
        return shareType;
    }

    /**
     * 设置分享类型
     *
     * @param shareType 分享类型
     */
    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    /**
     * 获取允许评论
     *
     * @return can_comment - 允许评论
     */
    public String getCanComment() {
        return canComment;
    }

    /**
     * 设置允许评论
     *
     * @param canComment 允许评论
     */
    public void setCanComment(String canComment) {
        this.canComment = canComment;
    }

    /**
     * 获取文章类型
     *
     * @return content_type - 文章类型
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 设置文章类型
     *
     * @param contentType 文章类型
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 获取允许踩
     *
     * @return unlike_enable - 允许踩
     */
    public String getUnlikeEnable() {
        return unlikeEnable;
    }

    /**
     * 设置允许踩
     *
     * @param unlikeEnable 允许踩
     */
    public void setUnlikeEnable(String unlikeEnable) {
        this.unlikeEnable = unlikeEnable;
    }

    /**
     * 获取显示评论
     *
     * @return show_comment - 显示评论
     */
    public String getShowComment() {
        return showComment;
    }

    /**
     * 设置显示评论
     *
     * @param showComment 显示评论
     */
    public void setShowComment(String showComment) {
        this.showComment = showComment;
    }

    /**
     * 获取踩数量
     *
     * @return unlike_num - 踩数量
     */
    public Integer getUnlikeNum() {
        return unlikeNum;
    }

    /**
     * 设置踩数量
     *
     * @param unlikeNum 踩数量
     */
    public void setUnlikeNum(Integer unlikeNum) {
        this.unlikeNum = unlikeNum;
    }

    /**
     * 获取赞数量
     *
     * @return like_num - 赞数量
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置赞数量
     *
     * @param likeNum 赞数量
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取小提示
     *
     * @return tips - 小提示
     */
    public String getTips() {
        return tips;
    }

    /**
     * 设置小提示
     *
     * @param tips 小提示
     */
    public void setTips(String tips) {
        this.tips = tips;
    }

    /**
     * 获取标题颜色
     *
     * @return font_color - 标题颜色
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * 设置标题颜色
     *
     * @param fontColor 标题颜色
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * 获取标题加粗
     *
     * @return font_bold - 标题加粗
     */
    public String getFontBold() {
        return fontBold;
    }

    /**
     * 设置标题加粗
     *
     * @param fontBold 标题加粗
     */
    public void setFontBold(String fontBold) {
        this.fontBold = fontBold;
    }

    /**
     * 获取分享链接
     *
     * @return share_url - 分享链接
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 设置分享链接
     *
     * @param shareUrl 分享链接
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    /**
     * 获取显示赞
     *
     * @return like_num_show - 显示赞
     */
    public String getLikeNumShow() {
        return likeNumShow;
    }

    /**
     * 设置显示赞
     *
     * @param likeNumShow 显示赞
     */
    public void setLikeNumShow(String likeNumShow) {
        this.likeNumShow = likeNumShow;
    }

    /**
     * 获取显示踩
     *
     * @return unlike_num_show - 显示踩
     */
    public String getUnlikeNumShow() {
        return unlikeNumShow;
    }

    /**
     * 设置显示踩
     *
     * @param unlikeNumShow 显示踩
     */
    public void setUnlikeNumShow(String unlikeNumShow) {
        this.unlikeNumShow = unlikeNumShow;
    }

    /**
     * 获取平台原创
     *
     * @return iNative - 平台原创
     */
    public String getInative() {
        return inative;
    }

    /**
     * 设置平台原创
     *
     * @param inative 平台原创
     */
    public void setInative(String inative) {
        this.inative = inative;
    }

    /**
     * 获取允许跳过广告
     *
     * @return skip_ad - 允许跳过广告
     */
    public String getSkipAd() {
        return skipAd;
    }

    /**
     * 设置允许跳过广告
     *
     * @param skipAd 允许跳过广告
     */
    public void setSkipAd(String skipAd) {
        this.skipAd = skipAd;
    }

    /**
     * 获取是否H5
     *
     * @return is_h5 - 是否H5
     */
    public String getIsH5() {
        return isH5;
    }

    /**
     * 设置是否H5
     *
     * @param isH5 是否H5
     */
    public void setIsH5(String isH5) {
        this.isH5 = isH5;
    }

    /**
     * 获取作者ID
     *
     * @return author_id - 作者ID
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * 设置作者ID
     *
     * @param authorId 作者ID
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * 获取是否显示
     *
     * @return show_article - 是否显示
     */
    public String getShowArticle() {
        return showArticle;
    }

    /**
     * 设置是否显示
     *
     * @param showArticle 是否显示
     */
    public void setShowArticle(String showArticle) {
        this.showArticle = showArticle;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取扩展字段
     *
     * @return extend - 扩展字段
     */
    public String getExtend() {
        return extend;
    }

    /**
     * 设置扩展字段
     *
     * @param extend 扩展字段
     */
    public void setExtend(String extend) {
        this.extend = extend;
    }
}