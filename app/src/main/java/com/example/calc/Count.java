package com.example.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Count {
    public static String test(String exp) {
        List<Double> listNumbers = new ArrayList<>();
        List<Character> listZnak = new ArrayList<>();

        for(String s:exp.replace(',', '.').split("[-+*/]")){
            listNumbers.add(Double.parseDouble(s));
        }

        for (char c : exp.toCharArray()) {
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                listZnak.add(c);
            }
        }
        int i=0;

        for(char c:listZnak){
            if(c == '*'){
                listNumbers.set(i,listNumbers.get(i)*listNumbers.get(i+1));
                listNumbers.remove(i+1);
                i--;
            }else if(c == '/'){
                listNumbers.set(i,listNumbers.get(i)/listNumbers.get(i+1));
                listNumbers.remove(i+1);
                i--;
            }
            i++;
        }

        listZnak.removeAll(new ArrayList<>(Arrays.asList('*','/')));
        int a=0;
        for(char c:listZnak){
            if(c == '+'){
                listNumbers.set(a,listNumbers.get(a)+listNumbers.get(a+1));
                listNumbers.remove(a+1);
                a--;
            }else if(c == '-'){
                listNumbers.set(a,listNumbers.get(a)-listNumbers.get(a+1));
                listNumbers.remove(a+1);
                a--;
            }
            a++;
        }

        if ((listNumbers.get(0) == Math.floor(listNumbers.get(0))) && !Double.isInfinite(listNumbers.get(0))) {
            return String.valueOf(listNumbers.get(0).intValue());
        }

        return listNumbers.get(0).toString();
    }
}



