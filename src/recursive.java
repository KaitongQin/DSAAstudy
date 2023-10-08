public class recursive{
    public static void main(String[] args){
        Recursive(8);
    }
    static void Recursive(int n) {
        if(n <= 0)
            return;
        if(n % 2 == 0) {
            System.out.print(n);
            Recursive(n - 1);
        } else {
            Recursive(n - 1);
            System.out.print(n);
        }
    }
}
