package five.service;

import five.service.api.FiveResult;
import five.service.api.FiveService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FiveImpl implements FiveService {
    @Override
    public FiveResult five(String s) {
        log.info("processing ...");
        FiveResult fiveResult = new FiveResult();
        fiveResult.setBefore(s);
        fiveResult.setAfter(s + " 5");
        return fiveResult;
    }
}
