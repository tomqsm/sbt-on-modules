package five.springapp;

import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

@BootstrapConfiguration
public class DefaultCuratorFrameworkConfig implements PropertySourceLocator {
    @Override
    public PropertySource<?> locate(Environment environment) {
        return null;
    }
}
