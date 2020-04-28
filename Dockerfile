FROM airhacks/glassfish
COPY ./target/car2.war ${DEPLOYMENT_DIR}
