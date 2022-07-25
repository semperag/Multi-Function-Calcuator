package calculator;

/**
 * This class represents an Operand in a mathematical expression. It will be used to pair a number
 * with its corresponding unit and perform basic arithmetic with other Operands.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class Operand implements ExpressionElement
{

  private String units;
  private double value;

  /**
   * Explicit value constructor for an Operand.
   * 
   * @param value
   *          Value of the operand
   * @param units
   *          Units of the operand
   * @throws IllegalArgumentException
   *           if units are null or empty.
   */
  public Operand(double value, String units)
  {
    // TODO: Decide if unitless values are valid
    if (units == null || "".contentEquals(units))
    {
      throw new IllegalArgumentException("Invalid units " + units);
    }
    // (?=match this expression)(?=match this too)(?=oh, and this)
    if (!units.matches("[a-zA-z]*[-\\/]?[a-zA-z]*"))
    {
      throw new IllegalArgumentException("Invalid units " + units);
    }

    // for (char ch : units.toCharArray())
    // {
    // if (!Character.isAlphabetic(ch) && ch != '-' && ch != '/')
    // {
    // throw new IllegalArgumentException("Invalid units " + units);
    // }
    // }

    this.value = value;
    this.units = units;
  }

  /**
   * Adds the passed Operand to this. In version 1 of the project we need only concatenate units.
   * 
   * @param other
   *          Other operand to add to this
   * @return Another Operand object that contains the sum
   * @throws IllegalArgumentException
   *           if other is null
   */
  public Operand add(Operand other)
  {
    if (other == null)
    {
      throw new IllegalArgumentException("Cannot have null as the other operand.");
    }

    if (this.units.contentEquals(other.units))
    {
      return new Operand(this.value + other.value, this.units);
    }
    else
    {
      throw new IllegalArgumentException(String
          .format("Cannot handle addition of differing units %s and %s.", this.units, other.units));
    }
  }

  /**
   * Subtracts the passed Operand from this. In version 1 of the project we need only concatenate
   * units.
   * 
   * @param other
   *          Other operand to subtract to this
   * @return Another Operand object that contains the difference
   * @throws IllegalArgumentException
   *           if other is null
   */
  public Operand subtract(Operand other)
  {
    if (other == null)
    {
      throw new IllegalArgumentException("Cannot have null as the other operand.");
    }

    if (this.units.contentEquals(other.units))
    {
      return new Operand(this.value - other.value, this.units);
    }
    else
    {
      throw new IllegalArgumentException(String.format(
          "Cannot handle subtraction of differing units %s and %s.", this.units, other.units));
    }
  }

  /**
   * Multiplies the passed Operand to this. In version 1 of the project we need only concatenate
   * units.
   * 
   * @param other
   *          Other operand to multiply to this
   * @return Another Operand object that contains the product
   * @throws IllegalArgumentException
   *           if other is null
   */
  public Operand multiply(Operand other)
  {
    if (other == null)
    {
      throw new IllegalArgumentException("Cannot have null as the other operand.");
    }

    if (this.units.contentEquals(other.units))
    {
      return new Operand(this.value * other.value, this.units);
    }
    else
    {
      return new Operand(this.value * other.value, this.units + "-" + other.units);
    }

  }

  /**
   * Divides this by the passed Operand. In version 1 of the project we need only concatenate units.
   * 
   * @param other
   *          Other operand to divide this by
   * @return Another Operand object that contains the Quotient
   * @throws IllegalArgumentException
   *           when other contains a value of 0 or other is null
   */
  public Operand divide(Operand other)
  {
    if (other == null)
    {
      throw new IllegalArgumentException("Cannot have null as the other operand.");
    }

    if (other.value == 0)
    {
      throw new IllegalArgumentException("Cannot have a divisor of 0.");
    }

    if (this.units.contentEquals(other.units))
    {
      return new Operand(this.value / other.value, this.units);
    }
    else
    {
      return new Operand(this.value / other.value, this.units + "/" + other.units);
    }

  }

  @Override
  public boolean equals(Object other)
  {
    return !(other instanceof Operand)
        && this.getExpression().equals(((Operand) other).getExpression());
  }

  /**
   * Accessor for the units field.
   * 
   * @return the units of the Operand
   */
  public String getUnits()
  {
    return this.units;
  }

  /**
   * Accessor for the value field.
   * 
   * @return the value of the Operand
   */
  public double getValue()
  {
    return this.value;
  }

  @Override
  public String getExpression()
  {
    return getValue() + " " + getUnits();
  }

  @Override
  public String toString()
  {
    return getExpression();
  }

  /**
   * Parses an operand from the given text. Searches for where a number begins and stops grabbing
   * text if it encounters an operator.
   * 
   * @param text
   *          Text to parse operand
   * @return Operand represented in text
   */
  public static Operand parseOperand(String text)
  {

    // NOTE: Will need to be updated if units involve mathematical symbols.
    // TODO: Convert to use regex instead or improve in any way
    // TODO: Test this code

    // Remove all whitespace
    String formatted = text.replaceAll("\\s+", "");
    // TODO: Create an isOperator() method and allow for * and / to be used as operators as well as
    // the unicode.

    // Search for occurence of any operator in the string
    String[] operators = {"+", "-", "*", "/", "\u00d7", "\u00f7"};
    int operatorLoc = Integer.MAX_VALUE;
    for (String op : operators)
    {
      if (formatted.indexOf(op) != -1
          && Character.isDigit(formatted.charAt(formatted.indexOf(op) + 1)))
      {
        operatorLoc = Math.min(operatorLoc, formatted.indexOf(op));
      }
    }

    // Remove any operators found and anything to the right
    if (operatorLoc > 0 && operatorLoc != Integer.MAX_VALUE)
    {
      formatted = formatted.substring(0, operatorLoc);
    }

    // Search for where number ends and unit begins.
    double value = 0;
    String units = "";
    for (int i = 0; i < formatted.length(); i++)
    {
      char ch = text.charAt(i);
      if (!(Character.isDigit(ch) || ch == '.'))
      {
        value = Double.parseDouble(formatted.substring(0, i));
        units = formatted.substring(i, formatted.length());
        break;
      }
    }

    return new Operand(value, units);
  }

}
