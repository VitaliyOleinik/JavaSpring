
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private static final String TOKEN = "";
    private static final String USERNAME = "";
    private Long chatId;
    private String inputText;

    final int RECONNECT_PAUSE = 1000;

    public Bot(DefaultBotOptions options){super(options);}

    public String getBotToken() {
        return TOKEN;
    }

    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage() != null && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case "/start":
                    chatId = update.getMessage().getChatId();
                    inputText = update.getMessage().getText();
                    SendMessage message = new SendMessage();
                    message.setChatId(chatId);
                    message.setText("Приветули Красотули, \n" +
                            "Напиши \"Курс валют\" и получишь меню.");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Курс валют":
                    try {
                        execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Посчитай сколько":
                    chatId = update.getMessage().getChatId();
                    inputText = update.getMessage().getText();

            }
        }else if(update.hasCallbackQuery()){
            try {
                execute(new SendMessage().setText(
                        update.getCallbackQuery().getData())
                        .setChatId(update.getCallbackQuery().getMessage().getChatId()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            try {
                execute(sendInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void botConnect() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiRequestException e) {
            try {
                Thread.sleep(RECONNECT_PAUSE);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
                return;
            }
            botConnect();
        }
    }

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("USD");
        inlineKeyboardButton1.setCallbackData("1 доллар = 428,87 тенге");
        inlineKeyboardButton2.setText("EUR");
        inlineKeyboardButton2.setCallbackData("1 евро = 510,25 тенге");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("RUB").setCallbackData("1 рубль = 5,90 тенге"));
        keyboardButtonsRow1.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Выберите валюту").setReplyMarkup(inlineKeyboardMarkup);
    }

//    public static SendMessage sendStartMessage(long chatId) {
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        return new SendMessage().setChatId(chatId).setText("Выберите действие").setReplyMarkup(inlineKeyboardMarkup);
//    }
}
