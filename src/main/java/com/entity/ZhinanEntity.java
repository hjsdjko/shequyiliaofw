package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 防范指南
 *
 * @author 
 * @email
 */
@TableName("zhinan")
public class ZhinanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhinanEntity() {

	}

	public ZhinanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 指南编号
     */
    @ColumnInfo(comment="指南编号",type="varchar(200)")
    @TableField(value = "zhinan_uuid_number")

    private String zhinanUuidNumber;


    /**
     * 指南标题
     */
    @ColumnInfo(comment="指南标题",type="varchar(200)")
    @TableField(value = "zhinan_name")

    private String zhinanName;


    /**
     * 指南图片
     */
    @ColumnInfo(comment="指南图片",type="varchar(200)")
    @TableField(value = "zhinan_photo")

    private String zhinanPhoto;


    /**
     * 指南视频
     */
    @ColumnInfo(comment="指南视频",type="varchar(200)")
    @TableField(value = "zhinan_video")

    private String zhinanVideo;


    /**
     * 指南类型
     */
    @ColumnInfo(comment="指南类型",type="int(11)")
    @TableField(value = "zhinan_types")

    private Integer zhinanTypes;


    /**
     * 指南热度
     */
    @ColumnInfo(comment="指南热度",type="int(11)")
    @TableField(value = "zhinan_clicknum")

    private Integer zhinanClicknum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 指南介绍
     */
    @ColumnInfo(comment="指南介绍",type="longtext")
    @TableField(value = "zhinan_content")

    private String zhinanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zhinan_delete")

    private Integer zhinanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：指南编号
	 */
    public String getZhinanUuidNumber() {
        return zhinanUuidNumber;
    }
    /**
	 * 设置：指南编号
	 */

    public void setZhinanUuidNumber(String zhinanUuidNumber) {
        this.zhinanUuidNumber = zhinanUuidNumber;
    }
    /**
	 * 获取：指南标题
	 */
    public String getZhinanName() {
        return zhinanName;
    }
    /**
	 * 设置：指南标题
	 */

    public void setZhinanName(String zhinanName) {
        this.zhinanName = zhinanName;
    }
    /**
	 * 获取：指南图片
	 */
    public String getZhinanPhoto() {
        return zhinanPhoto;
    }
    /**
	 * 设置：指南图片
	 */

    public void setZhinanPhoto(String zhinanPhoto) {
        this.zhinanPhoto = zhinanPhoto;
    }
    /**
	 * 获取：指南视频
	 */
    public String getZhinanVideo() {
        return zhinanVideo;
    }
    /**
	 * 设置：指南视频
	 */

    public void setZhinanVideo(String zhinanVideo) {
        this.zhinanVideo = zhinanVideo;
    }
    /**
	 * 获取：指南类型
	 */
    public Integer getZhinanTypes() {
        return zhinanTypes;
    }
    /**
	 * 设置：指南类型
	 */

    public void setZhinanTypes(Integer zhinanTypes) {
        this.zhinanTypes = zhinanTypes;
    }
    /**
	 * 获取：指南热度
	 */
    public Integer getZhinanClicknum() {
        return zhinanClicknum;
    }
    /**
	 * 设置：指南热度
	 */

    public void setZhinanClicknum(Integer zhinanClicknum) {
        this.zhinanClicknum = zhinanClicknum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：指南介绍
	 */
    public String getZhinanContent() {
        return zhinanContent;
    }
    /**
	 * 设置：指南介绍
	 */

    public void setZhinanContent(String zhinanContent) {
        this.zhinanContent = zhinanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZhinanDelete() {
        return zhinanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZhinanDelete(Integer zhinanDelete) {
        this.zhinanDelete = zhinanDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zhinan{" +
            ", id=" + id +
            ", zhinanUuidNumber=" + zhinanUuidNumber +
            ", zhinanName=" + zhinanName +
            ", zhinanPhoto=" + zhinanPhoto +
            ", zhinanVideo=" + zhinanVideo +
            ", zhinanTypes=" + zhinanTypes +
            ", zhinanClicknum=" + zhinanClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", zhinanContent=" + zhinanContent +
            ", zhinanDelete=" + zhinanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
