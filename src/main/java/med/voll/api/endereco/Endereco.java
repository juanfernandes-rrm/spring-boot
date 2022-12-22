package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro()!=null){
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro()!=null){
            this.bairro = dados.bairro();
        }
        if(dados.cep()!=null){
            this.cep = dados.cep();
        }
        if(dados.numero()!=null){
            this.numero = dados.numero();
        }
        if(dados.complemento()!=null){
            this.complemento = dados.complemento();
        }
        if(dados.cidade()!=null){
            this.cidade = dados.cidade();
        }
        if(dados.uf()!=null){
            this.uf = dados.uf();
        }
    }
}
