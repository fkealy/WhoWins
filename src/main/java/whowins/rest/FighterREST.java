package whowins.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FighterREST {

    @GetMapping("all-fighters")
    public int getFighters(){
        return 200;
    }

}
