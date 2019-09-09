package five.springapp.controller;

import five.service.api.FiveResult;
import five.service.api.FiveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@RestController
public class IndexController {

    @GetMapping("service")
    public List<FiveResult> getServiceInfo() {
        ServiceLoader<FiveService> load = ServiceLoader.load(FiveService.class);
        return load.stream()
                    .map(capitalizerDryProvider -> capitalizerDryProvider.get())
                    .filter(Objects::nonNull)
                    .map(service -> service.five("rumba"))
                    .collect(Collectors.toList());

    }


}