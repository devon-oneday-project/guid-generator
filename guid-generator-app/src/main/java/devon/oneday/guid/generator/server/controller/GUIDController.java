package devon.oneday.guid.generator.server.controller;

import devon.oneday.guid.generator.server.service.GUIDService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class GUIDController {

    private final GUIDService guidService;

    public GUIDController(GUIDService guidService) {
        this.guidService = guidService;
    }

    @GetMapping("/generate")
    Flux<String> hello(@RequestParam(value = "apiId") String apiId) {
        return Flux.just(guidService.getGUID(apiId));
    }

}
