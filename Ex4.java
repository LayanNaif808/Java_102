public class Ex4 {

    public static void main(String[] args) {

        // Try block to execute code that might cause an error
        try {

            int result = 10 / 0; 
            System.out.println(result);

        // Catch block to handle the specific ArithmeticException (division by zero)
        } catch (ArithmeticException e) {

            System.out.println("Error: Division by zero."); 

        }
    }
}

