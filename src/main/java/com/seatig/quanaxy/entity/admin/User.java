package com.seatig.quanaxy.entity.admin;

import com.seatig.quanaxy.entity.base.BaseEntity;

import lombok.Data;

/**
 * 用户信息
 * @Description 
 * @author xianw
 * @time 2019年2月20日下午1:35:33
 * @version v1.0
 */
@Data
public class User extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3421534893461423050L;
	
	private String userName; // 用户姓名
    private String password; // 密码
    private String qxPassword;
}
