import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestUnivocity {
    public void parseCSV(String fileName) {
        CsvParserSettings parserSettings = new CsvParserSettings(); //bring conf settings
        parserSettings.setLineSeparatorDetectionEnabled(true); //automatically detect line separated liens
        RowListProcessor rowProcessor = new RowListProcessor(); //process each row
        parserSettings.setRowProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true); //consider the first row as headers
        CsvParser parser = new CsvParser(parserSettings);
        parser.parse(new File(fileName)); //parse the file

        //String[] headers = rowProcessor.getHeaders();
        List<String[]> rows = rowProcessor.getRows(); //get the each line as a string list
        for (String[] row : rows) {
            System.out.println(Arrays.asList(row));
        }
    }

    public static void main(String[] args) {
        TestUnivocity test = new TestUnivocity();
        test.parseCSV("C:\\Users\\Aras\\Desktop\\testCSV.csv");

    }
}

