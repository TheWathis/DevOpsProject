import pandas.Dataframe;

public class ExampleDataframe {
    public static void main(String args[]) {
        Dataframe df = new Dataframe("docker/fichier_test.csv");
        System.out.println(df);
        try {
            System.out.println("meanValueByIndex(2) :");
            System.out.println(df.meanValueByIndex(2));
            System.out.println("\nmeanValueByLabel(Année de naissance) :");
            System.out.println(df.meanValueByLabel("Année de naissance"));
            System.out.println("\nminValueByLabel(Année de naissance) :");
            System.out.println(df.minValueByLabel("Année de naissance"));
            
        } catch (Exception e) { 
            e.printStackTrace();
        }
        
    }
}