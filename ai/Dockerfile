# 베이스 이미지 설정
FROM python:3.9

# 작업 디렉토리 설정
WORKDIR /app

# CMake 설치
RUN apt-get update && apt-get install -y \
    cmake \
    build-essential \
    libopenblas-dev \
    liblapack-dev \
    libx11-dev \
    libgtk-3-dev \
    libgl1-mesa-glx
    
RUN pip install --upgrade pip

# 종속성 파일 복사 및 설치
COPY requirements.txt /app
RUN pip install --no-cache-dir -r requirements.txt
RUN pip install gunicorn

# 애플리케이션 소스 복사
COPY . /app

# Flask 환경 변수 설정
ENV FLASK_APP=app.py
ENV FLASK_ENV=development

# 컨테이너 시작 시 실행할 명령어
CMD ["flask", "run", "--host=0.0.0.0", "--port=5000"]
