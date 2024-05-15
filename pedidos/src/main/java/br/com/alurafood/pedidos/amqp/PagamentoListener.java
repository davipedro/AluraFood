package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentoDto;

//o nome refere ao pagamento pois ele está ouvindo o servico de pagamento
@Component
public class PagamentoListener {
    
    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(PagamentoDto pagamento){

        String mensagem = """
            Dados do pagamento: %s
            Número do pedido: %s
            Valor R$: %s
            Status: %s
        """
            .formatted(pagamento.getId(), pagamento.getPedidoId(), pagamento.getValor(), pagamento.getStatus());

        System.out.println("Recebendo mensagem de pagamento: " +  mensagem);
    }
}
