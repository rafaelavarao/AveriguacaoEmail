import java.util.Scanner;

public class tarefaUm
{
    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);
        int repeticao = 6;

        for(int contador = 0; contador < repeticao; contador++){
            System.out.printf("Por favor, digite um email\n");
            String emailDigitado = teclado.nextLine().toLowerCase().trim();
            
            //chamando o metodo
            if(avaliarEmail(emailDigitado))
            {
                System.out.println("O email é valido.");
                System.out.println();
            } else {
                System.out.println("O email não é valido.");
                System.out.println();
            }

        }

    }

    public static boolean avaliarEmail (String email)
    {
        int posicaoArroba = 0;
        int tamanhoEmail = email.length();
        boolean parteUm = false;
        boolean parteDois = false;
        boolean digito = false;
    
        //procurando o "@" em cada elemento do email
        for (int posicao = 0; posicao < tamanhoEmail; posicao++){
            if(email.substring(posicao, posicao + 1).equals("@")){
                posicaoArroba = posicao;
            }
        }
        
        //definindo primeira parte e segunda parte com base na posição "@"
        String primeiraParte = email.substring(0, posicaoArroba);
        String segundaParte = email.substring(posicaoArroba +1, tamanhoEmail);
        
        //verificando a primeira parte
        if(primeiraParte.contains(".") 
        && primeiraParte.length() > 2 
        && !primeiraParte.substring(0,1).equals(".") 
        && !primeiraParte.endsWith(".")){
            parteUm = true;
        }
        
        //verificando a segunda parte
        if(segundaParte.length() > 18 && segundaParte.length() < 29 && segundaParte.endsWith(".superfast.com.br")){
            if(segundaParte.contains("marketing") 
            || segundaParte.contains("atendimento") 
            || segundaParte.contains("rh")
            || segundaParte.contains("financeiro") 
            || segundaParte.contains("gerencia")){
                parteDois = true;
            }
        }
        
        //definindo retorno
        if(parteUm && parteDois){
            return true;
        } else {
            return false;
        }
    }
}
