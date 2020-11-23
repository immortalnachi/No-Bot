package me.nachi.first;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
public class ping extends Command
    {
        public ping()
        {
            super.name= "ping";
            super.help= "Pings the bot";
            super.category=new Category("Utilities");
        }
        @Override
        protected void execute(CommandEvent event) {

        event.reply("Pong, I'm slow but my ping is "+event.getJDA().getGatewayPing()+" ms");

    }
}
