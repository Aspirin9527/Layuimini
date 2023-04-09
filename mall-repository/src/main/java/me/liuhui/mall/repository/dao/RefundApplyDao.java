package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.RefundApply;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "o_refund_apply")
public interface RefundApplyDao extends BaseDao<RefundApply,Long> {
	
}
