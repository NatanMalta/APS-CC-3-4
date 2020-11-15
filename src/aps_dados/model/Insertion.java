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
public class Insertion {
    public static void sort(List<Comparable> a) {
        int n = a.size();
        if (n == 1) return;
        for(int i = 1; i <= n; i++) {
            for(int j = (i - 1); (j > 0 && Util.menor(a.get(j), a.get(j - 1))); j--) {
                Util.trocar(a, j, j - 1);
            }
        }
    }
}
