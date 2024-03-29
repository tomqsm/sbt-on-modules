package five.service.spring;

import five.service.spring.api.FiveServiceSpring;
import five.service.spring.api.FiveServiceSpringData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class FiveServiceSpringImpl implements FiveServiceSpring {

    public static final Logger LOG = LoggerFactory.getLogger(FiveServiceSpringImpl.class);

    @Override
    public FiveServiceSpringData findById(Integer id) {
        FiveServiceSpringData data = new FiveServiceSpringData();
        data.setBefore("five");
        data.setAfter("five " + id);
        return data;
    }

    @Override
    public List<FiveServiceSpringData> findAll() {
        return Collections.emptyList();
    }
}
