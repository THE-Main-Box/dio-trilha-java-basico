import service.UserDataCollector;

public class ContaTerminal {

    public static void main(String[] args) {
        /// Ao iniciar uma nova coleta, ele irá coletar e criar uma nova conta para o usuário
        new UserDataCollector().initCollection();
    }

}