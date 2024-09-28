import java.lang.Math;
import javax.swing.JOptionPane;

public class SolveSecondDegree {
    public void solve(){
        String num1, num2, num3;

        num1 = JOptionPane.showInputDialog(null, "Form of the equation: a*(x^2) + b*x + c. Choose a: ", "Input a", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Form of the equation: a*(x^2) + b*x + c. Choose b: ", "Input b", JOptionPane.INFORMATION_MESSAGE);
        num3 = JOptionPane.showInputDialog(null, "Form of the equation: a*(x^2) + b*x + c. Choose c: ", "Input c", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        double c = Double.parseDouble(num3);
        double b2 = Math.pow(b, 2.0);
        double delta = b2 - (4*a*c);

        if (delta < 0){
            JOptionPane.showMessageDialog(null, "Equation has no solution", "Answer", JOptionPane.WARNING_MESSAGE);
        }
        else if (delta == 0){
            JOptionPane.showMessageDialog(null, "Equation has one solution: x = " + (-b / (2*a)), "Answer", JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            JOptionPane.showMessageDialog(null, "Equation has 2 solutions:\n " + 
                                                                        "x1 = " + ((-b + Math.pow(delta, 0.5)) / (2*a)) + "\n" +
                                                                        "x2 = " + ((-b - Math.pow(delta, 0.5)) / (2*a)));
        }
        
        System.exit(0);
    }
}


