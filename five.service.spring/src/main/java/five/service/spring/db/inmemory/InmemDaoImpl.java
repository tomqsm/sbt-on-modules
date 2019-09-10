package five.service.spring.db.inmemory;

import five.service.spring.api.FiveServiceSpring;
import five.service.spring.api.FiveServiceSpringData;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("inmemory")
public class InmemDaoImpl implements FiveServiceSpring {

    private static final Class<FiveServiceSpring> MAPPER_CLASS = FiveServiceSpring.class;

    @Autowired
    private SqlSession sqlSession;

    private FiveServiceSpring getMapper() {
        return sqlSession.getMapper(MAPPER_CLASS);
    }

    @Override
    public FiveServiceSpringData findById(Integer id) {
        return getMapper().findById(id);
    }

}
