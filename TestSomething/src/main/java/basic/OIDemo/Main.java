package basic.OIDemo;

import java.util.Scanner;

public class Main{

    public static void qsort(int[] a, int l, int r){
        int now = a[l];
        int i = l, j = r;
        while (i < j){
            while ((a[j] >  now) && (i < j))
                j--;
            while ((a[i] < now) && (i < j))
                i++;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; //因为上面是只有a[i/j]<>now的时候才动指针，相等不动，所以如果a[i/j]都等于now指针不动，此处防止死循环，要对i，j进行操作
            j--;
        }
        if (l < j)
            qsort(a,l,j);
        if (i < r)
            qsort(a,i,r);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] a = {3,4,2,7,1,6,8};
        qsort(a,0,a.length-1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}