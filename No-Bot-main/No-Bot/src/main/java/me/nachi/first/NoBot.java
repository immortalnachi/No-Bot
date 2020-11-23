package me.nachi.first;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class NoBot {
    private NoBot() throws LoginException {
        final JDA jda=new JDABuilder(AccountType.BOT)
                .setToken("Bot Token").build();
        CommandClientBuilder builder=new CommandClientBuilder();
        builder.setPrefix("&");
        builder.setOwnerId("OwnerId");
        builder.setStatus(OnlineStatus.IDLE);
        builder.setActivity(Activity.listening("Meowwwwwwwwww"));
        builder.setHelpWord("Help");
        builder.addCommand(new User_Info());
        builder.addCommand(new pfp());
        builder.addCommand(new Serverinfo());
        builder.addCommand(new Chaos());
        CommandClient client= builder.build();
        client.addCommand(new ping());
        jda.addEventListener(client);
        jda.addEventListener(new Autoword());



    }

    public static void main(String[] args) throws LoginException {
        long enable= System.currentTimeMillis();
        new NoBot();
        System.out.println("Bot has gained sentience in " +(System.currentTimeMillis() -enable + "ms"));
    }
}
