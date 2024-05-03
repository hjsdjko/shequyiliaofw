package com.entity.vo;

import com.entity.ZhinanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 防范指南
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhinan")
public class ZhinanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 指南编号
     */

    @TableField(value = "zhinan_uuid_number")
    private String zhinanUuidNumber;


    /**
     * 指南标题
     */

    @TableField(value = "zhinan_name")
    private String zhinanName;


    /**
     * 指南图片
     */

    @TableField(value = "zhinan_photo")
    private String zhinanPhoto;


    /**
     * 指南视频
     */

    @TableField(value = "zhinan_video")
    private String zhinanVideo;


    /**
     * 指南类型
     */

    @TableField(value = "zhinan_types")
    private Integer zhinanTypes;


    /**
     * 指南热度
     */

    @TableField(value = "zhinan_clicknum")
    private Integer zhinanClicknum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 指南介绍
     */

    @TableField(value = "zhinan_content")
    private String zhinanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zhinan_delete")
    private Integer zhinanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：指南编号
	 */
    public String getZhinanUuidNumber() {
        return zhinanUuidNumber;
    }


    /**
	 * 获取：指南编号
	 */

    public void setZhinanUuidNumber(String zhinanUuidNumber) {
        this.zhinanUuidNumber = zhinanUuidNumber;
    }
    /**
	 * 设置：指南标题
	 */
    public String getZhinanName() {
        return zhinanName;
    }


    /**
	 * 获取：指南标题
	 */

    public void setZhinanName(String zhinanName) {
        this.zhinanName = zhinanName;
    }
    /**
	 * 设置：指南图片
	 */
    public String getZhinanPhoto() {
        return zhinanPhoto;
    }


    /**
	 * 获取：指南图片
	 */

    public void setZhinanPhoto(String zhinanPhoto) {
        this.zhinanPhoto = zhinanPhoto;
    }
    /**
	 * 设置：指南视频
	 */
    public String getZhinanVideo() {
        return zhinanVideo;
    }


    /**
	 * 获取：指南视频
	 */

    public void setZhinanVideo(String zhinanVideo) {
        this.zhinanVideo = zhinanVideo;
    }
    /**
	 * 设置：指南类型
	 */
    public Integer getZhinanTypes() {
        return zhinanTypes;
    }


    /**
	 * 获取：指南类型
	 */

    public void setZhinanTypes(Integer zhinanTypes) {
        this.zhinanTypes = zhinanTypes;
    }
    /**
	 * 设置：指南热度
	 */
    public Integer getZhinanClicknum() {
        return zhinanClicknum;
    }


    /**
	 * 获取：指南热度
	 */

    public void setZhinanClicknum(Integer zhinanClicknum) {
        this.zhinanClicknum = zhinanClicknum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：指南介绍
	 */
    public String getZhinanContent() {
        return zhinanContent;
    }


    /**
	 * 获取：指南介绍
	 */

    public void setZhinanContent(String zhinanContent) {
        this.zhinanContent = zhinanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZhinanDelete() {
        return zhinanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZhinanDelete(Integer zhinanDelete) {
        this.zhinanDelete = zhinanDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
