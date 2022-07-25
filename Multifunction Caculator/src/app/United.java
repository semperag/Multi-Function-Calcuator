package app;

import gui.Calculator;

/**
 * While a large number of calculator "apps" exist, we at SagaciousMedia recognize that most of them
 * focus exclusively on unitless numbers. There are very few calculators that allow users to easily
 * work with operands that have units (e.g., ft, m, sec, mi/hr).
 * 
 * There are "apps" that allow users to convert between units (e.g., yards to meters), but very few
 * that allow users to perform operations on operands that have units. unitED is our first attempt
 * to address this need.
 * 
 * It is a calculator that allows users to quickly and easily perform operations on operands that
 * have units (e.g., divide 10mi by 0.5hr to get 20mi/hr).
 * 
 * @author SagaciousMedia's Team 10
 * @version 4/4/2020
 */
public class United
{
  /**
   * The entry point of the program.
   * 
   * @param args
   *          Unused
   */
  public static void main(String[] args)
  {
    Calculator calculator = new Calculator();
    calculator.run();
  }
}
