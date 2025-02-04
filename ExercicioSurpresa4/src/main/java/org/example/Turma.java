package exemploHerancaAssociacao;

import java.util.HashSet;
import java.util.Set;

public class Turma {
    private String identificador;
    private Professor professor;
    private Set<Curso> cursos = new HashSet<>();

    public Turma() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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

