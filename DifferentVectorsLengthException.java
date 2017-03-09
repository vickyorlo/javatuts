public class DifferentVectorsLengthException extends Exception{
    Vector a,b;
    public DifferentVectorsLengthException(){
            Vector a,b = new Vector();
        }
    

    public DifferentVectorsLengthException(Vector a, Vector b){
        this.a = new Vector(a);
        this.b = new Vector(b);
    }

    public String toString()
    {
        return a.toString()+","+b.toString();
    }
}