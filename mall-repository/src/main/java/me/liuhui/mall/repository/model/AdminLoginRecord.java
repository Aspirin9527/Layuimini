package me.liuhui.mall.repository.model;



import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

import java.util.Date;





/**
 * 
 */

@Data
public class AdminLoginRecord  {




    /**
     * id       db_column: id
     */

    @Pk
	private Long id;

    /**
     * 管理员id       db_column: admin_id
     */

private Long adminId;

    /**
     * 用户名       db_column: admin_user_name
     */

private String adminUserName;

    /**
     * ip       db_column: ip
     */

private String ip;

    /**
     * 登录时间       db_column: create_time
     */

private Date createTime;

    /**
     * 操作系统       db_column: os
     */

private String os;

    /**
     * 设备       db_column: device
     */

private String device;

    /**
     * 浏览器       db_column: browser
     */

private String browser;







}






