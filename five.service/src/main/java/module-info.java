import five.service.FiveImpl;
import five.service.api.FiveService;

open module five.service {
//    opens five.service.api to spring.core;
    requires lombok;
    requires slf4j.api;
    exports five.service.api;
    provides FiveService with FiveImpl;
}