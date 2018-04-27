package pro.khairutdinov.dz.controler;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CounterView implements Serializable {

    private int number;
    private int tmp;

    public String getNumber() {
        String name = "I'm Java developer!";

        if (number > name.length()) {
            if (tmp < 3) {
                number = name.length();
                tmp++;
            } else number = 0;
        }
        return name.substring(0, number);
    }

    public void increment() {
        number += 2;

    }
}

