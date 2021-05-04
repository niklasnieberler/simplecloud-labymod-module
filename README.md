<br />
<p align="center">
  <a href="https://github.com/MrManHD/simplecloud-labymod-module">
    <img src="https://mrmanhd.tryhub.de/img/github-logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">LabyMod Module</h3>

  <p align="center">
    Ein LabyMod-Module für SimpleCloud
    <br />
    <a href="https://mrmanhd.tryhub.de/dl/simplecloud-labymod-module.jar">Download</a>
    ·
    <a href="https://github.com/MrManHD/simplecloud-labymod-module/issues">Report Bug</a>
    ·
    <a href="https://www.spigotmc.org/resources/simplecloud-simplify-your-network.79466/">SimpleCloud</a>
  </p>
</p>

 <br />
    
## Installation
1. Lade dir das LabyMod-Module [HIER](https://mrmanhd.tryhub.de/dl/simplecloud-labymod-module.jar) herunter.

2. Für dieses Module brauchst du die LabyModApi. <br /> Die Api findest du [HIER](https://github.com/LabyMod/labymod-server-api/) oder lade dir die .jar Datei gleich [HIER](https://mrmanhd.tryhub.de/dl/labyapi.jar) herunter.

3. Nun musst du die LabyModApi in das Plugins Verzeichnis jedes Spigot-Servers hochladen, <br /> oder in das Template Verzeichnis `EVERY_SERVER` ziehen.

4. Als letztes musst du das Module in das `modules` Verzeichnis hochladen.

 <br />
    
## Config

```json
{
  "settings": {
    "activeActionMenu": true,
    "activePlayingGamemode": true,
    "activeRichPresence": true
  },
  "playingOnConfigurationList": [
    {
      "serverGroup": "BW-2x1",
      "permission": null,
      "message": "BedWars-%NUMBER% §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)"
    },
    {
      "serverGroup": "BW-2x2",
      "permission": "cloud.laby.bedwars",
      "message": "BedWars 2x2"
    }
  ],
  "richPresenceConfigurationList": [
    {
      "serverGroup": "Lobby",
      "permission": null,
      "message": "Lobby-%NUMBER% (%MOTD%)"
    },
    {
      "serverGroup": "SW-2x1",
      "permission": "cloud.laby.skywars",
      "message": "SkyWars [%STATE%] §8(§e%ONLINE_PLAYERS%§8/§c%MAX_PLAYERS%§8)"
    }
  ],
  "actionMenuConfigurationList": [
    {
      "displayName": "Kick player",
      "serverGroup": null,
      "permission": "cloud.laby.kick",
      "type": "RUN_COMMAND",
      "value": "kick {name}"
    },
    {
      "displayName": "Open shop",
      "serverGroup": "Lobby",
      "permission": null,
      "type": "OPEN_BROWSER",
      "value": "https://shop.labymod.net"
    },
    {
      "displayName": "Copy playername",
      "serverGroup": "Lobby",
      "permission": null,
      "type": "CLIPBOARD",
      "value": "{name}"
    },
    {
      "displayName": "Report player",
      "serverGroup": null,
      "permission": null,
      "type": "SUGGEST_COMMAND",
      "value": "report {name}"
    }
  ]
}
```

 <br />
    
## ActionMenu

 **{name}** wird durch den Spielernamen ersetzt.

### Action types

```
 NONE
 CLIPBOARD
 RUN_COMMAND
 SUGGEST_COMMAND
 OPEN_BROWSER
```

 <br />
    
## Placeholder

Serverstate:
``
%STATE%
``

MOTD:
``
%MOTD%
``

Servernumber:
``
%NUMBER%
``
 
Online Spieler:
``
%ONLINE_PLAYERS%
``
 
Maximale Spieler:
``
%MAX_PLAYERS%
``

 <br />
    
## Kontakt

Twitter: [@MrManHD](https://twitter.com/MrManHD)

Discord: MrManHD | ƝƖƙƚƛƧ#5363

Discord-Server: [discord.TryHub.de](https://tryhub.de/discord)
