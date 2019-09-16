package five.authentication.microservice.controller;

import five.authentication.microservice.model.IndexResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RibbonClient(name = "hello-service", configuration = HelloServiceConfiguration.class)
public class IndexController {
    public static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ControllerProperties controllerProperties;

    @GetMapping("auth")
    public IndexResult getdiscovery() {
        IndexResult indexResult = new IndexResult();
        indexResult.setName(controllerProperties.getName());
        indexResult.setValue("indexvalue");
        return indexResult;

    }

}
