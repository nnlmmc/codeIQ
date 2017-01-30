/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.math.*;
/**
 *
 * @author nishioka
 */
public class Room_and_Roof_20170126 {
    public static void main (String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        Integer cnt = cin.nextInt();
        // Declaration
        BigDecimal edge = BigDecimal.valueOf(1.0);
        BigDecimal sq = BigDecimal.valueOf(0.0);

        // Calculation
        for (int i=0; i<cnt; i++) {
            sq = edge.divide(BigDecimal.valueOf(2.0)).multiply(edge.divide(BigDecimal.valueOf(2.0))).add(edge.add(edge.multiply(BigDecimal.valueOf(Math.sqrt(3)/2.0))).multiply(edge.add(edge.multiply(BigDecimal.valueOf(Math.sqrt(3)/2.0)))));
            edge = sq;

            for (int j=0; j<cnt+1; j++) {
                edge = edge.subtract(edge.multiply(edge).subtract(sq).divide(edge.multiply(BigDecimal.valueOf(2.0)), 50, BigDecimal.ROUND_HALF_EVEN));
            }
        }

        System.out.println(sq.setScale(0, BigDecimal.ROUND_DOWN));
    }
}
