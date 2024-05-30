package GUI;

import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModelloTabellaRubrica extends AbstractTableModel {

    private String[] columns;
    private String[][] data;

    public ModelloTabellaRubrica(String[][] data, String[]columns){
        this.columns = columns;
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex<0 || columnIndex<0) return false;
        if(this.getRowCount()>=rowIndex && this.getColumnCount()>=columnIndex) return this.data[rowIndex][columnIndex];
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
}
