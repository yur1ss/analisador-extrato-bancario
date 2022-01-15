package services;

import com.otimizapower.analizadorextratobancario.entities.BankTransaction;
import com.otimizapower.analizadorextratobancario.services.BankStatementCSVParser;
import com.otimizapower.analizadorextratobancario.services.IBankStatementParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class BankStatementCSVParserTest {
    private static final String ONE_LINE_OF_BANK_STATEMENT = "15-01-2022,1000,salary";
    private final IBankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void deveAnalisarUmaLinhaCorreta() {
        final BankTransaction result = bankStatementParser.parseFrom(ONE_LINE_OF_BANK_STATEMENT);
        final BankTransaction expected = BankTransaction.newInstance(
                LocalDate.of(2022, Month.JANUARY, 15),1000d,"salary");

        Assertions.assertEquals(expected.getDate(), result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
    }
}
