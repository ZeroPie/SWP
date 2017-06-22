package bks.gui.bootloader.gui;

import org.jdesktop.beansbinding.Converter;

/**
 * Integer to String and vice versa converter.
 * @author farhan
 */
public class UserIDConverter extends Converter<Integer, String> {

    @Override
    public String convertForward(Integer value) {
        return String.valueOf(value);
    }

    @Override
    public Integer convertReverse(String value) {
        int ret;
        try {
            ret = (value == null) ? 0 : Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            ret = 0;
        }
        return ret;
    }
}
