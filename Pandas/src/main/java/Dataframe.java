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
     */
    public void changeLabelLine(Line line){
        label = line;
    }

    /**
     * Add a line in the dataframe
     *
     * @param line Line to be added
     */
    public void addLine(Line line){
        this.table.add(line);
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
     * @param csvFileName
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
            this.printDataframe();
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
     * @param numbersOfColumns List of line we want to keep
     * @param valueOfLines Values excepted for each column
     * @return The sub data frame
     */
    public Dataframe selectLineWhere(List<Integer> numbersOfColumns, List<String> valueOfLines) throws Line.ExceptionUnknowColumn {
        Dataframe toReturn = new Dataframe();
        toReturn.label = this.label.getSubColumnFromNumber(numbersOfColumns);
        Line l;
        for (int i = 0; i < this.table.size(); i++) {
            l = this.table.get(i).selectLineWhere(numbersOfColumns, valueOfLines);
            if(l != null){
                toReturn.table.add(l);
            }
        }
        return toReturn;
    }

    public class ExceptionWrongColumnType extends Exception {
        public String message;
        public ExceptionWrongColumnType(String message){
            super();
            this.message = message;
        }
        public ExceptionWrongColumnType(){
            super();
            this.message = "";
        }
    }

    /**
     * Return the sum of value in the given column.
     * If the column is of type string the function will raise an exception.
     *
     * @param indexColumn Index of the column to sum
     * @return The sum of the column
     */
    public Double sumOfColumn(Integer indexColumn) throws ExceptionWrongColumnType{
        if(indexColumn < 0 || indexColumn >= this.table.size()){
            throw new ExceptionWrongColumnType("Your index is not in the array");
        }
        try {
            Double result = Double.parseDouble(this.table.get(0).getElementByIndex(indexColumn).getElem().toString());
            for(int i = 1; i < this.table.size(); i++){
                result += Double.parseDouble(this.table.get(i).getElementByIndex(indexColumn).getElem().toString());
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
    public Double sumOfColumnByLabel(String label) throws ExceptionWrongColumnType{
        return sumOfColumn(this.label.getIndex(label));
    }

    /**
     * Get the sub dataframe for the given index list of label of column and their values.
     * For each i, column numbersOfLines[i] has to have the value of valueOfLines[i]
     *
     * @param labelOfColumns List of line we want to keep
     * @param valueOfLines Values excepted for each column
     * @return The sub data frame
     */
    public Dataframe selectLineWhereByLabel(List<String> labelOfColumns, List<String> valueOfLines) throws Line.ExceptionUnknowColumn {
        ArrayList<Integer> numbersOfColumns = new ArrayList<>();
        for(String label: labelOfColumns){
            numbersOfColumns.add(this.label.getIndex(label));
        }
        return selectLineWhere(numbersOfColumns, valueOfLines);
    }

    /**
     * Get the sub dataframe for the given index list of column we want to keep.
     *
     * @param numbersOfColumns The list of index of column we want to keep
     * @return The sub data frame
     */
    public Dataframe getSubDataFrameFromColumnsNumber(List<Integer> numbersOfColumns) {
        Dataframe toReturn = new Dataframe();
        toReturn.label = this.label.getSubColumnFromNumber(numbersOfColumns);
        for (int i = 0; i < this.table.size(); i++) {
            toReturn.table.add(this.table.get(i).getSubColumnFromNumber(numbersOfColumns));
        }
        return toReturn;
    }

    /**
     * Get the sub dataframe for the given label list of column we want to keep.
     *
     * @param labelsOfColumns The list of label of column we want to keep
     * @return The sub data frame
     */
    public Dataframe getSubDataFrameFromColumnsLabel(List<String> labelsOfColumns) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (String s: labelsOfColumns) {
            tmp.add(label.getIndex(s));
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
        this.label.printLine();
        int goal = Math.min(this.table.size(), numberOfLines);
        for(int i = 0; i < goal; i++) {
            this.table.get(i).printLine();
        }
    }

    /**
     * Print the numberOfLines last lines of the data frame.
     * If numberOfLines is greater than the size of the frame,
     * we'll print the entire frame
     *
     * @param numberOfLines The number of lines we want to print
     */
    public void printLastLines(int numberOfLines) {
        this.label.printLine();
        int i = Math.max((this.table.size() - numberOfLines), 0);
        for(; i < this.table.size(); i++) {
            this.table.get(i).printLine();
        }
    }

    /**
     * Print the content of the data frame
     *
     */
    public void printDataframe() {
        System.out.println(this);
    }

    /**
     * Convert the dataframe in string element
     *
     */
    @Override
    public String toString() {
        return "Dataframe : \n" +
                table;
    }

    /**
     * Sort the data frame with multiple given column
     *
     * @param indexColumn List of index of the column to sort
     */
    public void orderBy(final List<Integer> indexColumn) throws ExceptionWrongColumnType{
        //We have to check if each index is in the line
        for(Integer i: indexColumn) {
            if (this.table.size() > 0 && (i < 0 || i >= this.table.get(0).getElements().size())) {
                throw new ExceptionWrongColumnType("Your index is not in the array");
            }
        }
        Collections.sort(this.table, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                int currentIndex = 0;
                while (currentIndex < (indexColumn.size() - 1)) {
                    if (o1.getElementByIndex(indexColumn.get(currentIndex)).compareTo(o2.getElementByIndex(indexColumn.get(currentIndex))) != 0) {
                        return o1.getElementByIndex(indexColumn.get(currentIndex)).compareTo(o2.getElementByIndex(indexColumn.get(currentIndex)));
                    }
                    currentIndex++;
                }
                return o1.getElementByIndex(indexColumn.get(currentIndex)).compareTo(o2.getElementByIndex(indexColumn.get(currentIndex)));
            }
        });

    }

    /**
     * Sort the data frame with the given column
     *
     * @param indexColumn Index of the column to sort
     */
    public void orderBy(final Integer indexColumn) throws ExceptionWrongColumnType{
        if(this.table.size() > 0 && (indexColumn < 0 || indexColumn >= this.table.get(0).getElements().size())){
            throw new ExceptionWrongColumnType("Your index is not in the array");
        }
        Collections.sort(this.table, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.getElementByIndex(indexColumn).compareTo(o2.getElementByIndex(indexColumn));
            }
        });
    }

    /**
     * Sort the data frame with the given column label
     *
     * @param label Label of the column to sort
     */
    public void orderByLabel(final String label) throws ExceptionWrongColumnType{
        this.orderBy(this.label.getIndex(label));
    }

    /**
     * Return the maximum element for a column.
     * If the column does not exist return null
     *
     * @param indexColumn Index of the column
     * @return Element to be returned or null
     */
    public Element maxValueByColumnIndex(int indexColumn){
        if(this.table.size() < 1 || this.table.get(0).getElements().size() <= indexColumn || indexColumn < 0) {
            return null;
        }
        try {
            double d = Double.parseDouble(this.table.get(0).getElementByIndex(indexColumn).getElem().toString());
            Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
            for(int i = 1; i < this.table.size(); i++){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) < 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
            }
            return returnValue;
        } catch (NumberFormatException nfe) {
            Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
            for(int i = 1; i < this.table.size(); i++){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) > 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
            }
            return returnValue;
        }

    }

    /**
     * Return the maximum element for a column.
     * If the column does not exist return null
     *
     * @param columnLabel Label of the column
     * @return Element to be returned or null
     */
    public Element maxValueByLabel(String columnLabel){
        if(this.label == null){
            return null;
        }
        int indexLabel = this.label.getIndex(columnLabel);
        if(indexLabel != -1){
            return maxValueByColumnIndex(indexLabel);
        } else {
            return null;
        }

    }

    /**
     * Return the minimum element for a column.
     * If the column does not exist return null
     *
     * @param indexColumn Index of the column
     * @return Element to be returned or null
     */
    public Element minValueByColumnIndex(int indexColumn){
        if(this.table.size() < 1 || this.table.get(0).getElements().size() <= indexColumn || indexColumn < 0) {
            return null;
        }
        try {
            double d = Double.parseDouble(this.table.get(0).getElementByIndex(indexColumn).getElem().toString());
            Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
            for(int i = 1; i < this.table.size(); i++){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) > 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
            }
            return returnValue;
        } catch (NumberFormatException nfe) {
            Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
            for(int i = 1; i < this.table.size(); i++){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) < 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
            }
            return returnValue;
        }


    }

    /**
     * Return the minimum element for a column.
     * If the column does not exist return null
     *
     * @param columnLabel Label of the column
     * @return Element to be returned or null
     */
    public Element minValueByLabel(String columnLabel){
        if(this.label == null){
            return null;
        }
        int indexLabel = this.label.getIndex(columnLabel);
        if(indexLabel != -1){
            return minValueByColumnIndex(indexLabel);
        } else {
            return null;
        }

    }

    /**
     * Return the mean of the element for a column given by her index.
     * If the column does not exist or the column does not contain number return null
     *
     * @param indexColumn Index of the column
     * @return Element to be returned or null
     */
    public Element meanValueByIndex(int indexColumn){
        if(this.table.size() < 1
                || this.table.get(0).getElements().size() <= indexColumn
                || indexColumn < 0) {
            return null;
        }
        try {
            Double mean = 0.0;
            Integer numberOfElement = this.table.size();
            for(int i = 0; i < this.table.size(); i++){
                mean += Double.parseDouble(this.table.get(i).getElementByIndex(indexColumn).getElem().toString());
            }
            Element returnValue = new Element(mean/numberOfElement);
            return returnValue;
        } catch (NumberFormatException nfe) {
            return null;
        }

    }

    /**
     * Return the mean of the element for a column given by her label.
     * If the column does not exist or the column does not contain number return null
     *
     * @param columnLabel Label of the column
     * @return Element to be returned or null
     */
    public Element meanValueByLabel(String columnLabel){
        if(this.label == null){
            return null;
        }
        int indexLabel = this.label.getIndex(columnLabel);
        if(indexLabel != -1){
            return meanValueByIndex(indexLabel);
        } else {
            return null;
        }
    }

    /**
     * Main function
     */
    public static void main(String args[]) throws Line.ExceptionUnknowColumn {
        if(args.length > 0) {
            Dataframe df = new Dataframe(args[0]);

            System.out.println("----------------");
            ArrayList<Integer> column = new ArrayList<>();
            column.add(1);
            ArrayList<String> columnValue = new ArrayList<>();
            columnValue.add("Charlotte");

            Dataframe dSub = df.selectLineWhere(column, columnValue);
            dSub.printDataframe();

        }
    }

}
