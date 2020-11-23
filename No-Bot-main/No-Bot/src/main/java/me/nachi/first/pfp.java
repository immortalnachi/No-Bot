package me.nachi.first;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import java.awt.*;
import java.util.Objects;


public class pfp extends Command
{
    public pfp()
    {
        super.name="PFP";
        super.help="Avatar of the user";
        super.aliases= new String[]{"PFP","avatar"};
        super.category=new Category("Utilities");
        super.arguments="[name]";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getArgs().isEmpty())
        {
            Member name = event.getMessage().getMember();

            EmbedBuilder eb = new EmbedBuilder() //Embed builder
                    .setColor(Color.cyan)
                    .setImage("https://cdn.discordapp.com/avatars/"+ Objects.requireNonNull(name).getUser().getId()+"/"+name.getUser().getAvatarId()+".webp?size=1024")
                    .setTitle("Avatar");


            event.reply(eb.build());

        }
        else {
            Member name;
            try {

                name = event.getMessage().getMentionedMembers().get(0);
                EmbedBuilder eb = new EmbedBuilder() //Embed builder
                        .setColor(Color.cyan)
                        .setTitle("Avatar")
                        .setImage(name.getUser().getEffectiveAvatarUrl());


                event.reply(eb.build());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Exception Occurred");
                event.reply("You need to mention an user");

            }
        }
    }

}


