![follow of spring security](https://images.viblo.asia/3d6e20d9-8e39-4968-bf3a-1b31dd945488.png)
### Bước 1: Spring security filters
- Khi client gửi request từ browser đến server, request sẽ đi qua các filter của Spring Security. Các filter này sẽ kiểm tra xem request có hợp lệ không, nếu không hợp lệ thì sẽ trả về lỗi.
- Các filters của *Spring security*:
    - **SecurityContextPersistenceFilter**: Lưu trữ thông tin xác thực và quyền của người dùng vào session.
    - **LogoutFilter**: Xử lý logout.
    - **UsernamePasswordAuthenticationFilter**: Xác thực thông tin đăng nhập.
    - **DefaultLoginPageGeneratingFilter**: Tạo ra trang login mặc định.
    - **DefaultLogoutPageGeneratingFilter**: Tạo ra trang logout mặc định.
    - **BasicAuthenticationFilter**: Xác thực thông tin đăng nhập dựa trên HTTP Basic.
    - **RequestCacheAwareFilter**: Lưu trữ request hiện tại vào cache.
    - **SecurityContextHolderAwareRequestFilter**: Lưu trữ thông tin xác thực và quyền của người dùng vào SecurityContextHolder.
    - **AnonymousAuthenticationFilter**: Xác thực thông tin đăng nhập dựa trên thông tin đăng nhập mặc định.
    - **SessionManagementFilter**: Quản lý session.
    - **ExceptionTranslationFilter**: Xử lý exception.
    - **FilterSecurityInterceptor**: Kiểm tra quyền truy cập của người dùng.
### Bước 2: Authentication Manager
- Khi người dùng gửi thông tin đăng nhập, Spring Security sẽ sử dụng *AuthenticationManager* để xác thực thông tin đăng nhập.

- ***Lưu ý:*** Xác thực khác (*Authentication*) với kiểm tra (*Authorization*). Xác thực là xác định xem người dùng có phải là người dùng hợp lệ không, còn kiểm tra là xác định xem người dùng có quyền truy cập vào resource đó không.
### Bước 3: Authentication Provider
- *AuthenticationManager* sẽ sử dụng *AuthenticationProvider* để xác thực thông tin đăng nhập.
- *AuthenticationProvider* sẽ kiểm tra thông tin đăng nhập và trả về một đối tượng *Authentication* nếu thông tin đăng nhập hợp lệ.
- *AuthenticationProvider* sẽ trả về một exception nếu thông tin đăng nhập không hợp lệ.

**Thứ tự thực thi sẽ là:** Authentication -> Authorization

### Bước 4: UserDetailsService
- *UserDetailsService* sẽ lấy thông tin người dùng từ database.
- *UserDetailsService* sẽ trả về một đối tượng *UserDetails* chứa thông tin xác thực và quyền của người dùng.
- *UserDetailsService* sẽ trả về một exception nếu không tìm thấy thông tin người dùng.
- *UserDetailsService* sẽ trả về một exception nếu người dùng bị khóa.
- *UserDetailsService* sẽ trả về một exception nếu người dùng không có quyền truy cập vào resource đó.

### Bước 5: PasswordEncoder
- *PasswordEncoder* sẽ mã hóa mật khẩu người dùng trước khi lưu vào database. thường thì sẽ mã hóa bằng *BCrypt*.
- *PasswordEncoder* sẽ kiểm tra mật khẩu người dùng khi người dùng đăng nhập.
- *PasswordEncoder* sẽ trả về một exception nếu mật khẩu không hợp lệ.

### Bước 6 ...: Security Context Holder
- Sau khi đăng nhập thành công, thông tin xác thực và quyền của người dùng sẽ được lưu vào *SecurityContextHolder*.
- *SecurityContextHolder* sẽ lưu trữ thông tin xác thực và quyền của người dùng trong suốt quá trình request.
- *SecurityContextHolder* sẽ trả về thông tin xác thực và quyền của người dùng khi cần.
- *Principal* là đại diện danh tính của người dùng, thường là một đối tượng *UserDetails*.
- *Authorities* là quyền hạn của người dùng đang đăng nhập, thường là một danh sách các quyền hạn.

<p align="center">
------------------------------------------- Lưu Ý -------------------------------------------
</p>
<p align="center">
***Luồng thực thi của JWT sẽ khác một xíu so với Spring security***
</p>

![follow of spring security 6](https://drive.google.com/file/d/1aOwGGFhVLXqo-464PlqYrrsskgmY5_CA/view?usp=sharing)