package com.gamedev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommandContainer
{
    private String command;
    private String argument;
    private String data;

    private String chat_id;
    private String msg_id;

    private boolean callbackFlag;
    private boolean errorFlag;
    
    private static final Logger logger = LoggerFactory.getLogger(CommandContainer.class);

    public CommandContainer(String[] input, Boolean callbackFlag, String chat_id, String msg_id) {
        try {
            this.msg_id = msg_id;
            this.callbackFlag = callbackFlag;
            this.chat_id = chat_id;
            this.command = input[0];
            this.argument = input[1];
            this.data = input[2];
        } catch (Exception e) {
            logger.warn(
                "Couldn't parse the whole array to commandContainer\n" + e.getMessage()
            );
        }
    }

    public CommandContainer(String[] input, String chat_id) {
        try {
            this.chat_id = chat_id;
            this.command = input[0];
            this.argument = input[1];
            this.data = input[2];
        } catch (Exception e) { 
            logger.warn(
                "Couldn't parse the whole array to commandContainer\n" + e.getMessage()
            );    
        }
    }

    public String getCommand() {
        return this.command;
    }

    public String getArgument() {
        return this.argument;
    }

    public String getData() {
        return this.data;
    }

    public boolean hasCallback() {
        return callbackFlag;
    }

    public String getChatID() {
        return this.chat_id;
    }

    public String getMsgId() {
        return this.msg_id;
    }
}