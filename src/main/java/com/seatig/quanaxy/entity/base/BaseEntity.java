package com.seatig.quanaxy.entity.base;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 实体超类
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午2:05:17
 * @version v1.0
 */
@Data
public abstract class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4560331540586236532L;

	private Integer id;//id
	
	private Date createDate;//新增时间
	
	private String createBy;//创建人
	
}
