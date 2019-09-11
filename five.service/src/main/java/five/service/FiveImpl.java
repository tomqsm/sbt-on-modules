package five.service;

import five.service.api.FiveResult;
import five.service.api.FiveService;

public class FiveImpl implements FiveService {
    @Override
    public FiveResult five(String s) {
        FiveResult fiveResult = new FiveResult();
        fiveResult.setBefore(s);
        fiveResult.setAfter(s + " 5");
        return fiveResult;
    }
}
