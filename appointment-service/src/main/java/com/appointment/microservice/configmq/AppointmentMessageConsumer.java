package com.appointment.microservice.configmq;

import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.service.AppointmentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentMessageConsumer {

    @Autowired
    private AppointmentService appointmentService;
    @RabbitListener(queues = MQConfig.QUEUE)
    public void consumeMessage(AppointmentModel appointmentModel){
        appointmentService.doAppointment(appointmentModel);
    }
}
