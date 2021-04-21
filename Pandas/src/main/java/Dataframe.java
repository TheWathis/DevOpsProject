import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dataframe {

    private Line label;
    private final ArrayList<Line> table;

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
                        df.label.add(new Element(val));
                    }
                }

                while ((ligne = br.readLine()) != null) {
                    ArrayList<Element> tmp = new ArrayList<>();
                    String[] data = ligne.split(",");
                    for (String val : data) {
                        tmp.add(new Element(val));
                    }
                    df.table.add(new Line(df.table.size(), tmp));
                }
                df.printDataframe();
                System.out.println("----------------");
                df.printFirstLines(2);
                System.out.println("----------------");
                df.printFirstLines(15);
                System.out.println("----------------");
                df.printLastLines(2);
                System.out.println("----------------");
                df.printLastLines(15);
                System.out.println("################");
                Dataframe dfL = df.getSubDataFrameFromLines(new ArrayList<Integer>(Arrays.asList(0, 2)));
                System.out.println("################");
                dfL.printFirstLines(2);
                System.out.println("----------------");
                dfL.printFirstLines(15);
                System.out.println("----------------");
                dfL.printLastLines(2);
                System.out.println("----------------");
                dfL.printLastLines(15);
                System.out.println("################");
                Dataframe dfC = df.getSubDataFrameFromColumnsNumber(new ArrayList<Integer>(Arrays.asList(0, 2)));
                dfC.printDataframe();
                System.out.println("################");
                dfC.printFirstLines(2);
                System.out.println("----------------");
                dfC.printFirstLines(15);
                System.out.println("----------------");
                dfC.printLastLines(2);
                System.out.println("----------------");
                dfC.printLastLines(15);
                System.out.println("################");
                Dataframe dfCl = df.getSubDataFrameFromColumnsLabel(new ArrayList<String>(Arrays.asList("Sexe", "Année de naissance")));
                System.out.println("################");
                dfCl.printFirstLines(2);
                System.out.println("----------------");
                dfCl.printFirstLines(15);
                System.out.println("----------------");
                dfCl.printLastLines(2);
                System.out.println("----------------");
                dfCl.printLastLines(15);

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
