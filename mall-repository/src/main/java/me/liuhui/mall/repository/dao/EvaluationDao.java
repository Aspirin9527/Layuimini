package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Evaluation;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_evaluation")
public interface EvaluationDao extends BaseDao<Evaluation,Long> {
	
}
