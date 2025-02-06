package exemploHerancaAssociacao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

class Testes {

    @Test
    void deveRetornarNomeDoProfessorDaTurma() {
        Professor professor = new Professor();
        professor.setNome("Dr. Silva");

        Turma turma = new Turma();
        turma.setIdentificador("Turma A");
        turma.setProfessor(professor);

        professor.setTurma(turma);

        assertEquals("Dr. Silva", turma.getProfessor().getNome());
    }

    @Test
    void deveRetornarNomesDosAlunosDaTurma() {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Ana");

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Carlos");

        Turma turma = new Turma();
        turma.setIdentificador("Turma B");

        aluno1.adicionarTurma(turma);
        aluno2.adicionarTurma(turma);

        Set<String> nomesAlunos = new HashSet<>();
        for (Aluno aluno : new Aluno[]{aluno1, aluno2}) {
            if (aluno.getTurmas().contains(turma)) {
                nomesAlunos.add(aluno.getNome());
            }
        }

        assertTrue(nomesAlunos.contains("Ana"));
        assertTrue(nomesAlunos.contains("Carlos"));
        assertEquals(2, nomesAlunos.size());
    }

    @Test
    void deveRetornarNomesDosProfessoresDeUmCurso() {
        Curso curso = new Curso();
        curso.setNome("Engenharia");

        Turma turma1 = new Turma();
        turma1.setIdentificador("Turma C");
        turma1.adicionarCurso(curso);

        Turma turma2 = new Turma();
        turma2.setIdentificador("Turma D");
        turma2.adicionarCurso(curso);

        Professor professor1 = new Professor();
        professor1.setNome("Prof. João");
        turma1.setProfessor(professor1);

        Professor professor2 = new Professor();
        professor2.setNome("Prof. Maria");
        turma2.setProfessor(professor2);

        Set<String> nomesProfessores = new HashSet<>();
        for (Turma turma : curso.getTurmas()) {
            if (turma.getProfessor() != null) {
                nomesProfessores.add(turma.getProfessor().getNome());
            }
        }

        assertTrue(nomesProfessores.contains("Prof. João"));
        assertTrue(nomesProfessores.contains("Prof. Maria"));
        assertEquals(2, nomesProfessores.size());
    }

    @Test
    void deveRetornarNomesDosAlunosDeUmCurso() {
        Curso curso = new Curso();
        curso.setNome("Administração");

        Turma turma1 = new Turma();
        turma1.setIdentificador("Turma E");
        turma1.adicionarCurso(curso);

        Turma turma2 = new Turma();
        turma2.setIdentificador("Turma F");
        turma2.adicionarCurso(curso);

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Beatriz");
        aluno1.adicionarTurma(turma1);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Ricardo");
        aluno2.adicionarTurma(turma2);

        Set<String> nomesAlunos = new HashSet<>();
        for (Turma turma : curso.getTurmas()) {
            for (Aluno aluno : new Aluno[]{aluno1, aluno2}) {
                if (aluno.getTurmas().contains(turma)) {
                    nomesAlunos.add(aluno.getNome());
                }
            }
        }

        assertTrue(nomesAlunos.contains("Beatriz"));
        assertTrue(nomesAlunos.contains("Ricardo"));
        assertEquals(2, nomesAlunos.size());
    }

    @Test
    void deveRetornarNomesDosAlunosRegistradosEmUmCurso() {
        Curso curso = new Curso();
        curso.setNome("Ciência da Computação");

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Gustavo");
        aluno1.adicionarCurso(curso);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Letícia");
        aluno2.adicionarCurso(curso);

        Set<String> nomesAlunos = new HashSet<>();
        for (Aluno aluno : new Aluno[]{aluno1, aluno2}) {
            if (aluno.getCursos().contains(curso)) {
                nomesAlunos.add(aluno.getNome());
            }
        }

        assertTrue(nomesAlunos.contains("Gustavo"));
        assertTrue(nomesAlunos.contains("Letícia"));
        assertEquals(2, nomesAlunos.size());
    }

    @Test
    void deveRetornarDisciplinasDeUmCurso() {
        Curso curso = new Curso();
        curso.setNome("Matemática");

        Turma turma1 = new Turma();
        turma1.setIdentificador("Turma G");
        turma1.adicionarCurso(curso);

        Turma turma2 = new Turma();
        turma2.setIdentificador("Turma H");
        turma2.adicionarCurso(curso);

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNome("Cálculo I");
        disciplina1.setTurma(turma1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("Álgebra Linear");
        disciplina2.setTurma(turma2);

        Set<String> disciplinasCurso = new HashSet<>();
        for (Turma turma : curso.getTurmas()) {
            if (turma != null) {
                for (Disciplina disciplina : new Disciplina[]{disciplina1, disciplina2}) {
                    if (disciplina.getTurma().equals(turma)) {
                        disciplinasCurso.add(disciplina.getNome());
                    }
                }
            }
        }
        assertTrue(disciplinasCurso.contains("Cálculo I"));
        assertTrue(disciplinasCurso.contains("Álgebra Linear"));
        assertEquals(2, disciplinasCurso.size());
    }
    @Test
    void deveVerificarSeAlunoEstaNaTurma() {
        Aluno aluno = new Aluno();
        aluno.setNome("Lucas");

        Turma turma = new Turma();
        turma.setIdentificador("Turma X");

        aluno.adicionarTurma(turma);

        assertTrue(aluno.getTurmas().contains(turma));
    }

    @Test
    void deveVerificarSeAlunoNaoEstaNaTurma() {
        Aluno aluno = new Aluno();
        aluno.setNome("Lucas");

        Turma turma = new Turma();
        turma.setIdentificador("Turma X");

        assertFalse(aluno.getTurmas().contains(turma));
    }

    @Test
    void deveVerificarSeAlunoEstaNoCurso() {
        Aluno aluno = new Aluno();
        aluno.setNome("Mariana");

        Curso curso = new Curso();
        curso.setNome("Engenharia Civil");

        aluno.adicionarCurso(curso);

        assertTrue(aluno.getCursos().contains(curso));
    }

    @Test
    void deveVerificarSeAlunoNaoEstaNoCurso() {
        Aluno aluno = new Aluno();
        aluno.setNome("Mariana");

        Curso curso = new Curso();
        curso.setNome("Engenharia Civil");

        assertFalse(aluno.getCursos().contains(curso));
    }

    @Test
    void deveVerificarSeTurmaEstaNoCurso() {
        Curso curso = new Curso();
        curso.setNome("Medicina");

        Turma turma = new Turma();
        turma.setIdentificador("Turma Y");
        turma.adicionarCurso(curso);

        assertTrue(curso.getTurmas().contains(turma));
    }

    @Test
    void deveVerificarSeTurmaNaoEstaNoCurso() {
        Curso curso = new Curso();
        curso.setNome("Medicina");

        Turma turma = new Turma();
        turma.setIdentificador("Turma Y");

        assertFalse(curso.getTurmas().contains(turma));
    }

    @Test
    void deveExcluirAlunoDaTurma() {
        Aluno aluno = new Aluno();
        aluno.setNome("Lucas");

        Turma turma = new Turma();
        turma.setIdentificador("Turma X");

        aluno.adicionarTurma(turma);
        assertTrue(aluno.getTurmas().contains(turma));

        aluno.removerTurma(turma);
        assertFalse(aluno.getTurmas().contains(turma));
    }

    @Test
    void deveExcluirTurmaDoCurso() {
        Curso curso = new Curso();
        curso.setNome("Engenharia");

        Turma turma = new Turma();
        turma.setIdentificador("Turma Y");

        curso.adicionarTurma(turma);
        assertTrue(curso.getTurmas().contains(turma));

        curso.removerTurma(turma);
        assertFalse(curso.getTurmas().contains(turma));
    }

    @Test
    void deveExcluirAlunoDoCurso() {
        Aluno aluno = new Aluno();
        aluno.setNome("Mariana");

        Curso curso = new Curso();
        curso.setNome("Medicina");

        aluno.adicionarCurso(curso);
        assertTrue(aluno.getCursos().contains(curso));

        aluno.removerCurso(curso);
        assertFalse(aluno.getCursos().contains(curso));
    }
}
