package tarefa;

class Tarefa implements Runnable {
    private String nome;

    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(nome + " processando passo " + i + ".");
            try {
                // A thread tenta dormir por 2 segundos.
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                // O .interrupt() ativa ESTE BLOCO EXATAMENTE AQUI:
                System.out.println("-> CATCH ATIVADO: " + nome + " foi interrompida no meio do sono!");
                // Finaliza o método run mais cedo para parar a execução.
                return; 
            }
        }
        System.out.println(nome + " FINALIZADA COM SUCESSO!");
    }
}
