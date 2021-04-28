import Pandas.Dataframe;

public class ExampleDataframe {
    public static void main(String args[]) {
            Dataframe df = new Dataframe("fichier_test.csv");
            df.printDataframe();
    }
}