package bks.gui.bootloader.gui;

import bks.gui.bootloader.grenz.Message;

/**
 * Interface for logging messages.
 * @author farhan
 */
public interface IMessageLogger {
    public void logMessage(String msg, Message msgTyp);    
}
