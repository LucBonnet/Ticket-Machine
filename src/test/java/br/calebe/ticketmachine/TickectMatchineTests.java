package br.calebe.ticketmachine;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

class TicketMachineTests {
	@Test
	public void imprimirBilheteComSaldoZeradoTest() {
		TicketMachine tm = new TicketMachine(10);

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			tm.imprimir();
		});
	}

	@Test
	public void imprimirBilheteComSaldoAbaixoDoValorTest() {
		TicketMachine tm = new TicketMachine(3);

		Assertions.assertDoesNotThrow(() -> {
			tm.inserir(2);
		});

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			tm.imprimir();
		});
	}

	@Test
	public void imprimirBilheteComSaldoSuficienteTest() {
		TicketMachine tm = new TicketMachine(3);

		Assertions.assertDoesNotThrow(() -> {
			tm.inserir(5);
		});

		Assertions.assertDoesNotThrow(() -> {
			tm.imprimir();
		});

		Assertions.assertEquals(2, tm.getSaldo());
	}

	@Test
	public void inserirPapelMoedaInvalidoTest() {
		TicketMachine tm = new TicketMachine(3);

		Assertions.assertThrows(PapelMoedaInvalidaException.class, () -> {
			tm.inserir(3);
		});

		Assertions.assertEquals(0, tm.getSaldo());
	}

	@Test
	public void inserirPapelMoedaValidoTest() {
		TicketMachine tm = new TicketMachine(3);

		Assertions.assertDoesNotThrow(() -> {
			tm.inserir(5);
		});

		Assertions.assertEquals(5, tm.getSaldo());
	}

	@Test
	public void obterTrocoComSaldoMaiorQueZeroTest() {
		TicketMachine tm = new TicketMachine(3);

		Assertions.assertDoesNotThrow(() -> {
			tm.inserir(5);
		});

		Iterator<Integer> troco = tm.getTroco();
		Assertions.assertNotNull(troco);
	}
}
