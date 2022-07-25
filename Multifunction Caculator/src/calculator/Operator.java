package calculator;

/**
 * This class represents an Operator that the user can perform on two operands. Currently it is only
 * designated to be used in a stack that will evaluate expressions.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class Operator implements ExpressionElement
{
  public static final int HIGHEST_PRECEDENCE = 2;
  private Operation operation;
  private int precedence;

  /**
   * Explicit value constructor for an Operator.
   * 
   * @param operation
   *          Operation this operator performs
   */
  public Operator(Operation operation)
  {
    this.operation = operation;
    switch (operation)
    {
      case ADD:
      case SUBTRACT:
        precedence = 1;
        break;
      case MULTIPLY:
      case DIVIDE:
        precedence = 2;
        break;
      default:
        precedence = 0;
    }
  }

  /**
   * Creates an Operator object from the passed text.
   * 
   * @param text
   *          Text to parse from
   * @return Operator object with corresponding operation
   */
  public static Operator parseOperator(String text)
  {
    return new Operator(Operation.parseOperation(text.replaceAll("\\s+", "")));
  }

  /**
   * @return the operation
   */
  public Operation getOperation()
  {
    return operation;
  }

  @Override
  public String getExpression()
  {
    return operation.opString();
  }

  @Override
  public String toString()
  {
    return getExpression();
  }

  /**
   * @return the precedence
   */
  public int getPrecedence()
  {
    return precedence;
  }

}
