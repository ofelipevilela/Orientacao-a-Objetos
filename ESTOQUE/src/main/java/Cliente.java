class Cliente extends Pessoa {
    private String cpf;

    public Cliente(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }
}
