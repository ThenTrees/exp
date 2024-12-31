# Kafka Architecture
![Kafka](https://www.tutorialspoint.com/apache_kafka/images/cluster_architecture.jpg)

## Kiến trúc Kafka
1. **Producers**
- Các ứng dụng hoặc dịch vụ gửi dữ liệu(sự kiện) đến Kafka.
- Dữ liệu được gửi đến một topic cụ thể.

2. **Topics**
- Là nơi lưu trữ dữ liệu(sự kiện) trong Kafka.
- Mỗi topic được chia thành nhiều phần  nhỏ gọi là *partitions*, cho phép xử lý xong xong. 
- Dữ liệu trong mỗi partition được lưu trữ theo thứ tự và có thể đọc lại.

3. **Consumers**
- Nhận dữ liệu từ Kafka topic.
- Mỗi consumer thuộc một consumer group.
- Mỗi partition chỉ được một consumer trong một consumer group xử lý.
- Consumer group có thể có nhiều consumer.

4. **Brokers**
- Là các node(máy chủ) trong cluster Kafka.
- Mỗi broker chứa một phần dữ liệu của các topic.
- Mỗi broker có thể chứa nhiều partition của các topic.
- Mỗi partition chỉ được lưu trữ trên một broker.

5. **ZooKeeper**
- Là một dịch vụ quản lý Kafka.
- Dùng để quản lý các broker, topic, consumer group.
- Dùng để theo dõi trạng thái của các broker, topic, consumer group.

## Cách kafka hoạt động
- **Producer** gửi dữ liệu(sự kiện) đến một topic.
- **Broker** nhận dữ liệu từ producer và lưu trữ nó.
- **Consumer** nhận dữ liệu từ topic và xử lý nó.

![](https://images.viblo.asia/full/8bafdc21-2974-4143-9ff7-d077e4e064da.png)