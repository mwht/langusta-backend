package ovh.spajste.langusta.dataview;

public interface DataView<T> {
    public DataView<T> getDataViewFor(T element);
}
