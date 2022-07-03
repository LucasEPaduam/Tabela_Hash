/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbase;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lucas Eduardo
 */
public class HashDobra extends TabelaHash {

    private final List<Item>[] vetor;

    public HashDobra(int capacidade) {
        super(capacidade);
        this.vetor = new LinkedList[capacidade];
        for (int i = 0; i < capacidade; i++) {
            vetor[i] = new LinkedList<>();
        }

    }

    @Override
    public int inserir(int chave, Object valor) {

        int posicao = calculaDobra(chave);
        System.out.println("Chave: " + chave);
        System.out.println("Posição: " + posicao);
        System.out.println("Valor: " + valor.toString());
        vetor[posicao].add(new Item(chave, valor));
        setTamanho(getTamanho() + 1);
        System.out.println("");
        return 1;
    }

    @Override
    public int remover(int chave) {

        if (getTamanho() != 0) {
            int posicao = calculaDobra(chave);
            Item item = consultar(chave);
            if (vetor[posicao] != null && item != null) {
                System.out.println("Item removido");
                System.out.println("Chave: " + chave);
                System.out.println("Valor: " + item.getValor());
                System.out.println("");
                for (int i = 0; i < vetor[posicao].size(); i++) {

                    if (vetor[posicao].get(i).getChave() == chave) {
                        vetor[posicao].remove(i);
                    }

                }
                setTamanho(getTamanho() - 1);
                return 1;
            } else {

                System.out.println("Item não encontrado!");
            }
        }

        return 0;
    }

    @Override
    public Item consultar(int chave) {
        int posicao = calculaDobra(chave);
        if (vetor[posicao] != null) {

            for (int i = 0; i < vetor[posicao].size(); i++) {

                if (vetor[posicao].get(i).getChave() == chave) {
                    return vetor[posicao].get(i);

                }

            }

        }

        return null;
    }

    private int calculaDobra(int chave) {

        String binaria = Integer.toBinaryString(chave);

        if (binaria.length() % 2 != 0) {

            binaria = "00000" + binaria;
        }

        char[] charArray = binaria.toCharArray();
        int tamanhoCharArray = charArray.length / 2;

        char[] charArray1 = new char[tamanhoCharArray];
        char[] charArray2 = new char[tamanhoCharArray];

        for (int i = 0; i < tamanhoCharArray; i++) {
            charArray1[i] = charArray[i];
        }

        int j = 0;
        for (int i = tamanhoCharArray; i < charArray.length; i++) {

            charArray2[j] = charArray[i];
            j = j + 1;
        }

        char[] resultadoHash = new char[charArray1.length];

        for (int i = 0; i < charArray1.length; i++) {
            char caractere1 = charArray1[i];
            char caractere2 = charArray2[i];

            if ((caractere1 == '0' && caractere2 == '1') || (caractere1 == '1' && caractere2 == '0')) {

                resultadoHash[i] = '1';

            } else {

                resultadoHash[i] = '0';
            }

        }

        int numeroHash = Integer.parseInt(new String(resultadoHash), 2);

        if (numeroHash >= getCapacidade()) {
            numeroHash = numeroHash % getCapacidade();
        }

        return numeroHash;

    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < getCapacidade(); i++) {
            out += "" + i + ": ";
            out += vetor[i % getCapacidade()] + "\n";
        }
        return out;
    }

}
