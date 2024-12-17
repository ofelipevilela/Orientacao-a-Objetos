package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {


    @Test //1,7**2 = 2,89
    void mulherAbaixoDoPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("F");
        pessoa.setPeso(55.1);  //2,89 * 19,1 pra baixo
        pessoa.setAltura(1.70);
        assertEquals("Abaixo do peso", pessoa.calculaImc());
    }


    @Test
    void mulherNoPesoNormal() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("F");
        pessoa.setPeso(74.5); //2,89 * 25,8 pra baixo
        pessoa.setAltura(1.70);
        assertEquals("No peso normal", pessoa.calculaImc());
    }


    @Test
    void mulherMarginalmenteAcimaDoPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("F");
        pessoa.setPeso(78.8);  //2,89 * 27,3 pra baixo
        pessoa.setAltura(1.70);
        assertEquals("Marginalmente acima do peso", pessoa.calculaImc());
    }


    @Test
    void mulherAcimaDoPesoIdeal() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("F");
        pessoa.setPeso(93.3);  //2,89 * 32,3 pra baixo
        pessoa.setAltura(1.70);
        assertEquals("Acima do peso ideal", pessoa.calculaImc());
    }


    @Test
    void mulherObesa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("F");
        pessoa.setPeso(93.4);  //2,89 * 32,3 pra cima
        pessoa.setAltura(1.70);
        assertEquals("Obeso", pessoa.calculaImc());
    }


    @Test //1,80 * 1,80 = 3,24
    void homemAbaixoDoPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("M");
        pessoa.setPeso(67.0);   //3,24 * 20,7 pra baixo
        pessoa.setAltura(1.80);
        assertEquals("Abaixo do peso", pessoa.calculaImc());
    }


    @Test
    void homemNoPesoNormal() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("M");
        pessoa.setPeso(85.5);  //3,24 * 26,4 pra baixo
        pessoa.setAltura(1.80);
        assertEquals("No peso normal", pessoa.calculaImc());
    }


    @Test
    void homemMarginalmenteAcimaDoPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("M");
        pessoa.setPeso(90);  //3,24 * 27,8 pra baixo
        pessoa.setAltura(1.80);
        assertEquals("Marginalmente acima do peso", pessoa.calculaImc());
    }


    @Test
    void homemAcimaDoPesoIdeal() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("M");
        pessoa.setPeso(100);  //3,24 * 31,1 pra baixo
        pessoa.setAltura(1.80);
        assertEquals("Acima do peso ideal", pessoa.calculaImc());
    }


    @Test
    void homemObeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setSexo("M");
        pessoa.setPeso(101);  //3,24 * 31,1 pra cima
        pessoa.setAltura(1.80);
        assertEquals("Obeso", pessoa.calculaImc());
    }

    @Test
    void sexoInvalido() {
        Pessoa pessoa = new Pessoa();
        try {
            pessoa.setSexo("X");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Use 'M' para masculino ou 'F' para feminino", e.getMessage());
        }
    }
}