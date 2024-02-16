import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    String varvar = null;
    Equations equations = new Equations();

    @Override
    public String getBotUsername() {
        return "Kitty solves";
    }

    @Override
    public String getBotToken() {
        return "6102881406:AAHxpnuSiWO7WnlitIHKcLDMROfjUNfHwaU" ;
    }

    public Bot() {
        List<BotCommand> botCommands = new ArrayList<>();
        botCommands.add(new BotCommand("/start", "Начало работы"));
        botCommands.add(new BotCommand("/var1", "ввести 5 значений"));
        botCommands.add(new BotCommand("/var2", "ввести 4 значений"));
        botCommands.add(new BotCommand("/var3", "ввести 4 значений"));
        botCommands.add(new BotCommand("/var4", "ввести 2 значений"));
        botCommands.add(new BotCommand("/var5", "ввести 5 значений"));
        botCommands.add(new BotCommand("/var6", "ввести 1 значений"));
        botCommands.add(new BotCommand("/var7", "ввести 1 значений"));

        try {
            this.execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        sendText(id, msg.getText());

        if(msg.isCommand()){
            if(msg.getText().equals("/var1"))
                varvar = "1";
            else if (msg.getText().equals("/var2"))
                varvar = "2";
            else if (msg.getText().equals("/var3"))
                varvar = "3";
            else if (msg.getText().equals("/var4"))
                varvar = "4";
            else if (msg.getText().equals("/var5"))
                varvar = "5";
            else if (msg.getText().equals("/var6"))
                varvar = "6";
            else if (msg.getText().equals("/var7"))
                varvar = "7";
        }

        if(varvar.equals("1")) {
            update.getMessage();
            equations.varvar1(id, msg.getText());
        } else if (varvar.equals("2")) {
            update.getMessage();
            equations.varvar2(id, msg.getText());
        } else if (varvar.equals("3")) {
            update.getMessage();
            equations.varvar3(id, msg.getText());
        } else if (varvar.equals("4")) {
            update.getMessage();
            equations.varvar4(id, msg.getText());
        } else if (varvar.equals("5")) {
            update.getMessage();
            equations.varvar5(id, msg.getText());
        } else if (varvar.equals("6")) {
            update.getMessage();
            equations.varvar6(id, msg.getText());
        } else if (varvar.equals("7")) {
            update.getMessage();
            equations.varvar7(id, msg.getText());
        }

    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}
