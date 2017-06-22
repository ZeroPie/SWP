package bks.gui.bootloader.gui;

import bks.gui.bootloader.grenz.Message;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Binding.SyncFailure;

/**
 * Validation Listener for bindings.
 * @author farhan
 */
public class LoggingBindingListener extends AbstractBindingListener {

    private IMessageLogger logger;
    private volatile boolean isValid;

    public LoggingBindingListener(IMessageLogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException();
        }
        this.logger = logger;
        isValid = true;
    }
    

    @Override
    public void syncFailed(Binding binding, SyncFailure fail) {
        String description;        
        if ((fail != null) && (fail.getType() == Binding.SyncFailureType.VALIDATION_FAILED)) {
            description = fail.getValidationResult().getDescription();
        } else {
            description = "Sync failed!";
        }
        if( binding.getValidator() instanceof UserIDValidator){
            isValid = false;            
            logger.logMessage(description, Message.Error);
        }
    }

    @Override
    public void synced(Binding binding) {      
        if( binding.getValidator() instanceof UserIDValidator && !isValid){
            isValid = true;            
            logger.logMessage("OK", Message.Info);
        }

    }

    

}
