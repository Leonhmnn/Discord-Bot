package de.umfrage.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.bot.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.bot.sharding.ShardManager;
import net.dv8tion.jda.core.OnlineStatus;

public class DCBot {

	public ShardManager shardMan;

	public DCBot() throws LoginException, IllegalArgumentException {
		DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
		builder.setToken("TOKEN kann hier nicht veröffentlicht werden. Discord haut nen SECURITY WARNING raus");

		builder.setStatus(OnlineStatus.ONLINE);

		System.err.println("DCBOT 25");

		builder.addEventListeners(new Commandlistener());
		builder.addEventListeners(new listenerReaction());

		System.err.println("DCBOT 30");

		shardMan = builder.build();
		System.out.println("Bot online.");

		System.err.println("DCBOT 35");

		shutdown();
	}

	public void shutdown() {

		new Thread(() -> {

			System.err.println("DCBOT 44");

			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {

				System.err.println("DCBOT 50");

				while ((line = reader.readLine()) != null) {
					if (line.equalsIgnoreCase("exit")) {

						System.err.println("DCBOT 55");

						if (shardMan != null) {
							shardMan.setStatus(OnlineStatus.OFFLINE);
							shardMan.shutdown();
							System.out.println("Bot offline.");
						}
					} else {
						System.out.println("use 'exit' to shutdown.");
						System.err.println("DCBOT 62");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		System.err.println("DCBOT 74");
	}

}
