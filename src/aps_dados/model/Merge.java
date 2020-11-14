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
public class Merge {
    private static Comparable[] auxiliary;
    public static void sort(List<Comparable> a) {
        auxiliary = new Comparable[a.size()];
        sort(a, 0, (a.size() - 1));
    }
    public static void sort(List<Comparable> a, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, (mid + 1), high);
        merge(a, low, mid, high);
    }
    public static void merge(List<Comparable> a, int low, int mid, int high) {
        int i = low, j = (mid + 1);
        for(int k = low; k <= high; k++) {
            auxiliary[k] = a.get(k);
        }
        for(int k = low; k <= high; k++) {
            if(i > mid) {
                a.set(k, auxiliary[j++]);
            }
            else if(j > high) {
                a.set(k, auxiliary[i++]);
            }
            else if(Util.menor(auxiliary[j], auxiliary[i])) {
                a.set(k, auxiliary[j++]);
            }
            else {
                a.set(k, auxiliary[i++]);
            }
        }
    }
}