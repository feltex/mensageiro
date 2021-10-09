package br.com.feltex.mensageiro.mensageiro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsuarioConsumidor
{

    @RabbitListener(bindings = @QueueBinding(value = @Queue(UsuarioMensagemConfig.NOME_FILA),
            exchange = @Exchange(name = UsuarioMensagemConfig.NOME_EXCHANGE),
            key = UsuarioMensagemConfig.ROUTING_KEY))
    public void processarMensagem(final Message message, final Usuario usuario) {

        log.info("Prioridade {}", message.getMessageProperties().getPriority());
        log.info("Consumindo usuario {}", usuario);
    }
}
