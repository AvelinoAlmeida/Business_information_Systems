package WorkSchedule;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class WorkTest {

    private WorkSchedule workSchedule;
    private boolean allocationResult;
    private int hours; // Número de horas no calendário

    @Given("{int} hours a calendar")
    public void hHoursACalendar(int hours) {
        this.hours = hours; // Armazena o número de horas
        workSchedule = new WorkSchedule(hours); // Inicializa o calendário com o número de horas especificado
    }

    @And("{int} Employee needed to work")
    public void nEmployeeNeededToWork(int employeesNeeded) {
        // Define o número necessário de empregados para todas as horas
        for (int i = 0; i < hours; i++) { // Usa o valor do cenário Gherkin
            workSchedule.setRequiredNumber(employeesNeeded, i, i);
        }
    }

    @When("I allocate an {string} to work from {int} to {int}")
    public void iAllocateAnEmployeeToWorkFromIToF(String employee, int start, int end) {
        // Aloca um empregado no intervalo de horas especificado
        allocationResult = workSchedule.addWorkingPeriod(employee, start, end);
    }

    @Then("the result is {string}")
    public void theResultIs(String expectedResult) {
        // Converte o resultado esperado (string) para booleano e verifica o resultado
        boolean expected = Boolean.parseBoolean(expectedResult);
        assertEquals(expected, allocationResult, "O resultado da alocação está incorreto!");
    }
}