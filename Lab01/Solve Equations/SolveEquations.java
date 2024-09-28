import javax.swing.JOptionPane;
import java.lang.Math;

public class SolveEquations {
    public static void main(String[]args){
        String num;

        num = JOptionPane.showInputDialog(null, "Choose the degree of the equation: ", "Input degree", JOptionPane.INFORMATION_MESSAGE);
        double degree = Double.parseDouble(num);

        if (degree == 1.0) {
            String k;
            k = JOptionPane.showInputDialog(null, "Choose number of variable: ", "Input number of variable", JOptionPane.INFORMATION_MESSAGE);
            double num_of_vari = Double.parseDouble(k);

            if (num_of_vari == 1.0){
                SolveLinearEquation sol11 = new SolveLinearEquation();
                sol11.solve();
            }
            else if (num_of_vari == 2.0){
                SolveLinearSystem sol12 = new SolveLinearSystem();
                sol12.solve();
            }
        }
        else if (degree == 2.0){
            SolveSecondDegree sol2 = new SolveSecondDegree();
            sol2.solve();
        }
        System.exit(0);
    }
}
