import pandas.Dataframe;
import java.util.ArrayList;


public class ExampleDataframe {
    public static void main(String args[]) {
        Dataframe df = new Dataframe("docker/fichier_test.csv");
        System.out.println("Affichage d’un dataframe :\n");
        System.out.println(df);
        

        try {
            

            System.out.println("printFirstLines(2) :");
            df.printFirstLines(2);

            System.out.println("\nprintLastLines(2) :");
            df.printLastLines(2);
            
            System.out.println("##############################################################\n");
            System.out.println("Sélection dans un dataframe :\n");
            System.out.println("getSubDataFrameFromColumnsNumber(0,1) :");
            ArrayList<Integer> column1 = new ArrayList<>();
		    column1.add(0);
		    column1.add(1);
            Dataframe dfSub = df.getSubDataFrameFromColumnsNumber(column1);
            System.out.println(dfSub);

            System.out.println("getSubDataFrameFromLines(0,1) :\n");
            ArrayList<Integer> line = new ArrayList<>();
		    line.add(0);
		    line.add(1);
            Dataframe dfSub2 = df.getSubDataFrameFromLines(line);
            System.out.println(dfSub2);

            System.out.println("selectLineWhere(column = 1, value = Alponse) :");
            ArrayList<Integer> column2 = new ArrayList<>();
		    column2.add(1); //"Prénom"
		    ArrayList<String> columnValue2 = new ArrayList<>();
		    columnValue2.add("Alphonse");
		    Dataframe selectDataframe2 = df.selectLineWhere(column2, columnValue2);
            System.out.println(selectDataframe2);

            System.out.println("getSubDataFrameFromColumnsLabel(Prénom, Année de naissance) :\n");
            ArrayList<String> nameOfColumn = new ArrayList<>();
		    nameOfColumn.add("Prénom");
		    nameOfColumn.add("Année de naissance");
		    Dataframe df2 = df.getSubDataFrameFromColumnsLabel(nameOfColumn);
            System.out.println(df2);

            System.out.println("selectLineWhereByLabel : Prénom = Béatrice");
            ArrayList<String> column = new ArrayList<>();
		    column.add("Prénom");
		    ArrayList<String> columnValue = new ArrayList<>();
		    columnValue.add("Béatrice");
		    Dataframe selectDataframe = df.selectLineWhereByLabel(column, columnValue);
            System.out.println(selectDataframe);


            System.out.println("##############################################################\n");
            System.out.println("Statistiques sur un dataframe :\n");

            
            
            System.out.println("meanValueByIndex(2) :");
            System.out.println(df.meanValueByIndex(2));
            System.out.println("meanValueByLabel(Année de naissance) :");
            System.out.println(df.meanValueByLabel("Année de naissance"));
            
            System.out.println("\nminValueByLabel(Année de naissance) :");
            System.out.println(df.minValueByLabel("Année de naissance"));
            
            System.out.println("\nmaxValueByLabel(Année de naissance) :");
            System.out.println(df.maxValueByLabel("Année de naissance"));
            System.out.println("maxValueByColumnIndex(2) :");
            System.out.println(df.maxValueByColumnIndex(2));
            
            System.out.println("\nsumOfColumnByLabel(Année de naissance) :");
            System.out.println(df.sumOfColumnByLabel("Année de naissance"));
            System.out.println("sumOfColumn(2) :");
            System.out.println(df.sumOfColumn(2));

            System.out.println("\norderByLabel(Année de naissance) :\n");
            df.orderByLabel("Année de naissance");
            System.out.println(df);
            
            System.out.println("\norderBy(colonne (2,0) ) :");
            ArrayList<Integer> listOfColumn = new ArrayList<>();
		    listOfColumn.add(2);
		    listOfColumn.add(0);
            df.orderBy(listOfColumn);
            System.out.println(df);

            

            
            

            
            
            
        } catch (Exception e) { 
            e.printStackTrace();
        }
        
    }
}