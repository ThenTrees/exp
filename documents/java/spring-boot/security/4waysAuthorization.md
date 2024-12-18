### 1. BASIC AUTHENTICATION
- Basic Authentication (Xác thực cơ bản) là một phương pháp xác thực đơn giản thuộc giao thức HTTP, trong đó người dùng cung cấp thông tin đăng nhập (tên người dùng và mật khẩu) để truy cập vào tài nguyên bảo mật trên một máy chủ
- Cách này sử dụng cơ chế xác thực HTTP Basic để xác thực thông tin đăng nhập.
- Khi người dùng gửi thông tin đăng nhập (*username và password*), thông tin đăng nhập sẽ được mã hóa và gửi lên server theo HTTP HEADER.
- Server sẽ giải mã thông tin đăng nhập và kiểm tra thông tin đăng nhập.
- Nếu thông tin đăng nhập hợp lệ, server sẽ trả về một token cho client.
- Token này sẽ được sử dụng để xác thực người dùng trong các request tiếp theo.

### 2. DIGIT AUTHENTICATION
- Giống như cách xác thực HTTP Basic, nhưng thông tin đăng nhập sẽ được mã hóa bằng mã hóa số.
### 3. SSL CLIENT AUTHENTICATION
- Cách này sử dụng cơ chế xác thực SSL để xác thực thông tin đăng nhập. Ít được dùng vì phức tạp.
### 4. FORM-BASED AUTHENTICATION
- Cách này sử dụng form để xác thực thông tin đăng nhập. Thông tin đăng nhập sẽ được gửi lên server qua form.
- Server sẽ kiểm tra thông tin đăng nhập và trả về một token cho client.
- Token này sẽ được sử dụng để xác thực người dùng trong các request tiếp theo.
- ***Lưu ý:*** Cách này phổ biến nhất trong các cách xác thực.