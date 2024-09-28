import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String num1, num2;

        num1 = JOptionPane.showInputDialog(null, "Choose the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Choose the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);

        if (b == 0) {
            JOptionPane.showMessageDialog(null, "Divisor cannot equal to 0", "Syntax error", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Sum = " + (a+b) + "\n" +
                                                                "Difference = " + (a-b) + "\n" +
                                                                "Product = " + (a*b) + "\n" +
                                                                "Quotient = " + (a/b));
        }
        System.exit(0);
    }
}
