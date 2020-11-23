package me.nachi.first;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Serverinfo extends Command
{
    public Serverinfo()
    {
        super.name="serverinfo";
        super.help="Gives information about the server";
        super.aliases= new String[]{"Serverinfo","si","server-info"};
        super.category=new Category("Utilities");
    }

    @Override
    protected void execute(CommandEvent event)
    {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        EmbedBuilder eb = new EmbedBuilder()
                .setColor(Color.BLACK)
                .setAuthor(event.getGuild().getName())
                .setThumbnail(event.getGuild().getIconUrl())
                .addField("Server Owner: ", Objects.requireNonNull(event.getGuild().getOwner()).getUser().getAsMention(), true)
                .addField("Server Region: ", event.getGuild().getRegion().getName(), true)
                .addField("Number of members: ", String.valueOf(event.getGuild().getMemberCount()), true)
                .addField("Verification level required: ", String.valueOf(event.getGuild().getVerificationLevel()), true)
                .addField("Server filter level: ", String.valueOf(event.getGuild().getExplicitContentLevel()), true)
                .addField("Server was created on: ", (event.getGuild().getTimeCreated().format(fmt)), true);
        event.reply(eb.build());
    }
}
