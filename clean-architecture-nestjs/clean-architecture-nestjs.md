```
src/
│── core/                # Business logic và các định nghĩa chung
│   ├── domain/          # Entities và Aggregates
│   │   ├── entities/
│   │   │   ├── user.entity.ts
│   │   │   ├── order.entity.ts
│   │   │   ├── product.entity.ts
│   │   ├── repositories/
│   │   │   ├── user.repository.ts
│   │   │   ├── order.repository.ts
│   │   │   ├── product.repository.ts
│   ├── application/     # Use Cases (Services)
│   │   ├── dto/
│   │   │   ├── create-user.dto.ts
│   │   │   ├── update-user.dto.ts
│   │   ├── use-cases/
│   │   │   ├── create-user.use-case.ts
│   │   │   ├── get-user.use-case.ts
│   │   │   ├── update-user.use-case.ts
│
│── infrastructure/      # Cấu hình và các adapter kết nối với bên ngoài
│   ├── database/        # Database ORM/ODM (Prisma, TypeORM, Sequelize...)
│   │   ├── prisma/
│   │   ├── typeorm/
│   ├── repositories/    # Triển khai thực tế của các repositories
│   │   ├── user.repository.impl.ts
│   │   ├── order.repository.impl.ts
│   ├── controllers/     # REST API hoặc GraphQL controllers
│   │   ├── user.controller.ts
│   │   ├── order.controller.ts
│   ├── modules/         # Định nghĩa module của NestJS
│   │   ├── user.module.ts
│   │   ├── order.module.ts
│   ├── providers/       # Các services hỗ trợ khác (logging, caching)
│   │   ├── logger.service.ts
│   │   ├── cache.service.ts
│
│── main.ts              # Entry point của ứng dụng
│── app.module.ts        # Module gốc của ứng dụng
│── config/              # Configurations cho app
│   ├── database.config.ts
│   ├── env.config.ts
│
├── test/                # Unit tests và e2e tests
├── .env                 # File môi trường
├── tsconfig.json        # Config TypeScript
├── package.json         # Dependencies và scripts

```
