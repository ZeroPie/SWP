package bks.gui.bootloader.gui;

import java.util.ResourceBundle;
import org.jdesktop.beansbinding.Validator;
import org.jdesktop.beansbinding.Validator.Result;

/**
 * UserID Validator. Generates Validation error if user id <= 0
 * @author farhan
 */
public class UserIDValidator extends Validator<Integer> {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("bks/gui/bootloader/gui/Bundle");

    @Override
    public Result validate(Integer value) {
        Result result = null;
        if (value <= 0) {
            result = new Result(null, bundle.getString("FORMATERR"));
        }
        return result;
    }
}
