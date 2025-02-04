package exemploHerancaAssociacao;

import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa {
    private Set<Turma> turmas = new HashSet<>();
    private Set<Curso> cursos = new HashSet<>();

    public Aluno() {
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

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void removerCurso(Curso curso) {
        this.cursos.remove(curso);
    }
}
