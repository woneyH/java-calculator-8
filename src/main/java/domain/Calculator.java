package domain;

import java.util.List;
import java.util.Objects;

public class Calculator {

    public int plus(List<String> list){
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            String getValue = list.get(i);
            if(Objects.equals(getValue, "")){
                sum+=0;

                continue;
            }
            sum+= Integer.parseInt(getValue);
        }
        return sum;
    }
}
