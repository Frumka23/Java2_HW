package test;

public class StringNotInt extends Exception {
    public StringNotInt(int i, int j, String value, Throwable caused) {
        super(String.format("Указано не числовое значение %s в ячейке [%d][%d]", value, i, j), caused);
    }
}
