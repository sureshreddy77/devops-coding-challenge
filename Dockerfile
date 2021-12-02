FROM python:latest

ENV CONTAINER_LOCALE="en_US.UTF-8"
ENV CONTAINER_TZ="America/New_York"
ENV PASSWORD="':te{]GY.[e|G%L|e<*t-<*qwlP90`/G"
EXPOSE 80

COPY package.tar.gz /bin/

COPY app/ /app/
RUN pip install -r /app/requirements.txt

RUN apt-get -qq update
RUN apt-get -y upgrade \
    && apt-get -qq install -y ca-certificates locales tzdata unzip
RUN update-ca-certificates
RUN apt-get -qq remove  ca-certificates locales tzdata
RUN apt-get -qq clean autoclean
RUN apt-get -qq -y --purge autoremove
USER root
ENTRYPOINT [ "python", "/app/app.py" ]
