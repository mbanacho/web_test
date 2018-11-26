package pl.mbanacho.corpo.service.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.mbanacho.corpo.database.model.Employee;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


@Service
public class RabbitMqProducer {

    private final static Logger LOG = LoggerFactory.getLogger(RabbitMqProducer.class);

    @Value( "${rabbit.mq.user}" )
    private String RABBIT_USER;

    @Value( "${rabbit.mq.password}" )
    private String RABBIT_PASSWORD;

    @Value( "${rabbit.mq.host}" )
    private String RABBIT_HOST;

    @Value( "${rabbit.mq.port}" )
    private Integer RABBIT_PORT;

    @Value( "${rabbit.mq.queue.name}" )
    private String RABBIT_QUEUE_NAME;

    public void connectToRabbitMq(List<Employee> employees){
        try {
            Connection connection = getRabbitMqConnection();

            Channel channel = connection.createChannel();
            channel.queueDeclare(RABBIT_QUEUE_NAME, false, false, false, null);


            Employee emp = employees.get(0);
            emp.setReportsTo(null);
            emp.setOfficeCode(null);
            LOG.info("Try to convert emp: "+emp.toString());
            String message = convert(emp);
            LOG.info("Try to insert message: "+message);
            channel.basicPublish("", RABBIT_QUEUE_NAME, null, message.getBytes());


            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            connection.close();

        }catch (TimeoutException te){
            LOG.error(te.getMessage());
        }catch (IOException ioe){
            LOG.error(ioe.getMessage());
        }
    }

    private Connection getRabbitMqConnection() throws IOException, TimeoutException {
        LOG.info("Create rabbit connection "+RABBIT_HOST+RABBIT_PORT);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(RABBIT_USER);
        factory.setPassword(RABBIT_PASSWORD);
        factory.setHost(RABBIT_HOST);
        factory.setPort(RABBIT_PORT);
        return factory.newConnection();
    }

    public String convert(Object obj) {
        LOG.info("Try to convert");
        Gson gson = new GsonBuilder().create();
        LOG.info("ddddddddddd");
        String str = gson.toJson(obj);
        LOG.info(str);
        return str;
    }
}
