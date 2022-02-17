package de.umfrage.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commandlistener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {

		System.err.println("LSTCMMD 18");

		Message message = event.getMessage();
		String msg = message.getContentDisplay();

		if (event.isFromType(ChannelType.TEXT)) {

			System.err.println("LSTCMMD 25");

			TextChannel channel = event.getTextChannel();

			// !t arg0, arg1, arg2, ...
			if (msg.startsWith(Main.prefix)) {
				String[] args = msg.split(" ");

				if (args.length == 2) {

					System.err.println("LSTCMMD 35");

					if (args[1].equalsIgnoreCase("time")) {

						System.err.println("LSTCMMD 39");

						Calendar cal = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("dd MMM YYYY");
						SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
						channel.sendMessage("Today it's the  " + sdf.format(cal.getTime()) + " and it's "
								+ sdf2.format(cal.getTime()) + " !").queue();
					}

				}
				if (args[1].equalsIgnoreCase("hi")) {
					channel.sendMessage("Hello " + event.getMember().getAsMention() + " !").queue();
				}
				if (args[1].equalsIgnoreCase("bye" + " ")) {
					channel.sendMessage("good bye").queue();
				}
			}
		}
	}
}