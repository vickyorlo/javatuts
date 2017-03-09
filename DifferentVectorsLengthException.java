public class DifferentVectorsLengthException extends Exception{

    public DifferentVectorsLengthException(){
        System.out.println("Vectors not equal.");
        System.out.println("Please try another valid vector.");
    }

    public DifferentVectorsLengthException(String message){
        System.out.println(message);
        System.out.println("Please try another valid vector.");
    }

    public DifferentVectorsLengthException(Vector a, Vector b){
        System.out.println("Vectors have different lengths.");
        a.print();
        b.print();
        System.out.println("Please try another valid vector.");
    }
}