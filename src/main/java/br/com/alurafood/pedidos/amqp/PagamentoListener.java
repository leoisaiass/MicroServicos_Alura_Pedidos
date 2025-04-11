package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    // Anotação que indica que este metodo irá escutar a fila "pagamento.concluido"
    @RabbitListener(queues = "pagamento.concluido")
    // O @Payload indica que o parâmetro 'pagamento' será preenchido com os dados da mensagem recebida.
    public void recebeMensagem(@Payload PagamentoDto pagamento) {

        String mensagem = """
                Dados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s 
                Pagador: %s
                """.formatted(pagamento.getId(),
                pagamento.getPedidoId(),
                pagamento.getValor(),
                pagamento.getStatus(),
                pagamento.getNome());

        System.out.println("Recebi a mensagem " + mensagem);

    }
}