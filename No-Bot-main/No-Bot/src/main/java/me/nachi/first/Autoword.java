package me.nachi.first;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class Autoword extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {

        String name= Objects.requireNonNull(event.getMember()).getUser().getName();
        String messent= event.getMessage().getContentRaw();
        {
            if (messent.equalsIgnoreCase("Can you pass the turing test?"))
            {
                event.getChannel().sendMessage("To prevent mass panic, I'm gonna say NO").queue();
            }
            if (messent.equalsIgnoreCase("Hello"))
            {
                event.getChannel().sendMessage("Hello " + name).queue();
            }
            if(messent.equalsIgnoreCase("Hello there"))
            {
                event.getChannel().sendMessage("General Kenobi").queue();
            }
            if(messent.equalsIgnoreCase("Good Bot"))
            {
                event.getChannel().sendMessage("No U").queue();
            }
        }
    }
}
