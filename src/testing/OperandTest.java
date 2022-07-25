package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.Operand;

class OperandTest
{

  public static Operand Zero;
  public static Operand One;
  public static Operand Two;

  @BeforeEach
  void initialize()
  {
    Zero = new Operand(0, "Widgets");
    One = new Operand(1, "Widgets");
    Two = new Operand(2, "Widgets");
  }

  @Test
  void Operand()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      new Operand(1, null);
    });
  }

  @Test
  void testAdd()
  {
    assertEquals(0, Zero.add(Zero).getValue());
    assertEquals(1, One.add(Zero).getValue());
    assertEquals(2, One.add(One).getValue());
    assertEquals(3, One.add(Two).getValue());
    assertEquals(4, Two.add(Two).getValue());
  }

  @Test
  void testSubtract()
  {
    assertEquals(0, Zero.subtract(Zero).getValue());
    assertEquals(0, One.subtract(One).getValue());
    assertEquals(1, Two.subtract(One).getValue());
    assertEquals(-1, One.subtract(Two).getValue());
    assertEquals(0, Two.subtract(Two).getValue());
  }

  @Test
  void testMultiply()
  {
    assertEquals(0, Zero.multiply(Zero).getValue());
    assertEquals(0, One.multiply(Zero).getValue());
    assertEquals(1, One.multiply(One).getValue());
    assertEquals(2, One.multiply(Two).getValue());
    assertEquals(4, Two.multiply(Two).getValue());
  }

  @Test
  void testDivide()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      assertEquals(0, Zero.divide(Zero).getValue());
    });

    assertThrows(IllegalArgumentException.class, () -> {
      assertEquals(0, One.divide(Zero).getValue());
    });

    assertEquals(0, Zero.divide(One).getValue());
    assertEquals(1, One.divide(One).getValue());
    assertEquals(0.5d, One.divide(Two).getValue());
    assertEquals(1, Two.divide(Two).getValue());
  }

  @Test
  void testGetUnits()
  {
    assertEquals("Widgets", Zero.getUnits());
    assertEquals("Widgets", One.getUnits());
    assertEquals("Widgets", Two.getUnits());
  }

  @Test
  void testGetValue()
  {
    assertEquals(0, Zero.getValue());
    assertEquals(1, One.getValue());
    assertEquals(2, Two.getValue());
  }

  @Test
  void getExpression()
  {
    assertEquals("0.0 Widgets", Zero.getExpression());
    assertEquals("1.0 Widgets", One.getExpression());
    assertEquals("2.0 Widgets", Two.getExpression());
  }

  @Test
  void testNull()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      Zero.add(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Zero.subtract(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Zero.multiply(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Zero.divide(null);
    });
  }
/**
  @Test
  void testHybridUnit()
  {
    assertDoesNotThrow(() -> {
      new Operand(7.0, "ft-lbs");
    });
    assertDoesNotThrow(() -> {
      new Operand(7.0, "ft/lbs");
    });
  }*/

  @ParameterizedTest
  @ValueSource(strings = {"7+s", "!", "lbs+lbs", "", "lbs*lbs", "+"})
  void testInvalidUnits(String units)
  {
    assertThrows(IllegalArgumentException.class, () -> {
      new Operand(1.0, units);
    });
  }

}
