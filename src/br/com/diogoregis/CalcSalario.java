package br.com.diogoregis;

import java.util.Scanner;

public class CalcSalario {
    static int contador = 1;
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        double salario01, salario02, salario03, salario04, salario05;


        System.out.println("!!! Digite o salario bruto para cada funcionario !!!");
        System.out.println("Funcionario 1:");
        salario01 = tc.nextDouble();
        System.out.println("Funcionario 2:");
        salario02 = tc.nextDouble();
        System.out.println("Funcionario 3:");
        salario03 = tc.nextDouble();
        System.out.println("Funcionario 4:");
        salario04 = tc.nextDouble();
        System.out.println("Funcionario 5:");
        salario05 = tc.nextDouble();

        montaImprimeHolerite(salario01);
        montaImprimeHolerite(salario02);
        montaImprimeHolerite(salario03);
        montaImprimeHolerite(salario04);
        montaImprimeHolerite(salario05);

    }

    public static double calculaSalarioLiquido(double salarioBruto){
        return salarioBruto - calculaDesconto(salarioBruto);

    }

    public static double calculaDesconto(double salarioBruto){
        return calculaInss(salarioBruto) + calculaImpostoRenda(salarioBruto);
    }

    public static double calculaInss(double salarioBruto){
        if(salarioBruto <= 1212){
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
            return salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
            return salarioBruto * 0.12;
        } else return salarioBruto * 0.14;
    }

    public static double calculaImpostoRenda(double salarioBruto){
        double salario = salarioBruto - calculaInss(salarioBruto);

        if(salario <= 1903.98){
            return 0;
        } else if (salario <= 2826.65) {
            return salario * 0.075;
        } else if (salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario <= 4664.68) {
            return salario * 0.2250;
        } else return salario * 0.2750;
    }

    public static void montaImprimeHolerite(double salarioBruto){
        System.out.println();
        double totalDesconto = calculaDesconto(salarioBruto);
        double salarioLiquido = calculaSalarioLiquido(salarioBruto);
        double inss = calculaInss(salarioBruto);
        double impostoRenda = calculaImpostoRenda(salarioBruto);
        System.out.println("Funcionario 0" + contador);
        System.out.printf("Salario bruto:      R$ %.2f \n",salarioBruto);
        System.out.printf("Valor de INSS:      R$ %.2f \n", inss);
        System.out.printf("Imposto de renda:   R$ %.2f \n", impostoRenda);
        System.out.printf("Salario liquido:    R$ %.2f \n", salarioLiquido);
        System.out.printf("Total de descontos: R$ %.2f \n", totalDesconto);
        contador++;
    }

}
