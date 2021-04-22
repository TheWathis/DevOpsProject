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

    public Dataframe() {
        label = new Line();
        table = new ArrayList<>();
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
    public Element maxValueByColumnIndex(int numColumn){
        if(this.table.size() < 1 || this.table.get(0).getElements().size() <= numColumn) {
            return null;
        }
        Element returnValue = this.table.get(0).getElementByIndex(numColumn);
        for(int i = 1; i < this.table.size(); i++){
            if(returnValue.getElem() instanceof String){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(numColumn).getElem()) < 0){
                    returnValue = this.table.get(i).getElementByIndex(numColumn);
                }
            } else {
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(numColumn).getElem()) > 0){
                    returnValue = this.table.get(i).getElementByIndex(numColumn);
                }
            }
        }
        return returnValue;
    }

    public Element maxValueByLabel(String label){
        if(this.label == null){
            return null;
        }
        int indexLabel = this.label.getIndex(label);
        if(indexLabel != -1){
            return maxValueByColumnIndex(indexLabel);
        } else {
            return null;
        }

    }

    public Element minValueByColumnIndex(int numColumn){
        if(this.table.size() < 1 || this.table.get(0).getElements().size() <= numColumn) {
            return null;
        }
        Element returnValue = this.table.get(0).getElementByIndex(numColumn);
        for(int i = 1; i < this.table.size(); i++){
            if(returnValue.getElem() instanceof String){
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(numColumn).getElem()) > 0){
                    returnValue = this.table.get(i).getElementByIndex(numColumn);
                }
            } else {
                if(returnValue.compareTo(this.table.get(i).getElementByIndex(numColumn).getElem()) < 0){
                    returnValue = this.table.get(i).getElementByIndex(numColumn);
                }
            }

        }
        return returnValue;
    }

    public Element minValueByLabel(String label){
        if(this.label == null){
            return null;
        }
        int indexLabel = this.label.getIndex(label);
        if(indexLabel != -1){
            return minValueByColumnIndex(indexLabel);
        } else {
            return null;
        }

    }
    /**
     * Main function
     *
     */
    public static void main(String args[]) {
        Dataframe df = new Dataframe();
        if(args.length > 0) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(args[0]));

                String ligne = br.readLine();
                if (ligne != null) {
                    String[] data = ligne.split(",");
                    for (String val : data) {
                        /**
                         * Check if data is a numeric value
                         * */
                        if (val == null) {
                            df.label.add(new Element(""));;
                        }
                        try {
                            double d = Double.parseDouble(val);
                            df.label.add(new Element(d));
                        } catch (NumberFormatException nfe) {
                            df.label.add(new Element(val));
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
                    df.table.add(new Line(df.table.size(), tmp));
                }
                df.printDataframe();
                System.out.println("----------------");
                Element eSexe = df.maxValueByColumnIndex(0);
                if(eSexe == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eSexe.getElem().toString());
                }
                System.out.println("----------------");
                Element eName = df.maxValueByColumnIndex(1);
                System.out.println("Value of element for name " + eName.getElem().toString());
                System.out.println("----------------");
                Element eDate = df.maxValueByColumnIndex(2);
                System.out.println("Value of element for date " + eDate.getElem().toString());
                System.out.println("----------------");
                Element eNull = df.maxValueByColumnIndex(5);
                if(eNull == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eNull.getElem().toString());
                }


                System.out.println("// Test Min value by index ----------------------------------------------------");
                Element eSexeMin = df.minValueByColumnIndex(0);
                if(eSexeMin == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eSexeMin.getElem().toString());
                }
                System.out.println("----------------");
                Element eNameMin = df.minValueByColumnIndex(1);
                System.out.println("Value of element for name " + eNameMin.getElem().toString());
                System.out.println("----------------");
                Element eDateMin = df.minValueByColumnIndex(2);
                System.out.println("Value of element for date " + eDateMin.getElem().toString());
                System.out.println("----------------");
                Element eNullMin = df.minValueByColumnIndex(5);
                if(eNullMin == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eNullMin.getElem().toString());
                }


                System.out.println("// Test Max value by label ----------------------------------------------------");
                Element eSexeMaxLabel = df.maxValueByLabel("Sexe");
                if(eSexeMaxLabel == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eSexeMaxLabel.getElem().toString());
                }
                System.out.println("----------------");
                Element eNameMaxLabel = df.maxValueByLabel("Prénom");
                System.out.println("Value of element for name " + eNameMaxLabel.getElem().toString());
                System.out.println("----------------");
                Element eDateMaxLabel = df.maxValueByLabel("Année de naissance");
                System.out.println("Value of element for date " + eDateMaxLabel.getElem().toString());
                System.out.println("----------------");
                Element eNullMaxLabel = df.maxValueByLabel("bwa");
                if(eNullMaxLabel == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eNullMaxLabel.getElem().toString());
                }


                System.out.println("// Test Min value by label ----------------------------------------------------");
                Element eSexeMinLabel = df.minValueByLabel("Sexe");
                if(eSexeMinLabel == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eSexeMinLabel.getElem().toString());
                }
                System.out.println("----------------");
                Element eNameMinLabel = df.minValueByLabel("Prénom");
                System.out.println("Value of element for name " + eNameMinLabel.getElem().toString());
                System.out.println("----------------");
                Element eDateMinLabel = df.minValueByLabel("Année de naissance");
                System.out.println("Value of element for date " + eDateMinLabel.getElem().toString());
                System.out.println("----------------");
                Element eNullMinLabel = df.minValueByLabel("Test");
                if(eNullMinLabel == null){
                    System.out.println("Null pointer returned");
                } else {
                    System.out.println("Value of element for sexe " + eNullMinLabel.getElem().toString());
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
