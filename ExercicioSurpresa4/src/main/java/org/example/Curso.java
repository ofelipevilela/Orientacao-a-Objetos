package exemploHerancaAssociacao;

import java.util.HashSet;
import java.util.Set;

public class Curso {
    private String nome;
    private Set<Turma> turmas = new HashSet<>();

    public Curso() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }
}
