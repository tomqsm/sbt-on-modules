package five.service.spring.api;

import five.service.spring.db.inmemory.InmemDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringConfig.class)
@ActiveProfiles("inmemory")
public class FiveServiceSpringTest {

    public static final Logger LOG = LoggerFactory.getLogger(FiveServiceSpringTest.class);

    @Autowired
    private InmemDaoImpl repository;

    @Test
    public void fiveTest() {
        FiveServiceSpringData byId = repository.findById(3);
        assertThat(byId.getId()).isEqualTo(3L);
        LOG.info("found: {}", byId);
    }
}