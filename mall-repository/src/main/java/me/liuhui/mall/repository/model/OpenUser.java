package me.liuhui.mall.repository.model;


import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

import java.util.Date;

/**
 * 
 */

@Data
public class OpenUser  {




    /**
     * id       db_column: id
     */

    @Pk
	private Long id;

    /**
     * openid       db_column: openid
     */

private String openid;

    /**
     * nickname       db_column: nickname
     */

private String nickname;

    /**
     * createTime       db_column: create_time
     */

private Date createTime;

    /**
     * userInfo       db_column: user_info
     */

private String userInfo;

    /**
     * userId       db_column: user_id
     */

private Integer userId;

    /**
     * type       db_column: type
     */

private Integer type;

    /**
     * accessToken       db_column: access_token
     */

private String accessToken;







}






