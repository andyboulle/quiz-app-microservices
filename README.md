# Spring Boot Microservices Quiz App

This is a Quiz Application built using Spring Boot, utilizing a microservices architecture. The application consists of two main services: the Question Service and the Quiz Service. The Question Service manages operations related to questions, while the Quiz Service handles quiz creation and submission.

## Features

### Question Service

- **Get All Questions**: Retrieve all questions stored in the database.
  -  ```/question/allQuestions```
- **Get Questions by Category**: Filter questions based on their category.
  -  ```/question/category/{category}```
- **Add Questions**: Add new questions to the database.
  -  ```/question/addQuestion```
- **Generate List of Questions**: Generate a list of questions based on specified criteria.
  -  ```/question/generate```
- **Calculate Score**: Generate a result by comparing responses to question's correct answers.
  -  ```/question/getScore```

### Quiz Service

- **Create Quiz**: Create a new quiz by selecting questions from the Question Service.
  - ```/quiz/create```
- **Get Quiz**: Retrieve a specific quiz by its ID.
  - ```/quiz/get/{id}```
- **Submit Answers**: Submit answers to a quiz and receive the score.
  - ```/quiz/submit/{id}```

### Quizapp
This is a monolithic version of the application. This monolith was then converted into the quiz and question microservices.

## Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- PostgreSQL

### Configuration

1. Clone the repository: `git clone https://github.com/andyboulle/quiz-app-microservices.git`
2. Navigate to the project directory: `cd quiz-app-microservices`
3. Configure the database connection in `application.properties` files for both services.

### Running the Application

1. Start the Service Registry:
```bash
cd service-registry
mvn spring-boot:run
```
2. Start the Question Service:
```bash
cd question-service
mvn spring-boot:run
```
3. Start the Quiz Service:
```bash
cd quiz-service
mvn spring-boot:run
```

- **Question Service**: Available on port 8080
- **Quiz Service**: Available on port 8090
- **Service Registry**: Available on port 8761

## Credits

This project was inspired by the YouTube tutorial series by Telusko: 

https://www.youtube.com/playlist?list=PLsyeobzWxl7rRyGcqgZ3MP5pWGPwUvprI

