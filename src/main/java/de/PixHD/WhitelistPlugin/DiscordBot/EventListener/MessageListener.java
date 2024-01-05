package de.PixHD.WhitelistPlugin.DiscordBot.EventListener;

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

            // Jetzt kannst du etwas mit dem Nachrichteninhalt machen, z.B. ausgeben
            System.out.println("Erhaltene Nachricht: " + content);
        }
    }
}
