package com.example.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Calculator {
    public static String count(String exp) {

        List<Double> listNumbers = new ArrayList<>();
        List<Character> listZnak = new ArrayList<>();

        try{
            if(exp.charAt(0)=='-'){
                listNumbers.add(0.0);
                listZnak.add('-');
                exp=exp.substring(1);
            }

            exp=Calculator.replace(exp);

            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }

            for (char c : exp.toCharArray()) {
                if (c == '*' || c == '/' || c == '+') {
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
                    if(listNumbers.get(i+1)==0){
                        return "NIE DZIEL PRZEZ 0!";
                    }
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

        }catch (IllegalArgumentException err){
            return "BŁĄD";
        }
        return listNumbers.get(0).toString();
    }

    public static boolean validate(String exp){
        if(exp.charAt(0)=='+'||exp.charAt(0)=='*'||exp.charAt(0)=='/'){
            return false;
        }
        return true;
    }

    public static String negation(String exp){
        StringBuilder str = new StringBuilder(exp);
        List<Character> listZnak = new ArrayList<>();

        for (char c : exp.toCharArray()) {
            if (c == '*' || c == '/' || c == '+' || c=='-') {
                listZnak.add(c);
            }
        }
        for (int i=exp.length()-1;i>=0;i--) {
            if(exp.charAt(i)=='-'&&i==0){
                str.setCharAt(0,'p');
                exp = str.toString().replace("p","");
                break;
            }else if(exp.charAt(i)=='-'&&i!=0){
                    if(exp.charAt(i-1)!='*'&&exp.charAt(i-1)!='/'){
                        str.setCharAt(i,'p');
                        exp = str.toString().replace("p","+");
                        break;
                    }else if(exp.charAt(0)=='-'){
                        str.setCharAt(i,'p');
                        exp = str.toString().replace("p","");
                        break;
                    }else{
                        str.setCharAt(i,'p');
                        exp = str.toString().replace("p","");
                        break;
                    }
            }else if(exp.charAt(i)=='+'){
                str.setCharAt(i,'m');
                exp = str.toString().replace("m","-");
                break;
            }else if(listZnak.size()==0){
                exp = "-"+str.toString();
                break;
            }else if(exp.charAt(i)=='*') {
                str = str.insert(i+1,'-');
                exp = str.toString().replace("m", "-");
                break;
            }else if(exp.charAt(i)=='/') {
                str = str.insert(i+1,'-');
                exp = str.toString().replace("m", "-");
                break;
            }


        }
        if(exp.charAt(0)=='+'||exp.charAt(0)=='*'||exp.charAt(0)=='/'){
            exp=exp.substring(1);
        }

        return exp;
    }

    public static String percent(String exp){
        try{
            List<Double> listNumbers = new ArrayList<>();

            exp=Calculator.replace(exp);
            if(exp.charAt(0)=='+'){
                StringBuilder str = new StringBuilder(exp);
                exp=str.replace(0,1,"").toString();
                return String.valueOf(Double.parseDouble(exp)/100);
            }
            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }
            if(listNumbers.size()==1) {
                return String.valueOf(listNumbers.get(0) / 100);
            }else{
                exp=exp.replaceAll("\\+-","-");
                return exp;
            }
        }catch(Exception w){
            return "BŁĄD";
        }

    }

    private static String replace(String exp){
        exp  =  exp.replace("-","+-")
                .replace("*+-","*-")
                .replace("/+-","/-");

        return exp;
    }

    public static String log(String exp){
        try{
            List<Double> listNumbers = new ArrayList<>();

            exp=Calculator.replace(exp);
            if(exp.charAt(0)=='+'){
                StringBuilder str = new StringBuilder(exp);
                exp=str.replace(0,1,"").toString();
                return String.valueOf(Math.log(Double.parseDouble(exp)));
            }
            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }
            if(listNumbers.size()==1) {
                return String.valueOf(Math.log(listNumbers.get(0)));
            }else{
                exp=exp.replaceAll("\\+-","-");
                return exp;
            }
        }catch(Exception w){
            return "BŁĄD";
        }
    }

    public static String silnia(String exp){
        try{
            List<Double> listNumbers = new ArrayList<>();

            exp=Calculator.replace(exp);
            if(exp.charAt(0)=='+'){
                StringBuilder str = new StringBuilder(exp);
                exp=str.replace(0,1,"").toString();
                double l=Double.parseDouble(exp);
                if(l==0)
                    return String.valueOf(1);
                double ll=1;
                for(int i=1;i<=l;i++){
                    ll*=i;
                }
                if ((l == Math.floor(l)) && !Double.isInfinite(l)) {
                    return String.valueOf((int)ll);
                }
                return String.valueOf(ll);
            }
            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }
            if(listNumbers.size()==1) {
                double l=Double.parseDouble(exp);
                if(l==0)
                    return String.valueOf(1);
                double ll=1;
                for(int i=1;i<=l;i++){
                    ll*=i;
                }
                if ((l == Math.floor(l)) && !Double.isInfinite(l)) {
                    return String.valueOf((int)ll);
                }
                return String.valueOf(ll);
            }else{
                exp=exp.replaceAll("\\+-","-");
                return exp;
            }
        }catch(Exception w){
            return "BŁĄD";
        }
    }

    public static String sqrt(String exp){
        try{
            List<Double> listNumbers = new ArrayList<>();

            exp=Calculator.replace(exp);
            if(exp.charAt(0)=='+'){
                StringBuilder str = new StringBuilder(exp);
                exp=str.replace(0,1,"").toString();
                double num=Math.sqrt(Double.parseDouble(exp));
                if ((num == Math.floor(num)) && !Double.isInfinite(num)) {
                    return String.valueOf((int)num);
                }
                return String.valueOf(num);
            }
            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }
            if(listNumbers.size()==1) {
                double num=Math.sqrt(Double.parseDouble(exp));
                if ((num == Math.floor(num)) && !Double.isInfinite(num)) {
                    return String.valueOf((int)num);
                }
                return String.valueOf(num);
            }else{
                exp=exp.replaceAll("\\+-","-");
                return exp;
            }
        }catch(Exception w){
            return "BŁĄD";
        }
    }

    public static String x3(String exp){
        try{
            List<Double> listNumbers = new ArrayList<>();

            exp=Calculator.replace(exp);
            if(exp.charAt(0)=='+'){
                StringBuilder str = new StringBuilder(exp);
                exp=str.replace(0,1,"").toString();
                double num=Double.parseDouble(exp);
                double ll=1;
                for(int i=1;i<=3;i++){
                    ll*=num;
                }
                if ((num == Math.floor(num)) && !Double.isInfinite(num)) {
                    return String.valueOf((int)ll);
                }
                return String.valueOf(ll);
            }
            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }
            if(listNumbers.size()==1) {
                double num=Double.parseDouble(exp);
                double ll=1;
                for(int i=1;i<=3;i++){
                    ll*=num;
                }
                if ((num == Math.floor(num)) && !Double.isInfinite(num)) {
                    return String.valueOf((int)ll);
                }
                return String.valueOf(ll);
            }else{
                exp=exp.replaceAll("\\+-","-");
                return exp;
            }
        }catch(Exception w){
            return "BŁĄD";
        }
    }

    public static String x2(String exp){
        try{
            List<Double> listNumbers = new ArrayList<>();

            exp=Calculator.replace(exp);
            if(exp.charAt(0)=='+'){
                StringBuilder str = new StringBuilder(exp);
                exp=str.replace(0,1,"").toString();
                double num=Double.parseDouble(exp);
                double ll=1;
                for(int i=1;i<=2;i++){
                    ll*=num;
                }
                if ((num == Math.floor(num)) && !Double.isInfinite(num)) {
                    return String.valueOf((int)ll);
                }
                return String.valueOf(ll);
            }
            for(String s:exp.split("[+*/]")){
                listNumbers.add(Double.parseDouble(s));
            }
            if(listNumbers.size()==1) {
                double num=Double.parseDouble(exp);
                double ll=1;
                for(int i=1;i<=2;i++){
                    ll*=num;
                }
                if ((num == Math.floor(num)) && !Double.isInfinite(num)) {
                    return String.valueOf((int)ll);
                }
                return String.valueOf(ll);
            }else{
                exp=exp.replaceAll("\\+-","-");
                return exp;
            }
        }catch(Exception w){
            return "BŁĄD";
        }
    }

}