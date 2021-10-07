package br.com.feltex.mensageiro;

import br.com.feltex.mensageiro.mensageiro.Usuario;
import br.com.feltex.mensageiro.mensageiro.UsuarioMensagemConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MensageiroApplicationTests {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void produzirMensagem() {
        var usuario = new Usuario("Jose da Silva", "2242-33441", "jose@feltex.com.br");
        rabbitTemplate.convertAndSend(UsuarioMensagemConfig.NOME_EXCHANGE, UsuarioMensagemConfig.ROUTING_KEY,
                usuario);
    }

}
