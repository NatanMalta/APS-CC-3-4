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
public class Quick {
    public static void sort(List<Comparable> a) {
        sort(a, 0, a.size() - 1);
    }
    public static void sort(List<Comparable> a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }
    public static int partition(List<Comparable> a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a.get(low);
        while(true) {
            while(Util.menor(a.get(++i), v)) {
                if (i == high) break;
            }
            while(Util.maior(a.get(--j), v)) {
                if (j == low) break;
            }
            if(i >= j) break;
            Util.trocar(a, i, j);
        }
        Util.trocar(a, low, j);
        return j;
    }
}