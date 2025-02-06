package exemploHerancaAssociacao;

public class Professor extends Pessoa {
    private Turma turma;

    public Professor() {
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
