![Microservice](https://substackcdn.com/image/fetch/w_1456,c_limit,f_webp,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2F50a33065-89a1-49f1-989f-7f5d101fba61_3929x2429.png)
- **Monolithic:** Là một kiến trúc phần mềm mà ứng dụng được xây dựng dưới dạng một hệ thống lớn, chạy trên một máy chủ duy nhất. Tất cả các chức năng của ứng dụng đều được xây dựng trong một project duy nhất.
  - Tập trung toàn bộ vào 1 ứng dụng lớn, dễ hiểu dễ làm.
  - Kiến trúc truyền thống quen thuộc, dễ tiếp cận.
  - Phù hợp với dự án nhỏ(codebase và team nhỏ).
  - Phát triển và đưa ra sản phẩm nhanh.
![monolithic](https://images.viblo.asia/full/1381a58c-c04a-4ba7-a93b-70f5fa13daa4.png)
- **Microservice:** Là một kiến trúc phần mềm mà ứng dụng được xây dựng dưới dạng các dịch vụ nhỏ, chạy độc lập và có thể mở rộng dễ dàng. Mỗi service sẽ chịu trách nhiệm cho một chức năng cụ thể của ứng dụng.
  - Xây dựng các service độc lập, các team làm việc độc lập với từng service, features.
  - Các service có thể được viết bằng các ngôn ngữ lập trình khác nhau.
![microservice](https://api.careers.saigontechnology.com/storage/blogs/BLOG-oHeLIaKdmd21vu7mDMMl7HFbHIBRc4T1j9zNwSWY.webp)

```bash
  Tư tưởng của microservice là chia bài toán lớn thành các bài toán nhỏ.
```
![so sánh giữa microservice và monolithic](https://images.viblo.asia/full/43ad4c7e-fcb1-4b02-918c-d788f40390e8.png)
- Điểm mạnh:
  - Phù hợp vơi các ứng dụng lớn, phức tạp.
  - Về lâu dài dễ quản lý và mở rộng.
  - Dễ dàng phát triển và nâng cấp (Vì chỉ code theo chức năng nên khi join dự án chỉ cần học những service có liên quan).
  - Kiểm soát lỗi tốt hơn (Mỗi service chịu trách nhiệm cho một chức năng cụ thể nên khi có lỗi chỉ cần fix ở service đó).
- Điểm yếu: 
  - Phức tạp hơn trong việc quản lý, triển khai và monitor.
  - Cần phải có kiến thức về các công nghệ, ngôn ngữ lập trình khác nhau.
  - Khó đồng bộ và thống nhất giữa các service.
### Các thành phần cơ bản chính của ***microservice***.
![các thành phần cơ bản](https://statics.cdn.200lab.io/2024/02/sap2_0601.png)
- **Service:** Chứa các logic nghiệp vụ của từng chức năng cụ thể của ứng dụng. Chỉ *service* mới có thể truy cập vào db được.
- **Database:** Một tập hợp các table chứa dữ liệu của ứng dụng, phục vụ cho logic nghiệp vụ của service.
- **API Gateway:** Là một cổng giao tiếp giữa client và các service. Nó nhận request từ client và chuyển tiếp request đó đến service tương ứng.

### Các service giao tiếp với nhau trong ***microservice***.
- Các service có thể giao tiếp với nhau qua các cách sau:    
**Synchronous Communication:**
  - **HTTP Request:** Service A gửi request đến service B thông qua HTTP.
  - **gRPC:** Service A gửi request đến service B thông qua gRPC.
![api](https://images.viblo.asia/c247ce56-e3bd-45fa-95a3-e209d4ba5863.png)
  **Asynchronous Communication:**
  - **Message Queue:** Service A gửi message đến message queue, service B lắng nghe message queue và nhận message từ đó (1 msg chỉ được 1 service tiêu thụ).
  - **Event Bus:** Service A gửi event đến event bus, service B lắng nghe event bus và nhận event từ đó. (1 event có thể được nhiều service tiêu thụ đồng thời).
![message queue](https://images.viblo.asia/562f9b20-4123-407e-bbba-79cc53ca2707.png)

