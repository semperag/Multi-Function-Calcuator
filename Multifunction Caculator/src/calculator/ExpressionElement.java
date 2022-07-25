package calculator;

/**
 * This interface represents a single element in the stack used to evaluate expressions given by the
 * user.
 * 
 * @author SagaciousMedia's Team 10
 * 
 */
public interface ExpressionElement
{
  /**
   * Gets the string that represents what the expression is. It will be either a Operand or an
   * Operator in the first iteration of the project.
   * 
   * @return String representing the expression. ex: "+" or "12 lbs"
   */
  public abstract String getExpression();
}
