import javax.swing.*;
import javax.swing.event.TableModelEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexandr on 17.04.2016.
 */
public class MainWindow extends JFrame
{
    private static MainWindow instance;
    private CustomTable customTable;
    private JTable jTable;
    private DBconnection dBconnection;
    private JScrollPane jScrollPane;
    private MainWindow()
    {
        this.setTitle("Account");
        this.setIconImage(new ImageIcon(getClass().getResource("img/hospital.png")).getImage());
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocation(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        dBconnection = new DBconnection("im", "123456");
        dBconnection.init();

        customTable = new CustomTable();
        jTable = new JTable(customTable);
        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setPreferredSize(new Dimension(500,500));

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.getInstance().setVisible(false);
                LoginWindow.getInstance().setVisible(true);
            }
        });

        fileMenu.add(exitItem);

        JMenu operationMenu = new JMenu("Журнал операций");

        JMenuItem insertWardsItem = new JMenuItem("Добавить палату");
        ActionBtnListener(insertWardsItem, 1);
        JMenuItem insertPeopleItem = new JMenuItem("Добавить пациента");
        ActionBtnListener(insertPeopleItem, 2);
        JMenuItem insertDiagnosisItem = new JMenuItem("Добавить диагноз");
        ActionBtnListener(insertDiagnosisItem, 3);

        JMenuItem updateWardsItem = new JMenuItem("Изменить палату");
        ActionBtnListener(updateWardsItem, 4);
        JMenuItem updatePeopleItem = new JMenuItem("Изменить пациента");
        ActionBtnListener(updatePeopleItem, 5);

        JMenuItem deleteWardsItem = new JMenuItem("Удалить палату");
        ActionBtnListener(deleteWardsItem, 6);
        JMenuItem deletePeopleItem = new JMenuItem("Выписать пациента");
        ActionBtnListener(deletePeopleItem, 7);
        JMenuItem deleteDiagnosisItem = new JMenuItem("Удалить диагноз");
        ActionBtnListener(deleteDiagnosisItem, 8);

        operationMenu.add(insertWardsItem);
        operationMenu.add(insertPeopleItem);
        operationMenu.add(insertDiagnosisItem);

        operationMenu.add(updateWardsItem);
        operationMenu.add(updatePeopleItem);

        operationMenu.add(deleteWardsItem);
        operationMenu.add(deletePeopleItem);
        operationMenu.add(deleteDiagnosisItem);

        JMenu selectMenu = new JMenu("Справочник");
        JMenuItem selectWardsItem = new JMenuItem("Палаты");
        selectWardsListener(selectWardsItem);
        JMenuItem selectPeopleItem = new JMenuItem("Пациенты");
        selectPeopleListener(selectPeopleItem);
        JMenuItem selectDiagnosisItem = new JMenuItem("Диагнозы");
        selectDiagnosListener(selectDiagnosisItem);

        JMenu searchMenu = new JMenu("Поиск");

        JMenuItem searchWardsItem = new JMenuItem("Поиск палаты");
        ActionBtnListener(searchWardsItem, 10);
        JMenuItem searchPacientItem = new JMenuItem("Поиск пациента");
        ActionBtnListener(searchPacientItem, 9);

        searchMenu.add(searchWardsItem);
        searchMenu.add(searchPacientItem);

        selectMenu.add(selectWardsItem);
        selectMenu.add(selectPeopleItem);
        selectMenu.add(selectDiagnosisItem);

        JMenu reportMenu = new JMenu("Отчет");
        JMenuItem reportItem = new JMenuItem("Отчет 1");
        reportMenu.add(reportItem);
        reportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todoQuery("select name, avg(pacient/max_count) as avg_res from (select im.diagnosis.name, im.wards.max_count, " +
                        "count(*) as pacient from im.diagnosis, im.wards, im.people where im.diagnosis.id = im.people.diagnosis_id " +
                        "and im.people.wards_id = im.wards.id group by im.diagnosis.name, im.wards.max_count) group by name " +
                        "having avg(pacient/max_count) between 0.1 and 1.0", 11);
            }
        });


        menuBar.add(fileMenu);
        menuBar.add(selectMenu);
        menuBar.add(operationMenu);
        menuBar.add(reportMenu);
        menuBar.add(searchMenu);

        this.setJMenuBar(menuBar);
        this.add(jScrollPane);

        this.setVisible(true);
    }
    public static MainWindow getInstance()
    {
        if(instance == null)
        {
            instance = new MainWindow();
        }
        return instance;
    }

    private void selectWardsListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] wardsColumn = {"№", "name", "max_count"};
                customTable.setColumnsName(wardsColumn);
                customTable.selectWards(dBconnection, 3);
            }
        });
    }
    private void selectDiagnosListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] diagnosColums = {"№", "name"};
                customTable.setColumnsName(diagnosColums);
                customTable.selectDiagnos(dBconnection, 2);
            }
        });
    }

    private void selectPeopleListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] peopleColumns={"№", "first_name", "last_name", "pather_name", "diagnosis_id", "wards_id"};
                customTable.setColumnsName(peopleColumns);
                customTable.selectPeople(dBconnection, 6);
            }
        });
    }

    private void ActionBtnListener(JMenuItem menuItem, int number)
    {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DynamicWindow dynamicWindow = new DynamicWindow(number);
            }
        });
    }

    public void todoQuery(String query, int i)
    {
        if(i == 9)
        {
            String[] columnName = {"№", "first_name", "last_name", "pather_name", "diagnosis_id", "wards_id"};
            customTable.setColumnsName(columnName);
        }
        if(i == 10)
        {
            String[] columnName = {"№", "name", "max_count"};
            customTable.setColumnsName(columnName);
        }
        if(i == 11)
        {
            String[] columnName = {"name", "average"};
            customTable.setColumnsName(columnName);
        }
        customTable.todoQuery(dBconnection, query, i);
    }

}
