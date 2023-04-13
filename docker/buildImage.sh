cp ../core/target/orders-backend.jar .
IMAGE_NAME=czechprz/orders-backend
sudo docker image rm -f $IMAGE_NAME
sudo docker image build --tag $IMAGE_NAME .
sudo docker image push $IMAGE_NAME
