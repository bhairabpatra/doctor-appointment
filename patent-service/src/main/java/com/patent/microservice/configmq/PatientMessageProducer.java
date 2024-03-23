package com.patent.microservice.configmq;

import com.patent.microservice.model.AppointmentModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendPatientDetails(AppointmentModel appointmentModel){
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, appointmentModel);

    }
}
