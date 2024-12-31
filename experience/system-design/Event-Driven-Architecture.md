# Tổng Quan Về Event-Driven Architecture
1. Giới thiệu  
   - Event-Driven Architecture (EDA) là một kiến trúc phần mềm mà các thành phần của hệ thống giao tiếp với nhau thông qua các sự kiện.(sản xuất và tiêu thụ)
   - Các sự kiện này có thể là bất kỳ hành động nào trong hệ thống như tạo, cập nhật hoặc xóa dữ liệu.
2. Kiến trúc EDA.  
  2.1 Thành phần chính.  
   - Event Producer: Tạo ra sự kiện và gửi nó đến một hoặc nhiều Event Consumer.
    *example:* Khi một người dùng tạo một bài viết trên blog, hệ thống sẽ tạo một sự kiện `PostCreated` và gửi nó đến các Event Consumer như `Notification Service` để thông báo cho người dùng khác.
   - Event Consumer: Nhận sự kiện và xử lý nó.
    *example:* `Notification Service` nhận sự kiện `PostCreated` và sau đó gửi thông báo đến người dùng khác.
   - Event Broker: Là nơi lưu trữ sự kiện và phân phối chúng đến các Event Consumer.
    *example:* `Kafka`, `RabbitMQ`, `AWS SNS`, `Google Pub/Sub`.  
  2.2 Qui trình hoạt động.
   - Event Producer tạo ra sự kiện và gửi nó đến Event Broker.
   - Event Broker lưu trữ sự kiện và phân phối chúng đến các Event Consumer.
   - Event Consumer nhận sự kiện và xử lý nó.  
   ![ERA](https://images.viblo.asia/d32e8d31-480b-46c7-aab3-b1e85d83f71c.png)
3. Các mô hình triển khai
   - Point-to-Point: Một Event Producer gửi sự kiện đến một Event Consumer.
   - Publish/Subscribe: Một Event Producer gửi sự kiện đến một Event Broker và nhiều Event Consumer đăng ký nhận sự kiện đó.
   - Event Streaming: Sự kiện được lưu trữ trong một luồng và các Event Consumer có thể đọc sự kiện từ luồng đó.
4. Ưu và nhượt điểm
   4.1 Ưu điểm
   - Linh hoạt: Các thành phần của hệ thống không cần biết về nhau và có thể phát triển, triển khai và hoạt động độc lập.
   - Xử lý thời gian thực: Các sự kiện có thể được xử lý ngay lập tức khi chúng xảy ra.
   - Mở rộng: Các thành phần của hệ thống có thể được mở rộng một cách dễ dàng bằng cách thêm hoặc giảm Event Producer và Event Consumer.
   4.2 Nhược điểm
   - Phức tạp: Việc quản lý các sự kiện và đảm bảo tính nhất quán có thể phức tạp.
   - Độ trễ: Có thể có độ trễ giữa khi sự kiện xảy ra và khi nó được xử lý bởi Event Consumer.
   - Khó Debug: Việc theo dõi và gỡ lỗi các sự kiện có thể khó khăn trong hệ thống phân tán.
   - Chi phí quản lý: Việc triển khai và quản lý một hệ thống EDA có thể tốn kém.
5. Các công nghệ phổ biến
    - Apache Kafka
    - RabbitMQ
    - AWS SNS
    - Google Pub/Sub
    - Azure Event Hubs

**Author:** Thentrees
