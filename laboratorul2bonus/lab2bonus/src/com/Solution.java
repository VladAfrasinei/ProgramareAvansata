package com;

public class Solution {
    int n;//Va reprezenta marimea matricei  gen a[n][n]
    public Solution(int n)
    {
        this.n=n;
    }
    void BellmanFord(int graf[][],int x)//Primul parametru este graful iar al doilea punctul de plecare
    {
        int c[]=new int[n];
        int viz[]=new int[n];
        int t[]=new int[n];
        int mini=999999,poz=0;
        for(int i=0;i<n;i++)
        {
            c[i]=999999;//Setam punctul de ajungere la fiecare ca fiind o valoare maxima.
            viz[i]=0;//Niciun punct n a fost vizitat inca
        }
        c[x]=0;//Costul sa ajungem de unde plecam este 0
        for(int j=0;j<n-1;j++)
        {
            mini=999999;
            for(int i=0;i<n;i++)
                if(viz[i]==0&&c[i]<mini)
                {
                    mini=c[i];
                    poz=i;
                }
            viz[poz]=1;//Pentru punctul de cost minim, il setam ca vizitat
                for(int i=0;i<n;i++)
                    if(viz[i]==0&&graf[poz][i]>=0&&c[poz]!=999999&&c[poz]+graf[poz][i]<c[i])//verificam daca costul sa ajunge din x in poz si din poz in i este mai mic decat sa ajungem din x in i si daca da il schimbam
                    {
                        c[i]=c[poz]+graf[poz][i];
                        t[i]=poz;
                    }

        }
        System.out.println("Pentru:"+x+"costurile sunt:");
        for(int i=0;i<n;i++)
            System.out.print(c[i]+" ");
    }

}
