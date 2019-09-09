FROM openjdk:11
#RUN echo "root:$1$gft$YqZH8kGUliPazHrkJN7ag." | chpasswd
RUN useradd -ms /bin/bash gft -p '$1$gft$YqZH8kGUliPazHrkJN7ag.'
RUN usermod -aG sudo gft

USER gft
ADD springapp/target/modules ~/modules
EXPOSE 8070
WORKDIR ~

CMD java --add-modules java.instrument --module-path=modules --module five.springapp/five.springapp.Application
