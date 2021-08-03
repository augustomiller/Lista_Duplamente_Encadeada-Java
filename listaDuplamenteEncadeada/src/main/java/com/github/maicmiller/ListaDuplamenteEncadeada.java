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

    public void add(T elemento){ // Recebe o conteúdo do tipo genérico como parâmetro...
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo); // Esse ultimo nó aponta para o antigo ultimo nó da lista...
        if (primeiroNo == null){
            primeiroNo = novoNo;
        }
        if (ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoPrevio(noAuxiliar);

        if (novoNo.getNoProximo() != null){ // Fazendo uma inserção no meio da lista...
            novoNo.setNoProximo(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if (index == 0){ // Se o índice for igual a zero o nó auxiliar é o primeiro nó...
            primeiroNo = novoNo;
        }else{
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo; // O nó auxiliar recebe o primeiro nó, ou seja começa do primeiro nó...
        for (int i =0; (i < index) && (noAuxiliar != null); i++){ // Enquanto isso for true, o laço continua a percorrer e avançar na milha lista...
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return  noAuxiliar;
    }

    public int size(){
        return this.tamanhoLista;
    }
}
