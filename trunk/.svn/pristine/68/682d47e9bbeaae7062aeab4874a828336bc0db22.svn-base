package bks.fachlogik.kontosteuerung.impl;

import bks.fachlogik.componentcontroller.services.CompType;
import bks.fachlogik.componentcontroller.services.IActivateComponent;

/**
 *
 * @author mhenk
 */
public class IActivateComponentImpl implements IActivateComponent
{
    
    private boolean activated = false;
    private final CompType compType = CompType.KONTO;
    
    //AP4 Barthélémy Bonhomme
    @Override
    public CompType getComponentType()
    {
        return this.compType;
    }

    //AP4 Barthélémy Bonhomme
    @Override
    public boolean activateComponent(int userid)
    {
        if(userid != 23){
            return false;
        }
        
        if(!this.activated){
            this.activated = true;
            return true;
        }
        
        return false;
    }

    //AP4 Barthélémy Bonhomme
    @Override
    public boolean deactivateComponent()
    {
        if(this.activated){
            this.activated = false;
            return true;
        }
        
        return false;
    }

    //AP4 Barthélémy Bonhomme
    @Override
    public boolean isActivated()
    {
        return this.activated;
    }
    
}
