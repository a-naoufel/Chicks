
public interface IObsovable {
    public void addObserver(IObsover o);
    public void removeObserver(IObsover o);
    public void notifyObservers();
}
