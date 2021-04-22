import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
                    /**
                     * Check if data is a numeric value
                     * */
                    if (val == null) {
                        this.label.add(new Element(""));;
                    }
                    try {
                        double d = Double.parseDouble(val);
                        this.label.add(new Element(d));
                    } catch (NumberFormatException nfe) {
                        this.label.add(new Element(val));
                    }

                }
            }

            while ((ligne = br.readLine()) != null) {
                ArrayList<Element> tmp = new ArrayList<>();
                String[] data = ligne.split(",");
                for (String val : data) {
                    /**
                     * Check if data is a numeric value
                     * */
                    if (val == null) {
                        tmp.add(new Element(""));;
                    }
                    try {
                        double d = Double.parseDouble(val);
                        tmp.add(new Element(d));
                    } catch (NumberFormatException nfe) {
                        tmp.add(new Element(val));
                    }
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

    /***
     * Statistics functions
     *
     * For numbers value :
     *  - Max
     *  - Min
     *  - Sum
     *
     * For String value :
     *  - Max
     *  - Min
     *
     * */

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
        Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
        for(int i = 1; i < this.table.size(); i++){
            if(returnValue.getElem() instanceof String){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) < 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
            } else {
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) > 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
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
        Element returnValue = this.table.get(0).getElementByIndex(indexColumn);
        for(int i = 1; i < this.table.size(); i++){
            if(returnValue.getElem() instanceof String){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) > 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
            } else {
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(indexColumn).getElem()) < 0){
                    returnValue = this.table.get(i).getElementByIndex(indexColumn);
                }
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
                || indexColumn < 0
                || this.table.get(0).getElementByIndex(indexColumn).getElem() instanceof String) {
            return null;
        }
        Double mean = 0.0;
        Integer numberOfElement = this.table.size();
        for(int i = 0; i < this.table.size(); i++){
            mean += Double.parseDouble(this.table.get(i).getElementByIndex(indexColumn).getElem().toString());
        }
        Element returnValue = new Element(mean/numberOfElement);
        return returnValue;
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
     *
     */
    public static void main(String args[]) {
        if(args.length > 0) {
            Dataframe df = new Dataframe(args[0]);

            System.out.println("----------------");
            Element eSexe = df.meanValueByIndex(0);
            if(eSexe == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for sexe " + eSexe.getElem().toString());
            }
            System.out.println("----------------");
            Element eName = df.meanValueByIndex(1);
            if(eName == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for Name " + eName.getElem().toString());
            }
            System.out.println("----------------");
            Element eDate = df.meanValueByIndex(2);
            if(eDate == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for date " + eDate.getElem().toString());
            }
            System.out.println("----------------");
            Element eNull = df.meanValueByIndex(5);
            if(eNull == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for sexe " + eNull.getElem().toString());
            }

            System.out.println("// Test Max value by label ----------------------------------------------------");
            Element eSexeMaxLabel = df.meanValueByLabel("Sexe");
            if(eSexeMaxLabel == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for sexe " + eSexeMaxLabel.getElem().toString());
            }
            System.out.println("----------------");
            Element eNameMaxLabel = df.meanValueByLabel("Prénom");
            if(eNameMaxLabel == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for sexe " + eNameMaxLabel.getElem().toString());
            }
            System.out.println("----------------");
            Element eDateMaxLabel = df.meanValueByLabel("Année de naissance");
            if(eDateMaxLabel == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for sexe " + eDateMaxLabel.getElem().toString());
            }
            System.out.println("----------------");
            Element eNullMaxLabel = df.meanValueByLabel("bwa");
            if(eNullMaxLabel == null){
                System.out.println("Null pointer returned");
            } else {
                System.out.println("Value of element for sexe " + eNullMaxLabel.getElem().toString());
            }
        }
    }

}
