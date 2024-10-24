package br.calebe.ticketmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

class TicketMachineTests {
	@Test
	public void imprimirBilheteComSaldoZeradoTest() {
		TicketMachine tm = new TicketMachine(10);

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			tm.imprimir();
		});
	}
}
