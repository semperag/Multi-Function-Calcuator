package calculator;

/**
 * This enum represents all of the different type of operations that can be performed by unitED.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public enum Operation
{
  ADD("+"), SUBTRACT("-"), MULTIPLY("\u00d7"), DIVIDE("\u00f7");

  private String opString;

  Operation(String operation)
  {
    this.opString = operation;
  }

  /**
   * Return the Operator enum that corresponds to the string representation of the operator.
   * 
   * @param operator
   *          Should be one of "+", "-", "*", "/", or unicode
   * @return The corresponding Operator Enum
   * @throws IllegalArgumentException
   *           if the string does not represent a valid operator
   */
  public static Operation parseOperation(String operator)
  {
    if (operator == null)
    {
      throw new IllegalArgumentException("Cannot parse null");
    }

    for (Operation op : Operation.values())
    {
      if (op.opString.equals(operator))
      {
        return op;
      }
    }

    if (operator.equals("*"))
    {
      return Operation.MULTIPLY;
    }
    else if (operator.equals("/"))
    {
      return Operation.DIVIDE;
    }

    throw new IllegalArgumentException("Unrecognized operator");
  }

  /**
   * Returns true if the passed string can be parsed as an operator.
   * 
   * @param operator
   *          String to parse operator from
   * @return true if the passed string can be parsed as an operator
   */
  public static boolean isOperation(String operator)
  {
    for (Operation op : Operation.values())
    {
      if (op.opString.equals(operator))
      {
        return true;
      }
    }

    return operator.equals("*") || operator.equals("/");
  }

  /**
   * Return the string representation of this operator.
   * 
   * @return opString
   */
  public String opString()
  {
    return opString;
  }
}
