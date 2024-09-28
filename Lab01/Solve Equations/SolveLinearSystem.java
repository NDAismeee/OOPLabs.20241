import javax.swing.JOptionPane;

public class SolveLinearSystem {
    public void solve(){
        String num1, num2, num3, num4, s1, s2;

        num1 = JOptionPane.showInputDialog(null, "Form of the first equation: a11*x1 + a12*x2 = b1. Choose a11:", "Input a11", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Form of the first equation: a11*x1 + a12*x2 = b1. Choose a12:", "Input a12", JOptionPane.INFORMATION_MESSAGE);
        s1 = JOptionPane.showInputDialog(null, "Form of the first equation: a11*x1 + a12*x2 = b1. Choose b1:", "Input b1", JOptionPane.INFORMATION_MESSAGE);
        num3 = JOptionPane.showInputDialog(null, "Form of the first equation: a21*x1 + a22*x2 = b2. Choose a21:", "Input a21", JOptionPane.INFORMATION_MESSAGE);
        num4 = JOptionPane.showInputDialog(null, "Form of the first equation: a21*x1 + a22*x2 = b2. Choose a22:", "Input a22", JOptionPane.INFORMATION_MESSAGE);
        s2 = JOptionPane.showInputDialog(null, "Form of the first equation: a11*x1 + a12*x2 = b2. Choose b2:", "Input b2", JOptionPane.INFORMATION_MESSAGE);

        double a11 = Double.parseDouble(num1);
        double a12 = Double.parseDouble(num2);
        double b1 = Double.parseDouble(s1);
        double a21 = Double.parseDouble(num3);
        double a22 = Double.parseDouble(num4);
        double b2 = Double.parseDouble(s2);

        double D = a11*a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = a12*b2 - a21*b1;

        if (D != 0){
            JOptionPane.showMessageDialog(null, "Solution of the equation: (x1, x2) = (" + (D1/D) + ", " + (D2/D) + ")", "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (D == 0 && D1 == 0 && D2 == 0) {
            JOptionPane.showMessageDialog(null, "Infinity Solutions", "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "No Solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
    
}
