package com.crio.jukebox.commands;

import java.util.List;

public interface Icommand {
    void execute(List<String> tokens);
}
