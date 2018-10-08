package whowins.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import whowins.model.Fighter;
import whowins.service.FighterService;

import java.util.List;

@RestController
public class FighterREST {

    @GetMapping("/all-fighters")
    public List<Fighter> getFighters(){
        return new FighterService().getAllFighters();
    }

}
