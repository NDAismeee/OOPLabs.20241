import javax.swing.JOptionPane;

public class SolveLinearEquation {
    public void solve() {
        String num1, num2;
        
        num1 = JOptionPane.showInputDialog(null, "Form of the equation: a*x + b = 0. Choose a:", "Input", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Form of the equation: a*x + b = 0. Choose b:", "Input", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);

        if (a == 0){
            JOptionPane.showMessageDialog(null, "No Solution", "Syntax error", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "x = " + (-b / a), "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}
