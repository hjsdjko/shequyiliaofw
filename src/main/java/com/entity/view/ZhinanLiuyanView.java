package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhinanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 指南留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhinan_liuyan")
public class ZhinanLiuyanView extends ZhinanLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;
	//级联表 防范指南
		/**
		* 指南编号
		*/

		@ColumnInfo(comment="指南编号",type="varchar(200)")
		private String zhinanUuidNumber;
		/**
		* 指南标题
		*/

		@ColumnInfo(comment="指南标题",type="varchar(200)")
		private String zhinanName;
		/**
		* 指南图片
		*/

		@ColumnInfo(comment="指南图片",type="varchar(200)")
		private String zhinanPhoto;
		/**
		* 指南视频
		*/

		@ColumnInfo(comment="指南视频",type="varchar(200)")
		private String zhinanVideo;
		/**
		* 指南类型
		*/
		@ColumnInfo(comment="指南类型",type="int(11)")
		private Integer zhinanTypes;
			/**
			* 指南类型的值
			*/
			@ColumnInfo(comment="指南类型的字典表值",type="varchar(200)")
			private String zhinanValue;
		/**
		* 指南热度
		*/

		@ColumnInfo(comment="指南热度",type="int(11)")
		private Integer zhinanClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 指南介绍
		*/

		@ColumnInfo(comment="指南介绍",type="longtext")
		private String zhinanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zhinanDelete;



	public ZhinanLiuyanView() {

	}

	public ZhinanLiuyanView(ZhinanLiuyanEntity zhinanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhinanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}
	//级联表的get和set 防范指南

		/**
		* 获取： 指南编号
		*/
		public String getZhinanUuidNumber() {
			return zhinanUuidNumber;
		}
		/**
		* 设置： 指南编号
		*/
		public void setZhinanUuidNumber(String zhinanUuidNumber) {
			this.zhinanUuidNumber = zhinanUuidNumber;
		}

		/**
		* 获取： 指南标题
		*/
		public String getZhinanName() {
			return zhinanName;
		}
		/**
		* 设置： 指南标题
		*/
		public void setZhinanName(String zhinanName) {
			this.zhinanName = zhinanName;
		}

		/**
		* 获取： 指南图片
		*/
		public String getZhinanPhoto() {
			return zhinanPhoto;
		}
		/**
		* 设置： 指南图片
		*/
		public void setZhinanPhoto(String zhinanPhoto) {
			this.zhinanPhoto = zhinanPhoto;
		}

		/**
		* 获取： 指南视频
		*/
		public String getZhinanVideo() {
			return zhinanVideo;
		}
		/**
		* 设置： 指南视频
		*/
		public void setZhinanVideo(String zhinanVideo) {
			this.zhinanVideo = zhinanVideo;
		}
		/**
		* 获取： 指南类型
		*/
		public Integer getZhinanTypes() {
			return zhinanTypes;
		}
		/**
		* 设置： 指南类型
		*/
		public void setZhinanTypes(Integer zhinanTypes) {
			this.zhinanTypes = zhinanTypes;
		}


			/**
			* 获取： 指南类型的值
			*/
			public String getZhinanValue() {
				return zhinanValue;
			}
			/**
			* 设置： 指南类型的值
			*/
			public void setZhinanValue(String zhinanValue) {
				this.zhinanValue = zhinanValue;
			}

		/**
		* 获取： 指南热度
		*/
		public Integer getZhinanClicknum() {
			return zhinanClicknum;
		}
		/**
		* 设置： 指南热度
		*/
		public void setZhinanClicknum(Integer zhinanClicknum) {
			this.zhinanClicknum = zhinanClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 指南介绍
		*/
		public String getZhinanContent() {
			return zhinanContent;
		}
		/**
		* 设置： 指南介绍
		*/
		public void setZhinanContent(String zhinanContent) {
			this.zhinanContent = zhinanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZhinanDelete() {
			return zhinanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZhinanDelete(Integer zhinanDelete) {
			this.zhinanDelete = zhinanDelete;
		}


	@Override
	public String toString() {
		return "ZhinanLiuyanView{" +
			", zhinanUuidNumber=" + zhinanUuidNumber +
			", zhinanName=" + zhinanName +
			", zhinanPhoto=" + zhinanPhoto +
			", zhinanVideo=" + zhinanVideo +
			", zhinanClicknum=" + zhinanClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", zhinanContent=" + zhinanContent +
			", zhinanDelete=" + zhinanDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
