package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.Operation;
import calculator.Operator;

class OperatorTest
{

  Operator op;
  
  @Test
  void testOperator()
  {
    op = new Operator(Operation.parseOperation("+"));
  }
  
  @Test
  void testGetOperation() {
    op = new Operator(Operation.parseOperation("-"));
    assertEquals(Operation.parseOperation("-"), op.getOperation());
  }

}
