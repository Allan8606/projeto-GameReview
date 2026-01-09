package com.gamereview.projeto_game_review.exception;




public class GameNaoEncontradoException extends RuntimeException{
    //extendemos o RuntimeException para que ele reconheça o erro.
    //é uma exceção que pode ser lançada sem try/catch o nome descreve exatamente o problema.


    //super(...) envia a mensagem para a classe pai (RuntimeException)essa mensagem será usada no retorno da API depois.
    public GameNaoEncontradoException() {
        super("Game não encontrado");
    }
}
