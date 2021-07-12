package imooc.design.pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class Staff {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
