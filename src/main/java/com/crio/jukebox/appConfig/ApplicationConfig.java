package com.crio.jukebox.appConfig;

import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.Createplaylistcommand;
import com.crio.jukebox.commands.Createusercommand;
import com.crio.jukebox.commands.Deleteplaylistcommand;
import com.crio.jukebox.commands.Loaddatacommand;
import com.crio.jukebox.commands.Modifyplaylistcommand;
import com.crio.jukebox.commands.Playplaylistcommand;
import com.crio.jukebox.commands.Playsongcommand;
import com.crio.jukebox.repositories.IPlaylistrepositories;
import com.crio.jukebox.repositories.ISongrepositories;
import com.crio.jukebox.repositories.IUserrepositories;
import com.crio.jukebox.repositories.Playlistrepositories;
import com.crio.jukebox.repositories.Songrepository;
import com.crio.jukebox.repositories.Userrepositories;
import com.crio.jukebox.services.IPlayService;
import com.crio.jukebox.services.Iplaylistservice;
import com.crio.jukebox.services.Isongservice;
import com.crio.jukebox.services.Iuserservice;
import com.crio.jukebox.services.Playlistservice;
import com.crio.jukebox.services.Playservice;
import com.crio.jukebox.services.Songservice;
import com.crio.jukebox.services.Userservice;

public class ApplicationConfig {
    private final IPlaylistrepositories playlistrepositories = new Playlistrepositories();
    private final IUserrepositories userrepositories = new Userrepositories();
    private final ISongrepositories songrepositories = new Songrepository();

    private final Iuserservice userservice = new Userservice(userrepositories);
    private final Isongservice songservice = new Songservice(songrepositories);
    private final Iplaylistservice playlistservice = new Playlistservice(playlistrepositories, songrepositories);
    private final IPlayService playService = new Playservice(playlistrepositories);

    private final Createplaylistcommand createplaylistcommand = new Createplaylistcommand(playlistservice);
    private final Createusercommand createusercommand = new Createusercommand(userservice);
    private final Deleteplaylistcommand deleteplaylistcommand = new Deleteplaylistcommand(playlistservice);
    private final Loaddatacommand loaddatacommand = new Loaddatacommand(userservice);
    private final Modifyplaylistcommand modifyplaylistcommand = new Modifyplaylistcommand(playlistservice);
    private final Playplaylistcommand playplaylistcommand = new Playplaylistcommand(playService);
    private final Playsongcommand playsongcommand = new Playsongcommand(playService);
    private final CommandInvoker commandInvoker= new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("Create Playlist", createplaylistcommand);
        commandInvoker.register("Create User", createusercommand);
        commandInvoker.register("Delete User", deleteplaylistcommand);
        commandInvoker.register("Load data from csv", loaddatacommand);
        commandInvoker.register("Modify Playlist", modifyplaylistcommand);
        commandInvoker.register("Play Playlist command", playplaylistcommand);
        commandInvoker.register("Play Song Command", playsongcommand);
        return commandInvoker;
    }

}
