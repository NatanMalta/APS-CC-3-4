/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_dados.model;

import java.util.List;

/**
 *
 * @author brian
 */
public class Util {
    public static Boolean menor(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }
    public static Boolean maior(Comparable a, Comparable b) {
        return (a.compareTo(b) > 0);
    }
    public static Boolean igual(Comparable a, Comparable b) {
        return (a.compareTo(b) == 0);
    }
    public static Boolean trocar(List<Comparable> a, int i, int j) {
        if((i < 0) || (i >= a.size())) return false;
        else if((j < 0) || (j >= a.size())) return false;
        Comparable auxiliary;
        auxiliary = a.get(i);
        a.set(i, a.get(j));
        a.set(j, auxiliary);
        return true;
    }
    public static Boolean emOrdem(List<Comparable> a) {
        if(a.size() <= 1) return true;
        for(int x = 1; x < a.size(); x++) {
            if(!Util.menor(a.get(x - 1), a.get(x))) return false;
        }
        return true;
    }
}