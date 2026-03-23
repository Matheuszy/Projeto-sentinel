import pika
import json
import joblib
import pandas as pd


model = joblib.load('model/modelo_fraude.pkl')


def callback(ch, method, properties, body):

    transaction_data = json.loads(body)
    print(f" [x] Recebido: {transaction_data}")

    input_data = pd.DataFrame([[transaction_data['amount']]], columns=['Amount'])

    prediction = model.predict(input_data)

    if prediction[0] == -1:
        print(f" ALERTA DE FRAUDE! Transação ID: {transaction_data['transaction_id']}")

    else:
        print(f" [OK] Transação legítima: {transaction_data['transaction_id']}")

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

channel.queue_declare(queue='transaction.inbound', durable=True)

channel.basic_consume(queue='transaction.inbound', on_message_callback=callback, auto_ack=True)


channel.start_consuming()
