interface Subject {
    abstract void registerObserver(Observer o);
    abstract void removeObserver(Observer o);
    abstract void notfyAllObserver();
}
