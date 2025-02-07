package com.microservico.envia.email.consumer;

import com.microservico.envia.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.constantes.RabbitmqConstantes;
import org.example.dto.PedidoDto;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitmqConstantes.FILA_CONFIRMACAO_PEDIDOS_EMAIL)
    private void consumirPedido(PedidoDto pedidoDto) {
        emailService.enviarConfirmacaoPedidoPorEmail(pedidoDto);
    }
}
