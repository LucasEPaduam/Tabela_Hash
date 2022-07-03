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
public abstract class TabelaHash {
       
    
    private int capacidade;
    int tamanho;
    
    
    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tamanho = 0;
        
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    
    public abstract int inserir(int chave, Object valor);
    
    public abstract int remover(int chave);
    
    public abstract Item consultar(int chave);
    
}
