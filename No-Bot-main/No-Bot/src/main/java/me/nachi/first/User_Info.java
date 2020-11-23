package me.nachi.first;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User_Info extends Command
{
    public User_Info()
    {
        super.name="user-info";
        super.help="YOU";
        super.aliases= new String[]{"userinfo","ui"};
        super.category=new Category("Utilities");
        super.arguments="[User  ]";
    }
    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getArgs().isEmpty())
        {
           Member name = event.getMessage().getMember();
           DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
           EmbedBuilder eb = new EmbedBuilder() //Embed builder
                    .setColor(Color.cyan)
                    .setThumbnail(name.getUser().getEffectiveAvatarUrl())
                    .setTitle("User Info")
                    .setAuthor("Information on " + name.getUser().getName(), "https://www.youtube.com/watch?v=dQw4w9WgXcQ", name.getUser().getAvatarUrl())
                    .addField("Device: " , String.valueOf(name.getActiveClients()), true)
                    .addField("Status: ", String.valueOf(name.getOnlineStatus()), true)
                    .addField("Nickname: " , name.getNickname() ==null? "No nickname": name.getNickname(), true)
                    .addField("Roles: ", getRolesAsString(name.getRoles()), true) //the return statement leads here
                    .addField("Joined this server on: " , name.getTimeJoined().format(fmt), true)
                    .addField("Joined Discord on: ", name.getTimeCreated().format(fmt), true);

           event.reply(eb.build());

        }
        else
        {
            Member name;
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            try
            {

                    name = event.getMessage().getMentionedMembers().get(0);
                EmbedBuilder eb = new EmbedBuilder() //Embed builder
                        .setColor(Color.cyan)
                        .setTitle("User Info")
                        .setThumbnail(name.getUser().getEffectiveAvatarUrl())
                        .setAuthor("Information on " + name.getUser().getName(), "https://www.youtube.com/watch?v=dQw4w9WgXcQ", name.getUser().getAvatarUrl())
                        .addField("Device: " , String.valueOf(name.getActiveClients()), true)
                        .addField("Status: ", String.valueOf(name.getOnlineStatus()), true)
                        .addField("Nickname: " , name.getNickname() ==null? "No nickname": name.getNickname(), true)
                        .addField("Roles: ", getRolesAsString(name.getRoles()), true) //the return statement leads here
                        .addField("Joined this server on: " , name.getTimeJoined().format(fmt), true)
                        .addField("Joined Discord on: ", name.getTimeCreated().format(fmt), true);

                event.reply(eb.build());
            }catch (IndexOutOfBoundsException ex)
            {
                System.out.println("Exception Occurred");
                event.reply("You need to mention an user");
            }


        }

    }
    private String getRolesAsString(List roles)
    {
        String role;
        if (!roles.isEmpty())
        {
            Role temprole = (Role) roles.get(0);
            role = temprole.getName();
            for (int i=1;i<roles.size(); i++) //for listing the roles
            {
                temprole =(Role) roles.get(i);
                role+= ", "+temprole.getName();
            }
        }
        else
        {
            role   = "No Roles";
        }
        return role; //this one
    }
}
