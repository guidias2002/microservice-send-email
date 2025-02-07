package com.microservico.envia.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.example.dto.PedidoDto;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender mailSender;

    public void enviarConfirmacaoPedidoPorEmail(PedidoDto pedidoDto) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(pedidoDto.getEmailCliente());
        message.setSubject("Confirmação do pedido " + pedidoDto.getProduto());
        message.setText("Este é um email de confirmação do pedido " + pedidoDto.getProduto() + ". No valor de R$" + pedidoDto.getPreco());
        message.setFrom(fromEmail);

        mailSender.send(message);
        System.out.println("E-mail enviado com sucesso!");
    }
}
