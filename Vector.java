import java.io.*;
import java.math.*;
import java.util.*;

public class Vector{
    List<Double> elements = new ArrayList<Double>();

    public Vector()
    {}
    public Vector(Vector a){
        this.elements.addAll(a.elements);
    }
    public Vector(List<Double> elements){
        this.elements.addAll(elements);
    }
    public double Length(){
        return elements.size();
    }
    public String toString(){
        return elements.toString();
    }
    public Vector Add(Vector a) throws DifferentVectorsLengthException {
        if (this.Length() != a.Length())
        {
            throw new DifferentVectorsLengthException(this,a);
        }
        for (int i=0;i<elements.size();i++) {
            this.elements.set(i,this.elements.get(i)+a.elements.get(i));
        }
        return this;
    }
    public static void SaveToFile(String filename, Vector vec) throws IOException{
        File outputFile = new File(filename);
        outputFile.createNewFile();

        FileWriter writer = new FileWriter(outputFile);
        writer.write(Double.toString(vec.Length()));
        writer.flush();
        writer.close();
    }
    public void Read(){
        elements = new ArrayList<Double>();
        String userVectorInput = new String();
        Scanner in = new Scanner(System.in);
        Scanner findDoubles;
        double element = 0;
        while(true)
        {
            userVectorInput = in.nextLine();
            findDoubles = new Scanner(userVectorInput);
            try 
            {
                while(true)
                {
                    element = findDoubles.nextDouble();
                    elements.add(element);
                }
            }
            catch (InputMismatchException e)
            {
                if (elements.size() == 0)
                {
                    System.out.println("Invalid input. Please enter a vector as follows:\n1.0 3.0 2.0");
                    continue;
                }
                else
                {
                    System.out.println("Non-numerical input detected. Anything after it has been ignored.");
                    break;
                }
            }
            catch (NoSuchElementException e)
            {
                if (elements.size() == 0)
                {
                    System.out.println("Invalid input. Please enter a vector as follows:\n1.0 3.0 2.0");
                    continue;
                }
                else
                {
                    break;
                }
            }
        }
        System.out.println("Input: " + elements);

    }
    public static void main(String[] args)
    {

        Vector vec1 = new Vector();
        Vector vec2 = new Vector();

        do
        {
            vec1.Read();
            vec2.Read();
            System.out.println("bep");
            try{
                Vector added = new Vector(vec1.Add(vec2));
                System.out.print(added.toString());
                SaveToFile("vector.txt", added);
                break;
            }
            catch (DifferentVectorsLengthException e){
                System.out.println("These two vectors are not of equal size!: ");
                System.out.print(e);
                continue;
            }
            catch (IOException e){
                System.out.println(e);
            }
        } while (true);

    }
}
