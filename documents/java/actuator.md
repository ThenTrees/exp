```http://localhost:8080/actuator/info```    
Xem thông tin của service được config trong file ```yml``` hoặc ```properties```.
```bash
    Lưu ý: Nhớ thêm management.info.env.enabled=true vào file application.yml
```
```http://localhost:8080/actuator/metrics```
```bash
    Hiển thị các số liệu thống kê của ứng dụng, bao gồm số lượng request, thời gian xử lý, ...
```

```http://localhost:8080/actuator/health```
```bash
    management.endpoint.health.show-details=always
    Cho biết tình trạng của ứng dụng, bao gồm ổ đĩa, cơ ở dữ liệu ,... 
```
