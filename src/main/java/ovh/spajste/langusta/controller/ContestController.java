package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.repository.ContestRepository;

@RestController
public class ContestController {

    @Autowired
    private ContestRepository contestRepository;

    @GetMapping("/contest/all")
    public GenericStatus getAllContests() {
        /* TODO: probably security! */
        return GenericStatus.createSuccessfulStatus(contestRepository.findAll());
    }


}
