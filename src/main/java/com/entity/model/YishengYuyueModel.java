package com.entity.model;

import com.entity.YishengYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 挂号
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YishengYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 就诊识别码
     */
    private String yishengYuyueUuidNumber;


    /**
     * 挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yishengYuyueTime;


    /**
     * 时间类型
     */
    private Integer timeTypes;


    /**
     * 挂号状态
     */
    private Integer yishengYuyueTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
