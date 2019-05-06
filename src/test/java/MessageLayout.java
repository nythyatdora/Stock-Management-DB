public interface MessageLayout {
    int TYPE_DEFAULT = 0;
    int TYPE_WARNING = 1;
    int TYPE_SUCCESS = 2;
    int TYPE_DANGER = 3;

    void outputMessageLayout(String message, int type);
}
