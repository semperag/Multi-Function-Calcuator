package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the logical representation of the calculator and has a reference to the
 * CalculatorFrame that will display it. To use the class you should instantiate a new Calculator
 * and call the start
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class CalculatorLogic
{

  private List<ExpressionElement> expression;

  /**
   * Default constructor.
   */
  public CalculatorLogic()
  {
    expression = new ArrayList<>();
  }

  /**
   * Evaulates the expression on the stack. This will leave the result as the only ExpressionElement
   * on the stack.
   * 
   * @param text
   *          String representing an infix expression that needs to be calculated
   * 
   * @return The result of the expression on the stack.
   */
  public Operand evaluate(String text)
  {
    // NOTE: Parenthesis are not in this version yet.
    // TODO: Finish me.
    expression.clear();
    parseExpression(text);

    // Scan through and simplify multiplication and division
    for (int prec = Operator.HIGHEST_PRECEDENCE; prec >= 0; prec--)
    {
      for (int i = 0; i < expression.size(); i++)
      {
        ExpressionElement element = expression.get(i);
        if (element instanceof Operator)
        {
          Operator op = (Operator) element;
          if (op.getPrecedence() == prec)
          {
            if (i != 0 && i != expression.size() - 1 && expression.get(i - 1) instanceof Operand
                && expression.get(i + 1) instanceof Operand)
            {
              Operand left = (Operand) expression.remove(i - 1);
              expression.remove(i - 1);
              Operand right = (Operand) expression.remove(i - 1);
              expression.add(i - 1, simplify(left, op, right));
              i = 0;
              System.out.println(expression); // Step by step printout
            }
            else
            {
              throw new IllegalArgumentException("Operator not surrounded by operands.");
            }
          }
        }
      }
    }

    return (Operand) expression.get(0);
  }

  /**
   * Returns the result of performing the operation on the left and right operands.
   * 
   * @param left
   * @param op
   * @param right
   * @return Operand containing result
   * @throws IllegalArgumentException
   *           if it cannot recognize the operator
   */
  private Operand simplify(Operand left, Operator op, Operand right)
  {
    switch (op.getOperation())
    {
      case ADD:
        return left.add(right);
      case SUBTRACT:
        return left.subtract(right);
      case MULTIPLY:
        return left.multiply(right);
      case DIVIDE:
        return left.divide(right);
      default:
        throw new IllegalArgumentException("Unrecognized operator.");
    }
  }

  /**
   * Populates the list with operations and operators.
   * 
   * @param text
   *          Expression to parse
   */
  private void parseExpression(String text)
  {
    String formatted = text;
    // Remove all whitespace
    formatted = formatted.replaceAll("\\s+", "");
    // Remove everything after the equals
    int loc = formatted.indexOf("=");
    if (loc != -1)
    {
      formatted = formatted.substring(0, loc);
    }

    int lastOperator = 0;
    for (int i = 0; i < formatted.length(); i++)
    {
      if (Operation.isOperation(formatted.charAt(i) + ""))
      {
        if (i + 1 >= formatted.length())
        {
          throw new IllegalArgumentException("Operator not followed by number.");
        }
        if (Character.isDigit(formatted.charAt(i + 1)))
        {
          expression.add(Operand.parseOperand(formatted.substring(lastOperator, i)));
          expression.add(Operator.parseOperator(formatted.charAt(i) + ""));
          lastOperator = i + 1;
        }
      }
    }

    expression.add(Operand.parseOperand(formatted.substring(lastOperator, formatted.length())));

  }
}
