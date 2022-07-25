package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.CalculatorLogic;
import calculator.Operand;

class CalculatorLogicTest
{

  @Test
  void testEvaluateWithAddition()
  {
    CalculatorLogic calc = new CalculatorLogic();
    String testAdd = "1ft + 1ft";

    assertEquals("2.0 ft", calc.evaluate(testAdd).toString());
  }

  @Test
  void testEvaluateWithSubtraction()
  {
    CalculatorLogic calc = new CalculatorLogic();
    String testAdd = "4ft - 2ft";

    assertEquals("2.0 ft", calc.evaluate(testAdd).toString());
  }

  @Test
  void testEvaluateWithMultiplication()
  {
    CalculatorLogic calc = new CalculatorLogic();
    String testAdd = "4ft * 2ft";

    assertEquals("8.0 ft", calc.evaluate(testAdd).toString());
  }

  @Test
  void testEvaluateWithDivision()
  {
    CalculatorLogic calc = new CalculatorLogic();
    String testAdd = "4ft / 2ft";

    assertEquals("2.0 ft", calc.evaluate(testAdd).toString());
  }

  @Test
  void testEvaluateWithBadOperator()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      new CalculatorLogic().evaluate("4ft & 2ft");
    });
  }

  @Test
  void testEvaluateWithThreeOperands()
  {
    assertEquals("7.0 ft", new CalculatorLogic().evaluate("4ft + 2ft + 1ft").toString());
  }

  @Test
  void testEvaluateWithTooManyOperators()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      new CalculatorLogic().evaluate("4ft + ");
    });
  }

}
