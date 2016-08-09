import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexandr on 17.04.2016.
 */
public class RegistrationWindow extends JFrame
{
    private static RegistrationWindow instance;
    private JTextField loginTextField;
    private JPasswordField passwordField;
    private JPasswordField confirmPswField;
    private RegistrationWindow(String name)
    {
        this.setTitle(name);
        this.setIconImage(new ImageIcon(getClass().getResource("img/hospital.png")).getImage());
        this.setResizable(false);
        this.setSize(400, 400);
        this.setLocation(350, 125);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setVisible(true);

        Font customFont = new Font("Serif", Font.PLAIN, 17);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(customFont);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(customFont);

        JLabel confirmPswLabel = new JLabel("Confirm password");
        confirmPswLabel.setFont(customFont);

        Font textFieldFont = new Font("Serif", Font.PLAIN, 13);

        loginTextField = new JTextField(10);
        loginTextField.setFont(textFieldFont);

        passwordField = new JPasswordField(10);
        passwordField.setFont(textFieldFont);

        confirmPswField = new JPasswordField(10);
        confirmPswField.setFont(textFieldFont);

        JButton confirmButton = new JButton("Confirm");

        confirmButton.setFont(textFieldFont);
        confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setConfirmButton(confirmButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(textFieldFont);
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setCancelButton(cancelButton);

        this.add(loginLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(110,40,2,50), 0,0));
        this.add(passwordLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(140,40,2,50), 0,0));
        this.add(confirmPswLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(170,40,2,50), 0,0));

        this.add(loginTextField, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(110,200,2,50), 0,0));
        this.add(passwordField, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(140,200,2,50), 0,0));
        this.add(confirmPswField, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(170,200,2,50), 0,0));

        this.add(confirmButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(210,80,2,220), 0,0));
        this.add(cancelButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(210,200,2,100), 0,0));


    }

    public static RegistrationWindow getInstance()
    {
        if(instance == null)
        {
            instance = new RegistrationWindow("Registration");
        }
        return instance;
    }

    private void setConfirmButton(JButton button)
    {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginTextField.getText().length() > 0 && passwordField.getPassword().length > 0
                        && confirmPswField.getPassword().length >0)
                {
                    boolean passwordEquals = true;
                    if(passwordField.getPassword().length == confirmPswField.getPassword().length)
                    {
                        for(int i = 0; i < passwordField.getPassword().length; i++)
                        {
                            if(passwordField.getPassword()[i] != confirmPswField.getPassword()[i])
                            {
                                passwordEquals = false;
                            }
                        }
                    }
                    else
                    {
                        passwordEquals=false;
                    }
                    if(passwordEquals)
                    {
                        DBconnection connect = new DBconnection("IM", "123456");
                        connect.init();
                        connect.updateQuery("insert into users(login, password) values('" + loginTextField.getText() + "','" +
                                MD5Custom.encryption(passwordField.getText()) + "')");
                        RegistrationWindow.getInstance().setVisible(false);
                        loginTextField.setText(null);
                        passwordField.setText(null);
                        confirmPswField.setText(null);
                        connect.finiliaze();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Пароли не совпадают");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Не все поля заполнены");
                }
            }
        });
    }

    private void setCancelButton(JButton button)
    {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationWindow.getInstance().setVisible(false);
                loginTextField.setText(null);
                passwordField.setText(null);
                confirmPswField.setText(null);
            }
        });
    }
}
