package util;

import java.util.Arrays;
import model.Pagina;

public class MergeSort {

    public void mergeSort(Pagina[] s) {
        if (s.length > 1) {
            Pagina[] l = Arrays.copyOfRange(s, 0, s.length / 2);
            Pagina[] r = Arrays.copyOfRange(s, s.length / 2, s.length);
            mergeSort(l);
            mergeSort(r);
            merge(s, l, r);
        }
    }

    public void merge(Pagina[] s, Pagina[] l, Pagina[] r) {
        int li = 0;
        int ri = 0;
        for (int i = 0; i < s.length; i++) {
            if (li >= l.length) {
                s[i] = r[ri++];
            } else if (ri >= r.length) {
                s[i] = l[li++];

            } else {
                s[i] = l[li].compareTo(r[ri]) > 0 ? r[ri++] : l[li++];
            }
        }

    }

//    public void mergeSort(String[] s) {
//        if (s.length > 1) {
//            String[] l = Arrays.copyOfRange(s, 0, s.length / 2);
//            String[] r = Arrays.copyOfRange(s, s.length / 2, s.length);
//            mergeSort(l);
//            mergeSort(r);
//            merge(s, l, r);
//        }
//    }
//
//    public static void merge(String[] s, String[] l, String[] r) {
//        int ri = 0;
//        int li = 0;
//        for (int i = 0; i < s.length; i++) {
//            if (li >= l.length) {
//                s[i] = r[ri++];
//            } else if (ri >= r.length) {
//                s[i] = l[li];
//
//            } else {
//                s[i] = l[li].compareTo(r[ri]) < 0 ? l[li++] : r[ri++];
//            }
//        }
//    }
}
