package me.nachi.first;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.Objects;


public class Chaos extends Command
{
    public Chaos()
    {
        super.name="Chaos";
        super.help="Just Chaos";
        super.category=new Category("Fun");
        super.arguments="[User]";
    }

    @Override
    protected void execute(CommandEvent Event)
    {
        if (Event.getArgs().isEmpty())
        {
            for (int a = 1; a < 100; a++)
            {

                if(Objects.requireNonNull(Event.getMessage().getMember()).getUser().getId().equalsIgnoreCase("OwnerID"))
                {
                    Event.reply("Haha Owner is immune, bot owner go brrrrrrrr ʕノ•ᴥ•ʔノ ︵ ┻━┻");
                    break;
                }
                else
                    {
                        if (Event.getMessage().getGuild().getId().equalsIgnoreCase("ServerID"))
                        {
                            Event.reply("Command is disabled in this server ¯\\_(ツ)_/¯");
                            break;
                        }

                            Event.getMessage().getMember().getUser().openPrivateChannel().queue(channel ->
                            channel.sendMessage("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA").queue());
                     }
            }

        }
        else
        {

                try
                {

                  for (int a = 1; a <=100; a++)
                  {

                      if(Event.getMessage().getMentionedMembers().get(0).getId().equalsIgnoreCase("OwnerID"))
                      {
                          Event.reply("Haha Owner is immune, bot owner go brrrrrrrr ʕノ•ᴥ•ʔノ ︵ ┻━┻");
                          break;
                      }
                      else {
                          if (Event.getMessage().getGuild().getId().equalsIgnoreCase("ServerID"))
                          {
                              Event.reply("Command is disabled in this server ¯\\_(ツ)_/¯");
                              break;
                          }
                          else {
                              Event.getMessage().getMentionedUsers().get(0).openPrivateChannel().queue(channel -> channel.sendMessage("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA").queue());

                          }
                      }


                  }

                }
                catch (IndexOutOfBoundsException ex)
                {
                    System.out.println("Exception Occurred");
                    Event.reply("You need to mention an user");
                }
        }
    }
}
