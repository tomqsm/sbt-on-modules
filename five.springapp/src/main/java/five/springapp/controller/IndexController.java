package five.springapp.controller;

import five.service.api.FiveResult;
import five.service.api.FiveService;
import five.service.spring.api.FiveServiceSpring;
import five.service.spring.api.FiveServiceSpringData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@RestController
public class IndexController {

    @Autowired
    private FiveServiceSpring repository;

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
        return repository.findAll();

    }

}