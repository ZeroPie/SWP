package bks.fachlogik.componentcontroller.services;

public interface IActivateComponent
{

    public CompType getComponentType();

    public boolean activateComponent(int userid);

    public boolean deactivateComponent();

    public boolean isActivated();
}
