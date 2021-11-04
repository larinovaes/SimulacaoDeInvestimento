package br.com.zup.projetoSimulacao.mensagemdeerro;

public class MensagemDeErro {
    private String mensagemDeErro;
    private String campo;

    public MensagemDeErro(String mensagemDeErro, String campo) {
        this.mensagemDeErro = mensagemDeErro;
        this.campo = campo;
    }

    public String getMensagemDeErro() {
        return mensagemDeErro;
    }

    public void setMensagemDeErro(String mensagemDeErro) {
        this.mensagemDeErro = mensagemDeErro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
