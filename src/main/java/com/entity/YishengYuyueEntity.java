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
 * 挂号
 *
 * @author 
 * @email
 */
@TableName("yisheng_yuyue")
public class YishengYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengYuyueEntity() {

	}

	public YishengYuyueEntity(T t) {
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
     * 医生
     */
    @ColumnInfo(comment="医生",type="int(11)")
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 就诊识别码
     */
    @ColumnInfo(comment="就诊识别码",type="varchar(200)")
    @TableField(value = "yisheng_yuyue_uuid_number")

    private String yishengYuyueUuidNumber;


    /**
     * 挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="挂号时间",type="date")
    @TableField(value = "yisheng_yuyue_time")

    private Date yishengYuyueTime;


    /**
     * 时间类型
     */
    @ColumnInfo(comment="时间类型",type="int(11)")
    @TableField(value = "time_types")

    private Integer timeTypes;


    /**
     * 挂号状态
     */
    @ColumnInfo(comment="挂号状态",type="int(11)")
    @TableField(value = "yisheng_yuyue_types")

    private Integer yishengYuyueTypes;


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
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }
    /**
	 * 设置：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：就诊识别码
	 */
    public String getYishengYuyueUuidNumber() {
        return yishengYuyueUuidNumber;
    }
    /**
	 * 设置：就诊识别码
	 */

    public void setYishengYuyueUuidNumber(String yishengYuyueUuidNumber) {
        this.yishengYuyueUuidNumber = yishengYuyueUuidNumber;
    }
    /**
	 * 获取：挂号时间
	 */
    public Date getYishengYuyueTime() {
        return yishengYuyueTime;
    }
    /**
	 * 设置：挂号时间
	 */

    public void setYishengYuyueTime(Date yishengYuyueTime) {
        this.yishengYuyueTime = yishengYuyueTime;
    }
    /**
	 * 获取：时间类型
	 */
    public Integer getTimeTypes() {
        return timeTypes;
    }
    /**
	 * 设置：时间类型
	 */

    public void setTimeTypes(Integer timeTypes) {
        this.timeTypes = timeTypes;
    }
    /**
	 * 获取：挂号状态
	 */
    public Integer getYishengYuyueTypes() {
        return yishengYuyueTypes;
    }
    /**
	 * 设置：挂号状态
	 */

    public void setYishengYuyueTypes(Integer yishengYuyueTypes) {
        this.yishengYuyueTypes = yishengYuyueTypes;
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
        return "YishengYuyue{" +
            ", id=" + id +
            ", yishengId=" + yishengId +
            ", yonghuId=" + yonghuId +
            ", yishengYuyueUuidNumber=" + yishengYuyueUuidNumber +
            ", yishengYuyueTime=" + DateUtil.convertString(yishengYuyueTime,"yyyy-MM-dd") +
            ", timeTypes=" + timeTypes +
            ", yishengYuyueTypes=" + yishengYuyueTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
