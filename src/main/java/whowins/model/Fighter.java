package whowins.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Fighter {

    private static int health = 100;
    private String name;
    private int age;
    private int height;


    public Fighter(){
        this.name = "weakling";
        this.age = 0;
        this.height = 0;
    }
}

