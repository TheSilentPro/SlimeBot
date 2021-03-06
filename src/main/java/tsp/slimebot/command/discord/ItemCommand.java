package tsp.slimebot.command.discord;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.bukkit.ChatColor;
import tsp.slimebot.util.Utils;

public class ItemCommand extends SlimeCommand {

    public ItemCommand() {
      super("item");
    }

    @Override
    public void handle(SlashCommandInteractionEvent event) {
        String rawItem = event.getOption("name").getAsString();

        for (SlimefunItem item : Utils.getItems()) {
            String name = Utils.stripColor(item.getItemName());
            if (Utils.matches(rawItem, item)) {
                String wiki = item.getWikipage().isPresent() ? item.getWikipage().get() : "";

                event.getHook().editOriginalEmbeds(Utils.embed(event)
                        .setAuthor(name, !wiki.isEmpty() ? wiki : "https://github.com/Slimefun/Slimefun4/wiki")
                        .appendDescription("**Information**" + "\n")
                        .appendDescription(Utils.information(item))
                        .appendDescription("\n")
                        .appendDescription("**Description**" + "\n")
                        .appendDescription(Utils.description(item))
                        .appendDescription("\n")
                        .appendDescription("**Category**\n")
                        .appendDescription(Utils.category(item.getItemGroup()))
                        .appendDescription("\n")
                        .appendDescription("**Research**\n")
                        .appendDescription(Utils.research(item.getResearch()))
                        .appendDescription("\n")
                        .appendDescription("**Recipe**" + "\n")
                        .appendDescription(Utils.recipe(item) + "\n")
                        .appendDescription(Utils.recipeGrid(item))
                        .build()
                ).queue();
                return;
            }
        }

        event.getHook().editOriginalEmbeds(Utils.embed(event)
                .setAuthor("Invalid item.")
                .appendDescription("Could not find item: " + Utils.wrap(rawItem))
                .build()).queue();
    }
}
