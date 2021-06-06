/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Harding
 */

package base;

import java.util.Scanner;

public class MultiTaxCalc {
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    MultiTaxCalc newTax = new MultiTaxCalc();
    double total = newTax.initial();
    String state = newTax.state();
    if (state.equalsIgnoreCase("illinois")) {
      total = newTax.addTaxIl(total);
    }
    else if (state.equalsIgnoreCase("wisconsin")) {
      String county = newTax.county();
      total = newTax.addTaxWi(total, county);
    }
    System.out.printf("The total is $%.2f%n", total);
  }

  public double initial() {
    System.out.print("What is the order amount? ");
    return Double.parseDouble(input.nextLine());

  }

  public String state() {
    System.out.print("What is the state you live in? ");
    return input.nextLine();
  }

  public String county() {
    System.out.print("What is the county you live in? ");
    return input.nextLine();
  }

  public double addTaxIl(double subtotal) {
    double tax = subtotal * 8 / 100;
    System.out.printf("The tax is $%.2f.%n", tax);
    return subtotal + tax;
  }

  public double addTaxWi(double subtotal, String county) {
    double taxRate = 5;
    if (county.equalsIgnoreCase("Eau Claire")) {
      taxRate += 0.005;
    }
    else if (county.equalsIgnoreCase("Dunn")) {
      taxRate += 0.004;
    }
    double tax = subtotal * taxRate / 100;
    System.out.printf("The tax is $%.2f.%n", tax);
    return subtotal + tax;
  }
}
