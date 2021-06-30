import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class App {
    public static void main(String[] args) {
        ApiContextInitializer.init();

        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

        Bot exchangeBot = new Bot(botOptions);

        exchangeBot.botConnect();
    }
}
