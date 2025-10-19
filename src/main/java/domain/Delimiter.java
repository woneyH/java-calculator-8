package domain;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private Set<String> patternSet = new HashSet<>();

    public Delimiter() {
        patternSet.add(",");
        patternSet.add(":");
    }

    public void addPattern(String pattern) {
        patternSet.add(pattern);
    }

    public Set<String> getPatternSet(){
        return patternSet;
    }
}
