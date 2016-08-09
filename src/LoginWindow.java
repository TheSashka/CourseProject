import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexandr on 16.04.2016.
 */
public class LoginWindow extends JFrame
{
    private static LoginWindow instance;
    private JTextField loginTextField;
    private JPasswordField passwordField;
    private LoginWindow(String name)
    {
        Font customFont = new Font("Serif", Font.PLAIN, 17);
        this.setTitle(name);
        this.setIconImage(new ImageIcon(getClass().getResource("img/hospital.png")).getImage());
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocation(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        JLabel image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.RIGHT);
        image.setIcon(new ImageIcon(getClass().getResource("img/hospital.png")));

        JLabel loginLabel = new JLabel("Логин");
        loginLabel.setFont(customFont);

        JLabel passwordLabel = new JLabel("Пароль");
        passwordLabel.setFont(customFont);

        Font textFieldFont = new Font("Serif", Font.PLAIN, 13);

        JButton loginButton = new JButton("Вход");
        loginButton.setFont(textFieldFont);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButtonListener(loginButton);

        JButton registrationButton = new JButton("Регистрация");
        registrationButton.setFont(textFieldFont);
        registrationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registrationButtonListener(registrationButton);

        loginTextField = new JTextField(10);
        loginTextField.setFont(textFieldFont);

        passwordField = new JPasswordField(10);
        passwordField.setFont(textFieldFont);

        this.add(image, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(150,2,2,50), 0,0));
        this.add(loginLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(250,160,2,2), 0,0));
        this.add(passwordLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(275,160,2,2), 0,0));
        this.add(loginTextField, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(251,250,2,350), 0,0));
        this.add(passwordField, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(277,250,2,350), 0,0));
        this.add(loginButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(305,190,2,520), 0,0));
        this.add(registrationButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(305,290,2,400), 0,0));
        this.setVisible(true);

    }

    public static LoginWindow getInstance()
    {
        if(instance == null)
        {
            instance = new LoginWindow("Login");
        }
        return instance;
    }

    private void loginButtonListener(JButton button)
    {
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DBconnection dBconnection = new DBconnection("IM", "123456");
                dBconnection.init();
                ResultSet resultSet=dBconnection.selectQuery("select COUNT(*) as checks from users where users.login ='"+
                        loginTextField.getText() +"' and users.password ='"+MD5Custom.encryption(passwordField.getText())+"'");
                try {
                    if(resultSet.next() && resultSet.getString("checks").equals("1"))
                    {
                        MainWindow.getInstance().setVisible(true);
                        LoginWindow.getInstance().setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Неправильно");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                dBconnection.finiliaze();
            }
        });
    }

    private void registrationButtonListener(JButton button)
    {
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(RegistrationWindow.getInstance() != null)
                {
                    RegistrationWindow.getInstance().setVisible(true);
                }
                else
                {
                    RegistrationWindow.getInstance();
                }
            }
        });
    }
}
