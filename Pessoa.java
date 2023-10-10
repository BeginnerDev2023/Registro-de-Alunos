
public class Pessoa {
    private String nome;
    private String endereco;
    private data nascimento;

    public Pessoa (){}


    public Pessoa(String nome, String endereco, data nascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = nascimento;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public data getNascimento() {
        return nascimento;
    }


    public void setNascimento(data nascimento) {
        this.nascimento = nascimento;
    }


    void exibirDados(){
        System.out.println("Nome:"+this.nome);
        System.out.println("Endereço:"+this.endereco);
        System.out.printf("Nascimento: %02d/%02d/%04d%n", this.nascimento.getDia(), this.nascimento.getMes(), this.nascimento.getAno());
        System.out.println("========================");
    }    
    
}
