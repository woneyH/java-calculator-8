package service;

import domain.Delimiter;

import java.util.List;

public class ParserService {
    private final Delimiter delimiter;

    public ParserService() {
        this.delimiter = new Delimiter();
    }

    //입력된 값과 구분자 검사 로직 리스트로 값들 나누어서 전달 (여기서 구분자와 새로 추가한 구분자는 ,로 치환해서 보냄)
    public List<String> parseNumber(String input) {
        checkCustomDelimiter(input);
        for (String str : delimiter.getPatternSet()) {
            input = input.replace(str, "+");
        }
        input = input.replaceAll("//", "");
        input = input.replace("+\\n", "");
        return List.of(input.split("\\+"));
    }

    //48~57
    public void checkCustomDelimiter(String input) {
        int customFirstCheck = 0;
        int customLastCheck = 0;
        StringBuilder customDelimiter = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if ((48 <= c && c <= 57) || delimiter.getPatternSet().contains(c+"")){
                continue;
            }

            if (c == '/' && customFirstCheck < 2) {
                customFirstCheck++;
                continue;
            } else if (customFirstCheck == 2) {
                customDelimiter.append(c);
                customFirstCheck++;
            } else if (c == '\\' && customLastCheck == 0) {
                customLastCheck++;
            } else if (c == 'n' && customLastCheck == 1) {
                delimiter.addPattern(customDelimiter.toString());
            } else {
                throw new IllegalArgumentException("잘못된 값을 입력");
            }
        }
    }
}
