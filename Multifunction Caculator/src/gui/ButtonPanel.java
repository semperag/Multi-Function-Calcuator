package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class represents a Panel that can hold an arbitrary amount of JButtons. It will be used to
 * contain all of the buttons unitED needs for its first iteration.
 * 
 * @author SagaciousMedia's Team 10
 *
 */
public class ButtonPanel extends JPanel
{

  private static final long serialVersionUID = 1L;
  private JButton[] buttons = null;
  private Map<String, JButton> mapButtons;

  // TODO ---------------------- confused why we decided on a list instead of an array?
//  private List<JButton> buttons;
  

  /**
   * Default constructor for a ButtonPanel. For version 1 of the project it should initialize the
   * required buttons for the GUI.
   */
  public ButtonPanel()
  {
    // Reset, Clear, Addition, Subtraction, Multiplication, Division
    String buttonNames[] = {"R", "C", "\uFF0B", "\uFF0D", "\u00d7", "\u00f7", "="};
    mapButtons = new HashMap<>();
    buttons = new JButton[buttonNames.length];

    for (int i = 0; i < buttonNames.length; i++)
    {
      buttons[i] = new JButton();
      buttons[i].setText(buttonNames[i]);
      buttons[i].setVisible(true);
      add(buttons[i]);
      mapButtons.put(buttonNames[i], buttons[i]);
    }
  }
  
  // TODO -------------------------- Do we need these two methods anymore?
  
  /**
   * Explicit value constructor for a ButtonPanel.
   * 
   * @param buttons
   *          Buttons contained by the ButtonPanel
   */
  public ButtonPanel(List<JButton> buttons)
  {

    // TODO: Finish me.
  }

  /**
   * Explicit value constructor for a ButtonPanel. Forgoes the need to create a list of buttons to
   * pass in and instead we can pass arbitrarily many buttons into the panel.
   * 
   * Ex: new ButtonPanel(addButton, subtractButton, multiplyButton)
   * 
   * @param buttons
   *          Buttons contained by the ButtonPanel
   */
  public ButtonPanel(JButton... buttons)
  {
    this(Arrays.asList(buttons));
  }
  
  public JButton getButtonsMap(String key) 
  {
    return mapButtons.get(key);
  }
  
  public JButton getButtonsList(int index) 
  {
    return buttons[index];
  }
  
  public int getLength() {
    return buttons.length;
  }
}
