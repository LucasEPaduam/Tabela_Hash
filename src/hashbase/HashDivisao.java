/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbase;

/**
 *
 * @author Lucas Eduardo
 */
public class HashDivisao extends TabelaHash {

    private final Item[] hash;

    public HashDivisao(int capacidade) {
        super(capacidade);
        this.hash = new Item[capacidade];
    }

    @Override
    public int inserir(int chave, Object valor) {

        //Se o tamanho for igual a capacidade, a tabela está cheia
        if (getTamanho() < getCapacidade()) {

            int pos = chave % getCapacidade();
            System.out.println("Chave: " + chave);
            System.out.println("Posição: " + pos);
            System.out.println("Valor: " + valor.toString());

            //Posição livre
            if (hash[pos] == null) {
                hash[pos] = new Item(chave, valor);
                setTamanho(getTamanho() + 1);
                System.out.println("");
                return 1;
            } else {
                int i = 0;
                while (i < getCapacidade() && hash[(pos + i) % getCapacidade()] != null) {
                    i++;
                }
                System.out.println("Nova pos: " + (pos + i) % getCapacidade());
                System.out.println("");
                hash[(pos + i) % getCapacidade()] = new Item(chave, valor);
                setTamanho(getTamanho() + 1);
            }
        } else {
            System.out.println("Tabela Cheia! \n");
        }

        return 0;
    }

    @Override
    public int remover(int chave) {

        if (getTamanho() != 0) {
            int pos = chave % getCapacidade();
            if (hash[pos] != null && hash[pos].getChave() == chave) {
                System.out.println("Item removido");
                System.out.println("Chave: " + chave);
                System.out.println("Valor: " + hash[pos].getValor());
                System.out.println("");
                hash[pos] = null;
                setTamanho(getTamanho() - 1);
                return 1;
            } else {
                int i = 0;
                while ((hash[(pos + i) % getCapacidade()] == null)
                        || (i < getCapacidade()
                        && hash[(pos + i) % getCapacidade()].getChave() != chave)) {
                    i++;
                }

                if (i < getCapacidade()) {
                    System.out.println("Item removido");
                    System.out.println("Chave: " + chave);
                    System.out.println("Valor: " + hash[(pos + i) % getCapacidade()].getValor());
                    System.out.println("");
                    hash[(pos + i) % getCapacidade()] = null;
                    setTamanho(getTamanho() - 1);
                    return 1;
                }
            }
        }

        System.out.println("Item não encontrado!");
        return 0;
    }

    @Override
    public Item consultar(int chave) {
        int pos = chave % getCapacidade();
        if (hash[pos] != null && hash[pos].getChave() == chave) {
            return hash[pos];
        } else {
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] != null && hash[i].getChave() == chave) {
                    return hash[i];
                }
            }

            System.out.println("CHAVE NÃO LOCALIZADA");
            return null;
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < getCapacidade(); i++) {
            out += "" + i + ": ";
            out += hash[i % getCapacidade()] + "\n";
        }
        return out;
    }

}
