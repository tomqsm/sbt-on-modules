package five.service.spring.api;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FiveServiceSpring {
    @Select("select * from monitor where id=#{id}")
    FiveServiceSpringData findById(@Param("id") Integer id);
}
