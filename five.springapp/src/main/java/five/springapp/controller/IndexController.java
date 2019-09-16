package five.springapp.controller;

import five.service.api.FiveResult;
import five.service.api.FiveService;
import five.service.spring.api.FiveServiceSpring;
import five.service.spring.api.FiveServiceSpringData;
import five.springapp.properties.LadProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@RestController
public class IndexController {
    public static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private FiveServiceSpring repository;

    @Autowired
    private Environment environment;

    @Autowired
    private LadProperties cloudProperties;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Autowired
//    private ZookeeperServiceRegistry serviceRegistry;
    //@Autowired
    //private CuratorFramework curatorFramework;

    @GetMapping("service")
    public List<FiveResult> getServiceInfo() {
        ServiceLoader<FiveService> load = ServiceLoader.load(FiveService.class);
        return load.stream()
                .map(capitalizerDryProvider -> capitalizerDryProvider.get())
                .filter(Objects::nonNull)
                .map(service -> service.five("rumba"))
                .collect(Collectors.toList());

    }

    @GetMapping("service.spring")
    public List<FiveServiceSpringData> getServiceSpringInfo() {
        ServiceLoader<FiveServiceSpring> load = ServiceLoader.load(FiveServiceSpring.class);
        return load.stream()
                .map(capitalizerDryProvider -> capitalizerDryProvider.get())
                .filter(Objects::nonNull)
                .map(service -> service.findById(3))
                .collect(Collectors.toList());

    }

    @GetMapping("service.spring.injection")
    public List<FiveServiceSpringData> getServiceSpringInfoInjection() {
        LOG.info("Data from database {}", environment.getProperty("springapp.spring.profiles"));
        LOG.debug("Data from database {}", environment.getProperty("shared"));
        LOG.info("cloud properties {}", cloudProperties.getSurname());
        return repository.findAll();

    }

    @GetMapping("discovery")
    public String getdiscovery() {
        return serviceUrl();

    }

    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("discovery");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

//    public void registerThings() {
//        ServiceInstanceRegistration registration = ServiceInstanceRegistration.builder()
//                .defaultUriSpec()
//                .address("anyUrl")
//                .port(10)
//                .name("/a/b/c/d/anotherservice")
//                .build();
//        this.serviceRegistry.register(registration);
//    }

}