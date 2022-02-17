package de.umfrage.listener;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class listenerReaction extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {

		System.out.println("LSTREACT 15");

		Message message = event.getMessage();
		String msg = message.getContentDisplay();

		if (event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();

			// !tut arg0, arg1, arg2, ...
			if (msg.startsWith(Main.prefix)) {

				System.out.println("LSTREACT 26");

				String[] args = msg.split(" ");

				if (args.length == 2) {
					if (args[1].equalsIgnoreCase("team")) {

						System.out.println("LSTREACT 33");

						channel.sendMessage(
								"How we wanna Play? Please choose one of the options above.  🅰 Solo	  🅱 Duo	  🆎 Squad")
								.queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "🅰").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "🅱").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "🆎").queue();

					} else if (args[1].equalsIgnoreCase("play")) {

						channel.sendMessage(
								"When we can play? Please choose one of the options above.  🅰 Now  🅱 eventually later  🆎 never")
								.queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "🅰").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "🅱").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "🆎").queue();
					} else if (args[1].equalsIgnoreCase("break")) {

						channel.sendMessage("U wanna a break? Please choose one of the options above.").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👍").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👎").queue();
					} else if (args[1].equalsIgnoreCase("continue")) {

						channel.sendMessage("Can we continue playing? Please choose one of the options above.").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👍").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👎").queue();
					} else if (args[1].equalsIgnoreCase("attack")) {

						channel.sendMessage("Should we attack them? Please choose one of the options above.").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👍").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👎").queue();
					} else if (args[1].equalsIgnoreCase("stop.attack")) {

						channel.sendMessage(
								"Should we stop our attack and go back? Please choose one of the options above.")
								.queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👍").queue();
						channel.addReactionById(channel.getLatestMessageIdLong(), "👎").queue();
					} else if (args[1].isBlank()) {
						channel.sendMessage("Pleasy type something befor sending!").queue();

					} else if (args[1].equalsIgnoreCase("help")) {

						channel.sendMessage("Here's a list of commands u can use:").queue();
						channel.sendMessage("p- ...").queue();
						channel.sendMessage("...Hi: to say Hello").queue();
						channel.sendMessage("...team: how much player").queue();
						channel.sendMessage("...break: for heaving a break").queue();
						channel.sendMessage("...play: wich time u wanna play").queue();
						channel.sendMessage("...continue: to continue").queue();
						channel.sendMessage("...attack: for attacking others").queue();
						channel.sendMessage("...stop.attack: for stop attacking others").queue();
						channel.sendMessage("...time: tells u the time").queue();

					}
				}
			}
		}
	}
}