import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandr on 20.04.2016.
 */
public class CustomTable extends AbstractTableModel
{

    private int columnCount = 0;
    private ArrayList<String[]> dataArrayList;
    private String[] columnName;

    public CustomTable()
    {
        dataArrayList = new ArrayList<>();
    }
    public CustomTable(int columnCount, String[] columnName)
    {
        this.columnName = columnName;
        this.columnCount = columnCount;
        dataArrayList = new ArrayList<>();
        for(int i = 0; i < dataArrayList.size(); i++)
        {
            dataArrayList.add(new String[getColumnCount()]);
        }

    }
    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        String[] row = new String[getColumnCount()];
        row = dataArrayList.get(rowIndex);
        return row[columnIndex];
    }

    public void addData(String[] row)
    {

        String[] temp;
        temp = row;
        dataArrayList.add(temp);
    }


    public String getColumnName(int columnIndex)
    {
        if(columnName.length == 2)
        {
            switch (columnIndex)
            {
                case 0:
                    return columnName[0];
                case 1:
                    return columnName[1];
            }
        }
        if(columnName.length == 3)
        {
            switch (columnIndex)
            {
                case 0:
                    return columnName[0];
                case 1:
                    return columnName[1];
                case 2:
                    return columnName[2];
            }
        }
        if(columnName.length == 6)
        {
            switch (columnIndex)
            {
                case 0:
                    return columnName[0];
                case 1:
                    return columnName[1];
                case 2:
                    return columnName[2];
                case 3:
                    return columnName[3];
                case 4:
                    return columnName[4];
                case 5:
                    return columnName[5];
                default:
                    return "unknown";
            }
        }
        return "";
    }

    public void selectWards(DBconnection dBconnection,int columnCount)
    {
        dataArrayList.clear();
        if(this.columnCount != columnCount)
        {
            this.columnCount = columnCount;
            dataArrayList.clear();
            for (int i = 0; i < dataArrayList.size(); i++)
            {
                dataArrayList.add(new String[columnCount]);
            }

        }

        ResultSet resultSet = dBconnection.selectQuery("select * from wards");
        try {
            while (resultSet.next())
            {
                String[] row = {resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("max_count")};
                addData(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fireTableDataChanged();
        fireTableStructureChanged();
    }

    public void selectPeople(DBconnection dBconnection, int columnCount)
    {
        dataArrayList.clear();
        if(this.columnCount != columnCount)
        {
            this.columnCount = columnCount;
            dataArrayList.clear();
            for (int i = 0; i < dataArrayList.size(); i++)
            {
                dataArrayList.add(new String[columnCount]);
            }

        }

        ResultSet resultSet = dBconnection.selectQuery("select * from people");
        try {
            while (resultSet.next())
            {
                String[] row = {resultSet.getString("id"), resultSet.getString("first_name"), resultSet.getString("last_name"),
                resultSet.getString("pather_name"), resultSet.getString("diagnosis_id"), resultSet.getString("wards_id")};
                addData(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fireTableDataChanged();
        fireTableStructureChanged();
    }

    public void selectDiagnos(DBconnection dBconnection, int columnCount)
    {
        dataArrayList.clear();
        if(this.columnCount != columnCount)
        {
            this.columnCount = columnCount;
            dataArrayList.clear();
            for (int i = 0; i < dataArrayList.size(); i++)
            {
                dataArrayList.add(new String[columnCount]);
            }

        }

        ResultSet resultSet = dBconnection.selectQuery("select * from diagnosis");
        try {
            while (resultSet.next())
            {
                String[] row = {resultSet.getString("id"), resultSet.getString("name")};
                addData(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fireTableDataChanged();
        fireTableStructureChanged();
    }

    public void setColumnsName(String[] name)
    {
        this.columnName = name;
    }
    public void todoQuery(DBconnection dBconnection,String query, int i)
    {
        if(i == 9)
        {
            dataArrayList.clear();
            this.columnCount = 6;
            dataArrayList.clear();
            for (int j = 0; j < dataArrayList.size(); i++)
            {
                dataArrayList.add(new String[columnCount]);
            }


            ResultSet resultSet = dBconnection.selectQuery(query);
            try {
                while (resultSet.next())
                {
                    String[] row = {resultSet.getString("id"), resultSet.getString("first_name"), resultSet.getString("last_name"),
                            resultSet.getString("pather_name"), resultSet.getString("diagnosis_id"), resultSet.getString("wards_id")};
                    addData(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            fireTableDataChanged();
            fireTableStructureChanged();
        }
        if(i == 10)
        {
            dataArrayList.clear();
            this.columnCount = 3;
            for (int j = 0; j < dataArrayList.size(); i++)
            {
                dataArrayList.add(new String[columnCount]);
            }


            ResultSet resultSet = dBconnection.selectQuery(query);
            try {
                while (resultSet.next())
                {
                    String[] row = {resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("max_count")};
                    addData(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            fireTableDataChanged();
            fireTableStructureChanged();
        }
        if(i == 11)
        {
            dataArrayList.clear();
            this.columnCount = 2;
            for (int j = 0; j < dataArrayList.size(); i++)
            {
                dataArrayList.add(new String[columnCount]);
            }

            ResultSet resultSet = dBconnection.selectQuery(query);
            try {
                while (resultSet.next())
                {
                    String[] row = {resultSet.getString("name"), resultSet.getString("avg_res")};
                    addData(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            fireTableDataChanged();
            fireTableStructureChanged();
        }
    }
}
