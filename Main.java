import tarefa.Tarefa;

/*
 * A thread main espere um instante e interrompa a Thread A 
 * no meio do seu trabalho, forçando o bloco catch a ser 
 * executado.
 */
public class Main {
    public static void main(String[] args) {
        Tarefa tarefa = new Tarefa("Thread A");
        Thread t1 = new Thread(tarefa);

        // 1. Iniciando a thread:
        t1.start();

        try {
            // 2. A thread principal (main) espera apenas 1 segundo.
            // Isso garante que a Thread A comece a rodar e entre no seu primeiro sleep.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. A thread main acorda a Thread A:
        System.out.println("[Main] Vou interromper a Thread A agora...");
        t1.interrupt(); 
    }
}
