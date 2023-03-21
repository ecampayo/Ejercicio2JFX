package com.example.ejercicio2jfx;
public class Operaciones {
    private int a;
    private int b;
    public Operaciones(int a, int b){
        this.a=a;
        this.b=b;
    }
    public int getA(){
        return a; }
    public int getB(){
        return b; }
    public void setA(int a){
        this.a=a;
    }
    public void setB(int b){
        this.b=b;
    }
    public int suma(){
        return a+b;
    }
    public int resta(){
        return a-b;
    }
    public int multiplicacion(){
        return a*b;
    }
    public int division(){
        return a/b;
    }
}
