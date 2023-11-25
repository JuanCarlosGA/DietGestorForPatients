package Helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;

public abstract class CSVCoder<T> {
    private char collumnSeparator = ';';
    public CSVCoder(char collumnSeparator) {
        this.collumnSeparator = collumnSeparator;
    }

    public abstract String[] encode(T object);

    public String encode(List<T> list) {
        StringJoiner strJoinerCollumns = null;
        StringJoiner strJoinerRows = new StringJoiner("\n");
        String[] data = {};

        for (T element : list) {
            data = encode(element);
            strJoinerCollumns = new StringJoiner(String.valueOf(collumnSeparator));
            for (String value : data) {
                strJoinerCollumns.add(value);
            }
            strJoinerRows.add(strJoinerCollumns.toString());
        }

        return strJoinerRows.toString();
    }

    public abstract T decode(String[] data);

    public void readFromFile(String path, List<T> list) throws IOException {
        String collumnSeparator = Character.toString(this.collumnSeparator);
        String rowSeparator = "\n";
        String data = "";

        data = new String(Files.readAllBytes(Paths.get(path)));
        String[] cells = {};

        if (data.indexOf("\r\n") > 0) {
            rowSeparator = "\r\n";
        }

        if (this.collumnSeparator == '|') {
            collumnSeparator = "\\|";
        }

        String[] rows = data.split(rowSeparator);
        for (String row : rows) {
            cells = row.split(collumnSeparator);
            list.add(decode(cells));
        }
    }
}
