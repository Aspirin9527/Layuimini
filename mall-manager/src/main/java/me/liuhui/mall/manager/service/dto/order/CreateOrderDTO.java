package me.liuhui.mall.manager.service.dto.order;

import lombok.Data;

import java.util.Date;

@Data
public class CreateOrderDTO {


	private Long productId;

	private Integer status;

	private Double totalAmount;

	private Double payAmount;

	//private Double refundAmount;

	private Integer totalQuantity;

	private Integer consumerUserId;

	private String consigneeTel;

	private String consigneeCellphone;

	private String consigneeName;

	private String consigneeAddress;

	private Date createTime;

	/*private Date payTime;

	private Integer logisticid;

	private String logisticNo;*/


}
