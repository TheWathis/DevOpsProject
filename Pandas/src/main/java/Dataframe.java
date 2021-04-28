import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dataframe {

    private Line label;
    private final ArrayList<Line> table;

    /**
     * Change the label line
     *
     * @param line New line of label
     * @throws ExceptionSizeNotEqual if length of line aren't equal to label length
     */
    public void changeLabelLine(Line line) throws ExceptionSizeNotEqual {
        if (table.isEmpty()) {
            this.label = line;
        } else {
            if (this.table.get(0).getSize() == line.getSize()) {
                this.label = line;
            } else {
                throw new ExceptionSizeNotEqual("The size of the line isn't equal to the size of label");
            }
        }
    }

    /**
     * Add a line in the dataframe
     * You can't add an empty line
     *
     * @param line Line to be added
     * @throws ExceptionSizeNotEqual if length of line aren't equal to label length
     */
    public void addLine(Line line) throws ExceptionSizeNotEqual {
        if (this.label.getSize() == line.getSize()) {
            this.table.add(line);
        } else {
            throw new ExceptionSizeNotEqual("The size of the line isn't equal to the size of label");
        }
    }

    /**
     * Get the list of line in the dataframe
     *
     * @return List of line
     */
    public ArrayList<Line> getLines(){
        return this.table;
    }

    /**
     * Constructor
     * */
    public Dataframe() {
        label = new Line();
        table = new ArrayList<>();
    }

    /**
     * Constructor with given CSV fileName
     * @param csvFileName - path of the csv file
     * */
    public Dataframe(String csvFileName) {
        label = new Line();
        table = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFileName));
            String ligne = br.readLine();
            if (ligne != null) {
                String[] data = ligne.split(",");
                for (String val : data) {
                    this.label.add(new Element(val));
                }
            }
            while ((ligne = br.readLine()) != null) {
                ArrayList<Element> tmp = new ArrayList<>();
                String[] data = ligne.split(",");
                for (String val : data) {
                    tmp.add(new Element(val));
                }
                this.table.add(new Line(this.table.size(), tmp));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the sub dataframe for the given index list of lines.
     *
     * @param numbersOfLines List of line we want to keep
     * @return The sub data frame
     */
    public Dataframe getSubDataFrameFromLines(List<Integer> numbersOfLines) {
        Dataframe toReturn = new Dataframe();
        toReturn.label = this.label;
        for (int i: numbersOfLines) {
            toReturn.table.add(this.table.get(i));
        }
        return toReturn;
    }

    /**
     * Get the sub dataframe for the given index list of column and their values.
     * For each i, column numbersOfLines[i] has to have the value of valueOfLines[i]
     * An exception ExceptionUnknowColumn is thrown if the index of column is wrong.
     *
     * [ A / B / C / D ]
     * [ & / é / " / ' ]
     * [ = / ) / " / é ]
     * [ & / é / - / ' ]
     * selectLineWhere([1], [é])
     * [ A / B / C / D ]
     * [ & / é / " / ' ]
     * [ & / é / - / ' ]
     *
     * @param numbersOfColumns List of line we want to keep
     * @param valueOfLines Values excepted for each column
     * @return The sub data frame
     */
    public Dataframe selectLineWhere(List<Integer> numbersOfColumns, List<String> valueOfLines) throws ExceptionSizeNotEqual, ExceptionWrongIndex, ExceptionUnknownColumn {
        if (numbersOfColumns.size() != valueOfLines.size()) {
            Dataframe toReturn = new Dataframe();
            toReturn.label = this.label.getSubLineFromColumnNumber(numbersOfColumns);
            Line l;
            for (int i = 0; i < this.table.size(); i++) {
                l = this.table.get(i).selectLineWhere(numbersOfColumns, valueOfLines);
                if(l != null){
                    toReturn.table.add(l);
                }
            }
            return toReturn;
        } else {
            throw new ExceptionSizeNotEqual("Size of both list not equals");
        }
    }

    /**
     * Return the sum of value in the given column.
     * If the column is of type string the function will raise an exception.
     *
     * @param indexColumn Index of the column to sum
     * @return The sum of the column
     */
    public Double sumOfColumn(Integer indexColumn) throws ExceptionWrongColumnType, ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        if (indexColumn < 0 || this.label.getSize() <= indexColumn) {
            throw new ExceptionWrongIndex();
        }
        if (this.table.size() < 1) {
            throw new ExceptionOperationOnEmptyTable();
        }
        try {
            Double result = Double.parseDouble(this.table.get(0).getElementByIndex(indexColumn).getData().toString());
            for(int i = 1; i < this.table.size(); i++){
                result += Double.parseDouble(this.table.get(i).getElementByIndex(indexColumn).getData().toString());
            }
            return result;
        } catch (NumberFormatException nfe) {
            throw new ExceptionWrongColumnType("The given index show a column that cannot be parse as a Double");
        }
    }

    /**
     * Return the sum of value in the given column.
     * If the column is of type string the function will raise an exception.
     *
     * @param label Label of the column to sum
     * @return The sum of the column
     */
    public Double sumOfColumnByLabel(String label) throws ExceptionWrongColumnType, ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        return sumOfColumn(this.label.getIndexFromDataName(label));
    }

    /**
     * Get the sub dataframe for the given index list of label of column and their values.
     * For each i, column numbersOfLines[i] has to have the value of valueOfLines[i]
     *
     * @param labelOfColumns List of line we want to keep
     * @param valueOfLines Values excepted for each column
     * @return The sub data frame
     */
    public Dataframe selectLineWhereByLabel(List<String> labelOfColumns, List<String> valueOfLines) throws ExceptionSizeNotEqual, ExceptionWrongIndex, ExceptionUnknownColumn {
        ArrayList<Integer> numbersOfColumns = new ArrayList<>();
        for(String label: labelOfColumns){
            int index = this.label.getIndexFromDataName(label);
            if (index == -1) {
                throw new ExceptionUnknownColumn("Index invalid");
            }
            numbersOfColumns.add(index);
        }
        return selectLineWhere(numbersOfColumns, valueOfLines);
    }

    /**
     * Get the sub dataframe for the given index list of column we want to keep.
     *
     * @param numbersOfColumns The list of index of column we want to keep
     * @return The sub data frame
     */
    public Dataframe getSubDataFrameFromColumnsNumber(List<Integer> numbersOfColumns) throws ExceptionWrongIndex {
        Dataframe toReturn = new Dataframe();
        toReturn.label = this.label.getSubLineFromColumnNumber(numbersOfColumns);
        for (int i = 0; i < this.table.size(); i++) {
            toReturn.table.add(this.table.get(i).getSubLineFromColumnNumber(numbersOfColumns));
        }
        return toReturn;
    }

    /**
     * Get the sub dataframe for the given label list of column we want to keep.
     *
     * @param labelsOfColumns The list of label of column we want to keep
     * @return The sub data frame
     */
    public Dataframe getSubDataFrameFromColumnsLabel(List<String> labelsOfColumns) throws ExceptionWrongIndex {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (String s: labelsOfColumns) {
            tmp.add(label.getIndexFromDataName(s));
        }
        return getSubDataFrameFromColumnsNumber(tmp);
    }

    /**
     * Print the numberOfLines first lines of the data frame.
     * If numberOfLines is greater than the size of the frame,
     * we'll print the entire frame
     *
     * @param numberOfLines The number of lines we want to print
     */
    public void printFirstLines(int numberOfLines) {
        String tmp = this.label.toString();
        int goal = Math.min(this.table.size(), numberOfLines);
        for(int i = 0; i < goal; i++) {
            tmp = tmp .concat(this.table.get(i).toString());
        }
        System.out.println(tmp);
    }

    /**
     * Print the numberOfLines last lines of the data frame.
     * If numberOfLines is greater than the size of the frame,
     * we'll print the entire frame
     *
     * @param numberOfLines The number of lines we want to print
     */
    public void printLastLines(int numberOfLines) {
        String tmp = this.label.toString();
        int i = Math.max((this.table.size() - numberOfLines), 0);
        for(; i < this.table.size(); i++) {
            tmp = tmp .concat(this.table.get(i).toString());
        }
        System.out.println(tmp);
    }

    /**
     * Convert the dataframe in string element
     *
     */
    @Override
    public String toString() {
        String tmp = this.label.toString();
        for (Line l: this.table) {
            tmp = tmp.concat(l.toString());
        }
        return tmp;
    }

    /**
     * Sort the data frame with multiple given column
     *
     * @param indexColumn List of index of the column to sort
     */
    public void orderBy(final List<Integer> indexColumn) throws ExceptionOperationOnEmptyTable, ExceptionWrongIndex {
        //We have to check if each index is in the line
        if (this.table.size() < 1) {
            throw new ExceptionOperationOnEmptyTable();
        }
        for(Integer i: indexColumn) {
            if (i < 0 || this.label.getSize() <= i) {
                throw new ExceptionWrongIndex();
            }
        }
        Collections.sort(this.table, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                int currentIndex = 0;
                try {
                    while (currentIndex < (indexColumn.size() - 1)) {
                        if (o1.getElementByIndex(indexColumn.get(currentIndex)).compareTo(o2.getElementByIndex(indexColumn.get(currentIndex))) != 0) {
                            return o1.getElementByIndex(indexColumn.get(currentIndex)).compareTo(o2.getElementByIndex(indexColumn.get(currentIndex)));
                        }
                        currentIndex++;
                    }
                    return o1.getElementByIndex(indexColumn.get(currentIndex)).compareTo(o2.getElementByIndex(indexColumn.get(currentIndex)));
                } catch (ExceptionWrongIndex exceptionWrongIndex) {
                    return 0;
                }
            }
        });

    }

    /**
     * Sort the data frame with the given column
     *
     * @param indexColumn Index of the column to sort
     */
    public void orderBy(final Integer indexColumn) throws ExceptionOperationOnEmptyTable, ExceptionWrongIndex {
        if (indexColumn < 0 || this.label.getSize() <= indexColumn) {
            throw new ExceptionWrongIndex();
        }
        if (this.table.size() < 1) {
            throw new ExceptionOperationOnEmptyTable();
        }
        Collections.sort(this.table, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                try {
                    return o1.getElementByIndex(indexColumn).compareTo(o2.getElementByIndex(indexColumn));
                } catch (ExceptionWrongIndex exceptionWrongIndex) {
                    return 0;
                }
            }
        });
    }

    /**
     * Sort the data frame with a list of label
     *
     * @param labelList List of label of the column to sort
     */
    public void orderByLabel(final List<String> labelList) throws ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        ArrayList<Integer> listIndexColumn = new ArrayList<>();
        for(String labelName : labelList){
            listIndexColumn.add(this.label.getIndexFromDataName(labelName));
        }
        this.orderBy(listIndexColumn);
    }

    /**
     * Sort the data frame with the given column label
     *
     * @param label Label of the column to sort
     */
    public void orderByLabel(final String label) throws ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        this.orderBy(this.label.getIndexFromDataName(label));
    }

    /**
     * Return the maximum element for a column.
     * If the column does not exist return null
     *
     * @param indexColumn Index of the column
     * @return Element to be returned
     * @throws ExceptionWrongIndex if the index isn't correct
     * @throws ExceptionOperationOnEmptyTable if the table is empty
     */
    public Element maxValueByColumnIndex(int indexColumn) throws ExceptionOperationOnEmptyTable, ExceptionWrongIndex {
        if (indexColumn < 0 || this.label.getSize() <= indexColumn) {
            throw new ExceptionWrongIndex();
        }
        if (this.table.size() < 1) {
            throw new ExceptionOperationOnEmptyTable();
        }
        Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
        for(int i = 1; i < this.table.size(); i++){
            if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getData()) < 0){
                returnValue = this.table.get(i).getElementByIndex(indexColumn);
            }
        }
        return returnValue;
    }

    /**
     * Return the maximum element for a column.
     * If the column does not exist return null
     *
     * @param columnLabel Label of the column
     * @return Element to be returned or null
     * @throws ExceptionNoLabel if the label is empty
     * @throws ExceptionUnknownColumn if the columnLabel is wrong
     * @throws ExceptionWrongIndex shouldn't pop
     * @throws ExceptionOperationOnEmptyTable if the table is empty
     *
     */
    public Element maxValueByLabel(String columnLabel) throws ExceptionNoLabel, ExceptionUnknownColumn, ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        if(this.label.getSize() == 0){
            throw new ExceptionNoLabel();
        }
        int indexLabel = this.label.getIndexFromDataName(columnLabel);
        if (indexLabel == -1) {
            throw new ExceptionUnknownColumn("Column label is unknown");
        }
        return maxValueByColumnIndex(indexLabel);

    }

    /**
     * Return the minimum element for a column.
     * If the column does not exist return null
     *
     * @param indexColumn Index of the column
     * @return Element to be returned or null
     */
    public Element minValueByColumnIndex(int indexColumn) throws ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        if (indexColumn < 0 || this.label.getSize() <= indexColumn) {
            throw new ExceptionWrongIndex();
        }
        if (this.table.size() < 1) {
            throw new ExceptionOperationOnEmptyTable();
        }
        Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
        for(int i = 1; i < this.table.size(); i++){
            if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getData()) > 0){
                returnValue = this.table.get(i).getElementByIndex(indexColumn);
            }
        }
        return returnValue;
    }

    /**
     * Return the minimum element for a column.
     * If the column does not exist return null
     *
     * @param columnLabel Label of the column
     * @return Element to be returned or null
     */
    public Element minValueByLabel(String columnLabel) throws ExceptionNoLabel, ExceptionUnknownColumn, ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        if(this.label.getSize() == 0){
            throw new ExceptionNoLabel();
        }
        int indexLabel = this.label.getIndexFromDataName(columnLabel);
        if (indexLabel == -1) {
            throw new ExceptionUnknownColumn("Column label is unknown");
        }
        return minValueByColumnIndex(indexLabel);

    }

    /**
     * Return the mean of the element for a column given by her index.
     * If the column does not exist or the column does not contain number return null
     *
     * @param indexColumn Index of the column
     * @return Element to be returned
     */
    public Element meanValueByIndex(int indexColumn) throws ExceptionWrongIndex, ExceptionOperationOnEmptyTable, ExceptionWrongColumnType {
        if (indexColumn < 0 || this.label.getSize() <= indexColumn) {
            throw new ExceptionWrongIndex();
        }
        if (this.table.size() < 1) {
            throw new ExceptionOperationOnEmptyTable();
        }
        try {
            Double mean = 0.0;
            Integer numberOfElement = this.table.size();
            for(int i = 0; i < this.table.size(); i++){
                mean += Double.parseDouble(this.table.get(i).getElementByIndex(indexColumn).getData().toString());
            }
            Element returnValue = new Element(mean/numberOfElement);
            return returnValue;
        } catch (NumberFormatException nfe) {
            throw new ExceptionWrongColumnType("Can't preform this operation on the type of the column");
        }

    }

    /**
     * Return the mean of the element for a column given by her label.
     * If the column does not exist or the column does not contain number return null
     *
     * @param columnLabel Label of the column
     * @return Element to be returned
     */
    public Element meanValueByLabel(String columnLabel) throws ExceptionNoLabel, ExceptionUnknownColumn, ExceptionWrongColumnType, ExceptionWrongIndex, ExceptionOperationOnEmptyTable {
        if(this.label.getSize() == 0){
            throw new ExceptionNoLabel();
        }
        int indexLabel = this.label.getIndexFromDataName(columnLabel);
        if (indexLabel == -1) {
            throw new ExceptionUnknownColumn("Column label is unknown");
        }
        return meanValueByIndex(indexLabel);
    }

    /**
     * Main function
     */
    public static void main(String args[]) {
        if(args.length > 0) {
            Dataframe df = new Dataframe(args[0]);
            System.out.println(df);
        }
    }
}
