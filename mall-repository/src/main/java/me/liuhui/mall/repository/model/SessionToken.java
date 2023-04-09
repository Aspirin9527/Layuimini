package me.liuhui.mall.repository.model;


import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

import java.util.Date;

/**
 * 
 */

@Data
public class SessionToken  {




    /**
     * id       db_column: id
     */

    @Pk
	private Long id;

    /**
     * sessionToken       db_column: session_token
     */

private String sessionToken;

    /**
     * userId       db_column: user_id
     */

    private Long userId;
    private String username;

    /**
     * remoteAddress       db_column: remote_address
     */

private String remoteAddress;

    /**
     * createTime       db_column: create_time
     */

private Date createTime;
private Date loginDate;
private Date updateTime;
private Integer status;







}






