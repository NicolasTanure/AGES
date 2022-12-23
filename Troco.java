

/**
 * Escreva uma descrição da classe Troco aqui.
 * 
 * @Nicolas Tanure Miszczuk 
 * @version 23/12/2022
 */
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Troco {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    double conta, pago;

    try {
      System.out.printf("Informe o Valor do produto: ");
      conta = in.nextDouble();

      System.out.printf("Informe o Valor que vai pagar: ");
      pago = in.nextDouble();

      System.out.printf("%s", calculaTroco(conta, pago));
    }
    catch (InputMismatchException e) {
      System.err.printf("\nErro: dados informados inválidos !!!\n");
    }
  }

  public static String calculaTroco(double conta, double pago) {
    DecimalFormat formatador = new DecimalFormat("###,##0.00");
    if (pago < conta)
       return("\nPagamento insuficiente, faltam R$"+
         formatador.format(conta - pago) +"\n");
   else {
      int nota[] = {200,100, 50, 20, 10, 5, 2,1};
      int centavos[] = {50, 25, 10, 5, 1};

      String resultado;
      double troco;
      int i, vlr, ct;

      troco = pago - conta;
      resultado ="\nTroco = R$"+ formatador.format(troco) +"\n\n";
      vlr = (int)troco;
      i = 0;
      while (vlr != 0) {
        ct = vlr / nota[i]; 
        if (ct != 0) {
           resultado = resultado + (ct +"nota(s) de R$"+ nota[i] +"\n");
           vlr = vlr % nota[i]; 
        }
        i = i + 1; 
      }

      resultado = resultado +"\n";


      vlr = (int)Math.round((troco - (int)troco) * 100);
      i = 0;
      while (vlr != 0) {
        ct = vlr / centavos[i]; 
        if (ct != 0) {
           resultado = resultado + (ct +"moeda(s) de"+ centavos[i] +
           "centavo(s)\n");
           vlr = vlr % centavos[i]; 
        }
        i = i + 1; 
      }

      return(resultado);
    }
  }

}

