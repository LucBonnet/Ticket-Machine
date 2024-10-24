package br.calebe.ticketmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.Troco;

class TrocoTests {
    @Test
    public void obterTrocoComValorMaiorQueZeroTest() {
        Troco troco = new Troco(2);

        Iterator<PapelMoeda> iterator = troco.getIterator();
        while(iterator.hasNext()) {
            PapelMoeda pm = iterator.next();

            if (pm.getValor() == 2) {
                Assertions.assertEquals(1, pm.getQuantidade());
            } else {
                Assertions.assertEquals(0, pm.getQuantidade());
            }
        }
    }
    
    @Test
    public void obterTrocoComTodosOsValoresDePapelMoedaTest() {
        Troco troco = new Troco(187);

        Iterator<PapelMoeda> iterator = troco.getIterator();
        while(iterator.hasNext()) {
            PapelMoeda pm = iterator.next();
            Assertions.assertEquals(1, pm.getQuantidade());
        }
    }

}
