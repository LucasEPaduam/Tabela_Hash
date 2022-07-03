/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbase;

/**
 *
 * @author Lucas Eduardo
 * @param <T>
 */
public class Item<T> {

    private final int chave;
    private final T valor;

    public Item(int chave, T valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public T getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ITEM - " + "Chave = " + chave + ", Valor = " + valor + ']';
    }
}
