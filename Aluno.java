public class Aluno extends Pessoa {
    
    private double[] notas = new double[4];
    
    public Aluno(){};

    public Aluno(double[] notas) {
        for (int i = 0; i<notas.length; i++){
            this.notas[i] = notas[i];
        }
    }

 

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    

    public Pessoa RegistrarAluno(String nome, String endereco, data nascimento) {
        Pessoa aluno = new Pessoa(nome, endereco, nascimento);
        return aluno;
    }
    
    
    
    public void calcularMedia(){
        double media = 0;
        for (int i = 0; i < this.notas.length; i++) {
            media += this.notas[i];
        }
        
        media /= this.notas.length;
        
        System.out.println("Aluno(a):"+getNome());
        System.out.println("Media: "+media);
    }

    
    
    
}