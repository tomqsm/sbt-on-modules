import five.service.FiveImpl;
import five.service.api.FiveService;

open module five.service {
//    opens five.service.api to spring.core;
    exports five.service.api;
    provides FiveService with FiveImpl;
}