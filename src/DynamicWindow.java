import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicWindow extends JFrame
{
    private JTextField nameWardsText;
    private JTextField countWardsText;
    private JTextField idWardsText;

    private JTextField changeNameWardsText;
    private JTextField changeCountWardsText;

    private JTextField idPacientText;
    private JTextField firstNamePacientText;
    private JTextField lastNamePacientText;
    private JTextField patherNamePacientText;
    private JTextField diagnosisPacientText;
    private JTextField wardsPacientText;

    private JTextField changeFirstNamePacientText;
    private JTextField changeLastNamePacientText;
    private JTextField changePatherNamePacientText;
    private JTextField changeDiagnosPacientText;
    private JTextField changeWardsPacientText;

    private JTextField nameDiagnosText;

    private DBconnection dBconnection;

    DynamicWindow(int number)
    {
        this.setSize(350, 350);
        this.setLocation(400,150);
        this.setLayout(new GridBagLayout());
        this.setIconImage(new ImageIcon(getClass().getResource("img/hospital.png")).getImage());

        dBconnection = new DBconnection("IM", "123456");
        dBconnection.init();

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");
        this.add(confirmButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(250,70,2,170), 0,0));
        this.add(cancelButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                GridBagConstraints.HORIZONTAL, new Insets(250,170,2,70), 0,0));
        switch (number)
        {
            case 1: case 4: case 6: case 10:

                JLabel nameWardsLabel = new JLabel("Название палаты");
                JLabel countWardsLabel = new JLabel("Количество пациентов");

                nameWardsText = new JTextField(13);
                countWardsText = new JTextField(13);

                this.add(nameWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                        GridBagConstraints.HORIZONTAL, new Insets(100,30,2,150), 0,0));
                this.add(countWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                        GridBagConstraints.HORIZONTAL, new Insets(130,30,2,150), 0,0));
                this.add(nameWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                        GridBagConstraints.HORIZONTAL, new Insets(100, 190,2,30), 0,0));
                this.add(countWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                        GridBagConstraints.HORIZONTAL, new Insets(130,190,2,30), 0,0));

                if( number == 1)
                {
                    this.setTitle("Добавление палаты");
                }
                if(number == 4)
                {
                    JLabel changeNameWardsLabel = new JLabel("Изменение названия");
                    JLabel changeCountWardsLabel = new JLabel("Изменение количества");
                    changeCountWardsText = new JTextField(13);
                    changeNameWardsText = new JTextField(13);

                    JLabel idWardsLabel = new JLabel("id");

                    idWardsText = new JTextField(13);

                    this.add(idWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(40,30,2,150), 0,0));
                    this.add(nameWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(70,30,2,150), 0,0));
                    this.add(countWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(100,30,2,150), 0,0));
                    this.add(idWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(40,190,2,30), 0,0));
                    this.add(nameWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(70,190,2,30), 0,0));
                    this.add(countWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(100,190,2,30), 0,0));

                    this.add(changeNameWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(130,30,2,150), 0,0));
                    this.add(changeCountWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(160,30,2, 150), 0,0));
                    this.add(changeNameWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(130,190,2,30), 0,0));
                    this.add(changeCountWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(160,190,2,30), 0,0));

                    this.setTitle("Изменить данные о палате");
                }
                if(number == 6)
                {
                    JLabel idWardsLabel = new JLabel("id");

                    idWardsText = new JTextField(13);

                    this.add(idWardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(70,30,2,150), 0,0));
                    this.add(idWardsText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(70,190,2,30), 0,0));
                    this.setTitle("Удалить палату");
                }
                if(number == 10)
                {
                    this.setTitle("Поиск палаты");
                }
                break;

            case 2: case 5: case 7: case 9:

                JLabel firstNameLabel = new JLabel("Имя");
                JLabel lastNameLabel = new JLabel("Фамилия");
                JLabel patherNameLabel = new JLabel("Отчество");
                JLabel diagnosLabel = new JLabel("Диагноз");
                JLabel wardsLabel = new JLabel("Палата");

                firstNamePacientText = new JTextField(13);
                lastNamePacientText = new JTextField(13);
                patherNamePacientText = new JTextField(13);
                diagnosisPacientText = new JTextField(13);
                wardsPacientText = new JTextField(13);

                this.add(firstNameLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(60,30,2,150), 0,0));
                this.add(lastNameLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(90,30,2,150), 0,0));
                this.add(patherNameLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(120,30,2,150), 0,0));
                this.add(diagnosLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(150, 30,2,150), 0,0));
                this.add(wardsLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(180,30,2,150), 0,0));

                this.add(firstNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(60, 160,2,30), 0,0));
                this.add(lastNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(90, 160,2,30), 0,0));
                this.add(patherNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(120, 160,2,30), 0,0));
                this.add(diagnosisPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(150, 160,2,30), 0,0));
                this.add(wardsPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(180, 160,2,30), 0,0));

                if(number == 2)
                {
                    this.setTitle("Добавление пациента");
                }
                if(number == 5)
                {
                    this.setSize(600, 350);

                    JLabel changeFirstNamePacientLabel = new JLabel("Изменить имя");
                    JLabel changeLastNamePacientLabel = new JLabel("Изменить фамилию");
                    JLabel changePatherNamePacientLabel = new JLabel("Изменить отчество");
                    JLabel changeDiagnosisPacientLabel = new JLabel("Изменить диагноз");
                    JLabel changeWardsPacientLabel = new JLabel("Изменить палату");

                    changeFirstNamePacientText = new JTextField(13);
                    changeLastNamePacientText = new JTextField(13);
                    changePatherNamePacientText = new JTextField(13);
                    changeDiagnosPacientText = new JTextField(13);
                    changeWardsPacientText = new JTextField(13);

                    this.add(changeFirstNamePacientLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(60,280,2,150), 0,0));
                    this.add(changeLastNamePacientLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(90,280,2,150), 0,0));
                    this.add(changePatherNamePacientLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(120,280,2,150), 0,0));
                    this.add(changeDiagnosisPacientLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(150,280,2,150), 0,0));
                    this.add(changeWardsPacientLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(180,280,2,150), 0,0));

                    this.add(changeFirstNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(60, 410,2,20), 0,0));
                    this.add(changeLastNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(90, 410,2,20), 0,0));
                    this.add(changePatherNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(120, 410,2,20), 0,0));
                    this.add(changeDiagnosPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(150, 410,2,20), 0,0));
                    this.add(changeWardsPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(180, 410,2,20), 0,0));

                    this.add(firstNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(60, 110,2,320), 0,0));
                    this.add(lastNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(90, 110,2,320), 0,0));
                    this.add(patherNamePacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(120, 110,2,320), 0,0));
                    this.add(diagnosisPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(150, 110,2,320), 0,0));
                    this.add(wardsPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(180, 110,2,320), 0,0));

                    this.add(confirmButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(250,130,2,320), 0,0));
                    this.add(cancelButton, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(250,320,2,120), 0,0));
                    this.setTitle("Изменить данные о пациенте");
                }
                if(number == 7)
                {
                    JLabel idPacientLabel = new JLabel("id");

                    idPacientText = new JTextField(13);

                    this.add(idPacientLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(30,30,2,150), 0,0));

                    this.add(idPacientText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                            GridBagConstraints.HORIZONTAL, new Insets(30, 160,2,30), 0,0));

                    this.setTitle("Выписать пациента");
                }
                if(number == 9)
                {
                    this.setTitle("Поиск пациента");
                }
                break;
            case 3: case 8:

                if(number == 3)
                {
                    this.setTitle("Добавление диагноза");
                }
                if(number == 8)
                {
                    this.setTitle("Удалить диагноз");
                }

                JLabel nameDiagnosLabel = new JLabel("Название дианоза");

                nameDiagnosText = new JTextField(13);

                this.add(nameDiagnosLabel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(130, 30,2,150), 0,0));

                this.add(nameDiagnosText, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTHEAST,
                    GridBagConstraints.HORIZONTAL, new Insets(130, 160,2,30), 0,0));
                break;
        }

        cancelButtonListener(cancelButton);
        confirmButtonListener(confirmButton, number);

        this.setVisible(true);
    }
    private void clearWindow()
    {
        this.setVisible(!this.isVisible());
        dBconnection.finiliaze();
        this.removeAll();
    }

    private void confirmButtonListener(JButton button, int number)
    {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switch (number)
                {
                    case 1://Добавление палаты
                        dBconnection.updateQuery("insert into wards(id, name, max_count) values( SEQUENCE_WARDS.nextval, '"
                                +nameWardsText.getText()+"'," + countWardsText.getText()+")");
                        break;
                    case 2://Добавление пациента
                        dBconnection.updateQuery("insert into people(id, first_name, last_name, pather_name, diagnosis_id, wards_id) " +
                                "values(sequence_people.nextval, '"+ firstNamePacientText.getText()+"','"+lastNamePacientText.getText()+"','"+
                                patherNamePacientText.getText()+"',"+diagnosisPacientText.getText()+","+wardsPacientText.getText()+")");
                        break;
                    case 3://Добавление диагноза
                        dBconnection.updateQuery("insert into diagnosis(id, name) values(sequence_diag.nextval,'"+
                                nameDiagnosText.getText()+"')");
                        break;
                    case 4://Изменить данные о палате
                        String query = "update wards set ";
                        if(changeNameWardsText.getText().length()>0)
                        {
                            query+="name='"+changeNameWardsText.getText()+"'";
                            if(changeCountWardsText.getText().length()>0)
                            {
                                query+=",";
                            }
                        }
                        if(changeCountWardsText.getText().length()>0)
                        {
                            query+="max_count="+changeCountWardsText.getText();
                        }
                        if(idWardsText.getText().length()>0 || nameWardsText.getText().length() > 0 || countWardsText.getText().length()>0)
                        {
                            query+=" where ";
                            if(idWardsText.getText().length()>0)
                            {
                                query+="id"+idWardsText.getText();
                                if(nameWardsText.getText().length()>0)
                                {
                                    query+=" and name='"+nameWardsText.getText()+"'";
                                }
                                if(countWardsText.getText().length()>0)
                                {
                                    query+=" and max_count="+countWardsText.getText();
                                }
                            }
                            if(nameWardsText.getText().length()>0 && idWardsText.getText().length()==0)
                            {
                                query+="name='"+nameWardsText.getText()+"'";
                                if(countWardsText.getText().length()>0)
                                {
                                    query+=" and max_count="+countWardsText.getText();
                                }
                            }
                            if(countWardsText.getText().length()>0 && idWardsText.getText().length()==0
                                    && nameWardsText.getText().length()==0)
                            {
                                query+=" max_count="+countWardsText.getText();
                            }
                        }

                        dBconnection.updateQuery(query);
                        break;
                    case 5://Изменить данные о пациенте
                        dBconnection.updateQuery(updatePacient());
                        break;
                    case 6://Удалить палату
                        String query1="delete from wards ";
                        if(idWardsText.getText().length()>0 || nameWardsText.getText().length()>0 || countWardsText.getText().length()>0)
                        {
                            query1+="where ";
                            if(idWardsText.getText().length()>0)
                            {
                                query1+="id="+idWardsText.getText();
                                if(nameWardsText.getText().length()>0)
                                {
                                    query1+=" and name='"+nameWardsText.getText()+"'";
                                }
                                if(countWardsText.getText().length()>0)
                                {
                                    query1+=" and max_count="+countWardsText.getText();
                                }
                            }
                            if(nameWardsText.getText().length()>0 && idWardsText.getText().length() == 0)
                            {
                                query1+="name='"+nameWardsText.getText()+"'";
                                if(countWardsText.getText().length()>0)
                                {
                                    query1+=" and max_count="+countWardsText.getText();
                                }
                            }
                            if(countWardsText.getText().length()>0 && idWardsText.getText().length()==0 && nameWardsText.getText().length()==0)
                            {
                                query1+="max_count="+countWardsText.getText();
                            }
                        }
                        dBconnection.updateQuery(query1);
                        break;
                    case 7://Выписать пациента
                        dBconnection.updateQuery(deletePacient());
                        break;
                    case 8://Удалить диагноз
                        String query2 = "delete from diagnosis ";
                        if(nameDiagnosText.getText().length() > 0)
                        {
                            query2+="where name='"+nameDiagnosText.getText()+"'";
                        }
                        dBconnection.updateQuery(query2);
                        break;
                    case 9://Поиск пациента
                        String query3="select * from people ";
                        if(firstNamePacientText.getText().length() > 0 || lastNamePacientText.getText().length()>0
                                || patherNamePacientText.getText().length()>0 || diagnosisPacientText.getText().length()>0 ||
                                wardsPacientText.getText().length() > 0)
                        {
                            query3+="where ";
                            if(firstNamePacientText.getText().length()>0)
                            {
                                query3+="first_name='"+ firstNamePacientText.getText()+"' ";
                                if(lastNamePacientText.getText().length()>0)
                                {
                                    query3+="and last_name='"+lastNamePacientText.getText()+"' ";
                                }
                                if(patherNamePacientText.getText().length()>0)
                                {
                                    query3+="and pather_name='"+patherNamePacientText.getText()+" ";
                                }
                                if(diagnosisPacientText.getText().length()>0)
                                {
                                    query3+="and diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                                }
                                if(wardsPacientText.getText().length()>0)
                                {
                                    query3+="and wards_id='"+wardsPacientText.getText()+"' ";
                                }
                            }
                            if(lastNamePacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0)
                            {
                                query3+="last_name='"+lastNamePacientText.getText()+"' ";
                                if(patherNamePacientText.getText().length()>0)
                                {
                                    query3+="and pather_name='"+patherNamePacientText.getText()+"' ";
                                }
                                if(diagnosisPacientText.getText().length()>0)
                                {
                                    query3+="and diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                                }
                                if(wardsPacientText.getText().length()>0)
                                {
                                    query3+="and wards_id='"+wardsPacientText.getText()+"' ";
                                }
                            }
                            if(patherNamePacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0
                                    && lastNamePacientText.getText().length()==0)
                            {
                                query3+="pather_name='"+patherNamePacientText.getText()+"' ";
                                if(diagnosisPacientText.getText().length()>0)
                                {
                                    query3+="and diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                                }
                                if(wardsPacientText.getText().length()>0)
                                {
                                    query3+="and wards_id='"+wardsPacientText.getText()+"' ";
                                }
                            }
                            if(diagnosisPacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0
                                    && lastNamePacientText.getText().length()==0 && patherNamePacientText.getText().length()==0)
                            {
                                query3+="diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                                if(wardsPacientText.getText().length()>0)
                                {
                                    query3+="and wards_id='"+wardsPacientText.getText()+"' ";
                                }
                            }
                            if(wardsPacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0
                                    && lastNamePacientText.getText().length()==0 && patherNamePacientText.getText().length()==0
                                    && diagnosisPacientText.getText().length()==0)
                            {
                                query3+="wards_id='"+wardsPacientText.getText()+"' ";
                            }
                        }
                        MainWindow.getInstance().todoQuery(query3, 9);
                        break;
                    case 10://Поиск палаты
                        String query4="select * from wards ";
                        if(nameWardsText.getText().length()>0 || countWardsText.getText().length()>0)
                        {
                            query4+="where ";
                            if(nameWardsText.getText().length()>0)
                            {
                                query4+=" name='"+nameWardsText.getText()+"'";
                                if(countWardsText.getText().length()>0)
                                {
                                    query4+=" and max_count="+countWardsText.getText();
                                }
                            }

                            if(countWardsText.getText().length()>0 && nameWardsText.getText().length()==0)
                            {
                                query4+="max_count="+countWardsText.getText();
                            }
                            MainWindow.getInstance().todoQuery(query4, 10);
                        }
                        break;
                    default:
                        dBconnection.finiliaze();
                        break;
                }
                clearWindow();
            }
        });
    }
    private void cancelButtonListener(JButton button)
    {
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                clearWindow();
            }
        });
    }

    private String updatePacient()
    {
        String query="update people set ";
        if(changeFirstNamePacientText.getText().length()>0)
        {
            query+="first_name='"+ changeFirstNamePacientText.getText()+"' ";
            if(changeLastNamePacientText.getText().length()>0)
            {
                query+=",last_name='"+changeLastNamePacientText.getText()+"' ";
            }
            if(changePatherNamePacientText.getText().length()>0)
            {
                query+=",pather_name='"+changePatherNamePacientText.getText()+"', ";
            }
            if(changeDiagnosPacientText.getText().length()>0)
            {
                query+=",diagnosis_id='"+changeDiagnosPacientText.getText()+"', ";
            }
            if(changeWardsPacientText.getText().length()>0)
            {
                query+=",wards_id='"+changeWardsPacientText.getText()+"', ";
            }
        }
        if(changeLastNamePacientText.getText().length()>0 && changeFirstNamePacientText.getText().length() == 0)
        {
            query+="last_name='"+changeLastNamePacientText.getText()+"' ";
            if(changePatherNamePacientText.getText().length()>0)
            {
                query+=",pather_name='"+changePatherNamePacientText.getText()+"' ";
            }
            if(changeDiagnosPacientText.getText().length()>0)
            {
                query+=",diagnosis_id='"+changeDiagnosPacientText.getText()+"' ";
            }
            if(changeWardsPacientText.getText().length()>0)
            {
                query+=",wards_id='"+changeWardsPacientText.getText()+"' ";
            }
        }
        if(changePatherNamePacientText.getText().length()>0 && changeFirstNamePacientText.getText().length() == 0
                && changeLastNamePacientText.getText().length()==0)
        {
            query+="pather_name='"+changePatherNamePacientText.getText()+"' ";
            if(changeDiagnosPacientText.getText().length()>0)
            {
                query+=",diagnosis_id='"+changeDiagnosPacientText.getText()+"' ";
            }
            if(changeWardsPacientText.getText().length()>0)
            {
                query+=",wards_id='"+changeWardsPacientText.getText()+"' ";
            }
        }
        if(changeDiagnosPacientText.getText().length()>0 && changeFirstNamePacientText.getText().length() == 0
            && changeLastNamePacientText.getText().length()==0 && changePatherNamePacientText.getText().length()==0)
        {
            query+="diagnosis_id='"+changeDiagnosPacientText.getText()+"' ";
            if(changeWardsPacientText.getText().length()>0)
            {
                query+=", wards_id='"+changeWardsPacientText.getText()+"' ";
            }
        }
        if(changeWardsPacientText.getText().length()>0 && changeFirstNamePacientText.getText().length() == 0
                && changeLastNamePacientText.getText().length()==0 && changePatherNamePacientText.getText().length()==0
                && changeDiagnosPacientText.getText().length()==0)
        {
            query+="wards_id='"+changeWardsPacientText.getText()+"' ";
        }
        if(firstNamePacientText.getText().length() > 0 || lastNamePacientText.getText().length()>0 || patherNamePacientText.getText().length()>0
                || diagnosisPacientText.getText().length() > 0 || wardsPacientText.getText().length() > 0)
        {
            query+="where ";
            if(firstNamePacientText.getText().length()>0)
            {
                query+="first_name='"+ firstNamePacientText.getText()+"' ";
                if(lastNamePacientText.getText().length()>0)
                {
                    query+="and last_name='"+lastNamePacientText.getText()+"' ";
                }
                if(patherNamePacientText.getText().length()>0)
                {
                    query+="and pather_name='"+patherNamePacientText.getText()+" ";
                }
                if(diagnosisPacientText.getText().length()>0)
                {
                    query+="and diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                }
                if(wardsPacientText.getText().length()>0)
                {
                    query+="and wards_id='"+wardsPacientText.getText()+"' ";
                }
            }
            if(lastNamePacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0)
            {
                query+="last_name='"+lastNamePacientText.getText()+"' ";
                if(patherNamePacientText.getText().length()>0)
                {
                    query+="and pather_name='"+patherNamePacientText.getText()+"' ";
                }
                if(diagnosisPacientText.getText().length()>0)
                {
                    query+="and diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                }
                if(wardsPacientText.getText().length()>0)
                {
                    query+="and wards_id='"+wardsPacientText.getText()+"' ";
                }
            }
            if(patherNamePacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0
                    && lastNamePacientText.getText().length()==0)
            {
                query+="pather_name='"+patherNamePacientText.getText()+"' ";
                if(diagnosisPacientText.getText().length()>0)
                {
                    query+="and diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                }
                if(wardsPacientText.getText().length()>0)
                {
                    query+="and wards_id='"+wardsPacientText.getText()+"' ";
                }
            }
            if(diagnosisPacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0
                    && lastNamePacientText.getText().length()==0 && patherNamePacientText.getText().length()==0)
            {
                query+="diagnosis_id='"+diagnosisPacientText.getText()+"' ";
                if(wardsPacientText.getText().length()>0)
                {
                    query+="and wards_id='"+wardsPacientText.getText()+"' ";
                }
            }
            if(wardsPacientText.getText().length()>0 && firstNamePacientText.getText().length() == 0
                    && lastNamePacientText.getText().length()==0 && patherNamePacientText.getText().length()==0
                    && diagnosisPacientText.getText().length()==0)
            {
                query+="wards_id='"+wardsPacientText.getText()+"' ";
            }
        }
        return query;
    }

    private String deletePacient()
    {
        String query = "delete from people";
        if(firstNamePacientText.getText().length() > 0 || lastNamePacientText.getText().length()>0 || patherNamePacientText.getText().length()>0
                || diagnosisPacientText.getText().length() > 0 || wardsPacientText.getText().length() > 0 || idPacientText.getText().length()>0)
        {
            query += " where ";
            if(idPacientText.getText().length()>0)
            {
                query += "id="+idPacientText.getText();
                if (firstNamePacientText.getText().length() > 0)
                {
                    query += " and first_name='" + firstNamePacientText.getText() + "' ";
                }
                if (lastNamePacientText.getText().length() > 0)
                {
                    query += "and last_name='" + lastNamePacientText.getText() + "' ";
                }
                if (patherNamePacientText.getText().length() > 0)
                {
                    query += "and pather_name='" + patherNamePacientText.getText() + " ";
                }
                if (diagnosisPacientText.getText().length() > 0)
                {
                    query += "and diagnosis_id='" + diagnosisPacientText.getText() + "' ";
                }
                if (wardsPacientText.getText().length() > 0)
                {
                    query += "and wards_id='" + wardsPacientText.getText() + "' ";
                }
            }
            if (firstNamePacientText.getText().length() > 0 && idPacientText.getText().length()==0)
            {
                query += "first_name='" + firstNamePacientText.getText() + "' ";
                if (lastNamePacientText.getText().length() > 0)
                {
                    query += "and last_name='" + lastNamePacientText.getText() + "' ";
                }
                if (patherNamePacientText.getText().length() > 0)
                {
                    query += "and pather_name='" + patherNamePacientText.getText() + " ";
                }
                if (diagnosisPacientText.getText().length() > 0)
                {
                    query += "and diagnosis_id='" + diagnosisPacientText.getText() + "' ";
                }
                if (wardsPacientText.getText().length() > 0)
                {
                    query += "and wards_id='" + wardsPacientText.getText() + "' ";
                }
            }
            if (lastNamePacientText.getText().length() > 0 && firstNamePacientText.getText().length() == 0
                    && idPacientText.getText().length()==0)
            {
                query += "last_name='" + lastNamePacientText.getText() + "' ";
                if (patherNamePacientText.getText().length() > 0)
                {
                    query += "and pather_name='" + patherNamePacientText.getText() + "' ";
                }
                if (diagnosisPacientText.getText().length() > 0)
                {
                    query += "and diagnosis_id='" + diagnosisPacientText.getText() + "' ";
                }
                if (wardsPacientText.getText().length() > 0)
                {
                    query += "and wards_id='" + wardsPacientText.getText() + "' ";
                }
            }
            if (patherNamePacientText.getText().length() > 0 && firstNamePacientText.getText().length() == 0
                    && lastNamePacientText.getText().length() == 0 && idPacientText.getText().length()==0)
            {
                query += "pather_name='" + patherNamePacientText.getText() + "' ";
                if (diagnosisPacientText.getText().length() > 0)
                {
                    query += "and diagnosis_id='" + diagnosisPacientText.getText() + "' ";
                }
                if (wardsPacientText.getText().length() > 0) {
                    query += "and wards_id='" + wardsPacientText.getText() + "' ";
                }
            }
            if (diagnosisPacientText.getText().length() > 0 && firstNamePacientText.getText().length() == 0
                    && lastNamePacientText.getText().length() == 0 && patherNamePacientText.getText().length() == 0
                    && idPacientText.getText().length()==0)
            {
                query += "diagnosis_id='" + diagnosisPacientText.getText() + "' ";
                if (wardsPacientText.getText().length() > 0) {
                    query += "and wards_id='" + wardsPacientText.getText() + "' ";
                }
            }
            if (wardsPacientText.getText().length() > 0 && firstNamePacientText.getText().length() == 0
                    && lastNamePacientText.getText().length() == 0 && patherNamePacientText.getText().length() == 0
                    && diagnosisPacientText.getText().length() == 0 && idPacientText.getText().length()==0)
            {
                query += "wards_id='" + wardsPacientText.getText() + "' ";
            }
        }
        return query;
    }
}
