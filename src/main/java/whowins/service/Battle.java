package whowins.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import whowins.model.Fighter;

/**
 * Created by Freddie on 13/07/2018.
 */
@Getter
@Setter
@AllArgsConstructor
public class Battle {

    private Fighter fighter1;
    private Fighter fighter2;

    public Fighter start(){
        return grantHeightAdvantage();
    }

    private Fighter grantHeightAdvantage() {
        int heightDiff = fighter1.getHeight() - fighter2.getHeight();
        return heightDiff > 0 ? fighter2.reduceHealth(heightDiff) : fighter1.reduceHealth(-heightDiff);
    }

}
