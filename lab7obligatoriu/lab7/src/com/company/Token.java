package com.company;

import java.util.Objects;

public class Token {
    int valoare;
    Token(int valsetata)
    {
        this.valoare=valsetata;
    }

    public int getValoare() {
        return valoare;
    }
    public void setValoare(int valoare1)
    {
        this.valoare=valoare1;
    }

    public boolean egal(Object obiect) {
        if (this == obiect) return true;
        Class a=this.getClass();
        Class b=obiect.getClass();
        if (obiect == null || a != b) return false;
        //Pentru ca parametrul meu este de tip obiect trebuie sa facem conversia la clasa noastra
        Token varObject=(Token)obiect;
        //Verificam daca cele 2 au aceeasi valoare
        return this.getValoare() == varObject.getValoare();
    }

    public int hashCode() {
        return Objects.hash(valoare);
    }

    public String toString() {
        return "valoare=" + valoare;
    }

}
