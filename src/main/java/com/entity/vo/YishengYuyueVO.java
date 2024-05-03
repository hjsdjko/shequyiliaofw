package com.entity.vo;

import com.entity.YishengYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 挂号
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yisheng_yuyue")
public class YishengYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 就诊识别码
     */

    @TableField(value = "yisheng_yuyue_uuid_number")
    private String yishengYuyueUuidNumber;


    /**
     * 挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yisheng_yuyue_time")
    private Date yishengYuyueTime;


    /**
     * 时间类型
     */

    @TableField(value = "time_types")
    private Integer timeTypes;


    /**
     * 挂号状态
     */

    @TableField(value = "yisheng_yuyue_types")
    private Integer yishengYuyueTypes;


    /**
     * 创建时间
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
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：就诊识别码
	 */
    public String getYishengYuyueUuidNumber() {
        return yishengYuyueUuidNumber;
    }


    /**
	 * 获取：就诊识别码
	 */

    public void setYishengYuyueUuidNumber(String yishengYuyueUuidNumber) {
        this.yishengYuyueUuidNumber = yishengYuyueUuidNumber;
    }
    /**
	 * 设置：挂号时间
	 */
    public Date getYishengYuyueTime() {
        return yishengYuyueTime;
    }


    /**
	 * 获取：挂号时间
	 */

    public void setYishengYuyueTime(Date yishengYuyueTime) {
        this.yishengYuyueTime = yishengYuyueTime;
    }
    /**
	 * 设置：时间类型
	 */
    public Integer getTimeTypes() {
        return timeTypes;
    }


    /**
	 * 获取：时间类型
	 */

    public void setTimeTypes(Integer timeTypes) {
        this.timeTypes = timeTypes;
    }
    /**
	 * 设置：挂号状态
	 */
    public Integer getYishengYuyueTypes() {
        return yishengYuyueTypes;
    }


    /**
	 * 获取：挂号状态
	 */

    public void setYishengYuyueTypes(Integer yishengYuyueTypes) {
        this.yishengYuyueTypes = yishengYuyueTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
