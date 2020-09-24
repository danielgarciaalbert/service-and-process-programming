package data;

public class NegativeSubtractException extends Exception {
    int n1, n2;
    public NegativeSubtractException (int n1, int n2) {
        super("\"NegativeSubtractException: \\'\" + n1 + \" - \" + n2 + \"\\' result is negative.\";");
        this.n1 = n1;
        this.n2 = n2;
    }
}
