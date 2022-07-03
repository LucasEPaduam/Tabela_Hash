/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbase;

/**
 *
 * @author everton
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("***** HASH DIVISÃO *****\n");
        TabelaHash hashDivisao = new HashDivisao(4);
        hashDivisao.inserir(10, "ALIEN");
        hashDivisao.inserir(6, "POP");
        hashDivisao.inserir(10, "MISTICAL");
        hashDivisao.inserir(5, "SUPER");
        hashDivisao.inserir(6, "INVERT");
        hashDivisao.inserir(7, "UNDERGROUND");
        hashDivisao.remover(10);
        hashDivisao.inserir(7, "ALTERNATIVE");
        System.out.println(hashDivisao);
        hashDivisao.remover(10);
        
        System.out.println(hashDivisao.consultar(7));

        System.out.println("\n***** HASH DOBRA ****************************\n");
        TabelaHash hashDobra = new HashDobra(7);

        hashDobra.inserir(24, "PC");
        hashDobra.inserir(85, "GATO");
        hashDobra.inserir(5437, "NOTEPAD");
        hashDobra.inserir(23, "PAPER");
        hashDobra.inserir(85, "GATEWAY");
        hashDobra.inserir(99999, "CSHARP#");
        hashDobra.inserir(24, "PC CLONE");
        hashDobra.inserir(89, "TABLET");
        hashDobra.inserir(33, "GOD AGE");

        System.out.println(hashDobra);

        hashDobra.remover(99999);
        
        hashDobra.remover(3);

        System.out.println(hashDobra);
        System.out.println(hashDobra.consultar(3));
    }

}
