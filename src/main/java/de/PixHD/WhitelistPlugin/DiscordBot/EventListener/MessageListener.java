package de.PixHD.WhitelistPlugin.DiscordBot.EventListener;

import de.PixHD.WhitelistPlugin.WhitelistPlugin;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class MessageListener implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof MessageReceivedEvent) {
            Message message = ((MessageReceivedEvent) event).getMessage();
            String content = message.getContentRaw(); // oder getContentDisplay()
            String content2 = message.getContentDisplay();

            // Jetzt kannst du etwas mit dem Nachrichteninhalt machen, z.B. ausgeben
            //TODO: Must fix this - i am not able to read the message content
            System.out.println("Erhaltene Nachricht: " + content);
            System.out.println("Erhaltene Nachricht2: " + content2);
            WhitelistPlugin.addPlayerToWhitelist(content);
        }
    }
}
