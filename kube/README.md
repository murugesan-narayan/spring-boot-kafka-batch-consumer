# Alarm Data consumer
    It is responsible for consuming telefonica DE alarm data from their kafka environment.

## Run it in IDE with local kafka setup
1. Install kafka server with zookeeper
2. Start zookeeper and kafka server
3. Point your kafka bootstrap servers in application-test.yml
4. Run TefAlarmConsumerApplication.java with below vm options,
   ```shell
   -Dspring.profiles.active=test -Dspring.config.additional-location=file:./tef-alarm-consumer/src/test/resources/
   ```

## On Premises with NFS Installation

### Build Docker Image with Jenkins Jobs
1. Ensure that you are building right branch and right module.
2. Build the source files in Jenkins.
   1. Run the build http://10.2.2.101:7080/jenkins/job/snapshot_build_tefg/
   2. Docker Image will be pushed automatically to the repo configured.
   3. Latest jar can be found http://10.2.2.101:60000/TEFG_Live_Impl/.
3. Copy the latest kubernetes_resources folder from the git repository 
   into the kubernetes master server
   ```shell
   scp -P 22022 -r ./kubernetes_resources/DOCKER_FILES/tef-alarm-consumer/ appuser1@18.192.73.251:/home/appuser1/kubernetes_resources/DOCKER_FILES/tef-alarm-consumer/
   scp -P 22022 -r ./kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/alarm-consumer-chart/ appuser1@18.192.73.251:/home/appuser1/kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/alarm-consumer-chart/
   scp -P 22022 -r ./kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/ConfigMap_Files/tef-alarm-consumer-config/ appuser1@18.192.73.251:/home/appuser1/kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/ConfigMap_Files/tef-alarm-consumer-config/
   scp -P 22022 -r ./kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/Persistent_volume/Static_Provisining/tef_alarm_consumer_pv.yaml appuser1@18.192.73.251:/home/appuser1/kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/Persistent_volume/Static_Provisining/
   scp -P 22022 -r ./kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/Persistent_volume/Dynamic_Provisining/tef_alarm_consumer_pv.yaml appuser1@18.192.73.251:/home/appuser1/kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/Persistent_volume/Dynamic_Provisining/
   ```

### Manual Building of Docker Image
    You will find all the files required for creating a tef-alarm-consumer image 
    in kubernetes_resources/DOCKER_FILES/tef-alarm-consumer/ folder of the GIT repository. 
1. Go to kubernetes_resources/DOCKER_FILES/tef-alarm-consumer/
2. Add the newly built tef-alarm-consumer.jar file in this folder
   ```shell
   scp -P 22022 -r <path>/tef-alarm-consumer.jar appuser1@18.192.73.251:/home/appuser1/kubernetes_resources/DOCKER_FILES/tef-alarm-consumer/
   ```
3. Build the image by running the following command:
    ```shell
    $ cd kubernetes_resources/DOCKER_FILES/tef-alarm-consumer/
    $ sudo docker build . -t tef-alarm-consumer:v1
   ```
4. Command for pushing the built image to the private docker registry is as follows:
    ```shell
    $ sudo docker tag tef-alarm-consumer:v1 <IP/DOMAIN>/<PATH>/tef-alarm-consumer:v1
    $ sudo docker push <IP/DOMAIN>/<PATH>/tef-alarm-consumer:v1
    ```

### Dynamic NFS Provisioning
      Create the Storage class before you begin to use dynamic provisioning 
      in NFS Storage as Persistent volume. Refer the document Kubernetes 
      NFS Dynamic Provisioner.
1. Got to kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/
   Persistent_volume/Dynamic_Provisining/ 
2. You can find the file named as tef_alarm_consumer_pv.yaml for creating persistence volume
3. You can also edit the file increase the volume capacity.
4. Execute the below commands to create the persistent volume claim.
   Note that persistent volume will be automatically created by the storage class
   ```shell-
   $ kubectl apply -f tef_alarm_consumer_pv.yaml -n myapp-kube-workspace
   $ kubectl get pvc -n myapp-kube-workspace
   ```

### Creating Configmaps
1. Got to kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/ConfigMap_Files/.
2. Execute the below commands
   ```shell
   $ kubectl create configmap tef-alarm-consumer-config --from-file=tef-alarm-consumer-config/ --namespace=myapp-kube-workspace
   $ kubectl get configmap -n myapp-kube-workspace
   ```

### Installing Helm Charts
1. Go to kubernetes_resources/Helm_Charts/NFS_STORAGE_HELM/NFS_STORAGE_HELM/ folder.
2. Execute the below command
   ```shell
   helm install tef-alarm-consumer alarm-consumer-chart/ -n myapp-kube-workspace
   ```

### Verify Pods
1. Execute the below command
   ```shell
   $kubectl get pods -n myapp-kube-workspace
   ```
### Un Installing Helm Charts
1. Execute the below command
   ```shell
   helm uninstall tef-alarm-consumer -n myapp-kube-workspace
   ```