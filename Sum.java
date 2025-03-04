package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class Sum implements ICommand {
    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "Gets the sum of two numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.INTEGER, "number1", "First number", true)
                        .setMinValue(1));
        data.add(new OptionData(OptionType.INTEGER, "number2", "Second number", true)
                        .setMinValue(1));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        OptionMapping number1 = event.getOption("number1");
        int num1 = number1.getAsInt();
        OptionMapping number2 = event.getOption("number2");
        int num2 = number2.getAsInt();
        event.reply(num1 + num2 + "").queue();
    }
}
