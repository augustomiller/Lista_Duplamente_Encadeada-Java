package com.github.maicmiller;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo; // O nó auxiliar recebe o primeiro nó, ou seja começa do primeiro nó...
        for (int i =0; (i < index) && (noAuxiliar != null); i++){ // Enquanto isso for true, o laço continua a percorrer e avançar na milha lista...
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return  noAuxiliar;
    }

    public int size(){
        return tamanhoLista;
    }
}
