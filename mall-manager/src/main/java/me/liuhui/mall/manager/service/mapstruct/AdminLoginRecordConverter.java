
        package me.liuhui.mall.manager.service.mapstruct;


        import me.liuhui.mall.manager.service.vo.admin.AdminLoginRecordVO;
        import me.liuhui.mall.repository.model.AdminLoginRecord;
        import org.mapstruct.Mapper;
        import org.mapstruct.ReportingPolicy;

        import java.util.List;

        /**
 * Created on 2020/10/14 18:51
 * <p>
 * @author [清远]
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminLoginRecordConverter {

    List<AdminLoginRecordVO> toVo(List<AdminLoginRecord> entityList);

}
