package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import calculator.Operation;

class OperationTest
{

  Operation op;

  @Test
  void testAddtion()
  {
    op = Operation.parseOperation("+");
    assertEquals("+", op.opString());
  }

  @Test
  void testSubtraction()
  {
    op = Operation.parseOperation("-");
    assertEquals("-", op.opString());
  }

  @Test
  void testMultiply()
  {
    op = Operation.parseOperation("\u00d7");
    assertEquals("\u00d7", op.opString());
  }

  @Test
  void testDivision()
  {
    op = Operation.parseOperation("\u00f7");
    assertEquals("\u00f7", op.opString());
  }

  @Test
  void testNotAddition()
  {
    op = Operation.parseOperation("+");
    assertNotSame("-", op.opString());
  }

  @Test
  void testNotSubtraction()
  {
    op = Operation.parseOperation("-");
    assertNotSame("+", op.opString());
  }

  @Test
  void testNotMultiplication()
  {
    op = Operation.parseOperation("\u00d7");
    assertNotSame("\u00f7", op.opString());
  }

  @Test
  void testNotDivision()
  {
    op = Operation.parseOperation("\u00f7");
    assertNotSame("\u00d7\"", op.opString());
  }

  @Test
  void testNull()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      Operation.parseOperation(null);
    });
  }

  @Test
  void testUnrecognizedOperation()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      Operation.parseOperation("I should fail");
    });
  }
}
